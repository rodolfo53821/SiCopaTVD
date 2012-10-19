package testes;

import java.io.File;

import persistencia.Selecao;
import scanner.ScannerDb;

public class testeScan {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		
		ScannerDb sc = new ScannerDb();
		/*
		System.out.println(persistencia.Copa.getInstance().getJagadores().size());
		System.out.println(persistencia.Copa.getInstance().getJagadores().get(0).getNome());
		Selecao sel = persistencia.Copa.getInstance().getSelecoes().get(0);
		for(int i = 0; i< sel.getJogadores().size();i++)
		System.out.println(sel.getNome()+ " "+ sel.getJogadores().get(i).getNome());
		
		
		//scanner.ScannerDb.scanSelecoes(util.urls.dbSelecoes);
		System.out.println("Numero de selecoes "+persistencia.Copa.getInstance().getSelecoes().size());
		System.out.println(persistencia.Copa.getInstance().getSelecoes().get(0).getNome());
		
		
		//scanner.ScannerDb.scanEstadios(util.urls.dbEstadios);
		System.out.println("Numero de estadios"+persistencia.Copa.getInstance().getEstadios().size());
		System.out.println(persistencia.Copa.getInstance().getEstadios().get(0).getCapacidade());
		
		*/
		//sc.scanTabela(util.urls.dbTabela);
		System.out.println("Numero de jogos no grupo A"+persistencia.Tabela.getInstance().grupoAJogos.size());
		System.out.println("Numero de jogos no grupo B"+persistencia.Tabela.getInstance().grupoBJogos.size());
		
		System.out.println("Numero de jogos no grupo C"+persistencia.Tabela.getInstance().grupoCJogos.size());
		System.out.println("Numero de jogos no grupo D"+persistencia.Tabela.getInstance().grupoDJogos.size());
		System.out.println("Numero de jogos no grupo E"+persistencia.Tabela.getInstance().grupoEJogos.size());
		System.out.println("Numero de jogos no grupo F"+persistencia.Tabela.getInstance().grupoFJogos.size());
		System.out.println("Numero de jogos no grupo G"+persistencia.Tabela.getInstance().grupoGJogos.size());
		System.out.println("Numero de jogos no grupo H"+persistencia.Tabela.getInstance().grupoHJogos.size());
		
		
		
		
		
		persistencia.Copa.getInstance().toString();
	}

}
