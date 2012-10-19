package menuPartes;

import gerenciadores.Imagens;

import java.awt.Color;
import java.awt.Container;
import java.awt.Image;

import org.havi.ui.HAnimateEffect;
import org.havi.ui.HAnimation;
import org.havi.ui.HIcon;

import util.Coordenadas;

public class mapaAfricaDoSul extends Container {

	/*
	 * Sera definido o posicionamento do marcador para cada sede
	 * 
	 * Ellis Park,Free State,Green Point,Loftus Versfeld,Mbombela, Moses
	 * Mabhida,Nelson Mandela Bay,Peter Makoba,Royal Bafokeng,Soccer City
	 * 
	 */

	Coordenadas coordenadasEstadios[] = { new Coordenadas(188, 66),
			new Coordenadas(152, 104), new Coordenadas(45, 182),
			new Coordenadas(189, 59), new Coordenadas(220, 55),
			new Coordenadas(227, 118), new Coordenadas(149, 179),
			new Coordenadas(208, 33), new Coordenadas(175, 58),
			new Coordenadas(188, 66) };

	/** ************************* */

	private HIcon mapaAfricaDoSul;
	private HAnimation marcador;
	private final int larguraMapa = 278;
	private final int alturaMapa = 200;
	private final int larguraMarcador = 100;
	private final int alturaMarcador = 100;
	private Imagens imagens = Imagens.getInstance();
	private int posXMarcador;
	private int posYMarcador;

	public mapaAfricaDoSul(String estadioCorrente) {
		this.setBounds(0, 0, larguraMapa, alturaMapa);

		mapaAfricaDoSul = new HIcon(imagens
				.carregarImagem(util.urls.mapaAfricaDoSul), 0, 0, larguraMapa,
				alturaMapa);
		Image imagensMarcador[] = {
				imagens.carregarImagem(util.urls.marcador1),
				imagens.carregarImagem(util.urls.marcador2),
				imagens.carregarImagem(util.urls.marcador3) };

		marcador = new HAnimation(imagensMarcador, 3,
				HAnimateEffect.PLAY_REPEATING, HAnimateEffect.REPEAT_INFINITE,
				0, 0, larguraMarcador, alturaMarcador);
		marcador.setBackgroundMode(Color.TRANSLUCENT);
		mudaMarcador(estadioCorrente);
		marcador.start();

		this.add(marcador);
		this.add(mapaAfricaDoSul);

	}

	public void setVisible(boolean arg) {
		this.marcador.setVisible(true);
		this.mapaAfricaDoSul.setVisible(true);

	}

	public void mudaMarcador(String nomeSelecao) {

		int indiceSelecao = 0;// Africa do Sul

		if (nomeSelecao.equals("ELLIS PARK")) {
			indiceSelecao = 0;
		} else if (nomeSelecao.equals("FREE STATE")) {
			indiceSelecao = 1;
		} else if (nomeSelecao.equals("GREEN POINT")) {
			indiceSelecao = 2;
		} else if (nomeSelecao.equals("LOFTUS VERSFELD")) {
			indiceSelecao = 3;
		} else if (nomeSelecao.equals("MBOMBELA")) {
			indiceSelecao = 4;
		} else if (nomeSelecao.equals("MOSES MABHIDA")) {
			indiceSelecao = 5;
		} else if (nomeSelecao.equals("NELSON MANDELA BAY")) {
			indiceSelecao = 6;
		} else if (nomeSelecao.equals("PETER MOKABA")) {
			indiceSelecao = 7;
		} else if (nomeSelecao.equals("ROYAL BAFOKENG")) {
			indiceSelecao = 8;
		} else if (nomeSelecao.equals("SOCCER CITY")) {
			indiceSelecao = 9;
		}
		marcador.setLocation(coordenadasEstadios[indiceSelecao].getX()
				- larguraMarcador / 2, coordenadasEstadios[indiceSelecao]
				.getY()
				- alturaMarcador / 2);
	}
}
