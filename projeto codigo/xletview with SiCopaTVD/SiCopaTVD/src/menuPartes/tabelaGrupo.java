package menuPartes;

import gerenciadores.Imagens;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import org.havi.ui.HIcon;
import org.havi.ui.HStaticText;
import org.havi.ui.HVisible;

import persistencia.Jogo;
import persistencia.Selecao;
import persistencia.Tabela;

public class tabelaGrupo extends Container {

	// caracter que define o grupo
	private char grupoChar;
	// elementos para a tabela do grupo
	private HIcon tabelaGrupoIcon;
	private HIcon grupoLetra;
	private listaDeEmblemas emblemas;
	private jogosTexto jogoTexto;

	// variaveis de tamanho e de posicao
	private final int larguraTabelaGrupoIcon = 310;
	private final int alturaTabelaGrupoIcon = 412;
	private final int larguraGrupoLetraLargura = 55;
	private final int alturaGrupoLetraAltura = 55;

	private final int posXGrupoLetra = 32;
	private final int posYGrupoLetra = 346;
	private final int posXSelecaoEmblema = 93;
	private final int posYSelecaoEmblema = 349;

	private Imagens imagens = Imagens.getInstance();

	public tabelaGrupo(char grupo) {
		this.setBounds(0, 0, larguraTabelaGrupoIcon, alturaTabelaGrupoIcon);

		this.emblemas = new listaDeEmblemas(grupo);
		this.tabelaGrupoIcon = new HIcon(imagens
				.carregarImagem(util.urls.tabelaGrupo), 0, 0,
				larguraTabelaGrupoIcon, alturaTabelaGrupoIcon);
		this.jogoTexto = new jogosTexto(grupo);
		String urlLetra = null;

		switch (grupo) {
		case 'A':
			urlLetra = util.urls.letraA;
			break;
		case 'B':
			urlLetra = util.urls.letraB;
			break;
		case 'C':
			urlLetra = util.urls.letraC;
			break;
		case 'D':
			urlLetra = util.urls.letraD;
			break;
		case 'E':
			urlLetra = util.urls.letraE;
			break;
		case 'F':
			urlLetra = util.urls.letraF;
			break;
		case 'G':
			urlLetra = util.urls.letraG;
			break;
		case 'H':
			urlLetra = util.urls.letraH;
			break;

		}

		this.grupoLetra = new HIcon(imagens.carregarImagem(urlLetra),
				posXGrupoLetra, posYGrupoLetra, larguraGrupoLetraLargura,
				alturaGrupoLetraAltura);

		// setando posicoes ainda nao setadas
		this.emblemas.setLocation(posXSelecaoEmblema, posYSelecaoEmblema);
		this.jogoTexto.setLocation(10, 10);

		// adicionando os elementos ao container
		this.add(emblemas);
		this.add(jogoTexto);
		this.add(grupoLetra);
		this.add(tabelaGrupoIcon);
		this.repaint();

	}

	public class listaDeEmblemas extends Container {
		private HIcon[] emblemasIcon;
		private final int larguraEmblemaIcone = 55;
		private final int alturaEmblemaIcone = 55;

		public listaDeEmblemas(char grupo) {

			this.setBounds(0, 0, larguraEmblemaIcone * 4, alturaEmblemaIcone);
			emblemasIcon = new HIcon[4];
			List<Selecao> selecoes = persistencia.Copa.getInstance()
					.getTabela().grupoASelecoes;
		
			switch (grupo) {
			case 'A':
				selecoes = persistencia.Copa.getInstance().getTabela().grupoASelecoes;
				break;
			case 'B':
				selecoes = persistencia.Copa.getInstance().getTabela().grupoBSelecoes;
				break;
			case 'C':
				selecoes = persistencia.Copa.getInstance().getTabela().grupoCSelecoes;
				break;
			case 'D':
				selecoes = persistencia.Copa.getInstance().getTabela().grupoDSelecoes;
				break;
			case 'E':
				selecoes = persistencia.Copa.getInstance().getTabela().grupoESelecoes;
				break;
			case 'F':
				selecoes = persistencia.Copa.getInstance().getTabela().grupoFSelecoes;
				break;
			case 'G':
				selecoes = persistencia.Copa.getInstance().getTabela().grupoGSelecoes;
				break;
			case 'H':
				selecoes = persistencia.Copa.getInstance().getTabela().grupoHSelecoes;
				break;

			}

			// obtendo os emblemas e posicionando-os
			for (int i = 0; i < selecoes.size(); i++) {
				emblemasIcon[i] = new HIcon(imagens.carregarImagem(selecoes
						.get(i).getEmblema()));
				emblemasIcon[i]
						.setSize(larguraEmblemaIcone, alturaEmblemaIcone);
				emblemasIcon[i].setLocation(i * larguraEmblemaIcone, 0);
				this.add(emblemasIcon[i]);
			}

			this.repaint();

		}

	}

