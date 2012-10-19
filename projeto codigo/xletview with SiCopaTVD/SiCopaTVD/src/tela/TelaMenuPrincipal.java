package tela;

import gerenciadores.GerenciadorDeAnimacoesMenuPrincipal;
import gerenciadores.GerenciadorDeEfeitoSonoro;
import gerenciadores.Imagens;

import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;

import javax.media.MediaLocator;
import javax.media.NoPlayerException;
import javax.media.Player;

import menuPartes.listaDeAtalhos;
import menuPartes.logoPrograma;

import org.dvb.event.*;
import org.havi.ui.*;
import org.havi.ui.event.*;

import persistencia.Estadio;
import persistencia.Selecao;

import scanner.ScannerDb;
import util.*;

public class TelaMenuPrincipal implements UserEventListener {

	/*
	 * A tela tera um icone que sera sua capa de visualizacao tera um conjunto
	 * de animacoes que sao efetivadas a medida que os botoes sao apertados
	 */
	public final static int subMenuJogadores = 1;
	public final static int subMenuEstadios = 2;
	public final static int subMenuTimes = 3;
	public final static int subMenuTabela = 4;
	public final static int subMenuClassificacao = 5;
	public final static int subMenuSobre = 6;
	public final static int subMenuFigurinhas = 7;
	public final static int subMenuUsuario = 8;
	public final static int subMenuCompra = 9;

	private int subMenuCorrente;

	private HScene cena;
	// gerenciadores
	Imagens imagens = Imagens.getInstance();
	private EventManager controladorDeEvento;
	private GerenciadorDeAnimacoesMenuPrincipal gerenciadorDeAnimacao = new GerenciadorDeAnimacoesMenuPrincipal();
	private GerenciadorDeEfeitoSonoro efeitoSonoro;
	// componentes contidos na cena
	public HIcon imagemMenu;

	private HAnimation animacao;
	public logoPrograma logo;

	// ajuda/atalhos
	private listaDeAtalhos atalhos;
	private boolean mostrandoListaDeAtalhos = false;

	private static TelaMenuPrincipal Instance = null;

	public static synchronized TelaMenuPrincipal getInstance(HScene cena) {
		if (Instance == null)
			Instance = new TelaMenuPrincipal(cena);
		return Instance;
	}

	private TelaMenuPrincipal(HScene cena) {
		this.cena = cena;
		this.controladorDeEvento = EventManager.getInstance();

		this.animacao = new HAnimation();

	}

	public void inicia(int menuCorrente) {
		this.subMenuCorrente = menuCorrente;

		String urlInicio = null;
		switch (this.subMenuCorrente) {
		case subMenuClassificacao:
			urlInicio = util.urls.menuPrincipalClassificacao;
			break;
		case subMenuCompra:
			urlInicio = util.urls.menuPrincipalCompra;
			break;
		case subMenuEstadios:
			urlInicio = util.urls.menuPrincipalEstadios;
			break;
		case subMenuFigurinhas:
			urlInicio = util.urls.menuPrincipalFigurinha;
			break;
		case subMenuJogadores:
			urlInicio = util.urls.menuPrincipalJogadores;
			break;
		case subMenuSobre:
			urlInicio = util.urls.menuPrincipalSobre;
			break;
		case subMenuTabela:
			urlInicio = util.urls.menuPrincipalTabela;
			break;
		case subMenuTimes:
			urlInicio = util.urls.menuPrincipalTimes;
			break;
		case subMenuUsuario:
			urlInicio = util.urls.menuPrincipalUsuario;
			break;
		}
		// criando a imagen padrao
		Image imagenPadrao = imagens.carregarImagem(urlInicio);

		imagemMenu = new HIcon(imagenPadrao, 0, 0, cena.getWidth(), cena
				.getHeight());

		logo = new logoPrograma();
		logo.setVisible(true);

		// criando atalhos de botoes
		criaAtalhos();

		// adicionando componentes a cena
		cena.add(logo);
		cena.add(atalhos);
		cena.add(animacao);
		cena.add(imagemMenu);
		cena.repaint();

	}

