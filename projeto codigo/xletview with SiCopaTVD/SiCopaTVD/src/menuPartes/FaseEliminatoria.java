package menuPartes;

import gerenciadores.Imagens;

import util.urls;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import org.havi.ui.HIcon;
import org.havi.ui.HScene;
import org.havi.ui.HStaticText;
import org.havi.ui.HVisible;
import org.havi.ui.event.HRcEvent;

import persistencia.Jogo;

public class FaseEliminatoria extends Container {
	private HIcon oitavasIcone, quartasIcone, semiIcone, finalIcone,
			terceiroIcone, trofeuIcone, nomeFase, oitavasGrade, quartasGrade,
			semiGrade;
	private jogosTexto oitavasTexto, quartasTexto, semiTexto, finalTexto,
			terceiroTexto;
	private int faseCorrente;

	Imagens imagens = Imagens.getInstance();

	// dimensoes e posicoes
	final int larguraOitavasIcone = 320;
	final int alturaOitavasIcone = 475;
	final int larguraQuartasIcone = 320;
	final int alturaQuartasIcone = 241;
	final int larguraSemiIcone = 320;
	final int alturaSemiIcone = 123;
	final int larguraFinalIcone = 320;
	final int alturaFinalIcone = 63;
	final int larguraTerceiroIcone = 320;
	final int alturaTerceiroIcone = 63;
	final int larguraTrofeuIcone = 85;
	final int alturaTrofeuIcone = 203;

	final int larguraOitavasTexto = 1;
	final int alturaOitavasTexto = 1;
	final int larguraQuartasTexto = 1;
	final int alturaQuartasTexto = 1;
	final int larguraSemiTexto = 1;
	final int alturaSemiTexto = 1;
	final int larguraFinalTexto = 1;
	final int alturaFinalTexto = 1;
	final int larguraTerceiroTexto = 1;
	final int alturaTerceiroTexto = 1;
	final int larguraTrofeuTexto = 1;
	final int alturaTrofeuTexto = 1;

	final int larguraOitavasGrade = 117;
	final int alturaOitavasGrade = 426;
	final int larguraQuartasGrade = 101;
	final int alturaQuartasGrade = 188;
	final int larguraSemiGrade = 101;
	final int alturaSemiGrade = 103;

	final int larguraEliminatoria = 1;
	final int alturaEliminatoria = 1;

	private final int larguraNomeFase = 260;
	private final int alturaNomeFase = 85;

	public FaseEliminatoria(HScene cena) {

		faseCorrente = 0;
		this.setSize(cena.getWidth(), cena.getHeight());
		iniciandoComponentes(cena);
		nomeFase = new HIcon();
		nomeFase.setBounds(cena.getWidth() - larguraNomeFase, 5,
				larguraNomeFase, alturaNomeFase);
		nomeFase.setGraphicContent(imagens.carregarImagem(util.urls.oitavas),
				HVisible.NORMAL_STATE);

		this.add(nomeFase);
		this.add(oitavasTexto);
		this.add(oitavasIcone);

		this.add(quartasTexto);
		this.add(quartasIcone);

		this.add(semiTexto);
		this.add(semiIcone);

		this.add(finalTexto);
		this.add(finalIcone);

		this.add(terceiroTexto);
		this.add(terceiroIcone);

		this.add(trofeuIcone);

		this.add(oitavasGrade);
		this.add(quartasGrade);
		this.add(semiGrade);

	}