	public class jogosTexto extends Container {
		int posXTime1Jogo = 2;
		int posYTime1Jogo = 24;
		int posXTime2Jogo = 190;
		int posYTime2Jogo = 24;
		int posXLocalJogo;
		int posYLocalJogo = 2;
		int posXHoraJogo = 43;
		int posYHoraJogo = 2;
		int espacamentoYJogos = 55;
		int espacamentoYHora = 55;
		int espacamentoYLocal = 55;

		List<HStaticText> listaDeTexto = new ArrayList<HStaticText>();
		private int posYGolsA = posYTime1Jogo;
		private int espacamentoYGols = espacamentoYJogos;
		private int posXGolsA = 110;
		private int posYGolsB = posYTime1Jogo;
		private int posXGolsB = 156;

		public jogosTexto(char grupo) {
			this.setBounds(0, 0, larguraTabelaGrupoIcon, alturaTabelaGrupoIcon);
			List<Jogo> jogos = null;
			switch (grupo) {
			case 'A':
				jogos = persistencia.Copa.getInstance().getTabela().grupoAJogos;
				break;
			case 'B':
				jogos = persistencia.Copa.getInstance().getTabela().grupoBJogos;
				break;
			case 'C':
				jogos = persistencia.Copa.getInstance().getTabela().grupoCJogos;
				break;
			case 'D':
				jogos = persistencia.Copa.getInstance().getTabela().grupoDJogos;
				break;
			case 'E':
				jogos = persistencia.Copa.getInstance().getTabela().grupoEJogos;
				break;
			case 'F':
				jogos = persistencia.Copa.getInstance().getTabela().grupoFJogos;
				break;
			case 'G':
				jogos = persistencia.Copa.getInstance().getTabela().grupoGJogos;
				break;
			case 'H':
				jogos = persistencia.Copa.getInstance().getTabela().grupoHJogos;
				break;

			}

			// criando textos
			for (int i = 0; i < jogos.size(); i++) {
				String timeANome = abreviaSelecao(jogos.get(i).getTimeA()
						.getNome());
				String timeBNome = abreviaSelecao(jogos.get(i).getTimeB()
						.getNome());
				String localNome = jogos.get(i).getLocal().getNome();
				String horario = jogos.get(i).getData().toString() + "-"
						+ jogos.get(i).getHoraInicio();
				String golsA = String.valueOf(jogos.get(i).getTotalGolsTimeA());
				String golsB = String.valueOf(jogos.get(i).getTotalGolsTimeB());

				System.out.println("Jogo " + i + "\n" + timeANome + " " + golsA
						+ " x " + golsB + " " + timeBNome + " as " + horario
						+ " em " + localNome);

				HStaticText timeANomeText = new HStaticText();
				timeANomeText.setForeground(Color.white);
				timeANomeText.setBackgroundMode(Color.TRANSLUCENT);
				timeANomeText.setFont(Font.decode("ARIAL-15"));
				timeANomeText.setHorizontalAlignment(HVisible.HALIGN_LEFT);
				timeANomeText.setVerticalAlignment(HVisible.VALIGN_TOP);
				timeANomeText.setSize(100, 70);

				HStaticText timeBNomeText = new HStaticText();
				timeBNomeText.setForeground(Color.white);
				timeBNomeText.setBackgroundMode(Color.TRANSLUCENT);
				timeBNomeText.setFont(Font.decode("ARIAL-15"));
				timeBNomeText.setHorizontalAlignment(HVisible.HALIGN_LEFT);
				timeBNomeText.setVerticalAlignment(HVisible.VALIGN_TOP);
				timeBNomeText.setSize(100, 70);

				HStaticText localNomeText = new HStaticText();
				localNomeText.setSize(150, 70);
				localNomeText.setForeground(Color.white);
				localNomeText.setBackgroundMode(Color.TRANSLUCENT);
				localNomeText.setFont(Font.decode("ARIAL-12"));
				localNomeText.setHorizontalAlignment(HVisible.HALIGN_LEFT);
				localNomeText.setVerticalAlignment(HVisible.VALIGN_TOP);

				HStaticText horarioText = new HStaticText();
				horarioText.setForeground(Color.white);
				horarioText.setBackgroundMode(Color.TRANSLUCENT);
				horarioText.setFont(Font.decode("ARIAL-12"));
				horarioText.setHorizontalAlignment(HVisible.HALIGN_LEFT);
				horarioText.setVerticalAlignment(HVisible.VALIGN_TOP);
				horarioText.setSize(100, 70);

				HStaticText golsAText = new HStaticText();
				golsAText.setForeground(Color.black);
				golsAText.setBackground(Color.red);
				golsAText.setBackgroundMode(Color.TRANSLUCENT);
				golsAText.setFont(Font.decode("ARIAL-20"));
				golsAText.setHorizontalAlignment(HVisible.HALIGN_LEFT);
				golsAText.setVerticalAlignment(HVisible.VALIGN_TOP);
				golsAText.setSize(50, 50);

				HStaticText golsBText = new HStaticText();
				golsBText.setForeground(Color.black);
				golsBText.setBackground(Color.red);
				golsBText.setBackgroundMode(Color.TRANSLUCENT);
				golsBText.setFont(Font.decode("ARIAL-20"));
				golsBText.setHorizontalAlignment(HVisible.HALIGN_LEFT);
				golsBText.setVerticalAlignment(HVisible.VALIGN_TOP);
				golsBText.setSize(50, 50);

				// setando conteudo
				timeANomeText.setTextContent(timeANome, HVisible.NORMAL_STATE);
				timeBNomeText.setTextContent(timeBNome, HVisible.NORMAL_STATE);
				localNomeText.setTextContent(localNome, HVisible.NORMAL_STATE);
				horarioText.setTextContent(horario, HVisible.NORMAL_STATE);
				golsAText.setTextContent(golsA, HVisible.NORMAL_STATE);
				golsBText.setTextContent(golsB, HVisible.NORMAL_STATE);

				// posicionando locais dos textos

				timeANomeText.setLocation(posXTime1Jogo, posYTime1Jogo
						+ (i * espacamentoYJogos));
				timeBNomeText.setLocation(posXTime2Jogo, posYTime2Jogo
						+ (i * espacamentoYJogos));

				localNomeText.setLocation(
						posXHoraJogo + horarioText.getWidth(), posYLocalJogo
								+ (i * espacamentoYLocal));
				horarioText.setLocation(posXHoraJogo, posYHoraJogo
						+ (i * espacamentoYHora));

				golsAText.setLocation(posXGolsA, posYGolsA
						+ (i * espacamentoYGols));
				golsBText.setLocation(posXGolsB, posYGolsB
						+ (i * espacamentoYGols));

				timeANomeText.setVisible(true);
				timeBNomeText.setVisible(true);
				localNomeText.setVisible(true);
				horarioText.setVisible(true);
				golsAText.setVisible(true);
				golsBText.setVisible(true);

				this.add(golsAText);
				this.add(golsBText);
				this.add(timeANomeText);
				this.add(timeBNomeText);
				this.add(localNomeText);
				this.add(horarioText);

			}

			this.repaint();

		}

		private String abreviaSelecao(String nomeSelecao) {

			String resp = null;

			if (nomeSelecao.toUpperCase().equals("AFRICA DO SUL")) {
				resp = "AFRICA S.";

			} else if (nomeSelecao.toUpperCase().equals("COREIA DO NORTE")) {
				resp = "COREIA N.";
			} else if (nomeSelecao.toUpperCase().equals("COREIA DO SUL")) {
				resp = "COREIA S.";
			} else if (nomeSelecao.toUpperCase().equals("COSTA DO MARFIM")) {
				resp = "COSTA M.";

			} else if (nomeSelecao.toUpperCase().equals("ESTADOS UNIDOS")) {
				resp = "ESTADOS U.";

			} else if (nomeSelecao.toUpperCase().equals("INGLATERRA")) {
				resp = "INGLATERRA";

			} else if (nomeSelecao.toUpperCase().equals("NOVA ZELANDIA")) {
				resp = "NOVA Z.";

			} else {
				resp = nomeSelecao;
			}

			return resp;

		}

	}
}
