package menuPartes;

import gerenciadores.Imagens;

import java.awt.Container;
import java.util.HashMap;

import org.havi.ui.HIcon;
import org.havi.ui.event.HRcEvent;

import util.Coordenadas;

public class mapaDeSedes extends Container {

	private HIcon sedes, quadroSedes;
	private Imagens imagens = Imagens.getInstance();
	private final int larguraMapaDeSedes = 280;
	private final int alturaMapaDeSedes = 165;
	private final int larguraQuadroSedes = 87;
	private final int alturaQuadroSedes = 36;
	private int posXQuadroSelecao = 4;// posicao inicial do quadro de selecao
										// em relacao ao mapa de times
	private int posYQuadroSelecao = 4;
	private final int espacoEntreSedesX = 6;
	private final int espacoEntreSedesY = 4;
	public String sedeCorrente = "SOCCER CITY";

	private final String mapaDeSedes[][] = {
			{ "ELLIS PARK", "FREE STATE", "GREEN POINT" },
			{ "LOFTUS VERSFELD", "MBOMBELA", "MOSES MABHIDA" },
			{ "NELSON MANDELA BAY", "PETER MOKABA", "ROYAL BAFOKENG" },
			{ " ", " ", "SOCCER CITY" } };

	private HashMap<String, Coordenadas> tabelaDoMapaDeNomes;

	void constroiTabela() {

		tabelaDoMapaDeNomes = new HashMap<String, Coordenadas>();

		tabelaDoMapaDeNomes.put("ELLIS PARK", new Coordenadas(0, 0));
		tabelaDoMapaDeNomes.put("FREE STATE", new Coordenadas(0, 1));
		tabelaDoMapaDeNomes.put("GREEN POINT", new Coordenadas(0, 2));
		tabelaDoMapaDeNomes.put("LOFTUS VERSFELD", new Coordenadas(1, 0));
		tabelaDoMapaDeNomes.put("MBOMBELA", new Coordenadas(1, 1));
		tabelaDoMapaDeNomes.put("MOSES MABHIDA", new Coordenadas(1, 2));
		tabelaDoMapaDeNomes.put("NELSON MANDELA BAY", new Coordenadas(2, 0));
		tabelaDoMapaDeNomes.put("PETER MOKABA", new Coordenadas(2, 1));
		tabelaDoMapaDeNomes.put("ROYAL BAFOKENG", new Coordenadas(2, 2));
		tabelaDoMapaDeNomes.put("SOCCER CITY", new Coordenadas(3, 2));
	}

	public mapaDeSedes() {
		this.setBounds(0, 0, larguraMapaDeSedes, alturaMapaDeSedes);
		sedes = new HIcon(imagens.carregarImagem(util.urls.mapaDeSedes), 0, 0,
				larguraMapaDeSedes, alturaMapaDeSedes);
		quadroSedes = new HIcon(imagens.carregarImagem(util.urls.quadroSedes),
				0, 0, larguraQuadroSedes, alturaQuadroSedes);
		constroiTabela();

		Coordenadas coordenadasIniciais = tabelaDoMapaDeNomes.get(sedeCorrente);

		quadroSedes.setLocation(posXQuadroSelecao
				+ (larguraQuadroSedes + espacoEntreSedesX)
				* coordenadasIniciais.getY(), posYQuadroSelecao
				+ (alturaQuadroSedes + espacoEntreSedesY)
				* coordenadasIniciais.getX());

		this.add(quadroSedes);
		this.add(sedes);

	}

	// regras pra trocar o quadro de sede selecionada
	public void trocaSede(int direcao) {
		int di = 0;
		int dj = 0;
		Coordenadas coordenadaCorrente = tabelaDoMapaDeNomes.get(sedeCorrente);
		Coordenadas coordenadasNovas;

		if (direcao == HRcEvent.VK_UP) {
			if (coordenadaCorrente.getX() == 0) {
				if (coordenadaCorrente.getY() == 2)
					di = 3;
				else
					di = 2;
			} else
				di = -1;
		} else if (direcao == HRcEvent.VK_DOWN) {
			if (coordenadaCorrente.getX() == 2) {
				if (coordenadaCorrente.getY() == 2)
					di = 1;
				else
					di = 2;
			} else
				di = 1;
		} else if (direcao == HRcEvent.VK_LEFT) {
			if (coordenadaCorrente.getY() == 0) {
				dj = 2;
			} else if (coordenadaCorrente.getX() == 3
					&& coordenadaCorrente.getY() == 2)
				dj = 0;
			else
				dj = -1;
		} else if (direcao == HRcEvent.VK_RIGHT) {
			if (coordenadaCorrente.getX() == 3
					&& coordenadaCorrente.getY() == 2)
				dj = 0;
			else
				dj = 1;
		}

		coordenadasNovas = new Coordenadas(
				(coordenadaCorrente.getX() + di) % 4, (coordenadaCorrente
						.getY() + dj) % 3);
		sedeCorrente = mapaDeSedes[coordenadasNovas.getX()][coordenadasNovas
				.getY()];
		quadroSedes.setLocation(posXQuadroSelecao
				+ (larguraQuadroSedes + espacoEntreSedesX)
				* coordenadasNovas.getY(), posYQuadroSelecao
				+ (alturaQuadroSedes + espacoEntreSedesY)
				* coordenadasNovas.getX());

	}
}
