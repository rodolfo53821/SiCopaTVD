package persistencia;

import util.Data;

public class Jogo {

	private String horaInicio;
	private String horaFim;
	private Data data;
	private Estadio local;
	private Selecao timeA;
	private Selecao timeB;

	private Sumula sumula;

	public String getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}

	public String getHoraFim() {
		return horaFim;
	}

	public void setHoraFim(String horaFim) {
		this.horaFim = horaFim;
	}

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}

	public Selecao getTimeA() {
		return timeA;
	}

	public void setTimeA(Selecao timeA) {
		this.timeA = timeA;
	}

	public Selecao getTimeB() {
		return timeB;
	}

	public void setTimeB(Selecao timeB) {
		this.timeB = timeB;
	}

	public Sumula getSumula() {
		return sumula;
	}

	public void setSumula(Sumula sumula) {
		this.sumula = sumula;
	}

	public Jogo(String horaInicio, Data data, Estadio local, Selecao timeA,
			Selecao timeB, Sumula sumula) {
		super();
		this.horaInicio = horaInicio;
		this.data = data;
		this.local = local;
		this.timeA = timeA;
		this.timeB = timeB;
		this.sumula = sumula;
	}

	public Estadio getLocal() {
		return local;
	}

	public void setLocal(Estadio local) {
		this.local = local;
	}

	public int getTotalGolsTimeA() {
		int gols = 0;
		for (int i = 0; i < sumula.getGols().size(); i++) {
			if (sumula.getGols().get(i).getSelecao().getNome().toUpperCase()
					.equals(timeA.getNome().toUpperCase()))
				gols++;
		}
		return gols;

	}

	public int getTotalGolsTimeB() {
		int gols = 0;
		for (int i = 0; i < sumula.getGols().size(); i++) {
			if (sumula.getGols().get(i).getSelecao().getNome().toUpperCase()
					.equals(timeB.getNome().toUpperCase()))
				gols++;
		}
		return gols;

	}
}
