package persistencia;

import java.util.LinkedList;
import java.util.List;

public class Tabela {

	public List<Selecao> grupoASelecoes;
	public List<Selecao> grupoBSelecoes;
	public List<Selecao> grupoCSelecoes;
	public List<Selecao> grupoDSelecoes;
	public List<Selecao> grupoESelecoes;
	public List<Selecao> grupoFSelecoes;
	public List<Selecao> grupoGSelecoes;
	public List<Selecao> grupoHSelecoes;

	public List<Jogo> grupoAJogos;
	public List<Jogo> grupoBJogos;
	public List<Jogo> grupoCJogos;
	public List<Jogo> grupoDJogos;
	public List<Jogo> grupoEJogos;
	public List<Jogo> grupoFJogos;
	public List<Jogo> grupoGJogos;
	public List<Jogo> grupoHJogos;

	public List<Jogo> oitavasJogos;
	public List<Jogo> quartasJogos;
	public List<Jogo> semiFinaisJogos;
	public Jogo finalJogo;
	public Jogo terceiroLugarJogo;

	private Copa copa;

	private Tabela() {
		grupoASelecoes = new LinkedList<Selecao>();
		grupoBSelecoes = new LinkedList<Selecao>();
		grupoCSelecoes = new LinkedList<Selecao>();
		grupoDSelecoes = new LinkedList<Selecao>();
		grupoESelecoes = new LinkedList<Selecao>();
		grupoFSelecoes = new LinkedList<Selecao>();
		grupoGSelecoes = new LinkedList<Selecao>();
		grupoHSelecoes = new LinkedList<Selecao>();

		grupoAJogos = new LinkedList<Jogo>();
		grupoBJogos = new LinkedList<Jogo>();
		grupoCJogos = new LinkedList<Jogo>();
		grupoDJogos = new LinkedList<Jogo>();
		grupoEJogos = new LinkedList<Jogo>();
		grupoFJogos = new LinkedList<Jogo>();
		grupoGJogos = new LinkedList<Jogo>();
		grupoHJogos = new LinkedList<Jogo>();

		oitavasJogos = new LinkedList<Jogo>();
		quartasJogos = new LinkedList<Jogo>();
		semiFinaisJogos = new LinkedList<Jogo>();

		copa = Copa.getInstance();

	}

	public static Tabela instance = null;

	public static Tabela getInstance() {

		if (instance == null)
			instance = new Tabela();

		return instance;
	}

}
