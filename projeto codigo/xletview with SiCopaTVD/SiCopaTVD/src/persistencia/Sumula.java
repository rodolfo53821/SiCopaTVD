package persistencia;

import java.util.LinkedList;
import java.util.List;

public class Sumula {

	private List<Cartao> cartoes;
	private List<Gol> gols;

	public Sumula() {
		super();
		cartoes = new LinkedList<Cartao>();
		gols = new LinkedList<Gol>();
	}

	public List<Gol> getGols() {
		return gols;
	}

	public void setGols(List<Gol> gols) {
		this.gols = gols;
	}

}
