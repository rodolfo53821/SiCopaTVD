package persistencia;

import java.awt.Image;
import java.util.List;

import util.Data;

public class Estadio {

	private String nome;
	private String cidade;
	private Data inauguracao;
	private int capacidade;

	private String curiosidades;
	private String estadioImagem;

	private List<Jogo> jogos;
	private Copa copa;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public Data getInauguracao() {
		return inauguracao;
	}

	public void setInauguracao(Data inauguracao) {
		this.inauguracao = inauguracao;
	}

	public int getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}

	public String getCuriosidades() {
		return curiosidades;
	}

	public void setCuriosidades(String curiosidades) {
		this.curiosidades = curiosidades;
	}

	public String getEstadioImagem() {
		return estadioImagem;
	}

	public void setEstadioImagem(String estadioImagem) {
		this.estadioImagem = estadioImagem;
	}

	public List<Jogo> getJogos() {
		return jogos;
	}

	public void setJogos(List<Jogo> jogos) {
		this.jogos = jogos;
	}

	public Copa getCopa() {
		return copa;
	}

	public void setCopa(Copa copa) {
		this.copa = copa;
	}

	public Estadio(String nome, String cidade, Data inauguracao,
			int capacidade, String curiosidades, String estadioImagem) {
		super();
		this.nome = nome;
		this.cidade = cidade;
		this.inauguracao = inauguracao;
		this.capacidade = capacidade;
		this.curiosidades = curiosidades;
		this.estadioImagem = estadioImagem;
	}

}
