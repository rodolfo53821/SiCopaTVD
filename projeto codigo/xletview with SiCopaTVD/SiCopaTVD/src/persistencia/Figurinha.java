package persistencia;

import java.awt.Image;

public class Figurinha {

	public Figurinha() {
		obtida = false;

	}

	private String figurinhaImagem;
	private String descricao;
	public boolean obtida;

	public String getFigurinhaImagem() {
		return figurinhaImagem;
	}

	public void setFigurinhaImagem(String figurinhaImagem) {
		this.figurinhaImagem = figurinhaImagem;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
