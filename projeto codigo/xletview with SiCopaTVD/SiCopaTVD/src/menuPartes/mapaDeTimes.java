package menuPartes;

import gerenciadores.Imagens;

import java.awt.Container;
import java.util.HashMap;

import org.havi.ui.HIcon;
import org.havi.ui.event.HRcEvent;

import util.Coordenadas;

public class mapaDeTimes extends Container {

	private HIcon times, quadroSelecao, nomeTime;
	private Imagens imagens = Imagens.getInstance();
	private final int larguraMapaDeTimes = 700;
	private final int alturaMapaDeTimes = 200;
	private final int larguraQuadroSelecao = 50;
	private final int alturaQuadroSelecao = 50;
	private final int larguraNomeSelecao = 195;
	private final int alturaNomeSelecao = 50;
	private int posXQuadroSelecao = 24;// posicao inicial do quadro de selecao
										// em relacao ao mapa de times
	private int posYQuadroSelecao = 22;
	private final int espacoEntreTimes = 5;
	public String selecaoCorrente = "AFRICA DO SUL";

	// define o posicionamento dos times em forma de matriz
	private final String mapaDeNomes[][] = {
			{ " ", "ALEMANHA", "DINAMARCA", "ESLOVAQUIA", "ESLOVENIA",
					"ESPANHA", "FRANCA", "GRECIA", "HOLANDA", "INGLATERRA",
					"ITALIA", " " },
			{ "AFRICA DO SUL", "PORTUGAL", "SERVIA", "SUICA", "ARGENTINA",
					"CHILE", "HONDURAS", "ESTADOS UNIDOS", "MEXICO",
					"PARAGUAI", "URUGUAI", "BRASIL" },
			{ " ", "ARGELIA", "CAMAROES", "COSTA DO MARFIM", "GANA", "NIGERIA",
					"COREIA DO NORTE", "COREIA DO SUL", "JAPAO", "AUSTRALIA",
					"NOVA ZELANDIA", " " } };

	private HashMap<String, Coordenadas> tabelaDoMapaDeNomes;

	void constroiTabela() {

		tabelaDoMapaDeNomes = new HashMap<String, Coordenadas>();

		tabelaDoMapaDeNomes.put("ALEMANHA", new Coordenadas(0, 1));
		tabelaDoMapaDeNomes.put("DINAMARCA", new Coordenadas(0, 2));
		tabelaDoMapaDeNomes.put("ESLOVAQUIA", new Coordenadas(0, 3));
		tabelaDoMapaDeNomes.put("ESLOVENIA", new Coordenadas(0, 4));
		tabelaDoMapaDeNomes.put("ESPANHA", new Coordenadas(0, 5));
		tabelaDoMapaDeNomes.put("FRANCA", new Coordenadas(0, 6));
		tabelaDoMapaDeNomes.put("GRECIA", new Coordenadas(0, 7));
		tabelaDoMapaDeNomes.put("HOLANDA", new Coordenadas(0, 8));
		tabelaDoMapaDeNomes.put("INGLATERRA", new Coordenadas(0, 9));
		tabelaDoMapaDeNomes.put("ITALIA", new Coordenadas(0, 10));

		tabelaDoMapaDeNomes.put("AFRICA DO SUL", new Coordenadas(1, 0));
		tabelaDoMapaDeNomes.put("PORTUGAL", new Coordenadas(1, 1));
		tabelaDoMapaDeNomes.put("SERVIA", new Coordenadas(1, 2));
		tabelaDoMapaDeNomes.put("SUICA", new Coordenadas(1, 3));
		tabelaDoMapaDeNomes.put("ARGENTINA", new Coordenadas(1, 4));
		tabelaDoMapaDeNomes.put("CHILE", new Coordenadas(1, 5));
		tabelaDoMapaDeNomes.put("HONDURAS", new Coordenadas(1, 6));
		tabelaDoMapaDeNomes.put("ESTADOS UNIDOS", new Coordenadas(1, 7));
		tabelaDoMapaDeNomes.put("MEXICO", new Coordenadas(1, 8));
		tabelaDoMapaDeNomes.put("PARAGUAI", new Coordenadas(1, 9));
		tabelaDoMapaDeNomes.put("URUGUAI", new Coordenadas(1, 10));
		tabelaDoMapaDeNomes.put("BRASIL", new Coordenadas(1, 11));

		tabelaDoMapaDeNomes.put("ARGELIA", new Coordenadas(2, 1));
		tabelaDoMapaDeNomes.put("CAMAROES", new Coordenadas(2, 2));
		tabelaDoMapaDeNomes.put("COSTA DO MARFIM", new Coordenadas(2, 3));
		tabelaDoMapaDeNomes.put("GANA", new Coordenadas(2, 4));
		tabelaDoMapaDeNomes.put("NIGERIA", new Coordenadas(2, 5));
		tabelaDoMapaDeNomes.put("COREIA DO NORTE", new Coordenadas(2, 6));
		tabelaDoMapaDeNomes.put("COREIA DO SUL", new Coordenadas(2, 7));
		tabelaDoMapaDeNomes.put("JAPAO", new Coordenadas(2, 8));
		tabelaDoMapaDeNomes.put("AUSTRALIA", new Coordenadas(2, 9));
		tabelaDoMapaDeNomes.put("NOVA ZELANDIA", new Coordenadas(2, 10));

	}