	private void iniciandoComponentes(HScene cena) {
		oitavasIcone = new HIcon(
				imagens.carregarImagem(util.urls.oitavasIcone), (cena
						.getWidth() - larguraOitavasIcone) / 2 - 20, 20,
				larguraOitavasIcone, alturaOitavasIcone);
		quartasIcone = new HIcon(
				imagens.carregarImagem(util.urls.quartasIcone), (cena
						.getWidth() - larguraQuartasIcone) / 2, (cena
						.getHeight() - alturaQuartasIcone) / 2,
				larguraQuartasIcone, alturaQuartasIcone);
		semiIcone = new HIcon(imagens.carregarImagem(util.urls.semiIcone),
				(cena.getWidth() - larguraSemiIcone) / 2,
				(cena.getHeight() - alturaSemiIcone) / 2, larguraSemiIcone,
				alturaSemiIcone);
		int posYTrofeu = (cena.getHeight() - (2 * alturaTrofeuIcone + alturaFinalIcone)) / 2;
		int posYfinal = alturaTrofeuIcone + posYTrofeu;

		finalIcone = new HIcon(imagens.carregarImagem(util.urls.finalIcone),
				(cena.getWidth() - larguraFinalIcone) / 2, posYfinal,
				larguraFinalIcone, alturaFinalIcone);
		terceiroIcone = new HIcon(imagens
				.carregarImagem(util.urls.terceiroIcone),
				(cena.getWidth() - larguraTerceiroIcone), cena.getHeight() - 2
						* alturaTerceiroIcone, larguraTerceiroIcone,
				alturaTerceiroIcone);
		trofeuIcone = new HIcon(imagens.carregarImagem(util.urls.trofeuIcone),
				(cena.getWidth() - larguraTrofeuIcone) / 2, posYTrofeu,
				larguraTrofeuIcone, alturaTrofeuIcone);

		oitavasGrade = new HIcon(
				imagens.carregarImagem(util.urls.oitavasGrade), oitavasIcone
						.getX()
						+ oitavasIcone.getWidth() - 10,
				oitavasIcone.getY() + 20, larguraOitavasGrade,
				alturaOitavasGrade);
		quartasGrade = new HIcon(
				imagens.carregarImagem(util.urls.quartasGrade), quartasIcone
						.getX()
						+ quartasIcone.getWidth() - 10,
				quartasIcone.getY() + 20, larguraQuartasGrade,
				alturaQuartasGrade);
		semiGrade = new HIcon(imagens.carregarImagem(util.urls.semiGrade),
				semiIcone.getX() + semiIcone.getWidth() - 3,
				semiIcone.getY() + 10, larguraSemiGrade, alturaSemiGrade);

		oitavasIcone.setVisible(true);
		oitavasGrade.setVisible(true);
		quartasIcone.setVisible(false);
		quartasGrade.setVisible(false);
		semiIcone.setVisible(false);
		semiGrade.setVisible(false);
		finalIcone.setVisible(false);
		terceiroIcone.setVisible(false);
		trofeuIcone.setVisible(false);

		oitavasTexto = new jogosTexto("Oitavas", larguraOitavasIcone,
				alturaOitavasIcone);
		quartasTexto = new jogosTexto("Quartas", larguraQuartasIcone,
				alturaQuartasIcone);
		semiTexto = new jogosTexto("Semi", larguraSemiIcone, alturaSemiIcone);
		finalTexto = new jogosTexto("Final", larguraFinalIcone,
				alturaFinalIcone);
		terceiroTexto = new jogosTexto("Terceiro", larguraTerceiroIcone,
				alturaTerceiroIcone);

		oitavasTexto.setLocation(oitavasIcone.getX(), oitavasIcone.getY());
		quartasTexto.setLocation(quartasIcone.getX(), quartasIcone.getY());

		oitavasTexto.setVisible(true);
		quartasTexto.setVisible(false);

	}

	public void trocaFase(int botao) {
		int proxima;
		if (botao == HRcEvent.VK_DOWN) {
			proxima = (faseCorrente + 1) % 4;

		} else {
			proxima = faseCorrente == 0 ? 3 : (faseCorrente - 1);
		}

		Image imagemNome = null;

		// escondendo os menu
		switch (faseCorrente) {
		case 0: {
			oitavasGrade.setVisible(false);
			oitavasIcone.setVisible(false);
			oitavasTexto.setVisible(false);
			break;
		}
		case 1: {
			quartasGrade.setVisible(false);
			quartasIcone.setVisible(false);
			quartasTexto.setVisible(false);
			break;
		}
		case 2: {
			semiGrade.setVisible(false);
			semiIcone.setVisible(false);
			semiTexto.setVisible(false);
			break;
		}
		case 3: {

			finalIcone.setVisible(false);
			finalTexto.setVisible(false);
			terceiroTexto.setVisible(false);
			terceiroIcone.setVisible(false);
			trofeuIcone.setVisible(false);
			break;
		}
		}

		// mostrando os novos menus
		switch (proxima) {
		case 0: {
			imagemNome = imagens.carregarImagem(util.urls.oitavas);
			oitavasIcone.setVisible(true);
			oitavasGrade.setVisible(true);
			oitavasTexto.setVisible(true);
			break;
		}
		case 1: {
			imagemNome = imagens.carregarImagem(util.urls.quartas);
			quartasIcone.setVisible(true);
			quartasGrade.setVisible(true);
			quartasTexto.setVisible(true);
			break;
		}
		case 2: {
			imagemNome = imagens.carregarImagem(util.urls.semi);
			semiIcone.setVisible(true);
			semiGrade.setVisible(true);
			semiTexto.setVisible(true);
			break;
		}
		case 3: {
			imagemNome = imagens.carregarImagem(util.urls.finalNome);
			finalIcone.setVisible(true);
			finalTexto.setVisible(true);
			terceiroTexto.setVisible(true);
			terceiroIcone.setVisible(true);
			trofeuIcone.setVisible(true);
			break;
		}

		}

		faseCorrente = proxima;

		nomeFase.setGraphicContent(imagemNome, HVisible.NORMAL_STATE);
		nomeFase.repaint();
		this.repaint();

	}

