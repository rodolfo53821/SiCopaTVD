package menuPartes;

import gerenciadores.Imagens;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import org.dvb.ui.DVBTextLayoutManager;
import org.havi.ui.HIcon;
import org.havi.ui.HStaticText;

public class listaDeAtalhos extends Container {

	private HStaticText btVermelho, btVerde, btAmarelo, btAzul, btCimaBaixo,
			btEsquerdaDireita, btOk, btNum1a9, btAsterisco, btQuadrado, btNum0,
			btExit, btMenos, btMais;

	private Imagens imagens = Imagens.getInstance();
	private HIcon fundoAtalho;
	private final int larguraFundoAtalho = 700;
	private final int alturaFundoAtalho = 560;

	private int posicaoTexto[][] = { { 115, 105 }, { 115, 165 }, { 115, 225 },
			{ 115, 285 }, { 146, 345 }, { 146, 405 }, { 115, 465 },
			{ 488, 105 }, { 477, 165 }, { 477, 225 }, { 477, 285 },
			{ 477, 345 }, { 477, 405 }, { 477, 465 } };

	public listaDeAtalhos(String vermelho, String verde, String amarelo,
			String azul, String cimaBaixo, String esquerdaDireita, String ok,
			String num1a9, String asterisco, String num0, String quadrado,
			String exit, String menos, String mais) {

		this.setBounds(0, 0, larguraFundoAtalho, alturaFundoAtalho);

		this.fundoAtalho = new HIcon(imagens
				.carregarImagem(util.urls.telaAtalhos), 0, 0,
				larguraFundoAtalho, alturaFundoAtalho);
		this.btAmarelo = new HStaticText(amarelo);
		this.btAsterisco = new HStaticText(asterisco);
		this.btAzul = new HStaticText(azul);
		this.btCimaBaixo = new HStaticText(cimaBaixo);
		this.btEsquerdaDireita = new HStaticText(esquerdaDireita);
		this.btExit = new HStaticText(exit);
		this.btMais = new HStaticText(mais);
		this.btMenos = new HStaticText(menos);
		this.btNum0 = new HStaticText(num0);
		this.btOk = new HStaticText(ok);
		this.btNum1a9 = new HStaticText(num1a9);
		this.btQuadrado = new HStaticText(quadrado);
		this.btVerde = new HStaticText(verde);
		this.btVermelho = new HStaticText(vermelho);

		this.btAmarelo.setSize(180, 30);
		this.btAsterisco.setSize(180, 30);
		this.btAzul.setSize(180, 30);
		this.btCimaBaixo.setSize(180, 30);
		this.btEsquerdaDireita.setSize(180, 30);
		this.btExit.setSize(180, 30);
		this.btMais.setSize(180, 30);
		this.btMenos.setSize(180, 30);
		this.btNum0.setSize(180, 30);
		this.btOk.setSize(180, 30);
		this.btNum1a9.setSize(180, 30);
		this.btQuadrado.setSize(180, 30);
		this.btVerde.setSize(180, 30);
		this.btVermelho.setSize(180, 30);

		this.btAmarelo.setBackgroundMode(Color.TRANSLUCENT);
		this.btAsterisco.setBackgroundMode(Color.TRANSLUCENT);
		this.btAzul.setBackgroundMode(Color.TRANSLUCENT);
		this.btCimaBaixo.setBackgroundMode(Color.TRANSLUCENT);
		this.btEsquerdaDireita.setBackgroundMode(Color.TRANSLUCENT);
		this.btExit.setBackgroundMode(Color.TRANSLUCENT);
		this.btMais.setBackgroundMode(Color.TRANSLUCENT);
		this.btMenos.setBackgroundMode(Color.TRANSLUCENT);
		this.btNum0.setBackgroundMode(Color.TRANSLUCENT);
		this.btOk.setBackgroundMode(Color.TRANSLUCENT);
		this.btNum1a9.setBackgroundMode(Color.TRANSLUCENT);
		this.btQuadrado.setBackgroundMode(Color.TRANSLUCENT);
		this.btVerde.setBackgroundMode(Color.TRANSLUCENT);
		this.btVermelho.setBackgroundMode(Color.TRANSLUCENT);

		this.btAmarelo.setLocation(posicaoTexto[1][0], posicaoTexto[1][1]);
		this.btAsterisco.setLocation(posicaoTexto[8][0], posicaoTexto[8][1]);
		this.btAzul.setLocation(posicaoTexto[3][0], posicaoTexto[3][1]);
		this.btCimaBaixo.setLocation(posicaoTexto[4][0], posicaoTexto[4][1]);
		this.btEsquerdaDireita.setLocation(posicaoTexto[5][0],
				posicaoTexto[5][1]);
		this.btExit.setLocation(posicaoTexto[11][0], posicaoTexto[11][1]);
		this.btMais.setLocation(posicaoTexto[13][0], posicaoTexto[13][1]);
		this.btMenos.setLocation(posicaoTexto[12][0], posicaoTexto[12][1]);
		this.btNum0.setLocation(posicaoTexto[9][0], posicaoTexto[9][1]);
		this.btOk.setLocation(posicaoTexto[6][0], posicaoTexto[6][1]);
		this.btNum1a9.setLocation(posicaoTexto[7][0], posicaoTexto[7][1]);
		this.btQuadrado.setLocation(posicaoTexto[10][0], posicaoTexto[10][1]);
		this.btVerde.setLocation(posicaoTexto[2][0], posicaoTexto[2][1]);
		this.btVermelho.setLocation(posicaoTexto[0][0], posicaoTexto[0][1]);

		Font fonte = new Font(Font.SANS_SERIF, Font.BOLD, 14);
		Color cor = Color.white;

		this.btAmarelo.setFont(fonte);
		this.btAsterisco.setFont(fonte);
		this.btAzul.setFont(fonte);
		this.btCimaBaixo.setFont(fonte);
		this.btEsquerdaDireita.setFont(fonte);
		this.btExit.setFont(fonte);
		this.btMais.setFont(fonte);
		this.btMenos.setFont(fonte);
		this.btNum0.setFont(fonte);
		this.btOk.setFont(fonte);
		this.btNum1a9.setFont(fonte);
		this.btQuadrado.setFont(fonte);
		this.btVerde.setFont(fonte);
		this.btVermelho.setFont(fonte);

		this.btAmarelo.setForeground(cor);
		this.btAsterisco.setForeground(cor);
		this.btAzul.setForeground(cor);
		this.btCimaBaixo.setForeground(cor);
		this.btEsquerdaDireita.setForeground(cor);
		this.btExit.setForeground(cor);
		this.btMais.setForeground(cor);
		this.btMenos.setForeground(cor);
		this.btNum0.setForeground(cor);
		this.btNum1a9.setForeground(cor);
		this.btOk.setForeground(cor);
		this.btQuadrado.setForeground(cor);
		this.btVerde.setForeground(cor);
		this.btVermelho.setForeground(cor);

		DVBTextLayoutManager tlm = new DVBTextLayoutManager();
		tlm.setLineSpace(25);
		tlm.setHorizontalAlign(DVBTextLayoutManager.HORIZONTAL_START_ALIGN);
		tlm.setVerticalAlign(DVBTextLayoutManager.VERTICAL_CENTER);
		this.btVermelho
				.setHorizontalAlignment(DVBTextLayoutManager.HORIZONTAL_START_ALIGN);
		this.btVermelho
				.setVerticalAlignment(DVBTextLayoutManager.VERTICAL_START_ALIGN);

		this.add(btAmarelo);
		this.add(btAsterisco);
		this.add(btAzul);
		this.add(btCimaBaixo);
		this.add(btEsquerdaDireita);
		this.add(btExit);
		this.add(btMais);
		this.add(btNum0);
		this.add(btMenos);
		this.add(btOk);
		this.add(btNum1a9);
		this.add(btQuadrado);
		this.add(btVerde);
		this.add(btVermelho);
		this.add(fundoAtalho);

	}

	public void setVisible(boolean arg) {
		this.fundoAtalho.setVisible(arg);
		this.btAmarelo.setVisible(arg);
		this.btAsterisco.setVisible(arg);
		this.btAzul.setVisible(arg);
		this.btCimaBaixo.setVisible(arg);
		this.btEsquerdaDireita.setVisible(arg);
		this.btExit.setVisible(arg);
		this.btMais.setVisible(arg);
		this.btMenos.setVisible(arg);
		this.btNum0.setVisible(arg);
		this.btNum1a9.setVisible(arg);
		this.btOk.setVisible(arg);
		this.btQuadrado.setVisible(arg);
		this.btVerde.setVisible(arg);
		this.btVermelho.setVisible(arg);

	}
}
