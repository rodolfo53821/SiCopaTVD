package tela;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.io.IOException;

import javax.tv.carousel.CarouselFile;

import gerenciadores.Imagens;
import menuPartes.bandeiraEstilo;
import menuPartes.emblemaENome;
import menuPartes.listaDeAtalhos;
import menuPartes.listaDeJogadores;
import menuPartes.logoPrograma;

import org.dvb.event.EventManager;
import org.dvb.event.UserEvent;
import org.dvb.event.UserEventListener;
import org.dvb.event.UserEventRepository;
import org.dvb.ui.DVBTextLayoutManager;
import org.havi.ui.*;
import org.havi.ui.event.HRcEvent;

import persistencia.Jogador;
import persistencia.Selecao;

public class TelaMenuJogador implements UserEventListener {

	// gerenciadores
	private EventManager controladorDeEvento;
	private Imagens imagens = Imagens.getInstance();

	private HScene cena;

	// padrao singleton
	private static TelaMenuJogador Instance = null;
	// componentes presentes na cena
	private listaDeJogadores listaDeJogadoresMenu;
	private HIcon iconeInfo, iconeInfoRapido, iconeMolduraFoto, iconeFoto;
	private HStaticText info, infoPagina, infoRapido;
	private HIcon imagemPadrao;
	private bandeiraEstilo bandeira;
	private emblemaENome emblemaNome;
	public logoPrograma logo;

	// selecao e jogador corrente identificando a informacao de qual jogador
	// mostrar
	private Selecao selecaoCorrente;
	private int jogadorCorrente;

	// ajuda/atalhos
	private listaDeAtalhos atalhos;
	private boolean mostrandoListaDeAtalhos = false;

	// atributos dos componentes da cena
	private final int larguraImagemFundo = 500;
	private final int alturaImagemFundo = 350;
	private final int larguraIconeInfo = 245;
	private final int alturaIconeInfo = 386;
	private final int larguraInfo = larguraIconeInfo - 35;
	private final int alturaInfo = alturaIconeInfo - 43;
	private final int larguraInfoPagina = 171;
	private final int alturaInfoPagina = 38;
	private final int larguraIconeInfoRapido = 211;
	private final int alturaIconeInfoRapido = 115;
	private final int larguraInfoRapido = larguraIconeInfoRapido - 33;
	private final int alturaInfoRapido = alturaIconeInfoRapido - 20;
	private final int larguraIconeMolduraFoto = 152;
	private final int alturaIconeMolduraFoto = 134;
	private final int larguraIconeFoto = 133;
	private final int alturaIconeFoto = 100;

	private final int posXIconeInfo = 269;
	private final int posYIconeInfo = 87;
	private final int posXInfo = posXIconeInfo
			+ (larguraIconeInfo - larguraInfo) / 2;
	private final int posYInfo = posYIconeInfo + (alturaIconeInfo - alturaInfo)
			/ 2;
	private final int posXIconeInfoRapido = 52;
	private final int posYIconeInfoRapido = 235;
	private final int posXInfoRapido = posXIconeInfoRapido
			+ (larguraIconeInfoRapido - larguraInfoRapido) / 2;
	private final int posYInfoRapido = posYIconeInfoRapido + 5;
	private final int posXMoldura = posXIconeInfoRapido
			+ (larguraIconeInfoRapido - larguraIconeMolduraFoto) / 2;
	private final int posYMoldura = 113;
	private final int posXListaDeJogadores = 523;
	private final int posYListaDeJogadores = 87;
	private final int posXInfoPagina = posXListaDeJogadores;
	private final int posYInfoPagina = posYListaDeJogadores - alturaInfoPagina;
	private final int posXFoto = 10;// posicao da foto em x e em relacao a
									// moldura assumindo que a moldura esteja na
									// pos 0
	private final int posYFoto = 5;// posicao da foto em y e em relacao a
									// moldura assumindo que a moldura esteja na
									// pos 0

	public static synchronized TelaMenuJogador getInstance(HScene cena) {
		if (Instance == null)
			Instance = new TelaMenuJogador(cena);
		return Instance;
	}

