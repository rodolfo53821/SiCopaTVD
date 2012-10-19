package persistencia;

import util.TempoDeJogo;

public class Gol {

	private Selecao selecao;
	private TempoDeJogo instante;
	private String descricao;

	public Gol(Selecao selecao, TempoDeJogo instante, String descricao) {
		super();
		this.selecao = selecao;
		this.instante = instante;
		this.descricao = descricao;
	}

	public Gol(Selecao selecao) {
		super();
		this.selecao = selecao;
	}

	public Selecao getSelecao() {
		return selecao;
	}

	public void setSelecao(Selecao selecao) {
		this.selecao = selecao;
	}

}
