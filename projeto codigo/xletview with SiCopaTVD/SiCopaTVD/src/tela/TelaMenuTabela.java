package tela;

import gerenciadores.Imagens;
import menuPartes.FaseEliminatoria;
import menuPartes.FaseGrupos;
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

public class TelaMenuTabela implements UserEventListener {

	// definindo as variaveis da tela
	private HScene cena;
	private HIcon tabelaFundo, nomeFase;
	public logoPrograma logo;
	private FaseGrupos faseGrupos;
	private FaseEliminatoria faseEliminatoria;

	// gerenciadores
	Imagens imagens = Imagens.getInstance();
	private EventManager controladorDeEvento;

	// ajuda/atalhos
	private listaDeAtalhos atalhos;
	private boolean mostrandoListaDeAtalhos = false;
	private boolean mostrandoEliminatorias = false;

	private final int larguraNomeFase = 250;
	private final int alturaNomeFase = 85;

	private int posYFase1 = 10;

	public TelaMenuTabela(HScene cena) {
		this.cena = cena;
		this.controladorDeEvento = EventManager.getInstance();
	}

	public void inicia() {
		tabelaFundo = new HIcon(imagens.carregarImagem(util.urls.menuTabela),
				0, 0, cena.getWidth(), cena.getHeight());
		faseGrupos = new FaseGrupos();
		faseEliminatoria = new FaseEliminatoria(cena);
		faseGrupos.setLocation((cena.getWidth() - faseGrupos.getWidth()) / 2,
				(cena.getHeight() - faseGrupos.getHeight()) / 2);
		nomeFase = new HIcon(imagens.carregarImagem(util.urls.grupos), cena
				.getWidth()
				- larguraNomeFase, 5, larguraNomeFase, alturaNomeFase);

		faseGrupos.setVisible(!mostrandoEliminatorias);
		faseEliminatoria.setVisible(mostrandoEliminatorias);
		nomeFase.setVisible(!mostrandoEliminatorias);

		logo = new logoPrograma();

		// adicionando os botoes que contem acao ao gerenciador de botoes
		criaAtalhos();

		cena.add(logo);
		cena.add(atalhos);
		cena.add(nomeFase);
		cena.add(faseEliminatoria);
		cena.add(faseGrupos);
		cena.add(tabelaFundo);
		cena.repaint();

		System.out.println();

	}

	private void criaAtalhos() {
		// (String vermelho,String verde,String amarelo,String azul, String
		// cimaBaixo,String esquerdaDireita,String ok, String num1a9,String
		// asterisco,String num0,String quadrado,String exit, String
		// menos,String mais){
		atalhos = new listaDeAtalhos("Volta o menu ", " ", " ", " ",
				" Troca a fase", " Troca a pagina", " ", " ",
				"Entra/Sai ajuda ", " ", " ", " ", " ", " ");
		atalhos.setVisible(false);

		UserEventRepository eventoDeUsuario = new UserEventRepository(
				"TelaMenuTabela");
		eventoDeUsuario.addKey(HRcEvent.VK_ASTERISK);
		eventoDeUsuario.addAllArrowKeys();
		eventoDeUsuario.addAllColourKeys();
		eventoDeUsuario.addKey(HRcEvent.VK_ENTER);
		eventoDeUsuario.addKey(HRcEvent.VK_CHANNEL_DOWN);
		eventoDeUsuario.addKey(HRcEvent.VK_CHANNEL_UP);
		eventoDeUsuario.addKey(HRcEvent.VK_0);
		controladorDeEvento.addUserEventListener(this, eventoDeUsuario);

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
					telaAnterior.inicia(TelaMenuPrincipal.subMenuTabela);
				}
				// troca o pagina dentro da mesma fase
				if (mostrandoEliminatorias == false)
					if (botao == HKeyEvent.VK_LEFT
							|| botao == HKeyEvent.VK_RIGHT) {
						faseGrupos.trocaPagina(faseGrupos.proxima(botao));
					}

				if (mostrandoEliminatorias == true)
					if (botao == HKeyEvent.VK_UP || botao == HKeyEvent.VK_DOWN) {
						faseEliminatoria.trocaFase(botao);
					}

				if (botao == HRcEvent.VK_0) {

					mostrandoEliminatorias = !mostrandoEliminatorias;
					nomeFase.setVisible(!mostrandoEliminatorias);
					faseEliminatoria.setVisible(mostrandoEliminatorias);
					faseGrupos.setVisible(!mostrandoEliminatorias);

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
