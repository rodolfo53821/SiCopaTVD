package tela;

import java.io.IOException;

import gerenciadores.Imagens;

import menuPartes.listaDeAtalhos;
import menuPartes.logoPrograma;
import menuPartes.mapaMundo;
import menuPartes.mapaDeTimes;

import org.dvb.event.EventManager;
import org.dvb.event.UserEvent;
import org.dvb.event.UserEventListener;
import org.dvb.event.UserEventRepository;
import org.havi.ui.HIcon;
import org.havi.ui.HScene;
import org.havi.ui.event.HKeyEvent;
import org.havi.ui.event.HRcEvent;

import persistencia.Jogador;
import persistencia.Selecao;
import persistencia.Copa;
import util.Data;

public class TelaEscolhaDeTime implements UserEventListener {

	private HScene cena;

	// padrao singleton
	private static TelaEscolhaDeTime Instance = null;
	private EventManager controladorDeEvento;
	private Imagens imagens = Imagens.getInstance();
	private HIcon fundo;
	private mapaDeTimes times;
	private mapaMundo mundo;

	private int posXMundo;
	private int posYMundo = 0;
	private int posXTimes;
	private int posYTimes = 310;
	private listaDeAtalhos atalhos;
	private boolean mostraListaDeAtalhos = false;
	private int menu;
	public logoPrograma logo;

	public static synchronized TelaEscolhaDeTime getInstance(HScene cena) {
		if (Instance == null)
			Instance = new TelaEscolhaDeTime(cena);
		return Instance;
	}

	private TelaEscolhaDeTime(HScene cena) {
		this.cena = cena;
		this.controladorDeEvento = EventManager.getInstance();

	}

	public void inicia(int menu) {
		this.menu = menu;
		fundo = new HIcon(imagens.carregarImagem(util.urls.fundo), 0, 0, cena
				.getWidth(), cena.getHeight());
		times = new mapaDeTimes();
		mundo = new mapaMundo(times.selecaoCorrente);

		// posiciona os menus na tela
		mundo.setLocation((cena.getWidth() - mundo.getWidth()) / 2, posYMundo);
		times.setLocation((cena.getWidth() - times.getWidth()) / 2, posYTimes);

		logo = new logoPrograma();
		logo.setVisible(true);

		// criando atalhos de botoes
		criaAtalhos();

		// ativa-os
		mundo.setVisible(true);
		times.setVisible(true);

		// adiconando componentes a cena
		cena.add(logo);
		cena.add(atalhos);
		cena.add(times);
		cena.add(mundo);
		cena.add(fundo);
		cena.repaint();

	}

	private void criaAtalhos() {
		// (String vermelho,String verde,String amarelo,String azul, String
		// cimaBaixo,String esquerdaDireita,String ok, String num1a9,String
		// asterisco,String num0,String quadrado,String exit, String
		// menos,String mais){
		atalhos = new listaDeAtalhos("Volta o menu ", " ", " ", " ",
				" Navega pelas selecoes", " Navega pelas selecoes",
				"Acessa a selecao ", " ", "Entra/Sai ajuda ", " ", " ", " ",
				" ", " ");
		atalhos.setVisible(false);

		UserEventRepository eventoDeUsuario = new UserEventRepository(
				"TelaMenuPrincipal");
		eventoDeUsuario.addKey(HRcEvent.VK_ASTERISK);
		eventoDeUsuario.addAllArrowKeys();
		eventoDeUsuario.addAllColourKeys();
		eventoDeUsuario.addKey(HRcEvent.VK_ENTER);

		controladorDeEvento.addUserEventListener(this, eventoDeUsuario);

	}

	public void userEventReceived(UserEvent evento) {
		int tipo = evento.getType();
		int botao = evento.getCode();

		if (tipo == HKeyEvent.KEY_RELEASED) {

			if (!mostraListaDeAtalhos) {

				if (botao == HRcEvent.VK_COLORED_KEY_0) {// botao vermelho,
															// volta ao menu
															// anterior
					this.resetaTudo();

					TelaMenuPrincipal telaAnterior = TelaMenuPrincipal
							.getInstance(cena);
					telaAnterior.inicia(menu);
				}

				if (botao == HRcEvent.VK_DOWN || botao == HRcEvent.VK_UP
						|| botao == HRcEvent.VK_LEFT
						|| botao == HRcEvent.VK_RIGHT) {

					times.trocaTime(botao);
					mundo.mudaMarcador(times.selecaoCorrente);

					cena.repaint();
				}

				if (botao == HRcEvent.VK_ENTER) {
					
					switch (menu) {

					case TelaMenuPrincipal.subMenuJogadores: {
						this.resetaTudo();
						
						TelaMenuJogador telaJogador = TelaMenuJogador
								.getInstance(cena);

						
						try {
							telaJogador
									.inicia(Copa.getInstance()
											.getSelecaoEspecifica(
													times.selecaoCorrente));
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;
					}
					case TelaMenuPrincipal.subMenuTimes: {
						this.resetaTudo();
						TelaMenuTime telaTime = TelaMenuTime.getInstance(cena);
						telaTime.inicia(Copa.getInstance()
								.getSelecaoEspecifica(times.selecaoCorrente));
						break;
					}
					}

				}
			}

			if (botao == HRcEvent.VK_ASTERISK) {
				mostraListaDeAtalhos = !mostraListaDeAtalhos;
				atalhos.setVisible(mostraListaDeAtalhos);

			}

		}
	}

	private void resetaTudo() {

		this.cena.removeAll();
		this.cena.repaint();
		this.controladorDeEvento.removeUserEventListener(this);

	}

}
