package tela;

import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Image;

import gerenciadores.Imagens;
import menuPartes.bandeiraEstilo;
import menuPartes.listaDeAtalhos;
import menuPartes.listaDeJogadores;
import menuPartes.logoPrograma;
import menuPartes.mapaAfricaDoSul;
import menuPartes.mapaDeSedes;

import org.dvb.event.EventManager;
import org.dvb.event.UserEvent;
import org.dvb.event.UserEventListener;
import org.dvb.event.UserEventRepository;
import org.havi.ui.HIcon;
import org.havi.ui.HScene;
import org.havi.ui.HStaticText;
import org.havi.ui.HVisible;
import org.havi.ui.event.HKeyEvent;
import org.havi.ui.event.HRcEvent;

import persistencia.Estadio;
import persistencia.Selecao;
import util.urls;

public class TelaMenuEstadio implements UserEventListener {

	// gerenciadores
	private EventManager controladorDeEvento;
	private Imagens imagens = Imagens.getInstance();

	private HScene cena;

	// padrao singleton
	private static TelaMenuEstadio Instance = null;
	// componentes presentes na cena
	public mapaDeSedes mapaDeSedesMenu;
	private HIcon iconeInfo, iconeInfoImagem;
	private HIcon imagemPadrao;
	private mapaAfricaDoSul mapaAfricasDoSulMenu;
	public logoPrograma logo;
	private HStaticText infoSede;
	private HIcon imagemSede;

	// sede corrente identificando a informacao de qual sede mostrar
	private Estadio estadioCorrente;

	// ajuda/atalhos
	private listaDeAtalhos atalhos;
	private boolean mostrandoListaDeAtalhos = false;

	// atributos dos componentes da cena
	private final int larguraIconeInfo = 325;
	private final int alturaIconeInfo = 279;
	private final int larguraImagemSede = 269;
	private final int alturaImagemSede = 244;
	private final int larguraInfoSede = larguraIconeInfo - 49;
	private final int alturaInfoSede = alturaIconeInfo - 36;
	private final int posXInfo = 28;
	private final int posYInfo = 40;
	private final int posXInfoImagem = larguraIconeInfo + posXInfo + 10;
	private final int posYInfoImagem = posYInfo;
	private final int posXMapaDeSedes = 133;
	private final int posYMapaDeSedes = 323;
	private final int posXMapaAfricaDoSul = 422;
	private final int posYMapaAfricaDoSul = 323;
	private final int posXImagemSede = posXInfoImagem + 25;
	private final int posYImagemSede = posYInfoImagem + 15;
	private final int posXInfoSede = posXInfo + 24;
	private final int posYInfoSede = posYInfo + 14;

	public static synchronized TelaMenuEstadio getInstance(HScene cena) {
		if (Instance == null)
			Instance = new TelaMenuEstadio(cena);
		return Instance;
	}

	private TelaMenuEstadio(HScene cena) {
		this.cena = cena;
		this.controladorDeEvento = EventManager.getInstance();

	}

	public void inicia(Estadio estadioCorrente) {
		// inicia a tela de menu de estadio
		this.estadioCorrente = estadioCorrente;

		this.imagemPadrao = new HIcon(imagens
				.carregarImagem(util.urls.menuEstadio), 0, 0, cena.getWidth(),
				cena.getHeight());
		this.iconeInfo = new HIcon(imagens
				.carregarImagem(util.urls.infoEstadio), 0, 0, larguraIconeInfo,
				alturaIconeInfo);
		this.iconeInfoImagem = new HIcon(imagens
				.carregarImagem(util.urls.infoEstadio), 0, 0, larguraIconeInfo,
				alturaIconeInfo);
		this.mapaDeSedesMenu = new mapaDeSedes();
		this.mapaAfricasDoSulMenu = new mapaAfricaDoSul(estadioCorrente
				.getNome());
		this.infoSede = new HStaticText();
		this.imagemSede = new HIcon();

		this.logo = new logoPrograma();
		this.logo.setVisible(true);

		// mostra na tela os dados da sede corrente
		mostraSede(estadioCorrente);

		// posicionando os elementos na cena
		this.iconeInfo.setLocation(posXInfo, posYInfo);
		this.iconeInfoImagem.setLocation(posXInfoImagem, posYInfoImagem);
		this.mapaAfricasDoSulMenu.setLocation(posXMapaAfricaDoSul,
				posYMapaAfricaDoSul);
		this.mapaDeSedesMenu.setLocation(posXMapaDeSedes, posYMapaDeSedes);
		this.imagemSede.setLocation(posXImagemSede, posYImagemSede);
		this.infoSede.setLocation(posXInfoSede, posYInfoSede);
		// adicionando os botoes que contem acao ao gerenciador de botoes
		criaAtalhos();

		// adicionando componentes a cena
		this.cena.add(logo);
		this.cena.add(atalhos);
		this.cena.add(infoSede);
		this.cena.add(imagemSede);
		this.cena.add(iconeInfo);
		this.cena.add(iconeInfoImagem);
		this.cena.add(mapaAfricasDoSulMenu);
		this.cena.add(mapaDeSedesMenu);
		this.cena.add(imagemPadrao);
		this.cena.repaint();

	}