	private TelaMenuJogador(HScene cena) {
		this.cena = cena;

		this.controladorDeEvento = EventManager.getInstance();

	}

	public void inicia(Selecao selecaoCorrente) throws IOException {
		this.selecaoCorrente = selecaoCorrente;
		jogadorCorrente = 0;
		
		// iniciando o menu com os jogadores da selecao corrente
		this.listaDeJogadoresMenu = new listaDeJogadores(this.selecaoCorrente);
		this.emblemaNome = new emblemaENome(this.selecaoCorrente.getNome()
				.toUpperCase());
		
		this.imagemPadrao = new HIcon(imagens
				.carregarImagem(util.urls.menuJogador), 0, 0, cena.getWidth(),
				cena.getHeight());
		this.bandeira = new bandeiraEstilo(selecaoCorrente.getNome()
				.toUpperCase());
		this.logo = new logoPrograma();
		
		HDefaultTextLayoutManager controladorDeLayoutDeTexto = new HDefaultTextLayoutManager();
		this.infoPagina = new HStaticText("Pagina:"
				+ listaDeJogadoresMenu.paginaCorrente + "/"
				+ listaDeJogadoresMenu.qtdePaginas, posXInfoPagina,
				posYInfoPagina, larguraInfoPagina, alturaInfoPagina, Font
						.decode(util.FormataString.fonteString), Color.BLACK,
				null, controladorDeLayoutDeTexto);
		this.infoPagina.setBackgroundMode(Color.TRANSLUCENT);
		this.infoPagina.setHorizontalAlignment(HVisible.HALIGN_LEFT);
		this.infoPagina.setVerticalAlignment(HVisible.VALIGN_BOTTOM);

		this.emblemaNome.setLocation(
				(this.emblemaNome.getWidth() - this.larguraIconeMolduraFoto)
						/ 2 + posXMoldura, 20);
		// this.emblemaNome.setLocation(posXListaDeJogadores +
		// listaDeJogadoresMenu.getWidth() - this.emblemaNome.getWidth(),
		// posYInfoPagina - this.emblemaNome.getHeight() + 15);
		this.bandeira.setLocation(0, 0);
		// this.bandeira.setLocation((cena.getWidth()-larguraImagemFundo)/2,(cena.getHeight()-alturaImagemFundo)/2
		// );
		this.listaDeJogadoresMenu.setLocation(posXListaDeJogadores,
				posYListaDeJogadores);
		this.listaDeJogadoresMenu.setVisible(true);
		this.logo.setVisible(true);
		this.emblemaNome.setVisible(true);

		// adicionando os botoes que contem acao ao gerenciador de botoes
		criaAtalhos();

		// adicionando componentes a cena
		this.cena.add(logo);
		this.cena.add(atalhos);
		this.cena.add(emblemaNome);
		this.cena.add(infoPagina);
		this.cena.add(listaDeJogadoresMenu);

		criaIconesDeInfo();
		atualizaInfos();

		this.cena.add(bandeira);
		this.cena.add(imagemPadrao);

		this.cena.repaint();

	}

