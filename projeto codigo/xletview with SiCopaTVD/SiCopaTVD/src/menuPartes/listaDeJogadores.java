package menuPartes;

import gerenciadores.Imagens;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.havi.ui.*;

import persistencia.Selecao;
import persistencia.Jogador;
import persistencia.Copa;

public class listaDeJogadores extends HContainer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static Selecao selecaoCorrente;
	private static List<HIcon> menuJogadores;
	private static List<HStaticText> menuJogadoresApelido;
	public static int jogadorCorrente;
	private static HIcon iconeIdentificador;
	private static HStaticText infoPagina;
	private Imagens imagens = Imagens.getInstance();

	private static int larguraIcone = 171;
	private static int alturaIcone = 38;
	private static int larguraApelido = larguraIcone - 20;
	private static int alturaApelido = alturaIcone - 10;
	private static int posXApelido = (larguraIcone - larguraApelido) / 2;
	private static int posYApelido = (alturaIcone - alturaApelido) / 2;
	public static int paginaCorrente;
	public static int qtdePaginas;

	public listaDeJogadores(Selecao selecao) {

		this.menuJogadores = new ArrayList<HIcon>();
		this.menuJogadoresApelido = new ArrayList<HStaticText>();
		this.selecaoCorrente = selecao;
		this.jogadorCorrente = 0;// o primeiro jogador
		this.paginaCorrente = 1;
		this.qtdePaginas = (selecaoCorrente.getJogadores().size() + 10) / 11;

		this.setBounds(0, 0, larguraIcone, alturaIcone * 11);
		this.iconeIdentificador = new HIcon(imagens
				.carregarImagem(util.urls.escolhidoOp), 0, 0, larguraIcone,
				alturaIcone);

		HDefaultTextLayoutManager controladorDeLayoutDeTexto = new HDefaultTextLayoutManager();

		// criando os icones e adicionando ao componente

		
		for (int i = 0; i < selecaoCorrente.getJogadores().size(); i++) {
			menuJogadores.add(new HIcon(imagens
					.carregarImagem(util.urls.escolhaOp), 0, 0, larguraIcone,
					alturaIcone));

			menuJogadores.get(i).setLocation(0, ((i % 11) * alturaIcone));
			String apelido = selecaoCorrente.getJogadores().get(i).getNome();
			apelido = apelido.substring(0, apelido.indexOf(","));

			HStaticText apelidoJogador = new HStaticText(apelido, posXApelido,
					((i % 11) * alturaIcone + posYApelido), larguraApelido,
					alturaApelido, Font.decode(util.FormataString.fonteString),
					Color.white, null, controladorDeLayoutDeTexto);
			apelidoJogador.setBackgroundMode(Color.TRANSLUCENT);
			apelidoJogador.setHorizontalAlignment(HVisible.HALIGN_CENTER);
			apelidoJogador.setVerticalAlignment(HVisible.VALIGN_CENTER);

			menuJogadoresApelido.add(apelidoJogador);

			this.add(menuJogadoresApelido.get(i));
			this.add(menuJogadores.get(i));

		}
		
		this.add(iconeIdentificador, 0);

	}

	public void setVisible(boolean arg) {
		iconeIdentificador.setVisible(arg);
		for (int i = 0; i < menuJogadores.size(); i++) {
			if (i <= 10)
				menuJogadores.get(i).setVisible(true);
			else
				menuJogadores.get(i).setVisible(false);
		}
	}

	public static void trocaJogador(int botao) {
		int direcao;
		int proximoJogador;
		if (botao == org.havi.ui.event.HRcEvent.VK_DOWN) {

			direcao = 1;

		} else {
			if (jogadorCorrente % 11 == 0) {
				direcao = (paginaCorrente * 11) >= menuJogadores.size() ? menuJogadores
						.size()
						- jogadorCorrente - 1
						: 10;

			} else
				direcao = -1;
		}

		proximoJogador = jogadorCorrente + direcao;

		if (jogadorCorrente + direcao >= menuJogadores.size()
				|| jogadorCorrente + direcao >= (paginaCorrente) * 11) {
			proximoJogador = (paginaCorrente - 1) * 11;
		}

		iconeIdentificador
				.setLocation(0, ((proximoJogador) % 11) * alturaIcone);
		jogadorCorrente = proximoJogador;

	}

	public void trocaPagina(int atual, int botao) {
		int proxima;
		if (botao == org.havi.ui.event.HRcEvent.VK_RIGHT) {
			proxima = (atual + 1) % qtdePaginas;
			if (proxima == 0)
				proxima = qtdePaginas;
		} else {
			if (atual == 1)
				proxima = qtdePaginas;
			else
				proxima = (atual - 1) % qtdePaginas;
		}

		
		for (int i = 0; i < 11; i++) {

			// desabilita a pagina corrente
			if (i + (atual - 1) * 11 < menuJogadores.size()) {
				menuJogadores.get(i + (atual - 1) * 11).setVisible(false);
				menuJogadoresApelido.get(i + (atual - 1) * 11)
						.setVisible(false);
			}
			// habilta a proxima pagina
			if (i + (proxima - 1) * 11 < menuJogadores.size()) {
				menuJogadores.get(i + (proxima - 1) * 11).setVisible(true);
				menuJogadoresApelido.get(i + (proxima - 1) * 11).setVisible(
						true);
			}

		}

		jogadorCorrente = (proxima - 1) * 11;
		iconeIdentificador.setLocation(0, 0);
		paginaCorrente = proxima;
		this.repaint();

	}

	public static Jogador getJogadorCorrente() {
		return selecaoCorrente.getJogadores().get(jogadorCorrente);

	}

}
