package util;

public class Data {

	private int dia;
	private int mes;
	private int ano;

	public Data(int dia, int mes, int ano) {
		super();
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
	}

	public String toString() {
		return dia + "/" + mes + "/" + ano;
	}

	public static Data stringToData(String data) {
		String valueData[] = data.split("/");

		return new Data(Integer.parseInt(valueData[0]), Integer
				.parseInt(valueData[1]), Integer.parseInt(valueData[2]));
	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

}
