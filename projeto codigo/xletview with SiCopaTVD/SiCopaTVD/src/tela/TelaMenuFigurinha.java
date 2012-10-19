package tela;

import gerenciadores.Imagens;

import java.awt.Container;
import java.io.IOException;

import menuPartes.TodasFigurinhas;
import menuPartes.listaDeAtalhos;
import menuPartes.logoPrograma;

import org.dvb.event.EventManager;
import org.dvb.event.UserEvent;
import org.dvb.event.UserEventListener;
import org.dvb.event.UserEventRepository;
import org.havi.ui.HIcon;
import org.havi.ui.HScene;
import org.havi.ui.event.HKeyEvent;
import org.havi.ui.event.HRcEvent;

public class TelaMenuFigurinha extends Container implements UserEventListener {

	HScene cena;

	// gerenciadores
	private EventManager controladorDeEvento;
	private Imagens imagens = Imagens.getInstance();

	// componentes da cena
	private HIcon fundo;
	private TodasFigurinhas todasFigurinhas;
	public logoPrograma logo;

	// ajuda/atalhos
	private listaDeAtalhos atalhos;
	private boolean mostrandoListaDeAtalhos = false;
	private static TelaMenuFigurinha Instance = null;

	private TelaMenuFigurinha(HScene cena) {
		this.cena = cena;

		this.controladorDeEvento = EventManager.getInstance();
	}

	public static synchronized TelaMenuFigurinha getInstance(HScene cena) {
		if (Instance == null)
			Instance = new TelaMenuFigurinha(cena);

		return Instance;

	}

	public void inicia() {
		
		fundo = new HIcon(imagens.carregarImagem(util.urls.menuFigurinha), 0,
				0, cena.getWidth(), cena.getHeight());
		try {

			todasFigurinhas = new TodasFigurinhas(cena);

			logo = new logoPrograma();

			criaAtalhos();

			this.cena.add(logo);
			this.cena.add(atalhos);
			this.cena.add(todasFigurinhas);
			this.cena.add(fundo);

			this.cena.repaint();

		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}

	private void criaAtalhos() {
		// (String vermelho,String verde,String amarelo,String azul, String
		// cimaBaixo,String esquerdaDireita,String ok, String num1a9,String
		// asterisco,String num0,String quadrado,String exit, String
		// menos,String mais){
		atalhos = new listaDeAtalhos("Volta o menu anterior", " ", " ", " ",
				" ", " ", " ", " ",
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

	public void userEventReceived(UserEvent evento) {
		int tipo = evento.getType();
		int botao = evento.getCode();

		if (tipo == HKeyEvent.KEY_RELEASED) {

			if (!mostrandoListaDeAtalhos) {

				if (botao == HRcEvent.VK_COLORED_KEY_0) {// botao vermelho,
															// volta ao menu
															// anterior
					this.resetaTudo();
					TelaMenuPrincipal telaAnterior = TelaMenuPrincipal
							.getInstance(cena);
					telaAnterior.inicia(TelaMenuPrincipal.subMenuFigurinhas);
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
