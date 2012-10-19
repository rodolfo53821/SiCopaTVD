package menuPartes;

import java.awt.Color;
import java.awt.Container;

import org.havi.ui.event.HKeyEvent;

public class FaseGrupos extends Container {

	private tabelaGrupo grupoA;
	private tabelaGrupo grupoB;
	private tabelaGrupo grupoC;
	private tabelaGrupo grupoD;
	private tabelaGrupo grupoE;
	private tabelaGrupo grupoF;
	private tabelaGrupo grupoG;
	private tabelaGrupo grupoH;
	private final int larguraFaseGrupos = 310;
	private final int alturaFaseGrupos = 412;
	private int pagGrupo = 1;
	private final int posXGrupo = 10;
	private final int posYGrupo = 10;
	private int qtdePaginas = 8;

	// posicao das tabelas
	public FaseGrupos() {
		this.setBounds(0, 0, larguraFaseGrupos, alturaFaseGrupos);

		grupoA = new tabelaGrupo('A');
		grupoB = new tabelaGrupo('B');
		grupoC = new tabelaGrupo('C');
		grupoD = new tabelaGrupo('D');
		grupoE = new tabelaGrupo('E');
		grupoF = new tabelaGrupo('F');
		grupoG = new tabelaGrupo('G');
		grupoH = new tabelaGrupo('H');

		this.add(grupoA);
		this.add(grupoB);
		this.add(grupoC);
		this.add(grupoD);
		this.add(grupoE);
		this.add(grupoF);
		this.add(grupoG);
		this.add(grupoH);

		this.repaint();
		trocaPagina(pagGrupo);

	}

	public void trocaPagina(int pagGrupo2) {

		grupoA.setVisible(false);
		grupoB.setVisible(false);
		grupoC.setVisible(false);
		grupoD.setVisible(false);
		grupoE.setVisible(false);
		grupoF.setVisible(false);
		grupoG.setVisible(false);
		grupoH.setVisible(false);

		switch (pagGrupo2) {
		case 1:
			grupoA.setVisible(true);
			break;
		case 2:
			grupoB.setVisible(true);
			break;

		case 3:
			grupoC.setVisible(true);
			break;
		case 4:
			grupoD.setVisible(true);
			break;
		case 5:
			grupoE.setVisible(true);
			break;
		case 6:
			grupoF.setVisible(true);
			break;
		case 7:
			grupoG.setVisible(true);
			break;
		case 8:
			grupoH.setVisible(true);
			break;
		}

		pagGrupo = pagGrupo2;

	}

	public int proxima(int evento) {

		int proxima = 0;
		if (evento == HKeyEvent.VK_LEFT) {
			if (pagGrupo == 1)
				proxima = qtdePaginas;
			else
				proxima = pagGrupo - 1;
		} else if (evento == HKeyEvent.VK_RIGHT) {
			proxima = (pagGrupo + 1) % qtdePaginas;
			if (proxima == 0)
				proxima = qtdePaginas;
		}

		return proxima;

	}
}
