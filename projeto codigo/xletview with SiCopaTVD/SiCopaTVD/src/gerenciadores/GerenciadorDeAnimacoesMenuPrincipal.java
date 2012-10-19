package gerenciadores;

import java.awt.Image;

import org.havi.ui.HAnimation;
import org.havi.ui.HScene;
import org.havi.ui.event.HRcEvent;

import util.urls;

public class GerenciadorDeAnimacoesMenuPrincipal {

	static Image imagemNecessaria[] = null;
	static Imagens imagens = Imagens.getInstance();
	HAnimation animacoesCorrente[] = null;
	HScene cena;

	public HAnimation[] geraConjuntoDeAnimacoes(HScene cena) {

		this.cena = cena;

		return animacoesCorrente;
	}

	public static String[] imagensContidas = {
			urls.menuPrincipalJogadoresV1,
			urls.menuPrincipalJogadoresV2,
			urls.menuPrincipalJogadoresV3,
			urls.menuPrincipalJogadoresV4,
			urls.menuPrincipalJogadoresV5,

			urls.menuPrincipalEstadiosV1,
			urls.menuPrincipalEstadiosV2,
			urls.menuPrincipalEstadiosV3,
			urls.menuPrincipalEstadiosV4,
			urls.menuPrincipalEstadiosV5,
			urls.menuPrincipalTimesV1,
			urls.menuPrincipalTimesV2,
			urls.menuPrincipalTimesV3,
			urls.menuPrincipalTimesV4,
			urls.menuPrincipalTimesV5,

			urls.menuPrincipalTabelaV1,
			urls.menuPrincipalTabelaV2,
			urls.menuPrincipalTabelaV3,
			urls.menuPrincipalTabelaV4,
			urls.menuPrincipalTabelaV5,
			urls.menuPrincipalClassificacaoV1,
			urls.menuPrincipalClassificacaoV2, // 21
			urls.menuPrincipalClassificacaoV3,
			urls.menuPrincipalClassificacaoV4,
			urls.menuPrincipalClassificacaoV5,
			urls.menuPrincipalSobreV1,
			urls.menuPrincipalSobreV2,
			urls.menuPrincipalSobreV3,
			urls.menuPrincipalSobreV4,
			urls.menuPrincipalSobreV5,

			urls.menuPrincipalFigurinhaV1,
			urls.menuPrincipalFigurinhaV2, // 31
			urls.menuPrincipalFigurinhaV3, urls.menuPrincipalFigurinhaV4,
			urls.menuPrincipalFigurinhaV5,
			urls.menuPrincipalUsuarioV1,
			urls.menuPrincipalUsuarioV2,
			urls.menuPrincipalUsuarioV3,
			urls.menuPrincipalUsuarioV4,
			urls.menuPrincipalUsuarioV5,
			urls.menuPrincipalCompraV1,
			urls.menuPrincipalCompraV2, // 41
			urls.menuPrincipalCompraV3,
			urls.menuPrincipalCompraV4,
			urls.menuPrincipalCompraV5,

			// imagens para movimentacao horizontal
			urls.menuPrincipalConsultaH1, urls.menuPrincipalConsultaH2,
			urls.menuPrincipalConsultaH3,

			urls.menuPrincipalExtraH1, urls.menuPrincipalExtraH2,
			urls.menuPrincipalExtraH3,

			urls.menuPrincipalCampeonatoH1, urls.menuPrincipalCampeonatoH2,
			urls.menuPrincipalCampeonatoH3 };