	private void criaIconesDeInfo() {
		this.iconeInfo = new HIcon(
				imagens.carregarImagem(util.urls.infoQuadro), 0, 0,
				this.larguraIconeInfo, this.alturaIconeInfo);
		this.iconeInfoRapido = new HIcon(imagens
				.carregarImagem(util.urls.infoRapido), 0, 0,
				this.larguraIconeInfoRapido, this.alturaIconeInfoRapido);
		this.iconeMolduraFoto = new HIcon(imagens
				.carregarImagem(util.urls.fotoQuadro), 0, 0,
				this.larguraIconeMolduraFoto, this.alturaIconeMolduraFoto);
		this.info = new HStaticText();
		this.infoRapido = new HStaticText();
		this.iconeFoto = new HIcon();
		this.iconeInfoRapido.setBackground(Color.BLACK);

		// setando as configuracoes do texto

		this.info.setForeground(Color.white);
		this.info.setBackgroundMode(Color.TRANSLUCENT);
		this.info.setFont(Font.decode(util.FormataString.fonteString));
		this.info.setHorizontalAlignment(HVisible.HALIGN_LEFT);
		this.info.setVerticalAlignment(HVisible.VALIGN_TOP);

		this.infoRapido.setForeground(Color.white);
		this.infoRapido.setBackgroundMode(Color.TRANSLUCENT);
		this.infoRapido.setFont(Font.decode(util.FormataString.fonteString));
		this.infoRapido.setHorizontalAlignment(HVisible.HALIGN_LEFT);
		this.infoRapido.setVerticalAlignment(HVisible.VALIGN_TOP);

		// posicionando os icones de acordo com os valores obtidos no photoshop
		this.iconeInfo.setLocation(posXIconeInfo, posYIconeInfo);
		this.iconeInfoRapido.setLocation(posXIconeInfoRapido,
				posYIconeInfoRapido);
		this.iconeMolduraFoto.setLocation(posXMoldura, posYMoldura);
		this.iconeFoto.setBounds(posXMoldura + posXFoto,
				posYMoldura + posYFoto, larguraIconeFoto, alturaIconeFoto);
		this.info.setBounds(posXInfo, posYInfo, larguraInfo, alturaInfo);
		this.infoRapido.setBounds(posXInfoRapido, posYInfoRapido,
				larguraInfoRapido, alturaInfoRapido);

		this.cena.add(iconeFoto);
		this.cena.add(info);
		this.cena.add(infoRapido);
		this.cena.add(iconeInfo);
		this.cena.add(iconeMolduraFoto);
		this.cena.add(iconeInfoRapido);

	}

	private void criaAtalhos() {
		// (String vermelho,String verde,String amarelo,String azul, String
		// cimaBaixo,String esquerdaDireita,String ok, String num1a9,String
		// asterisco,String num0,String quadrado,String exit, String
		// menos,String mais){
		atalhos = new listaDeAtalhos("Volta o menu anterior", " ", " ", " ",
				" Troca o jogador", " Troca pagina", " ", " ",
				"Entra/Sai ajuda ", " ", " ", " ", " ", " ");
		atalhos.setVisible(false);

		UserEventRepository eventoDeUsuario = new UserEventRepository(
				"TelaMenuJogador");
		eventoDeUsuario.addKey(HRcEvent.VK_ASTERISK);

		eventoDeUsuario.addAllArrowKeys();
		eventoDeUsuario.addAllColourKeys();
		eventoDeUsuario.addKey(HRcEvent.VK_ENTER);

		this.controladorDeEvento.addUserEventListener(this, eventoDeUsuario);

	}