	private void mostraSede(Estadio estadio) {
		String info = criaInfoSede(estadio);

		this.infoSede.setTextContent(info, HVisible.NORMAL_STATE);
		Image imagem = imagens.carregarImagem(estadio.getEstadioImagem());
		this.imagemSede.setGraphicContent(imagem, HVisible.NORMAL_STATE);
		this.infoSede.setSize(larguraInfoSede, alturaInfoSede);
		this.infoSede.setBackgroundMode(Color.TRANSLUCENT);
		this.infoSede.setForeground(Color.white);
		this.infoSede.setHorizontalAlignment(HVisible.HALIGN_LEFT);
		this.infoSede.setVerticalAlignment(HVisible.VALIGN_TOP);
		this.infoSede.setFont(Font.decode(util.FormataString.fonteString));

		this.imagemSede.setSize(larguraImagemSede, alturaImagemSede);
		this.cena.repaint();
	}

	private String criaInfoSede(Estadio estadio) {
		String info;

		info = util.FormataString.formatandoString(
				"NOME: " + estadio.getNome(), larguraInfoSede);
		info += "\n";
		info += util.FormataString.formatandoString("CIDADE: "
				+ estadio.getCidade(), larguraInfoSede);
		info += "\n";
		info += util.FormataString.formatandoString("CAPACIDADE: "
				+ estadio.getCapacidade(), larguraInfoSede);
		info += "\n";
		info += util.FormataString.formatandoString("INAUGURACAO: "
				+ estadio.getInauguracao(), larguraInfoSede);
		info += "\n";
		info += util.FormataString.formatandoString("CURIOSIDADE: "
				+ estadio.getCuriosidades(), larguraInfoSede);
		// info = "ABCDEFGHIJLMNOPQ\nRSTUVXWY:1234 56780/-";
		return info;
	}

	private void criaAtalhos() {
		// (String vermelho,String verde,String amarelo,String azul, String
		// cimaBaixo,String esquerdaDireita,String ok, String num1a9,String
		// asterisco,String num0,String quadrado,String exit, String
		// menos,String mais){
		this.atalhos = new listaDeAtalhos("Volta o menu anterior", " ", " ",
				" ", " Troca o sede", " Troca a sede", " ", " ",
				"Entra/Sai ajuda ", " ", " ", " ", " ", " ");
		this.atalhos.setVisible(false);

		UserEventRepository eventoDeUsuario = new UserEventRepository(
				"TelaMenuEstadio");
		eventoDeUsuario.addKey(HRcEvent.VK_ASTERISK);

		eventoDeUsuario.addAllArrowKeys();
		eventoDeUsuario.addAllColourKeys();
		eventoDeUsuario.addKey(HRcEvent.VK_ENTER);

		this.controladorDeEvento.addUserEventListener(this, eventoDeUsuario);

	}

	// metodo que implementa as acoes dos botoes
	public void userEventReceived(UserEvent evento) {
		int tipo = evento.getType();
		int botao = evento.getCode();

		if (tipo == HKeyEvent.KEY_RELEASED) {

			if (!mostrandoListaDeAtalhos) {

				if (botao == HRcEvent.VK_DOWN || botao == HRcEvent.VK_UP
						|| botao == HRcEvent.VK_RIGHT
						|| botao == HRcEvent.VK_LEFT) {
					
					mapaDeSedesMenu.trocaSede(botao);
					
					mapaAfricasDoSulMenu
							.mudaMarcador(mapaDeSedesMenu.sedeCorrente);
					
					estadioCorrente = persistencia.Copa.getInstance()
							.getEstadioEspecifico(mapaDeSedesMenu.sedeCorrente);
					
					mostraSede(estadioCorrente);
				}

				else if (botao == HRcEvent.VK_ENTER) {

				}// fim do if para o botao enter
				else if (botao == HRcEvent.VK_COLORED_KEY_0) {// botao
																// vermelho,
																// volta ao menu
																// anterior
					this.resetaTudo();
					TelaMenuPrincipal telaAnterior = TelaMenuPrincipal
							.getInstance(cena);
					telaAnterior.inicia(TelaMenuPrincipal.subMenuEstadios);
				}

				if (botao == HRcEvent.VK_CHANNEL_DOWN
						|| botao == HRcEvent.VK_CHANNEL_UP)
					;// efeitoSonoro.aumentaVolume(botao);
				// dispara efeito sonoro
				// efeitoSonoro.iniciaEfeito();

			}// fim do if para mostrandoMenuAtalhos

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