	public Image[] carregandoTodasAsImagensNecessarias() {
		Image[] imagensNecessarias = {
				imagens.carregarImagem(urls.menuPrincipalJogadoresV1),
				imagens.carregarImagem(urls.menuPrincipalJogadoresV2),
				imagens.carregarImagem(urls.menuPrincipalJogadoresV3),
				imagens.carregarImagem(urls.menuPrincipalJogadoresV4),
				imagens.carregarImagem(urls.menuPrincipalJogadoresV5),

				imagens.carregarImagem(urls.menuPrincipalEstadiosV1),
				imagens.carregarImagem(urls.menuPrincipalEstadiosV2),
				imagens.carregarImagem(urls.menuPrincipalEstadiosV3),
				imagens.carregarImagem(urls.menuPrincipalEstadiosV4),
				imagens.carregarImagem(urls.menuPrincipalEstadiosV5),

				imagens.carregarImagem(urls.menuPrincipalTimesV1),
				imagens.carregarImagem(urls.menuPrincipalTimesV2),
				imagens.carregarImagem(urls.menuPrincipalTimesV3),
				imagens.carregarImagem(urls.menuPrincipalTimesV4),
				imagens.carregarImagem(urls.menuPrincipalTimesV5),

				imagens.carregarImagem(urls.menuPrincipalTabelaV1),
				imagens.carregarImagem(urls.menuPrincipalTabelaV2),
				imagens.carregarImagem(urls.menuPrincipalTabelaV3),
				imagens.carregarImagem(urls.menuPrincipalTabelaV4),
				imagens.carregarImagem(urls.menuPrincipalTabelaV5),

				imagens.carregarImagem(urls.menuPrincipalClassificacaoV1),
				imagens.carregarImagem(urls.menuPrincipalClassificacaoV2),
				imagens.carregarImagem(urls.menuPrincipalClassificacaoV4),
				imagens.carregarImagem(urls.menuPrincipalClassificacaoV4),
				imagens.carregarImagem(urls.menuPrincipalClassificacaoV5),

				imagens.carregarImagem(urls.menuPrincipalSobreV1),
				imagens.carregarImagem(urls.menuPrincipalSobreV2),
				imagens.carregarImagem(urls.menuPrincipalSobreV3),
				imagens.carregarImagem(urls.menuPrincipalSobreV4),
				imagens.carregarImagem(urls.menuPrincipalSobreV5),

				imagens.carregarImagem(urls.menuPrincipalFigurinhaV1),
				imagens.carregarImagem(urls.menuPrincipalFigurinhaV2),
				imagens.carregarImagem(urls.menuPrincipalFigurinhaV3),
				imagens.carregarImagem(urls.menuPrincipalFigurinhaV4),
				imagens.carregarImagem(urls.menuPrincipalFigurinhaV4),

				imagens.carregarImagem(urls.menuPrincipalUsuarioV1),
				imagens.carregarImagem(urls.menuPrincipalUsuarioV2),
				imagens.carregarImagem(urls.menuPrincipalUsuarioV3),
				imagens.carregarImagem(urls.menuPrincipalUsuarioV4),
				imagens.carregarImagem(urls.menuPrincipalUsuarioV5),

				imagens.carregarImagem(urls.menuPrincipalCompraV1),
				imagens.carregarImagem(urls.menuPrincipalCompraV2),
				imagens.carregarImagem(urls.menuPrincipalCompraV4),
				imagens.carregarImagem(urls.menuPrincipalCompraV4),
				imagens.carregarImagem(urls.menuPrincipalCompraV5),

				// imagens para movimentacao horizontal
				imagens.carregarImagem(urls.menuPrincipalConsultaH1),
				imagens.carregarImagem(urls.menuPrincipalConsultaH2),
				imagens.carregarImagem(urls.menuPrincipalConsultaH3),

				imagens.carregarImagem(urls.menuPrincipalExtraH1),
				imagens.carregarImagem(urls.menuPrincipalExtraH2),
				imagens.carregarImagem(urls.menuPrincipalExtraH3),

				imagens.carregarImagem(urls.menuPrincipalCampeonatoH1),
				imagens.carregarImagem(urls.menuPrincipalCampeonatoH2),
				imagens.carregarImagem(urls.menuPrincipalCampeonatoH3)

		};
		return imagensNecessarias;
	}