	void atualizaInfos() throws IOException {
		
		Jogador jogador = selecaoCorrente.getJogadores().get(jogadorCorrente);
		// atualiza info de infos
		String infoDados = " ";
		String nome = jogador.getNome();
		nome = nome.substring(nome.indexOf(",") + 1, nome.length());
		infoDados += util.FormataString.formatandoString("NOME: " + nome,
				larguraInfo);
		infoDados += "\n";
		infoDados += util.FormataString.formatandoString("POSICAO: "
				+ jogador.getPosicao(), larguraInfo);
		infoDados += "\n";
		infoDados += util.FormataString.formatandoString("D. NASCIMENTO: "
				+ jogador.getDataNascimento(), larguraInfo);
		infoDados += "\n";
		infoDados += util.FormataString.formatandoString("ALTURA: "
				+ jogador.getAltura() + " CM", larguraInfo);
		infoDados += "\n";
		infoDados += util.FormataString.formatandoString("PESO: "
				+ jogador.getPeso() + " KG", larguraInfo);
		infoDados += "\n";
		infoDados += util.FormataString.formatandoString("HISTORICO EM COPAS: "
				+ jogador.getHistoricoEmCopas(), larguraInfo);
		infoDados += "\n";

		infoDados = infoDados.substring(1, infoDados.length());

		this.info.setTextContent(infoDados, HVisible.NORMAL_STATE);
		// atualiza info de infoRapido

		String infoDadosRapido = " ";
		String apelido = jogador.getNome();
		apelido = apelido.substring(0, apelido.indexOf(","));
		infoDadosRapido += util.FormataString.formatandoString("APELIDO: "
				+ apelido, larguraInfoRapido);
		infoDadosRapido += util.FormataString.formatandoString(
				"NACIONALIDADE.: " + jogador.getNacionalidade(),
				larguraInfoRapido);
		infoDadosRapido = infoDadosRapido
				.substring(1, infoDadosRapido.length());

		this.infoRapido.setTextContent(infoDadosRapido, HVisible.NORMAL_STATE);
		String pathApelido = "figurinhas/"
				+ selecaoCorrente.getNome().toLowerCase() + "/"
				+ apelido.toLowerCase() + ".png";
		CarouselFile jogadorFile = new CarouselFile(pathApelido);
		if (jogadorFile.exists()) {
			this.listaDeJogadoresMenu.getJogadorCorrente().getFigurinha().obtida = true;
			this.listaDeJogadoresMenu.getJogadorCorrente().getFigurinha()
					.setFigurinhaImagem(jogadorFile.getAbsolutePath());
		}
		// atualiza info de fotos
		// caso tenha a figurinha
		if (this.listaDeJogadoresMenu.getJogadorCorrente().getFigurinha().obtida) {
			this.iconeFoto.setGraphicContent(imagens
					.carregarImagem(this.listaDeJogadoresMenu
							.getJogadorCorrente().getFigurinha()
							.getFigurinhaImagem()), HVisible.NORMAL_STATE);
			// iconeFoto = new
			// HIcon(imagens.carregarImagem(this.listaDeJogadoresMenu.getJogadorCorrente().getFigurinha().getFigurinhaImagem()),0,0,larguraIconeFoto,alturaIconeFoto);
		} else
			// carrega a figurinha default
			this.iconeFoto.setGraphicContent(imagens
					.carregarImagem(util.urls.rostoDefault),
					HVisible.NORMAL_STATE);

		this.cena.repaint();

	}

	public void setSelecaoCorrente(Selecao selecaoCorrente) {
		this.selecaoCorrente = selecaoCorrente;
	}

	// tratador da acao dos botoes
	public void userEventReceived(UserEvent evento) {

		int tipo = evento.getType();
		int botao = evento.getCode();

		if (tipo == HRcEvent.KEY_RELEASED) {

			if (!mostrandoListaDeAtalhos) {
				if (botao == HRcEvent.VK_COLORED_KEY_0) {// botao vermelho,
															// volta ao menu
															// anterior
					this.resetaTudo();
					TelaEscolhaDeTime telaAnterior = TelaEscolhaDeTime
							.getInstance(cena);
					telaAnterior.inicia(TelaMenuPrincipal.subMenuJogadores);
				} else if (botao == HRcEvent.VK_UP || botao == HRcEvent.VK_DOWN) {
					// troca a caixa do menu
					this.listaDeJogadoresMenu.trocaJogador(botao);
					this.jogadorCorrente = listaDeJogadoresMenu.jogadorCorrente;
					// atualiza info do jogador
					try {
						atualizaInfos();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				} else if (botao == HRcEvent.VK_LEFT
						|| botao == HRcEvent.VK_RIGHT) {
					// troca a pagina
					this.listaDeJogadoresMenu.trocaPagina(
							listaDeJogadoresMenu.paginaCorrente, botao);
					// atualiza info da pagina
					this.infoPagina.setTextContent("Pagina:"
							+ listaDeJogadoresMenu.paginaCorrente + "/"
							+ listaDeJogadoresMenu.qtdePaginas,
							HVisible.NORMAL_STATE);
					// atualiza a info do jogador
					this.jogadorCorrente = listaDeJogadoresMenu.jogadorCorrente;
					// atualiza info do jogador
					try {
						atualizaInfos();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}

			}

			if (botao == HRcEvent.VK_ASTERISK) {// aciona a ajuda
				mostrandoListaDeAtalhos = !mostrandoListaDeAtalhos;

				atalhos.setVisible(mostrandoListaDeAtalhos);

			}
		}

	}

	private void resetaTudo() {

		this.cena.removeAll();
		this.cena.repaint();
		this.controladorDeEvento.removeUserEventListener(this);

	}

}
