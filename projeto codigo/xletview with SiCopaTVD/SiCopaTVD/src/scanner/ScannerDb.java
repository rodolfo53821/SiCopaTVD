package scanner;

import java.awt.Image;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import javax.tv.carousel.CarouselFile;
import javax.tv.locator.Locator;
import javax.tv.locator.LocatorFactory;
import javax.tv.locator.MalformedLocatorException;

import org.dvb.dsmcc.DSMCCObject;
import org.dvb.dsmcc.ServiceDomain;

import persistencia.*;
import util.Data;
import xjava.io.FileInputStream;

public class ScannerDb {

	public ScannerDb() {

		try {
			
			scanSelecoes(util.urls.dbSelecoes);
			
			scanJogadores(util.urls.dbJogadores);
			
			scanEstadios(util.urls.dbEstadios);
			
			scanTabela(util.urls.dbTabela);
			
			Copa.getInstance().toString();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedLocatorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void scanJogadores(String dbJogadores) throws IOException {

		CarouselFile carousel = new CarouselFile(
				"banco de dados local/jogadores.sdb");
		RandomAccessFile randomFile = new RandomAccessFile(carousel
				.getAbsolutePath(), "r");

		String jogadorIdentificador = "#";
		String outroJogador = randomFile.readLine();

		// lendo as linhas do arquivo
		while (outroJogador.equals(jogadorIdentificador)) {
			//System.out.println("Debug -- encontrou um jogador");
			String nome, dataNascimento, altura, cartoes, figurinha, gols, historicoEmCopas, nacionalidade, peso, posicao, selecao;
			// System.out.println("Debug");
			// TODO definir a ordem de leitura
			nome = randomFile.readLine();
			dataNascimento = randomFile.readLine();
			altura = randomFile.readLine();
			peso = randomFile.readLine();
			posicao = randomFile.readLine();
			nacionalidade = randomFile.readLine();
			selecao = randomFile.readLine();
			historicoEmCopas = randomFile.readLine();
			figurinha = randomFile.readLine();
			gols = randomFile.readLine();
			cartoes = randomFile.readLine();

			// buscando o indice da selecao
			int indSelecao = 0;
			if (!Copa.getInstance().getSelecoes().isEmpty())
				for (; indSelecao < Copa.getInstance().getSelecoes().size(); indSelecao++) {
					if (Copa.getInstance().getSelecoes().get(indSelecao)
							.getNome().equals(selecao.toUpperCase()))
						break;

				}
			Selecao selecaoCorrente;
			// TODO EM CASO DE NAO HAVER A SELECAO AINDA DEVE CRIALA
			if (indSelecao == Copa.getInstance().getSelecoes().size()
					|| Copa.getInstance().getSelecoes().isEmpty()) {
				selecaoCorrente = new Selecao(selecao.toUpperCase());
				Copa.getInstance().getSelecoes().add(selecaoCorrente);
			} else
				selecaoCorrente = Copa.getInstance().getSelecoes().get(
						indSelecao);

			Jogador jogadorCorrente = new Jogador(nome.toUpperCase(), util.Data
					.stringToData(dataNascimento), nacionalidade.toUpperCase(),
					posicao.toUpperCase(), Double.parseDouble(altura), Double
							.parseDouble(peso), historicoEmCopas.toUpperCase(),
					selecaoCorrente);

			Copa.getInstance().getJogadores().add(jogadorCorrente);
			Copa.getInstance().getSelecoes().get(indSelecao).getJogadores()
					.add(jogadorCorrente);
			
			outroJogador = randomFile.readLine();
			

		}
		

	}

	private void scanSelecoes(String dbSelecoes) throws IOException,
			MalformedLocatorException {

		CarouselFile carousel = new CarouselFile(
				"banco de dados local/selecoes.sdb");
		RandomAccessFile randomFile = new RandomAccessFile(carousel
				.getAbsolutePath(), "r");

		String selecaoIdentificador = "#";
		String outraSelecao = randomFile.readLine();

		// lendo as linhas do arquivo
		while (outraSelecao.equals(selecaoIdentificador)) {
			System.out.println("Debug -- encontrou uma selecao");

			String federacao, filiacao, nome, principaisTitulos, rankNaFifa, grupo;

			nome = randomFile.readLine();
			federacao = randomFile.readLine();
			filiacao = randomFile.readLine();

			principaisTitulos = randomFile.readLine();
			rankNaFifa = randomFile.readLine();
			grupo = randomFile.readLine();

			
			String emblema = util.urls.getInstance().getUrlEmblema(
					nome.toUpperCase());
			Selecao selecaoCorrente = new Selecao(nome.toUpperCase(), federacao
					.toUpperCase(), util.Data.stringToData(filiacao),
					principaisTitulos.toUpperCase(), Integer
							.parseInt(rankNaFifa), emblema);

			// verificar se ja foi criada tal selecao
			int indSelecao = 0;
			for (; indSelecao < Copa.getInstance().getSelecoes().size(); indSelecao++) {
				if (Copa.getInstance().getSelecoes().get(indSelecao).getNome()
						.toLowerCase().equals(nome.toLowerCase()))
					break;

			}

			// nao existe a selecao ainda
			if (indSelecao == Copa.getInstance().getSelecoes().size())
				Copa.getInstance().getSelecoes().add(selecaoCorrente);
			else {
				Copa.getInstance().getSelecoes().get(indSelecao).setEmblema(
						emblema);
				Copa.getInstance().getSelecoes().get(indSelecao).setFederacao(
						federacao);
				Copa.getInstance().getSelecoes().get(indSelecao)
						.setFiliacaoAFifa(util.Data.stringToData(filiacao));
				Copa.getInstance().getSelecoes().get(indSelecao)
						.setPrincipaisTitulos(principaisTitulos);
				Copa.getInstance().getSelecoes().get(indSelecao).setRankNaFifa(
						Integer.parseInt(rankNaFifa));

			}

			// inserindo selecao na tabela
			if (grupo.equals("A")) {
				Tabela.getInstance().grupoASelecoes.add(selecaoCorrente);
			} else if (grupo.equals("B")) {
				Tabela.getInstance().grupoBSelecoes.add(selecaoCorrente);
			} else if (grupo.equals("C")) {
				Tabela.getInstance().grupoCSelecoes.add(selecaoCorrente);
			} else if (grupo.equals("D")) {
				Tabela.getInstance().grupoDSelecoes.add(selecaoCorrente);
			} else if (grupo.equals("E")) {
				Tabela.getInstance().grupoESelecoes.add(selecaoCorrente);
			} else if (grupo.equals("F")) {
				Tabela.getInstance().grupoFSelecoes.add(selecaoCorrente);
			} else if (grupo.equals("G")) {
				Tabela.getInstance().grupoGSelecoes.add(selecaoCorrente);
			} else if (grupo.equals("H")) {
				Tabela.getInstance().grupoHSelecoes.add(selecaoCorrente);
			}

			outraSelecao = randomFile.readLine();

		}
		

	}

	private void scanEstadios(String dbEstadios) throws IOException {

		CarouselFile carousel = new CarouselFile(
				"banco de dados local/estadios.sdb");
		RandomAccessFile randomFile = new RandomAccessFile(carousel
				.getAbsolutePath(), "r");

		String estadioIdentificador = "#";
		String outroEstadio = randomFile.readLine();

		// lendo as linhas do arquivo
		while (outroEstadio.equals(estadioIdentificador)) {
			// System.out.println("Debug -- encontrou um estadio");

			String nome, cidade, inauguracao, capacidade, curiosidades;

			nome = randomFile.readLine();
			cidade = randomFile.readLine();
			inauguracao = randomFile.readLine();
			capacidade = randomFile.readLine();
			curiosidades = randomFile.readLine();
		

			String estadioImagem = util.urls.getInstance().getUrlEstadioImagem(
					nome);
			Estadio estadioCorrente = new Estadio(nome.toUpperCase(), cidade
					.toUpperCase(), util.Data.stringToData(inauguracao),
					Integer.parseInt(capacidade), curiosidades.toUpperCase(),
					estadioImagem);

			Copa.getInstance().getEstadios().add(estadioCorrente);

			outroEstadio = randomFile.readLine();

		}
		

	}

	private void scanTabela(String dbTabela) throws IOException {

		// Tabela so pode ser criada depois que criar selecoes
		CarouselFile carousel = new CarouselFile(
				"banco de dados local/tabela.sdb");
		RandomAccessFile randomFile = new RandomAccessFile(carousel
				.getAbsolutePath(), "r");

		String jogoIdentificador = "#";
		String outroJogo = randomFile.readLine();

		// lendo as linhas do arquivo
		while (outroJogo.equals(jogoIdentificador)) {

			String horaInicio, data, local, timeA, timeB, golsA, golsB;

			String nomeDoGrupo;

			nomeDoGrupo = randomFile.readLine();
			horaInicio = randomFile.readLine();
			data = randomFile.readLine();
			local = randomFile.readLine();
			timeA = randomFile.readLine();
			timeB = randomFile.readLine();
			golsA = randomFile.readLine();
			golsB = randomFile.readLine();

			Selecao timeACorrente = null;
			Selecao timeBCorrente = null;
			Estadio localCorrente = null;

			System.out.println("Grupo " + nomeDoGrupo);

			for (int i = 0; i < Copa.getInstance().getSelecoes().size(); i++) {
				if (Copa.getInstance().getSelecoes().get(i).getNome().equals(
						timeA.toUpperCase()))
					timeACorrente = Copa.getInstance().getSelecoes().get(i);
				else if (Copa.getInstance().getSelecoes().get(i).getNome()
						.equals(timeB.toUpperCase()))
					timeBCorrente = Copa.getInstance().getSelecoes().get(i);
			}

			for (int i = 0; i < Copa.getInstance().getEstadios().size(); i++) {
				if (Copa.getInstance().getEstadios().get(i).getNome().equals(
						local.toUpperCase()))
					localCorrente = Copa.getInstance().getEstadios().get(i);
			}

			List<Gol> gols = new LinkedList<Gol>();
			for (int i = 0; i < Integer.parseInt(golsA); i++) {
				Gol gol = new Gol(timeACorrente);
				gols.add(gol);
			}
			for (int i = 0; i < Integer.parseInt(golsB); i++) {
				Gol gol = new Gol(timeBCorrente);
				gols.add(gol);
			}
			Sumula sumula = new Sumula();
			sumula.setGols(gols);

			Jogo jogoCorrente = new Jogo(horaInicio.toUpperCase(), util.Data
					.stringToData(data), localCorrente, timeACorrente,
					timeBCorrente, sumula);

			if (nomeDoGrupo.equals("A")) {
				Tabela.getInstance().grupoAJogos.add(jogoCorrente);

			} else if (nomeDoGrupo.equals("B")) {
				Tabela.getInstance().grupoBJogos.add(jogoCorrente);

			} else if (nomeDoGrupo.equals("C")) {
				Tabela.getInstance().grupoCJogos.add(jogoCorrente);

			} else if (nomeDoGrupo.equals("D")) {
				Tabela.getInstance().grupoDJogos.add(jogoCorrente);

			} else if (nomeDoGrupo.equals("E")) {
				Tabela.getInstance().grupoEJogos.add(jogoCorrente);

			} else if (nomeDoGrupo.equals("F")) {
				Tabela.getInstance().grupoFJogos.add(jogoCorrente);

			} else if (nomeDoGrupo.equals("G")) {
				Tabela.getInstance().grupoGJogos.add(jogoCorrente);

			} else if (nomeDoGrupo.equals("H")) {
				Tabela.getInstance().grupoHJogos.add(jogoCorrente);

			} else if (nomeDoGrupo.equals("Oitavas")) {
				Tabela.getInstance().oitavasJogos.add(jogoCorrente);
			} else if (nomeDoGrupo.equals("Quartas")) {
				Tabela.getInstance().quartasJogos.add(jogoCorrente);
			} else if (nomeDoGrupo.equals("Semi")) {
				Tabela.getInstance().semiFinaisJogos.add(jogoCorrente);
			} else if (nomeDoGrupo.equals("Terceiro")) {
				Tabela.getInstance().terceiroLugarJogo = jogoCorrente;
			} else if (nomeDoGrupo.equals("Final")) {
				Tabela.getInstance().finalJogo = jogoCorrente;
			}

			outroJogo = randomFile.readLine();

		}
		Copa.getInstance().setTabela(Tabela.getInstance());

	}

}