	public class jogosTexto extends Container {
		int posXTime1Jogo = 7;
		int posYTime1Jogo = 24;
		int posXTime2Jogo = 200;
		int posYTime2Jogo = 24;
		int posXLocalJogo;
		int posYLocalJogo = 2;
		int posXHoraJogo = 43;
		int posYHoraJogo = 2;
		int espacamentoYJogos = 57;
		int espacamentoYHora = 57;
		int espacamentoYLocal = 57;

		List<HStaticText> listaDeTexto = new ArrayList<HStaticText>();
		private int posYGolsA = posYTime1Jogo;
		private int espacamentoYGols = espacamentoYJogos;
		private int posXGolsA = 120;
		private int posYGolsB = posYTime1Jogo;
		private int posXGolsB = 176;

		public jogosTexto(String grupo, int larguraTabelaGrupoIcon,
				int alturaTabelaGrupoIcon) {
			this.setBounds(0, 0, larguraTabelaGrupoIcon, alturaTabelaGrupoIcon);
			List<Jogo> jogos = null;

			if (grupo.equals("Oitavas"))
				jogos = !persistencia.Copa.getInstance().getTabela().oitavasJogos
						.isEmpty() ? persistencia.Copa.getInstance()
						.getTabela().oitavasJogos : new ArrayList<Jogo>();
			;
			if (grupo.equals("Quartas"))
				jogos = !persistencia.Copa.getInstance().getTabela().quartasJogos
						.isEmpty() ? persistencia.Copa.getInstance()
						.getTabela().quartasJogos : new ArrayList<Jogo>();
			if (grupo.equals("Semi"))
				jogos = !persistencia.Copa.getInstance().getTabela().semiFinaisJogos
						.isEmpty() ? persistencia.Copa.getInstance()
						.getTabela().semiFinaisJogos : new ArrayList<Jogo>();
			;
			if (grupo.equals("Final")) {
				jogos = new ArrayList<Jogo>();
				if (persistencia.Copa.getInstance().getTabela().finalJogo != null)
					jogos
							.add(persistencia.Copa.getInstance().getTabela().finalJogo);
			}
			if (grupo.equals("Terceiro")) {
				jogos = new ArrayList<Jogo>();
				if (persistencia.Copa.getInstance().getTabela().terceiroLugarJogo != null)
					jogos
							.add(persistencia.Copa.getInstance().getTabela().terceiroLugarJogo);
			}

			// criando textos
			if (!jogos.isEmpty())
				for (int i = 0; i < jogos.size(); i++) {
					String timeANome = abreviaSelecao(jogos.get(i).getTimeA()
							.getNome());
					String timeBNome = abreviaSelecao(jogos.get(i).getTimeB()
							.getNome());
					String localNome = jogos.get(i).getLocal().getNome();
					String horario = jogos.get(i).getData().toString() + "-"
							+ jogos.get(i).getHoraInicio();
					String golsA = String.valueOf(jogos.get(i)
							.getTotalGolsTimeA());
					String golsB = String.valueOf(jogos.get(i)
							.getTotalGolsTimeB());

					System.out.println("Jogo " + i + "\n" + timeANome + " "
							+ golsA + " x " + golsB + " " + timeBNome + " as "
							+ horario + " em " + localNome);

					HStaticText timeANomeText = new HStaticText();
					timeANomeText.setForeground(Color.white);
					timeANomeText.setBackgroundMode(Color.TRANSLUCENT);
					timeANomeText.setFont(Font.decode("ARIAL-15"));
					timeANomeText.setHorizontalAlignment(HVisible.HALIGN_LEFT);
					timeANomeText.setVerticalAlignment(HVisible.VALIGN_TOP);
					timeANomeText.setSize(100, 70);

					HStaticText timeBNomeText = new HStaticText();
					timeBNomeText.setForeground(Color.white);
					timeBNomeText.setBackgroundMode(Color.TRANSLUCENT);
					timeBNomeText.setFont(Font.decode("ARIAL-15"));
					timeBNomeText.setHorizontalAlignment(HVisible.HALIGN_LEFT);
					timeBNomeText.setVerticalAlignment(HVisible.VALIGN_TOP);
					timeBNomeText.setSize(100, 70);

					HStaticText localNomeText = new HStaticText();
					localNomeText.setSize(150, 70);
					localNomeText.setForeground(Color.white);
					localNomeText.setBackgroundMode(Color.TRANSLUCENT);
					localNomeText.setFont(Font.decode("ARIAL-10"));
					localNomeText.setHorizontalAlignment(HVisible.HALIGN_LEFT);
					localNomeText.setVerticalAlignment(HVisible.VALIGN_TOP);

					HStaticText horarioText = new HStaticText();
					horarioText.setForeground(Color.white);
					horarioText.setBackgroundMode(Color.TRANSLUCENT);
					horarioText.setFont(Font.decode("ARIAL-10"));
					horarioText.setHorizontalAlignment(HVisible.HALIGN_LEFT);
					horarioText.setVerticalAlignment(HVisible.VALIGN_TOP);
					horarioText.setSize(100, 70);

					HStaticText golsAText = new HStaticText();
					golsAText.setForeground(Color.black);
					golsAText.setBackground(Color.red);
					golsAText.setBackgroundMode(Color.TRANSLUCENT);
					golsAText.setFont(Font.decode("ARIAL-20"));
					golsAText.setHorizontalAlignment(HVisible.HALIGN_LEFT);
					golsAText.setVerticalAlignment(HVisible.VALIGN_TOP);
					golsAText.setSize(50, 50);

					HStaticText golsBText = new HStaticText();
					golsBText.setForeground(Color.black);
					golsBText.setBackground(Color.red);
					golsBText.setBackgroundMode(Color.TRANSLUCENT);
					golsBText.setFont(Font.decode("ARIAL-20"));
					golsBText.setHorizontalAlignment(HVisible.HALIGN_LEFT);
					golsBText.setVerticalAlignment(HVisible.VALIGN_TOP);
					golsBText.setSize(50, 50);

					// setando conteudo
					timeANomeText.setTextContent(timeANome,
							HVisible.NORMAL_STATE);
					timeBNomeText.setTextContent(timeBNome,
							HVisible.NORMAL_STATE);
					localNomeText.setTextContent(localNome,
							HVisible.NORMAL_STATE);
					horarioText.setTextContent(horario, HVisible.NORMAL_STATE);
					golsAText.setTextContent(golsA, HVisible.NORMAL_STATE);
					golsBText.setTextContent(golsB, HVisible.NORMAL_STATE);

					// posicionando locais dos textos

					timeANomeText.setLocation(posXTime1Jogo, posYTime1Jogo
							+ (i * (espacamentoYJogos + i / 3)));
					timeBNomeText.setLocation(posXTime2Jogo, posYTime2Jogo
							+ (i * (espacamentoYJogos + i / 3)));

					localNomeText.setLocation(posXHoraJogo
							+ horarioText.getWidth(), posYLocalJogo
							+ (i * (espacamentoYLocal + i / 3)));
					horarioText.setLocation(posXHoraJogo, posYHoraJogo
							+ (i * (espacamentoYHora + i / 3)));

					golsAText.setLocation(posXGolsA, posYGolsA
							+ (i * (espacamentoYGols + i / 3)));
					golsBText.setLocation(posXGolsB, posYGolsB
							+ (i * (espacamentoYGols + i / 3)));

					timeANomeText.setVisible(true);
					timeBNomeText.setVisible(true);
					localNomeText.setVisible(true);
					horarioText.setVisible(true);
					golsAText.setVisible(true);
					golsBText.setVisible(true);

					this.add(golsAText);
					this.add(golsBText);
					this.add(timeANomeText);
					this.add(timeBNomeText);
					this.add(localNomeText);
					this.add(horarioText);

				}

			this.repaint();

		}

		private String abreviaSelecao(String nomeSelecao) {

			String resp = null;

			if (nomeSelecao.toUpperCase().equals("AFRICA DO SUL")) {
				resp = "AFRICA S.";

			} else if (nomeSelecao.toUpperCase().equals("COREIA DO NORTE")) {
				resp = "COREIA N.";
			} else if (nomeSelecao.toUpperCase().equals("COREIA DO SUL")) {
				resp = "COREIA S.";
			} else if (nomeSelecao.toUpperCase().equals("COSTA DO MARFIM")) {
				resp = "COSTA M.";

			} else if (nomeSelecao.toUpperCase().equals("ESTADOS UNIDOS")) {
				resp = "ESTADOS U.";

			} else if (nomeSelecao.toUpperCase().equals("INGLATERRA")) {
				resp = "INGLATERRA";

			} else if (nomeSelecao.toUpperCase().equals("NOVA ZELANDIA")) {
				resp = "NOVA Z.";

			} else {
				resp = nomeSelecao;
			}

			return resp;

		}

	}

}
