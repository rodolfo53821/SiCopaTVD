package tela;

import gerenciadores.Imagens;

import java.awt.Container;

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

public class TelaMenuSobre extends Container implements UserEventListener {

	HScene cena;
	// componentes da cena
	private HIcon fundo;

	// gerenciadores
	Imagens imagens = Imagens.getInstance();
	private EventManager controladorDeEvento;

	public logoPrograma logo;

	// ajuda/atalhos
	private listaDeAtalhos atalhos;
	private boolean mostrandoListaDeAtalhos = false;

	private static TelaMenuSobre Instance = null;

	public static TelaMenuSobre getInstance(HScene cena) {
		if (Instance == null)
			Instance = new TelaMenuSobre(cena);

		return Instance;
	}

	private TelaMenuSobre(HScene cena) {
		this.cena = cena;
		this.controladorDeEvento = EventManager.getInstance();
	}

	public void inicia() {
		
		fundo = new HIcon(imagens.carregarImagem(util.urls.menuSobre), 0, 0,
				cena.getWidth(), cena.getHeight());
		
		logo = new logoPrograma();

		// adicionando os botoes que contem acao ao gerenciador de botoes
		criaAtalhos();
		
		this.cena.add(logo);
		this.cena.add(atalhos);
		this.cena.add(fundo);

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
		eventoDeUsuario.addKey(HRcEvent.VK_COLORED_KEY_0);
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
					TelaMenuPrincipal telaAnterior = TelaMenuPrincipal
							.getInstance(cena);
					telaAnterior.inicia(TelaMenuPrincipal.subMenuSobre);
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
