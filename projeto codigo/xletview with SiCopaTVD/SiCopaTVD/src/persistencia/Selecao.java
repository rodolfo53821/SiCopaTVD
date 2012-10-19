package persistencia;

import java.awt.Image;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

import util.Data;

public class Selecao {

	private String nome;
	private String federacao;
	private Data filiacaoAFifa;
	private String principaisTitulos;
	private int rankNaFifa;
	private String emblema;

	private List<Jogador> jogadores = new LinkedList<Jogador>();

	public Selecao(String nome) {
		this.nome = nome;
	}

	public Selecao(String nome, String federacao, Data filiacaoAFifa,
			String principaisTitulos, int rankNaFifa, String emblema) {
		super();
		this.nome = nome;
		this.federacao = federacao;
		this.filiacaoAFifa = filiacaoAFifa;
		this.principaisTitulos = principaisTitulos;
		this.rankNaFifa = rankNaFifa;
		this.emblema = emblema;
	}

	public Selecao(String nome, String federacao, Data filiacaoAFifa,
			String principaisTitulos, int rankNaFifa, String emblema,
			List<Jogador> jogadores) {
		super();
		this.nome = nome;
		this.federacao = federacao;
		this.filiacaoAFifa = filiacaoAFifa;
		this.principaisTitulos = principaisTitulos;
		this.rankNaFifa = rankNaFifa;
		this.emblema = emblema;
		this.jogadores = jogadores;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFederacao() {
		return federacao;
	}

	public void setFederacao(String federacao) {
		this.federacao = federacao;
	}

	public Data getFiliacaoAFifa() {
		return filiacaoAFifa;
	}

	public void setFiliacaoAFifa(Data filiacaoAFifa) {
		this.filiacaoAFifa = filiacaoAFifa;
	}

	public String getPrincipaisTitulos() {
		return principaisTitulos;
	}

	public void setPrincipaisTitulos(String principaisTitulos) {
		this.principaisTitulos = principaisTitulos;
	}

	public int getRankNaFifa() {
		return rankNaFifa;
	}

	public void setRankNaFifa(int rankNaFifa) {
		this.rankNaFifa = rankNaFifa;
	}

	public String getEmblema() {
		return emblema;
	}

	public void setEmblema(String emblema) {
		this.emblema = emblema;
	}

	public List<Jogador> getJogadores() {
		return jogadores;
	}

	public void setJogadores(List<Jogador> jogadores) {
		this.jogadores = jogadores;
	}

}