	private void criaAtalhos() {
		// (String vermelho,String verde,String amarelo,String azul, String
		// cimaBaixo,String esquerdaDireita,String ok, String num1a9,String
		// asterisco,String num0,String quadrado,String exit, String
		// menos,String mais){
		atalhos = new listaDeAtalhos("Volta o menu ", " ", " ", " ",
				" Troca o submenu", " Troca o menu", "Acessa o submenu ", " ",
				"Entra/Sai ajuda ", " ", " ", " ", " ", " ");
		atalhos.setVisible(false);

		UserEventRepository eventoDeUsuario = new UserEventRepository(
				"TelaMenuPrincipal");
		eventoDeUsuario.addKey(HRcEvent.VK_ASTERISK);
		eventoDeUsuario.addAllArrowKeys();
		eventoDeUsuario.addAllColourKeys();
		eventoDeUsuario.addKey(HRcEvent.VK_ENTER);
		eventoDeUsuario.addKey(HRcEvent.VK_CHANNEL_DOWN);
		eventoDeUsuario.addKey(HRcEvent.VK_CHANNEL_UP);
		controladorDeEvento.addUserEventListener(this, eventoDeUsuario);

	}

	public void userEventReceived(UserEvent evento) {
		int tipo = evento.getType();
		int botao = evento.getCode();

		if (tipo == HKeyEvent.KEY_RELEASED) {

			if (!mostrandoListaDeAtalhos) {

				Image imagenPadrao = null;
				if (botao == HRcEvent.VK_DOWN) {// rola a bola pra baixo

					// iniciando a animacao
					int idAnimacao = gerenciadores.GerenciadorDeAnimacoesMenuPrincipal
							.obtemAnimacao(subMenuCorrente, botao);
					// acionaAnimacao(idAnimacao);

					// TROCA A TELA
					// MUDA O SUBMENUCORRENTE
					// criando a imagen padrao

					if (subMenuCorrente == subMenuJogadores) {
						imagenPadrao = imagens
								.carregarImagem(urls.menuPrincipalEstadios);
						subMenuCorrente = subMenuEstadios;
					} else if (subMenuCorrente == subMenuTimes) {
						imagenPadrao = imagens
								.carregarImagem(urls.menuPrincipalJogadores);
						subMenuCorrente = subMenuJogadores;
					} else if (subMenuCorrente == subMenuEstadios) {
						imagenPadrao = imagens
								.carregarImagem(urls.menuPrincipalTimes);
						subMenuCorrente = subMenuTimes;
					} else if (subMenuCorrente == subMenuTabela) {
						imagenPadrao = imagens
								.carregarImagem(urls.menuPrincipalClassificacao);
						subMenuCorrente = subMenuClassificacao;
					} else if (subMenuCorrente == subMenuClassificacao) {
						imagenPadrao = imagens
								.carregarImagem(urls.menuPrincipalSobre);
						subMenuCorrente = subMenuSobre;
					} else if (subMenuCorrente == subMenuSobre) {
						imagenPadrao = imagens
								.carregarImagem(urls.menuPrincipalTabela);
						subMenuCorrente = subMenuTabela;
					} else if (subMenuCorrente == subMenuFigurinhas) {
						imagenPadrao = imagens
								.carregarImagem(urls.menuPrincipalUsuario);
						subMenuCorrente = subMenuUsuario;
					} else if (subMenuCorrente == subMenuUsuario) {
						imagenPadrao = imagens
								.carregarImagem(urls.menuPrincipalCompra);
						subMenuCorrente = subMenuCompra;
					} else if (subMenuCorrente == subMenuCompra) {
						imagenPadrao = imagens
								.carregarImagem(urls.menuPrincipalFigurinha);
						subMenuCorrente = subMenuFigurinhas;
					}

				}

				else if (botao == HRcEvent.VK_UP) { // rola a bola pra cima

					// iniciando a animacao
					int idAnimacao = gerenciadores.GerenciadorDeAnimacoesMenuPrincipal
							.obtemAnimacao(subMenuCorrente, botao);
					// acionaAnimacao(idAnimacao);

					// TROCA A TELA
					// MUDA O SUBMENUCORRENTE
					// criando a imagen padrao

					if (subMenuCorrente == subMenuTimes) {
						imagenPadrao = imagens
								.carregarImagem(urls.menuPrincipalEstadios);
						subMenuCorrente = subMenuEstadios;
					} else if (subMenuCorrente == subMenuEstadios) {
						imagenPadrao = imagens
								.carregarImagem(urls.menuPrincipalJogadores);
						subMenuCorrente = subMenuJogadores;
					} else if (subMenuCorrente == subMenuJogadores) {
						imagenPadrao = imagens
								.carregarImagem(urls.menuPrincipalTimes);
						subMenuCorrente = subMenuTimes;
					} else if (subMenuCorrente == subMenuSobre) {
						imagenPadrao = imagens
								.carregarImagem(urls.menuPrincipalClassificacao);
						subMenuCorrente = subMenuClassificacao;
					} else if (subMenuCorrente == subMenuTabela) {
						imagenPadrao = imagens
								.carregarImagem(urls.menuPrincipalSobre);
						subMenuCorrente = subMenuSobre;
					} else if (subMenuCorrente == subMenuClassificacao) {
						imagenPadrao = imagens
								.carregarImagem(urls.menuPrincipalTabela);
						subMenuCorrente = subMenuTabela;
					} else if (subMenuCorrente == subMenuCompra) {
						imagenPadrao = imagens
								.carregarImagem(urls.menuPrincipalUsuario);
						subMenuCorrente = subMenuUsuario;
					} else if (subMenuCorrente == subMenuFigurinhas) {
						imagenPadrao = imagens
								.carregarImagem(urls.menuPrincipalCompra);
						subMenuCorrente = subMenuCompra;
					} else if (subMenuCorrente == subMenuUsuario) {
						imagenPadrao = imagens
								.carregarImagem(urls.menuPrincipalFigurinha);
						subMenuCorrente = subMenuFigurinhas;
					}

				} else if (botao == HRcEvent.VK_RIGHT) { // troca elo passa
					// pro
					// da
					// direita

					// iniciando a animacao
					int idAnimacao = gerenciadores.GerenciadorDeAnimacoesMenuPrincipal
							.obtemAnimacao(subMenuCorrente, botao);
					// acionaAnimacao(idAnimacao);

					if (subMenuCorrente == subMenuJogadores
							|| subMenuCorrente == subMenuEstadios
							|| subMenuCorrente == subMenuTimes) {
						// ir do menu consulta para o extra

						imagenPadrao = imagens
								.carregarImagem(urls.menuPrincipalFigurinha);

						subMenuCorrente = subMenuFigurinhas;

					} else if (subMenuCorrente == subMenuTabela
							|| subMenuCorrente == subMenuClassificacao
							|| subMenuCorrente == subMenuSobre) {

						imagenPadrao = imagens
								.carregarImagem(urls.menuPrincipalJogadores);

						subMenuCorrente = subMenuJogadores;

					} else if (subMenuCorrente == subMenuFigurinhas
							|| subMenuCorrente == subMenuCompra
							|| subMenuCorrente == subMenuUsuario) {

						imagenPadrao = imagens
								.carregarImagem(urls.menuPrincipalTabela);

						subMenuCorrente = subMenuTabela;

					}

				} else if (botao == HRcEvent.VK_LEFT) { // troca elo passa pro
					// da
					// esquerda

					// iniciando a animacao
					int idAnimacao = gerenciadores.GerenciadorDeAnimacoesMenuPrincipal
							.obtemAnimacao(subMenuCorrente, botao);
					// acionaAnimacao(idAnimacao);

					if (subMenuCorrente == subMenuJogadores
							|| subMenuCorrente == subMenuEstadios
							|| subMenuCorrente == subMenuTimes) {
						// ir do menu consulta para o campeonato

						imagenPadrao = imagens
								.carregarImagem(urls.menuPrincipalTabela);

						subMenuCorrente = subMenuTabela;

					} else if (subMenuCorrente == subMenuTabela
							|| subMenuCorrente == subMenuClassificacao
							|| subMenuCorrente == subMenuSobre) {
						// ir do menu campeonato para o menu extra
						imagenPadrao = imagens
								.carregarImagem(urls.menuPrincipalFigurinha);

						subMenuCorrente = subMenuFigurinhas;

					} else if (subMenuCorrente == subMenuFigurinhas
							|| subMenuCorrente == subMenuCompra
							|| subMenuCorrente == subMenuUsuario) {
						// ir do menu extra para o menu consulta
						imagenPadrao = imagens
								.carregarImagem(urls.menuPrincipalJogadores);

						subMenuCorrente = subMenuJogadores;

					}

				}// fim do if para o botao esquerdo

				if (botao == HRcEvent.VK_LEFT || botao == HRcEvent.VK_RIGHT
						|| botao == HRcEvent.VK_DOWN || botao == HRcEvent.VK_UP) {
					imagemMenu.setGraphicContent(imagenPadrao,
							HVisible.NORMAL_STATE);
					cena.repaint();

				}

				else if (botao == HRcEvent.VK_ENTER) {
					switch (subMenuCorrente) {

					case subMenuJogadores: {
						this.resetaTudo();
						TelaEscolhaDeTime escolhaDeTime = TelaEscolhaDeTime
								.getInstance(cena);
						escolhaDeTime
								.inicia(TelaMenuPrincipal.subMenuJogadores);
						break;

					}
					case subMenuEstadios: {
						this.resetaTudo();

						TelaMenuEstadio telaEstadio = TelaMenuEstadio
								.getInstance(this.cena);
						telaEstadio.inicia(persistencia.Copa.getInstance()
								.getEstadioEspecifico("SOCCER CITY"));
						break;
					}

					case subMenuTabela: {

						this.resetaTudo();
						TelaMenuTabela tabela = new TelaMenuTabela(cena);
						tabela.inicia();
						break;

					}
					case subMenuTimes: {
						this.resetaTudo();
						TelaEscolhaDeTime escolhaDeTime = TelaEscolhaDeTime
								.getInstance(cena);
						escolhaDeTime.inicia(TelaMenuPrincipal.subMenuTimes);
						break;

					}
					case subMenuSobre: {
						this.resetaTudo();
						TelaMenuSobre telaSobre = TelaMenuSobre
								.getInstance(cena);
						telaSobre.inicia();
						break;
					}

					case subMenuFigurinhas: {
						this.resetaTudo();
						TelaMenuFigurinha telaFigurinhas = TelaMenuFigurinha
								.getInstance(cena);
						telaFigurinhas.inicia();
						break;
					}
					}

				}// fim do if para o botao enter
				if (botao == HRcEvent.VK_CHANNEL_DOWN
						|| botao == HRcEvent.VK_CHANNEL_UP)
					efeitoSonoro.aumentaVolume(botao);
				// dispara efeito sonoro
				// efeitoSonoro.iniciaEfeito();

			}// fim do if para mostrandoMenuAtalhos

			if (botao == HRcEvent.VK_ASTERISK) {// aciona a ajuda
				mostrandoListaDeAtalhos = !mostrandoListaDeAtalhos;

				atalhos.setVisible(mostrandoListaDeAtalhos);
				
			}

		}

	}

	private void acionaAnimacao(int idAnimacao) {
		

		animacao
				.setAnimateContent(gerenciadorDeAnimacao
						.carregandoImagensParaAnimacao(idAnimacao),
						HState.NORMAL_STATE);
		animacao.setBackgroundMode(Color.TRANSLUCENT);
		animacao.setBounds(0, 0, cena.getWidth(), cena.getHeight());
		animacao.setRepeatCount(0);
		animacao.setVisible(true);
		animacao.setDelay(1);
		animacao.start();

	}

	private void resetaTudo() {

		this.cena.removeAll();
		this.cena.repaint();
		this.controladorDeEvento.removeUserEventListener(this);

	}

}
