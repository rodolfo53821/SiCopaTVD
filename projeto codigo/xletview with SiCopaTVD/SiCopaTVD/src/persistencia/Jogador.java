package persistencia;

import java.util.LinkedList;
import java.util.List;

import util.Data;

public class Jogador {

	private String nome;
	private Data dataNascimento;
	private String nacionalidade;
	private String posicao;
	private double altura;
	private double peso;
	private String historicoEmCopas;

	private Selecao selecao;
	private Figurinha figurinha;
	private List<Gol> gols = new LinkedList<Gol>();
	private List<Cartao> cartoes = new LinkedList<Cartao>();

	public Jogador(String nome, Data dataNascimento, String nacionalidade,
			String posicao, double altura, double peso,
			String historicoEmCopas, Selecao selecao) {
		super();
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.nacionalidade = nacionalidade;
		this.posicao = posicao;
		this.altura = altura;
		this.peso = peso;
		this.historicoEmCopas = historicoEmCopas;
		this.selecao = selecao;
		this.figurinha = new Figurinha();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Data getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Data dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public String getPosicao() {
		return posicao;
	}

	public void setPosicao(String posicao) {
		this.posicao = posicao;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public String getHistoricoEmCopas() {
		return historicoEmCopas;
	}

	public void setHistoricoEmCopas(String historicoEmCopas) {
		this.historicoEmCopas = historicoEmCopas;
	}

	public Selecao getSelecao() {
		return selecao;
	}

	public void setSelecao(Selecao selecao) {
		this.selecao = selecao;
	}

	public Figurinha getFigurinha() {
		return figurinha;
	}

	public void setFigurinha(Figurinha figurinha) {
		this.figurinha = figurinha;
	}

}