	public void setVisible(boolean arg) {
		this.times.setVisible(arg);
		this.quadroSelecao.setVisible(arg);
		this.nomeTime.setVisible(arg);
	}

	public mapaDeTimes() {
		this.setBounds(0, 0, larguraMapaDeTimes, alturaMapaDeTimes
				+ alturaNomeSelecao);
		times = new HIcon(imagens.carregarImagem(util.urls.mapaDeTimes), 0, 0,
				larguraMapaDeTimes, alturaMapaDeTimes);
		quadroSelecao = new HIcon(imagens
				.carregarImagem(util.urls.quadroSelecao), 0, 0,
				larguraQuadroSelecao, alturaQuadroSelecao);
		constroiTabela();
		Coordenadas coordenadasIniciais = tabelaDoMapaDeNomes
				.get(selecaoCorrente);

		nomeTime = new HIcon();
		nomeTime.setBounds(0, 0, larguraNomeSelecao, alturaNomeSelecao);
		trocaNome(selecaoCorrente);

		nomeTime.setLocation((this.getWidth() - larguraNomeSelecao) / 2, 0);
		times.setLocation(0, alturaNomeSelecao);

		quadroSelecao.setLocation(posXQuadroSelecao
				+ (larguraQuadroSelecao + espacoEntreTimes)
				* coordenadasIniciais.getY(), posYQuadroSelecao
				+ (alturaQuadroSelecao + espacoEntreTimes)
				* coordenadasIniciais.getX() + alturaNomeSelecao);

		this.add(nomeTime);
		this.add(quadroSelecao);
		this.add(times);

	}