	public static Image[] carregandoImagensParaAnimacao(int animacao) {

		/*
		 * Mapa de animações para o menu principal Movimentos verticais 1 a 18
		 * baixo e cima 1 e 2 jogadores 3 e 4 estadios 5 e 6 times 7 e 8 tabela
		 * 9 e 10 classificacao 11 e 12 sobre 13 e 14 figurinhas 15 e 16 usuario
		 * 17 e 18 compra
		 * 
		 * Movimentos horizontais direita e esquerda 19 20 21 e 22 23 24
		 * consulta para extra e campeonato 25 26 27 e 28 29 30 campeonato para
		 * consulta e extra 31 32 33 e 34 35 36 extra pra campeonato e consulta
		 */
		Image imagensParaAnimacao[] = null;

		switch (animacao) {

		case 1: {
			Image imagensParaAnimacao1[] = { imagemNecessaria(0),
					imagemNecessaria(1), imagemNecessaria(2),
					imagemNecessaria(3), imagemNecessaria(4),
					imagemNecessaria(7), imagemNecessaria(6),
					imagemNecessaria(5) };
			imagensParaAnimacao = imagensParaAnimacao1;
			break;

		}
		case 2: {
			Image imagensParaAnimacao2[] = { imagemNecessaria(0),
					imagemNecessaria(1), imagemNecessaria(2),
					imagemNecessaria(14), imagemNecessaria(13),
					imagemNecessaria(12), imagemNecessaria(11),
					imagemNecessaria(10) };

			imagensParaAnimacao = imagensParaAnimacao2;
			break;
		}
		case 3: {
			Image imagensParaAnimacao3[] = { imagemNecessaria(5),
					imagemNecessaria(6), imagemNecessaria(7),
					imagemNecessaria(8), imagemNecessaria(9),
					imagemNecessaria(12), imagemNecessaria(11),
					imagemNecessaria(10) };
			imagensParaAnimacao = imagensParaAnimacao3;
			break;
		}
		case 4: {
			Image imagensParaAnimacao4[] = { imagemNecessaria(5),
					imagemNecessaria(6), imagemNecessaria(7),
					imagemNecessaria(4), imagemNecessaria(3),
					imagemNecessaria(2), imagemNecessaria(1),
					imagemNecessaria(0) };
			imagensParaAnimacao = imagensParaAnimacao4;
			break;
		}
		case 5: {
			Image imagensParaAnimacao5[] = { imagemNecessaria(10),
					imagemNecessaria(11), imagemNecessaria(12),
					imagemNecessaria(13), imagemNecessaria(14),
					imagemNecessaria(2), imagemNecessaria(1),
					imagemNecessaria(0) };
			imagensParaAnimacao = imagensParaAnimacao5;
			break;
		}

		case 6: {
			Image imagensParaAnimacao6[] = { imagemNecessaria(10),
					imagemNecessaria(11), imagemNecessaria(12),
					imagemNecessaria(9), imagemNecessaria(8),
					imagemNecessaria(7), imagemNecessaria(6),
					imagemNecessaria(5) };
			imagensParaAnimacao = imagensParaAnimacao6;
			break;
		}

		case 7: {
			Image imagensParaAnimacao7[] = { imagemNecessaria(15 + 0),
					imagemNecessaria(15 + 1), imagemNecessaria(15 + 2),
					imagemNecessaria(15 + 3), imagemNecessaria(15 + 4),
					imagemNecessaria(15 + 7), imagemNecessaria(15 + 6),
					imagemNecessaria(15 + 5) };
			imagensParaAnimacao = imagensParaAnimacao7;
			break;
		}

		case 8: {
			Image imagensParaAnimacao8[] = { imagemNecessaria(15 + 0),
					imagemNecessaria(15 + 1), imagemNecessaria(15 + 2),
					imagemNecessaria(15 + 14), imagemNecessaria(15 + 13),
					imagemNecessaria(15 + 12), imagemNecessaria(15 + 11),
					imagemNecessaria(15 + 10) };
			imagensParaAnimacao = imagensParaAnimacao8;
			break;
		}

		case 9: {
			Image imagensParaAnimacao9[] = { imagemNecessaria(15 + 5),
					imagemNecessaria(15 + 6), imagemNecessaria(15 + 7),
					imagemNecessaria(15 + 8), imagemNecessaria(15 + 9),
					imagemNecessaria(15 + 12), imagemNecessaria(15 + 11),
					imagemNecessaria(15 + 10) };
			imagensParaAnimacao = imagensParaAnimacao9;
			break;
		}

		case 10: {
			Image imagensParaAnimacao10[] = { imagemNecessaria(15 + 5),
					imagemNecessaria(15 + 6), imagemNecessaria(15 + 7),
					imagemNecessaria(15 + 4), imagemNecessaria(15 + 3),
					imagemNecessaria(15 + 2), imagemNecessaria(15 + 1),
					imagemNecessaria(15 + 0) };

			imagensParaAnimacao = imagensParaAnimacao10;
			break;
		}
		case 11: {
			Image imagensParaAnimacao11[] = { imagemNecessaria(15 + 10),
					imagemNecessaria(15 + 11), imagemNecessaria(15 + 12),
					imagemNecessaria(15 + 13), imagemNecessaria(15 + 14),
					imagemNecessaria(15 + 2), imagemNecessaria(15 + 1),
					imagemNecessaria(15 + 0) };

			imagensParaAnimacao = imagensParaAnimacao11;
			break;
		}
		case 12: {
			Image imagensParaAnimacao12[] = { imagemNecessaria(15 + 10),
					imagemNecessaria(15 + 11), imagemNecessaria(15 + 12),
					imagemNecessaria(15 + 9), imagemNecessaria(15 + 8),
					imagemNecessaria(15 + 7), imagemNecessaria(15 + 6),
					imagemNecessaria(15 + 5) };

			imagensParaAnimacao = imagensParaAnimacao12;
			break;
		}
		case 13: {
			Image imagensParaAnimacao13[] = { imagemNecessaria(30 + 0),
					imagemNecessaria(30 + 1), imagemNecessaria(30 + 2),
					imagemNecessaria(30 + 3), imagemNecessaria(30 + 4),
					imagemNecessaria(30 + 7), imagemNecessaria(30 + 6),
					imagemNecessaria(30 + 5) };

			imagensParaAnimacao = imagensParaAnimacao13;
			break;
		}
		case 14: {
			Image imagensParaAnimacao14[] = { imagemNecessaria(30 + 0),
					imagemNecessaria(30 + 1), imagemNecessaria(30 + 2),
					imagemNecessaria(30 + 14), imagemNecessaria(30 + 13),
					imagemNecessaria(30 + 12), imagemNecessaria(30 + 11),
					imagemNecessaria(30 + 10) };

			imagensParaAnimacao = imagensParaAnimacao14;
			break;
		}
		case 15: {
			Image imagensParaAnimacao15[] = { imagemNecessaria(30 + 5),
					imagemNecessaria(30 + 6), imagemNecessaria(30 + 7),
					imagemNecessaria(30 + 8), imagemNecessaria(30 + 9),
					imagemNecessaria(30 + 12), imagemNecessaria(30 + 11),
					imagemNecessaria(30 + 10) };

			imagensParaAnimacao = imagensParaAnimacao15;
			break;
		}
		case 16: {
			Image imagensParaAnimacao16[] = { imagemNecessaria(30 + 5),
					imagemNecessaria(30 + 6), imagemNecessaria(30 + 7),
					imagemNecessaria(30 + 4), imagemNecessaria(30 + 3),
					imagemNecessaria(30 + 2), imagemNecessaria(30 + 1),
					imagemNecessaria(30 + 0) };

			imagensParaAnimacao = imagensParaAnimacao16;
			break;
		}
		case 17: {

			Image imagensParaAnimacao17[] = { imagemNecessaria(30 + 10),
					imagemNecessaria(30 + 11), imagemNecessaria(30 + 12),
					imagemNecessaria(30 + 13), imagemNecessaria(30 + 14),
					imagemNecessaria(30 + 2), imagemNecessaria(30 + 1),
					imagemNecessaria(30 + 0) };

			imagensParaAnimacao = imagensParaAnimacao17;
			break;
		}

		case 18: {
			Image imagensParaAnimacao18[] = { imagemNecessaria(30 + 10),
					imagemNecessaria(30 + 11), imagemNecessaria(30 + 12),
					imagemNecessaria(30 + 9), imagemNecessaria(30 + 8),
					imagemNecessaria(30 + 7), imagemNecessaria(30 + 6),
					imagemNecessaria(30 + 5) };

			imagensParaAnimacao = imagensParaAnimacao18;
			break;
		}

		case 19: {
			// quando em consulta o sub menu é o jogadores e op direita
			Image imagensParaAnimacao19[] = { imagemNecessaria(0),
					imagemNecessaria(1), imagemNecessaria(2),
					imagemNecessaria(45), imagemNecessaria(46),
					imagemNecessaria(47), imagemNecessaria(32),
					imagemNecessaria(31), imagemNecessaria(30) };

			imagensParaAnimacao = imagensParaAnimacao19;
			break;
		}
		case 20: {
			// quando em consulta o sub menu é o estadio entao va a jogador
			// antes
			Image imagensParaAnimacao20[] = { imagemNecessaria(5),
					imagemNecessaria(6), imagemNecessaria(7),
					imagemNecessaria(4), imagemNecessaria(3),
					imagemNecessaria(45), imagemNecessaria(46),
					imagemNecessaria(47), imagemNecessaria(32),
					imagemNecessaria(31), imagemNecessaria(30) };

			imagensParaAnimacao = imagensParaAnimacao20;
			break;
		}
		case 21: {
			// quando em consulta o sub menu é o times entao va a jogador antes
			Image imagensParaAnimacao21[] = { imagemNecessaria(10),
					imagemNecessaria(11), imagemNecessaria(12),
					imagemNecessaria(13), imagemNecessaria(14),
					imagemNecessaria(45), imagemNecessaria(46),
					imagemNecessaria(47), imagemNecessaria(32),
					imagemNecessaria(31), imagemNecessaria(30) };

			imagensParaAnimacao = imagensParaAnimacao21;
			break;
		}

		case 22: {
			// direcao esquerda pa o menu consulta
			Image imagensParaAnimacao22[] = { imagemNecessaria(0),
					imagemNecessaria(1), imagemNecessaria(2),
					imagemNecessaria(53), imagemNecessaria(52),
					imagemNecessaria(17), imagemNecessaria(16),
					imagemNecessaria(15) };

			imagensParaAnimacao = imagensParaAnimacao22;
			break;
		}
		case 23: {
			// quando sub em estadios
			Image imagensParaAnimacao23[] = { imagemNecessaria(5),
					imagemNecessaria(6), imagemNecessaria(7),
					imagemNecessaria(4), imagemNecessaria(3),
					imagemNecessaria(53), imagemNecessaria(52),
					imagemNecessaria(17), imagemNecessaria(16),
					imagemNecessaria(15) };

			imagensParaAnimacao = imagensParaAnimacao23;
			break;
		}
		case 24: {
			// quando o submenu esta em times
			Image imagensParaAnimacao24[] = { imagemNecessaria(10),
					imagemNecessaria(11), imagemNecessaria(12),
					imagemNecessaria(13), imagemNecessaria(14),
					imagemNecessaria(53), imagemNecessaria(52),
					imagemNecessaria(17), imagemNecessaria(16),
					imagemNecessaria(15) };

			imagensParaAnimacao = imagensParaAnimacao24;
			break;
		}

		case 25: {
			// quando em campeonato o sub menu é o tabela e op direita
			Image imagensParaAnimacao25[] = { imagemNecessaria(15 + 0),
					imagemNecessaria(15 + 1), imagemNecessaria(15 + 2),
					imagemNecessaria(51), imagemNecessaria(52),
					imagemNecessaria(53), imagemNecessaria(2),
					imagemNecessaria(1), imagemNecessaria(0) };

			imagensParaAnimacao = imagensParaAnimacao25;
			break;
		}
		case 26: {
			// sub menu classificacao va a tabela antes
			Image imagensParaAnimacao26[] = { imagemNecessaria(15 + 5),
					imagemNecessaria(15 + 6), imagemNecessaria(15 + 7),
					imagemNecessaria(15 + 4), imagemNecessaria(15 + 3),
					imagemNecessaria(51), imagemNecessaria(52),
					imagemNecessaria(53), imagemNecessaria(2),
					imagemNecessaria(1), imagemNecessaria(0) };

			imagensParaAnimacao = imagensParaAnimacao26;
			break;
		}
		case 27: {
			// sub menu sobre va a tabela antes
			Image imagensParaAnimacao27[] = { imagemNecessaria(15 + 10),
					imagemNecessaria(15 + 11), imagemNecessaria(15 + 12),
					imagemNecessaria(15 + 13), imagemNecessaria(15 + 14),
					imagemNecessaria(51), imagemNecessaria(52),
					imagemNecessaria(53), imagemNecessaria(2),
					imagemNecessaria(1), imagemNecessaria(0) };

			imagensParaAnimacao = imagensParaAnimacao27;
			break;
		}
		case 28: {
			// direcao esquerda pa o menu consulta
			Image imagensParaAnimacao28[] = { imagemNecessaria(15 + 0),
					imagemNecessaria(15 + 1), imagemNecessaria(15 + 2),
					imagemNecessaria(50), imagemNecessaria(49),
					imagemNecessaria(32), imagemNecessaria(31),
					imagemNecessaria(30) };

			imagensParaAnimacao = imagensParaAnimacao28;
			break;
		}
		case 29: {
			// quando sub em classi
			Image imagensParaAnimacao29[] = { imagemNecessaria(15 + 5),
					imagemNecessaria(15 + 6), imagemNecessaria(15 + 7),
					imagemNecessaria(15 + 4), imagemNecessaria(15 + 3),
					imagemNecessaria(50), imagemNecessaria(49),
					imagemNecessaria(32), imagemNecessaria(31),
					imagemNecessaria(30) };
			imagensParaAnimacao = imagensParaAnimacao29;
			break;
		}
		case 30: {
			// quando o submenu esta sobre
			Image imagensParaAnimacao30[] = { imagemNecessaria(15 + 10),
					imagemNecessaria(15 + 11), imagemNecessaria(15 + 12),
					imagemNecessaria(15 + 13), imagemNecessaria(15 + 14),
					imagemNecessaria(50), imagemNecessaria(49),
					imagemNecessaria(32), imagemNecessaria(31),
					imagemNecessaria(30) };

			imagensParaAnimacao = imagensParaAnimacao30;
			break;
		}
		case 31: {
			// quando em extra o sub menu é o figurinha e op direita
			Image imagensParaAnimacao31[] = { imagemNecessaria(15 + 15 + 0),
					imagemNecessaria(15 + 15 + 1),
					imagemNecessaria(15 + 15 + 2), imagemNecessaria(48),
					imagemNecessaria(49), imagemNecessaria(50),
					imagemNecessaria(15 + 2), imagemNecessaria(15 + 1),
					imagemNecessaria(15 + 0) };
			imagensParaAnimacao = imagensParaAnimacao31;
			break;
		}
		case 32: {
			// sub menu usuario va a figurinha antes
			Image imagensParaAnimacao32[] = { imagemNecessaria(30 + 5),
					imagemNecessaria(30 + 6), imagemNecessaria(30 + 7),
					imagemNecessaria(30 + 4), imagemNecessaria(30 + 3),
					imagemNecessaria(48), imagemNecessaria(49),
					imagemNecessaria(50), imagemNecessaria(15 + 2),
					imagemNecessaria(15 + 1), imagemNecessaria(15 + 0) };
			imagensParaAnimacao = imagensParaAnimacao32;
			break;
		}
		case 33: {
			// sub menu compra va a figurinha antes
			Image imagensParaAnimacao33[] = { imagemNecessaria(30 + 10),
					imagemNecessaria(30 + 11), imagemNecessaria(30 + 12),
					imagemNecessaria(30 + 13), imagemNecessaria(30 + 14),
					imagemNecessaria(48), imagemNecessaria(49),
					imagemNecessaria(50), imagemNecessaria(15 + 2),
					imagemNecessaria(15 + 1), imagemNecessaria(15 + 0) };
			imagensParaAnimacao = imagensParaAnimacao33;
			break;
		}

		case 34: {
			// direcao esquerda
			Image imagensParaAnimacao34[] = { imagemNecessaria(30 + 0),
					imagemNecessaria(30 + 1), imagemNecessaria(30 + 2),
					imagemNecessaria(47), imagemNecessaria(46),
					imagemNecessaria(2), imagemNecessaria(1),
					imagemNecessaria(0) };
			imagensParaAnimacao = imagensParaAnimacao34;
			break;
		}
		case 35: {
			// quando sub em usuario
			Image imagensParaAnimacao35[] = { imagemNecessaria(30 + 5),
					imagemNecessaria(30 + 6), imagemNecessaria(30 + 7),
					imagemNecessaria(30 + 4), imagemNecessaria(30 + 3),
					imagemNecessaria(47), imagemNecessaria(46),
					imagemNecessaria(2), imagemNecessaria(1),
					imagemNecessaria(0) };
			imagensParaAnimacao = imagensParaAnimacao35;
			break;
		}
		case 36: {
			// quando o submenu compra
			Image imagensParaAnimacao36[] = { imagemNecessaria(30 + 10),
					imagemNecessaria(30 + 11), imagemNecessaria(30 + 12),
					imagemNecessaria(30 + 13), imagemNecessaria(30 + 14),
					imagemNecessaria(47), imagemNecessaria(46),
					imagemNecessaria(2), imagemNecessaria(1),
					imagemNecessaria(0) };

			imagensParaAnimacao = imagensParaAnimacao36;
			break;
		}

		}

		return imagensParaAnimacao;

	}

	public static Image imagemNecessaria(int valor) {

		return imagens.carregarImagem(imagensContidas[valor]);
	}

	public static int obtemAnimacao(int submenu, int botao) {
		int identificador = 0;

		if (botao == HRcEvent.VK_DOWN)// rola a bola pra baixo
			identificador = submenu * 2 - 1;
		else if (botao == HRcEvent.VK_UP) // rola a bola pra cima
			identificador = submenu * 2;
		else if (botao == HRcEvent.VK_RIGHT) // troca elo passa pro da
			// direita
			identificador = submenu + 18 + ((submenu - 1) / 3) * 3;
		else if (botao == HRcEvent.VK_LEFT) // troca elo passa pro da esquerda
			identificador = submenu + 21 + ((submenu - 1) / 3) * 3;

		return identificador;
	}

	public GerenciadorDeAnimacoesMenuPrincipal() {

	}
}
