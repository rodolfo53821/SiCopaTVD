package menuPartes;

import gerenciadores.Imagens;

import java.awt.Color;
import java.awt.Container;
import java.awt.Image;
import java.awt.Point;

import org.havi.ui.HAnimateEffect;
import org.havi.ui.HAnimation;
import org.havi.ui.HIcon;

import persistencia.Selecao;
import util.Coordenadas;

public class mapaMundo extends Container {

	/*
	 * Sera definido o posicionamento do marcador para cada selecao
	 * 
	 * Africa do
	 * Sul,Alemanha,Argelia,Argentina,Australia,Brasil,Camaroes,Chile,Coreia do
	 * norte,Coreia do Sul, costa do
	 * marfim,dinamarca,eslovaquia,eslovenia,espanha,estados
	 * unidos,franca,gana,grecia,holanda,
	 * honduras,inglaterra,italia,japao,mexico,nigeria,nova zelandia,
	 * paraguai,portugal,servia, suica,uruguai
	 * 
	 * 
	 */

	Coordenadas coordenadasPaises[] = {
			new Coordenadas(363, 280),
			new Coordenadas(338, 88),
			new Coordenadas(323, 146),
			new Coordenadas(210, 292),
			new Coordenadas(565, 270),
			new Coordenadas(228, 250),// b
			new Coordenadas(343, 198), new Coordenadas(193, 289),
			new Coordenadas(541, 115), new Coordenadas(548, 125),
			new Coordenadas(310, 192),
			new Coordenadas(339, 73),// d
			new Coordenadas(355, 96), new Coordenadas(343, 96),
			new Coordenadas(316, 116), new Coordenadas(167, 129),// e
			new Coordenadas(327, 101),// f
			new Coordenadas(319, 193), new Coordenadas(360, 117),// g
			new Coordenadas(333, 87), new Coordenadas(159, 175),// h
			new Coordenadas(321, 87), new Coordenadas(345, 108),// i
			new Coordenadas(563, 127),// j
			new Coordenadas(132, 157),// m
			new Coordenadas(335, 188), new Coordenadas(621, 306),// n
			new Coordenadas(213, 263), new Coordenadas(308, 118),// p
			new Coordenadas(356, 107), new Coordenadas(334, 103),// s
			new Coordenadas(219, 290) };// u

	/** ************************* */

	private HIcon mapa;
	private HAnimation marcador;
	private final int larguraMapa = 687;
	private final int alturaMapa = 386;
	private final int larguraMarcador = 100;
	private final int alturaMarcador = 100;
	private Imagens imagens = Imagens.getInstance();
	private int posXMarcador;
	private int posYMarcador;

	public mapaMundo(String selecaoCorrente) {
		this.setBounds(0, 0, larguraMapa, alturaMapa);

		mapa = new HIcon(imagens.carregarImagem(util.urls.mapa), 0, 0,
				larguraMapa, alturaMapa);
		Image imagensMarcador[] = {
				imagens.carregarImagem(util.urls.marcador1),
				imagens.carregarImagem(util.urls.marcador2),
				imagens.carregarImagem(util.urls.marcador3) };

		marcador = new HAnimation(imagensMarcador, 3,
				HAnimateEffect.PLAY_REPEATING, HAnimateEffect.REPEAT_INFINITE,
				0, 0, larguraMarcador, alturaMarcador);
		marcador.setBackgroundMode(Color.TRANSLUCENT);
		mudaMarcador(selecaoCorrente);
		marcador.start();

		this.add(marcador);
		this.add(mapa);

	}

	public void setVisible(boolean arg) {
		this.marcador.setVisible(true);
		this.mapa.setVisible(true);

	}

	public void mudaMarcador(String nomeSelecao) {

		int indiceSelecao = 0;// Africa do Sul

		if (nomeSelecao.equals("AFRICA DO SUL")) {
			indiceSelecao = 0;
		} else if (nomeSelecao.equals("ALEMANHA")) {
			indiceSelecao = 1;
		} else if (nomeSelecao.equals("ARGELIA")) {
			indiceSelecao = 2;
		} else if (nomeSelecao.equals("ARGENTINA")) {
			indiceSelecao = 3;
		} else if (nomeSelecao.equals("AUSTRALIA")) {
			indiceSelecao = 4;
		} else if (nomeSelecao.equals("BRASIL")) {
			indiceSelecao = 5;
		} else if (nomeSelecao.equals("CAMAROES")) {
			indiceSelecao = 6;
		} else if (nomeSelecao.equals("CHILE")) {
			indiceSelecao = 7;
		} else if (nomeSelecao.equals("COREIA DO NORTE")) {
			indiceSelecao = 8;
		} else if (nomeSelecao.equals("COREIA DO SUL")) {
			indiceSelecao = 9;
		} else if (nomeSelecao.equals("COSTA DO MARFIM")) {
			indiceSelecao = 10;
		} else if (nomeSelecao.equals("DINAMARCA")) {
			indiceSelecao = 11;
		} else if (nomeSelecao.equals("ESLOVAQUIA")) {
			indiceSelecao = 12;
		} else if (nomeSelecao.equals("ESLOVENIA")) {
			indiceSelecao = 13;
		} else if (nomeSelecao.equals("ESPANHA")) {
			indiceSelecao = 14;
		} else if (nomeSelecao.equals("ESTADOS UNIDOS")) {
			indiceSelecao = 15;
		} else if (nomeSelecao.equals("FRANCA")) {
			indiceSelecao = 16;
		} else if (nomeSelecao.equals("GANA")) {
			indiceSelecao = 17;
		} else if (nomeSelecao.equals("GRECIA")) {
			indiceSelecao = 18;
		} else if (nomeSelecao.equals("HOLANDA")) {
			indiceSelecao = 19;
		} else if (nomeSelecao.equals("HONDURAS")) {
			indiceSelecao = 20;
		} else if (nomeSelecao.equals("INGLATERRA")) {
			indiceSelecao = 21;
		} else if (nomeSelecao.equals("ITALIA")) {
			indiceSelecao = 22;
		} else if (nomeSelecao.equals("JAPAO")) {
			indiceSelecao = 23;
		} else if (nomeSelecao.equals("MEXICO")) {
			indiceSelecao = 24;
		} else if (nomeSelecao.equals("NIGERIA")) {
			indiceSelecao = 25;
		} else if (nomeSelecao.equals("NOVA ZELANDIA")) {
			indiceSelecao = 26;
		} else if (nomeSelecao.equals("PARAGUAI")) {
			indiceSelecao = 27;
		} else if (nomeSelecao.equals("PORTUGAL")) {
			indiceSelecao = 28;
		} else if (nomeSelecao.equals("SERVIA")) {
			indiceSelecao = 29;
		} else if (nomeSelecao.equals("SUICA")) {
			indiceSelecao = 30;
		} else if (nomeSelecao.equals("URUGUAI")) {
			indiceSelecao = 31;
		}

		marcador.setLocation(coordenadasPaises[indiceSelecao].getX()
				- larguraMarcador / 2, coordenadasPaises[indiceSelecao].getY()
				- alturaMarcador / 2);

	}

}