	public void trocaNome(String nomeSelecao) {

		if (nomeSelecao.toUpperCase().equals("AFRICA DO SUL")) {
			nomeTime.setGraphicContent(imagens
					.carregarImagem(util.urls.nomeAfricaDoSul),
					org.havi.ui.HVisible.NORMAL_STATE);
		} else if (nomeSelecao.toUpperCase().equals("ALEMANHA")) {
			nomeTime.setGraphicContent(imagens
					.carregarImagem(util.urls.nomeAlemanha),
					org.havi.ui.HVisible.NORMAL_STATE);
		} else if (nomeSelecao.toUpperCase().equals("ARGELIA")) {
			nomeTime.setGraphicContent(imagens
					.carregarImagem(util.urls.nomeArgelia),
					org.havi.ui.HVisible.NORMAL_STATE);
		} else if (nomeSelecao.toUpperCase().equals("ARGENTINA")) {
			nomeTime.setGraphicContent(imagens
					.carregarImagem(util.urls.nomeArgentina),
					org.havi.ui.HVisible.NORMAL_STATE);
		} else if (nomeSelecao.toUpperCase().equals("AUSTRALIA")) {
			nomeTime.setGraphicContent(imagens
					.carregarImagem(util.urls.nomeAustralia),
					org.havi.ui.HVisible.NORMAL_STATE);
		} else if (nomeSelecao.toUpperCase().equals("BRASIL")) {
			nomeTime.setGraphicContent(imagens
					.carregarImagem(util.urls.nomeBrasil),
					org.havi.ui.HVisible.NORMAL_STATE);
		} else if (nomeSelecao.toUpperCase().equals("CAMAROES")) {
			nomeTime.setGraphicContent(imagens
					.carregarImagem(util.urls.nomeCamaroes),
					org.havi.ui.HVisible.NORMAL_STATE);
		} else if (nomeSelecao.toUpperCase().equals("CHILE")) {
			nomeTime.setGraphicContent(imagens
					.carregarImagem(util.urls.nomeChile),
					org.havi.ui.HVisible.NORMAL_STATE);
		} else if (nomeSelecao.toUpperCase().equals("COREIA DO NORTE")) {
			nomeTime.setGraphicContent(imagens
					.carregarImagem(util.urls.nomeCoreiaDoNorte),
					org.havi.ui.HVisible.NORMAL_STATE);
		} else if (nomeSelecao.toUpperCase().equals("COREIA DO SUL")) {
			nomeTime.setGraphicContent(imagens
					.carregarImagem(util.urls.nomeCoreiaDoSul),
					org.havi.ui.HVisible.NORMAL_STATE);
		} else if (nomeSelecao.toUpperCase().equals("COSTA DO MARFIM")) {
			nomeTime.setGraphicContent(imagens
					.carregarImagem(util.urls.nomeCostaDoMarfim),
					org.havi.ui.HVisible.NORMAL_STATE);
		} else if (nomeSelecao.toUpperCase().equals("DINAMARCA")) {
			nomeTime.setGraphicContent(imagens
					.carregarImagem(util.urls.nomeDinamarca),
					org.havi.ui.HVisible.NORMAL_STATE);
		} else if (nomeSelecao.toUpperCase().equals("ESLOVAQUIA")) {
			nomeTime.setGraphicContent(imagens
					.carregarImagem(util.urls.nomeEslovaquia),
					org.havi.ui.HVisible.NORMAL_STATE);
		} else if (nomeSelecao.toUpperCase().equals("ESLOVENIA")) {
			nomeTime.setGraphicContent(imagens
					.carregarImagem(util.urls.nomeEslovenia),
					org.havi.ui.HVisible.NORMAL_STATE);
		} else if (nomeSelecao.toUpperCase().equals("ESPANHA")) {
			nomeTime.setGraphicContent(imagens
					.carregarImagem(util.urls.nomeEspanha),
					org.havi.ui.HVisible.NORMAL_STATE);
		} else if (nomeSelecao.toUpperCase().equals("ESTADOS UNIDOS")) {
			nomeTime.setGraphicContent(imagens
					.carregarImagem(util.urls.nomeEstadosUnidos),
					org.havi.ui.HVisible.NORMAL_STATE);
		} else if (nomeSelecao.toUpperCase().equals("FRANCA")) {
			nomeTime.setGraphicContent(imagens
					.carregarImagem(util.urls.nomeFranca),
					org.havi.ui.HVisible.NORMAL_STATE);
		} else if (nomeSelecao.toUpperCase().equals("GANA")) {
			nomeTime.setGraphicContent(imagens
					.carregarImagem(util.urls.nomeGana),
					org.havi.ui.HVisible.NORMAL_STATE);
		} else if (nomeSelecao.toUpperCase().equals("GRECIA")) {
			nomeTime.setGraphicContent(imagens
					.carregarImagem(util.urls.nomeGrecia),
					org.havi.ui.HVisible.NORMAL_STATE);
		} else if (nomeSelecao.toUpperCase().equals("HOLANDA")) {
			nomeTime.setGraphicContent(imagens
					.carregarImagem(util.urls.nomeHolanda),
					org.havi.ui.HVisible.NORMAL_STATE);
		} else if (nomeSelecao.toUpperCase().equals("HONDURAS")) {
			nomeTime.setGraphicContent(imagens
					.carregarImagem(util.urls.nomeHonduras),
					org.havi.ui.HVisible.NORMAL_STATE);
		} else if (nomeSelecao.toUpperCase().equals("INGLATERRA")) {
			nomeTime.setGraphicContent(imagens
					.carregarImagem(util.urls.nomeInglaterra),
					org.havi.ui.HVisible.NORMAL_STATE);
		} else if (nomeSelecao.toUpperCase().equals("ITALIA")) {
			nomeTime.setGraphicContent(imagens
					.carregarImagem(util.urls.nomeItalia),
					org.havi.ui.HVisible.NORMAL_STATE);
		} else if (nomeSelecao.toUpperCase().equals("JAPAO")) {
			nomeTime.setGraphicContent(imagens
					.carregarImagem(util.urls.nomeJapao),
					org.havi.ui.HVisible.NORMAL_STATE);
		} else if (nomeSelecao.toUpperCase().equals("MEXICO")) {
			nomeTime.setGraphicContent(imagens
					.carregarImagem(util.urls.nomeMexico),
					org.havi.ui.HVisible.NORMAL_STATE);
		} else if (nomeSelecao.toUpperCase().equals("NIGERIA")) {
			nomeTime.setGraphicContent(imagens
					.carregarImagem(util.urls.nomeNigeria),
					org.havi.ui.HVisible.NORMAL_STATE);
		} else if (nomeSelecao.toUpperCase().equals("NOVA ZELANDIA")) {
			nomeTime.setGraphicContent(imagens
					.carregarImagem(util.urls.nomeNovaZelandia),
					org.havi.ui.HVisible.NORMAL_STATE);
		} else if (nomeSelecao.toUpperCase().equals("PARAGUAI")) {
			nomeTime.setGraphicContent(imagens
					.carregarImagem(util.urls.nomeParaguai),
					org.havi.ui.HVisible.NORMAL_STATE);
		} else if (nomeSelecao.toUpperCase().equals("PORTUGAL")) {
			nomeTime.setGraphicContent(imagens
					.carregarImagem(util.urls.nomePortugal),
					org.havi.ui.HVisible.NORMAL_STATE);
		} else if (nomeSelecao.toUpperCase().equals("SERVIA")) {
			nomeTime.setGraphicContent(imagens
					.carregarImagem(util.urls.nomeServia),
					org.havi.ui.HVisible.NORMAL_STATE);
		} else if (nomeSelecao.toUpperCase().equals("SUICA")) {
			nomeTime.setGraphicContent(imagens
					.carregarImagem(util.urls.nomeSuica),
					org.havi.ui.HVisible.NORMAL_STATE);
		} else if (nomeSelecao.toUpperCase().equals("URUGUAI")) {
			nomeTime.setGraphicContent(imagens
					.carregarImagem(util.urls.nomeUruguai),
					org.havi.ui.HVisible.NORMAL_STATE);
		}

	}

