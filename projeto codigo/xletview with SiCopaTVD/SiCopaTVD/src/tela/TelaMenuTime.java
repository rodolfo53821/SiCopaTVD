package tela;

import gerenciadores.Imagens;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import menuPartes.FaseGrupos;
import menuPartes.bandeiraEstilo;
import menuPartes.emblemaENome;
import menuPartes.listaDeAtalhos;
import menuPartes.logoPrograma;

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

import persistencia.Selecao;

public class TelaMenuTime extends Container implements UserEventListener {

	// definindo as variaveis da tela
	private HScene cena;
	private HIcon timeFundo;
	private emblemaENome emblema;
	private bandeiraEstilo bandeira;
	private HIcon iconeInfo;
	private HStaticText info;
	public logoPrograma logo;

	// gerenciadores
	Imagens imagens = Imagens.getInstance();
	private EventManager controladorDeEvento;

	// ajuda/atalhos
	private listaDeAtalhos atalhos;
	private boolean mostrandoListaDeAtalhos = false;

	// padrao singleton
	private static TelaMenuTime Instance = null;
	Selecao selecaoCorrente;

	// variaveis de tamanho e posicao
	private final int larguraIconeInfo = 245;
	private final int alturaIconeInfo = 386;
	private final int larguraInfo = larguraIconeInfo - 35;
	private final int alturaInfo = alturaIconeInfo - 43;
	private final int posXIconeInfo = 269;
	private final int posYIconeInfo = 87;
	private final int posXInfo = posXIconeInfo
			+ (larguraIconeInfo - larguraInfo) / 2;
	private final int posYInfo = posYIconeInfo + (alturaIconeInfo - alturaInfo)
			/ 2;

	public static synchronized TelaMenuTime getInstance(HScene cena) {
		if (Instance == null)
			Instance = new TelaMenuTime(cena);
		return Instance;

	}

	private TelaMenuTime(HScene cena) {
		this.cena = cena;
		this.controladorDeEvento = EventManager.getInstance();

	}

	public void inicia(Selecao corrente) {
		selecaoCorrente = corrente;
		timeFundo = new HIcon(imagens.carregarImagem(util.urls.menuTime), 0, 0,
				cena.getWidth(), cena.getHeight());
		emblema = new emblemaENome(selecaoCorrente.getNome());
		bandeira = new bandeiraEstilo(selecaoCorrente.getNome());
		iconeInfo = new HIcon(imagens.carregarImagem(util.urls.infoQuadro), 0,
				0, larguraIconeInfo, alturaIconeInfo);
		info = new HStaticText();

		// setando configuracoes do texto
		this.info.setForeground(Color.white);
		this.info.setBackgroundMode(Color.TRANSLUCENT);
		this.info.setFont(Font.decode(util.FormataString.fonteString));
		this.info.setHorizontalAlignment(HVisible.HALIGN_LEFT);
		this.info.setVerticalAlignment(HVisible.VALIGN_TOP);

		atualizaInfo();

		// POSICAO DOS COMPONENTES DA CENA
		this.emblema
				.setLocation((cena.getWidth() - emblema.getWidth()) / 2, 10);
		this.iconeInfo.setLocation(posXIconeInfo, posYIconeInfo);
		this.bandeira.setLocation(0,
				(cena.getHeight() - bandeira.getHeight()) / 2);
		this.info.setBounds(posXInfo, posYInfo, larguraInfo, alturaInfo);
		logo = new logoPrograma();
		// adicionando os botoes que contem acao ao gerenciador de botoes
		criaAtalhos();

		this.info.setVisible(true);

		this.cena.add(logo);
		this.cena.add(atalhos);
		this.cena.add(emblema);
		this.cena.add(info);
		this.cena.add(iconeInfo);
		this.cena.add(bandeira);
		this.cena.add(timeFundo);

		this.cena.repaint();
		System.out.println();
	}

	private void atualizaInfo() {
		String infoDados = " ";
		infoDados += util.FormataString.formatandoString("NOME: "
				+ selecaoCorrente.getNome(), larguraInfo);
		infoDados += "\n";
		infoDados += util.FormataString.formatandoString("FEDERACAO: "
				+ selecaoCorrente.getFederacao(), larguraInfo);
		infoDados += "\n";
		infoDados += util.FormataString.formatandoString("PRINCIPAIS TITULOS: "
				+ selecaoCorrente.getPrincipaisTitulos(), larguraInfo);
		infoDados += "\n";
		infoDados += util.FormataString.formatandoString("FILIACAO A FIFA: "
				+ selecaoCorrente.getFiliacaoAFifa().getAno(), larguraInfo);
		infoDados += "\n";
		infoDados += util.FormataString.formatandoString("RANK NA FIFA: "
				+ selecaoCorrente.getRankNaFifa() + " @", larguraInfo);
		infoDados += "\n";

		infoDados = infoDados.substring(1, infoDados.length());

		this.info.setTextContent(infoDados, HVisible.NORMAL_STATE);
		this.cena.repaint();

	}

	private void criaAtalhos() {
		// (String vermelho,String verde,String amarelo,String azul, String
		// cimaBaixo,String esquerdaDireita,String ok, String num1a9,String
		// asterisco,String num0,String quadrado,String exit, String
		// menos,String mais){
		atalhos = new listaDeAtalhos("Volta o menu ", " ", " ", " ", " ", " ",
				" ", " ", "Entra/Sai ajuda ", " ", " ", " ", " ", " ");
		atalhos.setVisible(false);

		UserEventRepository eventoDeUsuario = new UserEventRepository(
				"TelaMenuTabela");
		eventoDeUsuario.addKey(HRcEvent.VK_ASTERISK);
		eventoDeUsuario.addAllArrowKeys();
		eventoDeUsuario.addAllColourKeys();
		eventoDeUsuario.addKey(HRcEvent.VK_ENTER);
		eventoDeUsuario.addKey(HRcEvent.VK_CHANNEL_DOWN);
		eventoDeUsuario.addKey(HRcEvent.VK_CHANNEL_UP);
		controladorDeEvento.addUserEventListener(this, eventoDeUsuario);

	}

	public void userEventReceived(UserEvent evento) {

		int tipo = evento.getType();
		int botao = evento.getCode();

		if (tipo == HKeyEvent.KEY_RELEASED) {

			if (!mostrandoListaDeAtalhos) {
				// troca o pagina dentro da mesma fase

				if (botao == HRcEvent.VK_COLORED_KEY_0) {// botao vermelho,
															// volta ao menu
															// anterior
					this.resetaTudo();
					TelaEscolhaDeTime telaAnterior = TelaEscolhaDeTime
							.getInstance(cena);
					telaAnterior.inicia(TelaMenuPrincipal.subMenuTimes);
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
