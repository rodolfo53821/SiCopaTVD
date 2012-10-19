package persistencia;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Copa {

	private static String nome = "Copa Africa do Sul";
	private static int ano = 2010;
	private static String paisSede = "Africa do Sul";
	private static Copa instance = null;

	public static Copa getInstance() {
		if (instance == null)
			instance = new Copa();

		return instance;
	}

	public Copa() {
		selecoes = new LinkedList<Selecao>();
		estadios = new LinkedList<Estadio>();
		jogadores = new LinkedList<Jogador>();
	}

	private static List<Selecao> selecoes = new LinkedList<Selecao>();
	private static List<Estadio> estadios = new LinkedList<Estadio>();
	private static Tabela tabela;

	public List<Selecao> getSelecoes() {
		return selecoes;
	}

	public static List<Jogador> jogadores = new LinkedList<Jogador>();

	public List<Jogador> getJogadores() {
		return jogadores;
	}

	public void setJogadores(List<Jogador> jagadores) {
		this.jogadores = jagadores;
	}

	public void setSelecoes(List<Selecao> selecoes) {
		this.selecoes = selecoes;
	}

	public List<Estadio> getEstadios() {
		return estadios;
	}

	public void setEstadios(List<Estadio> estadios) {
		this.estadios = estadios;
	}

	public Tabela getTabela() {
		return tabela;
	}

	public void setTabela(Tabela tabela) {
		this.tabela = tabela;
	}

	public Selecao getSelecaoEspecifica(String nomeDaSelecao) {
		Selecao selecao = null;
		int i;
		for (i = 0; i < selecoes.size(); i++) {
			if (selecoes.get(i).getNome().toUpperCase().equals(
					nomeDaSelecao.toUpperCase()))
				break;

		}

		if (i != selecoes.size())
			selecao = selecoes.get(i);

		return selecao;

	}

	public Estadio getEstadioEspecifico(String nomeDoEstadio) {
		Estadio estadio = null;
		int i;
		for (i = 0; i < estadios.size(); i++)
			if (estadios.get(i).getNome().equals(nomeDoEstadio))
				break;

		if (i != estadios.size())
			estadio = estadios.get(i);

		return estadio;

	}

	public List<Figurinha> getTodasFigurinhas() {
		List<Figurinha> todasFigurinhas = new ArrayList<Figurinha>();
		for (int sel = 0; sel < selecoes.size(); sel++) {
			for (int fig = 0; fig < selecoes.get(sel).getJogadores().size(); fig++) {
				if (selecoes.get(sel).getJogadores().get(fig).getFigurinha().obtida)
					todasFigurinhas.add(selecoes.get(sel).getJogadores().get(
							fig).getFigurinha());
			}
		}

		return todasFigurinhas;

	}

	public String toString() {
		String resp = null;
		System.out.println("Copa " + nome + " em " + ano + " sediada por "
				+ paisSede);
		System.out.println("Jogdores " + jogadores.size());
		for (int i = 0; i < jogadores.size(); i++)
			System.out.println(i + ": " + jogadores.get(i).getNome());

		System.out.println("Selecoes " + selecoes.size());
		for (int i = 0; i < selecoes.size(); i++)
			System.out.println(i + ": " + selecoes.get(i).getNome());

		System.out.println("Sedes " + estadios.size());
		for (int i = 0; i < estadios.size(); i++)
			System.out.println(i + ": " + estadios.get(i).getNome());

		System.out.println("Tabela");
		System.out.println("Grupo A");
		for (int i = 0; i < tabela.grupoAJogos.size(); i++)
			System.out.println(i + ": "
					+ tabela.grupoAJogos.get(i).getLocal().getNome() + " "
					+ tabela.grupoAJogos.get(i).getHoraInicio());

		return resp;

	}

}
