package menuPartes;

import java.awt.Container;
import java.io.IOException;
import java.util.List;

import javax.tv.carousel.CarouselFile;

import org.dvb.dsmcc.AsynchronousLoadingEventListener;
import org.dvb.dsmcc.DSMCCObject;
import org.dvb.dsmcc.DSMCCStreamEvent;
import org.dvb.dsmcc.ObjectChangeEventListener;
import org.havi.ui.HIcon;
import org.havi.ui.HScene;
import org.havi.ui.HVisible;

import persistencia.Copa;
import persistencia.Figurinha;

import gerenciadores.Imagens;

public class TodasFigurinhas extends Container {

	// gerenciador
	Imagens imagens = Imagens.getInstance();

	// tamanhos e posicoes
	private final int larguraMoldura = 147;
	private final int alturaMoldura = 114;
	private final int larguraFigura = 133;
	private final int alturaFigura = 100;
	private final int distHorizontal = 29;
	private final int distVertical = 42;
	private final int posXFiguraIni = 16;
	private final int posYFiguraIni = 42;

	private final int posicaoFigurinhas[][] = { {}, {},

	};

	private HScene cena;

	public TodasFigurinhas(HScene cena) throws IOException {
		this.cena = cena;
		this.setSize(cena.getWidth(), cena.getHeight());

		List<Figurinha> figuras = Copa.getInstance().getTodasFigurinhas();
		int qtde = figuras.size();

		// nesse momento e muito importante manter a ordem de insercao pois dela
		// saberemos qual figurinha reposicionar

		int linha = 0;
		int coluna = 0;
		for (int i = 0; i < figuras.size(); i++) {
			HIcon moldura = new HIcon();
			HIcon figura = new HIcon();
			moldura.setGraphicContent(
					imagens.carregarImagem(util.urls.moldura),
					HVisible.NORMAL_STATE);
			CarouselFile jogadorFile = new CarouselFile(figuras.get(i)
					.getFigurinhaImagem());
			figura.setGraphicContent(imagens.carregarImagem(jogadorFile
					.getAbsolutePath()), HVisible.NORMAL_STATE);
			/*
			 * DSMCCObject obj = new DSMCCObject(jogadorFile.getAbsolutePath());
			 * 
			 * obj.addObjectChangeEventListener(controladorDeAtualizacaoDeFigura);
			 * 
			 * AsynchronousLoadingEventListener controladorDeAtualizacao;
			 * obj.asynchronousLoad(controladorDeAtualizacao);
			 */

			moldura.setSize(larguraMoldura, alturaMoldura);
			figura.setSize(larguraFigura, alturaFigura);
			int posX = 0;
			int posY = 0;

			if (linha != 2) {
				posX = (distHorizontal + larguraMoldura) * (coluna)
						+ posXFiguraIni;
				posY = (distVertical + alturaMoldura) * (linha) + posYFiguraIni;
			} else {
				posX = (distHorizontal + larguraMoldura) * (coluna + 1)
						+ posXFiguraIni;
				posY = (distVertical + alturaMoldura) * (linha) + posYFiguraIni;
			}
			moldura.setLocation(posX, posY);
			figura.setLocation(posX + (larguraMoldura - larguraFigura) / 2,
					posY + (alturaMoldura - alturaFigura) / 2);
			this.add(figura);
			this.add(moldura);

			coluna = (coluna + 1) % 4;
			linha = (i + 1) % 4 == 0 ? (linha + 1) % 3 : linha;
		}

	}

}