	public void trocaTime(int direcao) {
		int di = 0;
		int dj = 0;
		Coordenadas coordenadaCorrente = tabelaDoMapaDeNomes
				.get(selecaoCorrente);
		Coordenadas coordenadasNovas;

		if (direcao == HRcEvent.VK_UP) {
			if (selecaoCorrente.equals("AFRICA DO SUL")
					|| selecaoCorrente.equals("BRASIL"))
				di = 0;
			else if (coordenadaCorrente.getX() == 0)
				di = 2;
			else
				di = -1;
		} else if (direcao == HRcEvent.VK_DOWN) {
			if (selecaoCorrente.equals("AFRICA DO SUL")
					|| selecaoCorrente.equals("BRASIL"))
				di = 0;
			else
				di = 1;
		} else if (direcao == HRcEvent.VK_LEFT) {
			if (selecaoCorrente.equals("ALEMANHA")
					|| selecaoCorrente.equals("ARGELIA")) {
				dj = 9;
			} else if (selecaoCorrente.equals("AFRICA DO SUL"))
				dj = 11;
			else
				dj = -1;
		} else if (direcao == HRcEvent.VK_RIGHT) {
			if (selecaoCorrente.equals("ITALIA")
					|| selecaoCorrente.equals("NOVA ZELANDIA")) {
				dj = 3;
			} else
				dj = 1;
		}

		coordenadasNovas = new Coordenadas(
				(coordenadaCorrente.getX() + di) % 3, (coordenadaCorrente
						.getY() + dj) % 12);
		selecaoCorrente = mapaDeNomes[coordenadasNovas.getX()][coordenadasNovas
				.getY()];

		quadroSelecao.setLocation(posXQuadroSelecao
				+ (larguraQuadroSelecao + espacoEntreTimes)
				* coordenadasNovas.getY(), posYQuadroSelecao
				+ (alturaQuadroSelecao + espacoEntreTimes)
				* coordenadasNovas.getX() + alturaNomeSelecao);
		trocaNome(selecaoCorrente);

	}

}
