package util;

import java.net.URL;
import java.util.HashMap;

import sun.awt.EmbeddedFrame;

public class urls {

	private static String pathPrograma = "SiCopaTVD\\";

	// banco de dados local
	private static final String dbLocal = pathPrograma
			+ "banco de dados local\\";
	public static final String dbJogadores = dbLocal + "jogadores.sdb";
	public static final String dbSelecoes = dbLocal + "selecoes.sdb";
	public static final String dbEstadios = dbLocal + "estadios.sdb";
	public static final String dbTabela = dbLocal + "tabela.sdb";

	// efeitos sonoros

	public static final String efeitoSonoro = "musicaDance.mp2";

	// emblemas selecao
	private final static String emblema = pathPrograma + "imagens/emblemas/";

	public final static String africaDoSulEmblema = emblema
			+ "emblemaAfricaDoSul.png";
	public final static String alemanhaEmblema = emblema
			+ "emblemaAlemanha.png";
	public final static String argeliaEmblema = emblema + "emblemaArgelia.png";
	public final static String australiaEmblema = emblema
			+ "emblemaAustralia.png";
	public final static String argentinaEmblema = emblema
			+ "emblemaArgentina.png";
	public final static String brasilEmblema = emblema + "emblemaBrasil.png";
	public final static String camaroesEmblema = emblema
			+ "emblemaCamaroes.png";
	public final static String chileEmblema = emblema + "emblemaChile.png";
	public final static String coreiaDoNorteEmblema = emblema
			+ "emblemaCoreiaDoNorte.png";
	public final static String coreiaDoSulEmblema = emblema
			+ "emblemaCoreiaDoSul.png";
	public final static String costaDoMarfimEmblema = emblema
			+ "emblemaCostaDoMarfim.png";
	public final static String dinamarcaEmblema = emblema
			+ "emblemaDinamarca.png";
	public final static String eslovaquiaEmblema = emblema
			+ "emblemaEslovaquia.png";
	public final static String esloveniaEmblema = emblema
			+ "emblemaEslovenia.png";
	public final static String espanhaEmblema = emblema + "emblemaEspanha.png";
	public final static String estadosUnidosEmblema = emblema
			+ "emblemaEstadosUnidos.png";
	public final static String francaEmblema = emblema + "emblemaFranca.png";
	public final static String ganaEmblema = emblema + "emblemaGana.png";
	public final static String greciaEmblema = emblema + "emblemaGrecia.png";
	public final static String holandaEmblema = emblema + "emblemaHolanda.png";
	public final static String hondurasEmblema = emblema
			+ "emblemaHonduras.png";
	public final static String inglaterraEmblema = emblema
			+ "emblemaInglaterra.png";
	public final static String italiaEmblema = emblema + "emblemaItalia.png";
	public final static String japaoEmblema = emblema + "emblemaJapao.png";
	public final static String mexicoEmblema = emblema + "emblemaMexico.png";
	public final static String nigeriaEmblema = emblema + "emblemaNigeria.png";
	public final static String novaZelandiaEmblema = emblema
			+ "emblemaNovaZelandia.png";
	public final static String paraguaiEmblema = emblema
			+ "emblemaParaguai.png";
	public final static String portugalEmblema = emblema
			+ "emblemaPortugal.png";
	public final static String serviaEmblema = emblema + "emblemaServia.png";
	public final static String suicaEmblema = emblema + "emblemaSuica.png";
	public final static String uruguaiEmblema = emblema + "emblemaUruguai.png";

	// Ellis Park,Free State,Green Point,Loftus Versfeld,Mbombela, Moses
	// Mabhida,Nelson Mandela Bay,Peter Makoba,Royal Bafokeng,Soccer City
	// imagem estadio
	public final static String estadioImagem = pathPrograma
			+ "imagens/estadios/";
	public final static String ellisParkEstadio = estadioImagem
			+ "ellisPark.png";
	public final static String freeStateEstadio = estadioImagem
			+ "freeState.png";
	public final static String greenPointEstadio = estadioImagem
			+ "greenPoint.png";
	public final static String loftusVersfeldEstadio = estadioImagem
			+ "loftusVersfeld.png";
	public final static String mbombelaEstadio = estadioImagem + "mbombela.png";
	public final static String mosesMabhidaEstadio = estadioImagem
			+ "mosesMabhida.png";
	public final static String nelsonMandelaBayEstadio = estadioImagem
			+ "nelsonMandelaBay.png";
	public final static String peterMokabaEstadio = estadioImagem
			+ "peterMokaba.png";
	public final static String royalBafokengEstadio = estadioImagem
			+ "ellisPark.png";
	public final static String soccerCityEstadio = estadioImagem
			+ "soccerCity.png";

	// logo
	public final static String logoPrograma = pathPrograma
			+ "imagens/logos/sicopatvd.png";

	// bandeiras estilizadas

	public final static String bandeiraEstilo = pathPrograma
			+ "imagens/telas/fundo/bandeira";
	public final static String africaDoSulEstilo = "AfricaDoSulEstilo.png";
	public final static String alemanhaEstilo = "AlemanhaEstilo.png";
	public final static String argeliaEstilo = "ArgeliaEstilo.png";
	public final static String australiaEstilo = "AustraliaEstilo.png";
	public final static String argentinaEstilo = "ArgentinaEstilo.png";
	public final static String brasilEstilo = "BrasilEstilo.png";
	public final static String camaroesEstilo = "CamaroesEstilo.png";
	public final static String chileEstilo = "ChileEstilo.png";
	public final static String coreiaDoNorteEstilo = "CoreiaDoNorteEstilo.png";
	public final static String coreiaDoSulEstilo = "CoreiaDoSulEstilo.png";
	public final static String costaDoMarfimEstilo = "CostaDoMarfimEstilo.png";
	public final static String dinamarcaEstilo = "DinamarcaEstilo.png";
	public final static String eslovaquiaEstilo = "EslovaquiaEstilo.png";
	public final static String esloveniaEstilo = "EsloveniaEstilo.png";
	public final static String espanhaEstilo = "EspanhaEstilo.png";
	public final static String estadosUnidosEstilo = "EstadosUnidosEstilo.png";
	public final static String francaEstilo = "FrancaEstilo.png";
	public final static String ganaEstilo = "GanaEstilo.png";
	public final static String greciaEstilo = "GreciaEstilo.png";
	public final static String holandaEstilo = "HolandaEstilo.png";
	public final static String hondurasEstilo = "HondurasEstilo.png";
	public final static String inglaterraEstilo = "InglaterraEstilo.png";
	public final static String italiaEstilo = "ItaliaEstilo.png";
	public final static String japaoEstilo = "JapaoEstilo.png";
	public final static String mexicoEstilo = "MexicoEstilo.png";
	public final static String nigeriaEstilo = "NigeriaEstilo.png";
	public final static String novaZelandiaEstilo = "NovaZelandiaEstilo.png";
	public final static String paraguaiEstilo = "ParaguaiEstilo.png";
	public final static String portugalEstilo = "PortugalEstilo.png";
	public final static String serviaEstilo = "ServiaEstilo.png";
	public final static String suicaEstilo = "SuicaEstilo.png";
	public final static String uruguaiEstilo = "UruguaiEstilo.png";

	public final static String fundo = pathPrograma
			+ "imagens/telas/fundo/fundo.png";

	// nomes selecoes em forma de icones
	public final static String pathNome = pathPrograma
			+ "imagens/telas/menu selecoes/partes/nomes/";
	public final static String nomeBrasil = pathNome + "nomeBrasil.png";
	public final static String nomeAfricaDoSul = pathNome
			+ "nomeAfricaDoSul.png";
	public final static String nomeAlemanha = pathNome + "nomeAlemanha.png";
	public final static String nomeArgelia = pathNome + "nomeArgelia.png";
	public final static String nomeArgentina = pathNome + "nomeArgentina.png";
	public final static String nomeAustralia = pathNome + "nomeAustralia.png";
	public final static String nomeCamaroes = pathNome + "nomeCamaroes.png";
	public final static String nomeChile = pathNome + "nomeChile.png";
	public final static String nomeCoreiaDoNorte = pathNome
			+ "nomeCoreiaDoNorte.png";
	public final static String nomeCoreiaDoSul = pathNome
			+ "nomeCoreiaDoSul.png";
	public final static String nomeCostaDoMarfim = pathNome
			+ "nomeCostaDoMarfim.png";
	public final static String nomeDinamarca = pathNome + "nomeDinamarca.png";
	public final static String nomeEslovaquia = pathNome + "nomeEslovaquia.png";
	public final static String nomeEslovenia = pathNome + "nomeEslovenia.png";
	public final static String nomeEspanha = pathNome + "nomeEspanha.png";
	public final static String nomeEstadosUnidos = pathNome
			+ "nomeEstadosUnidos.png";
	public final static String nomeFranca = pathNome + "nomeFranca.png";
	public final static String nomeGana = pathNome + "nomeGana.png";
	public final static String nomeGrecia = pathNome + "nomeGrecia.png";
	public final static String nomeHolanda = pathNome + "nomeHolanda.png";
	public final static String nomeHonduras = pathNome + "nomeHonduras.png";
	public final static String nomeInglaterra = pathNome + "nomeInglaterra.png";
	public final static String nomeItalia = pathNome + "nomeItalia.png";
	public final static String nomeJapao = pathNome + "nomeJapao.png";
	public final static String nomeMexico = pathNome + "nomeMexico.png";
	public final static String nomeNigeria = pathNome + "nomeNigeria.png";
	public final static String nomeNovaZelandia = pathNome
			+ "nomeNovaZelandia.png";
	public final static String nomeParaguai = pathNome + "nomeParaguai.png";
	public final static String nomePortugal = pathNome + "nomePortugal.png";
	public final static String nomeServia = pathNome + "nomeServia.png";
	public final static String nomeSuica = pathNome + "nomeSuica.png";
	public final static String nomeUruguai = pathNome + "nomeUruguai.png";

	// ************************************************imagens de
	// tela******************************////////////////////////////////////

	// >>>>>>>>>>>>>>>>>>>>>>>>para menu principal
	public final static String pathMenuPrincipal = pathPrograma
			+ "imagens/telas/menu principal/";
	// estaticas
	public final static String menuPrincipalJogadores = pathMenuPrincipal
			+ "estatico/consulta/jogador.png";
	public final static String menuPrincipalEstadios = pathMenuPrincipal
			+ "estatico/consulta/estadio.png";
	public final static String menuPrincipalTimes = pathMenuPrincipal
			+ "estatico/consulta/times.png";
	public final static String menuPrincipalTabela = pathMenuPrincipal
			+ "estatico/campeonato/tabela.png";
	public final static String menuPrincipalClassificacao = pathMenuPrincipal
			+ "estatico/campeonato/classificacao.png";
	public final static String menuPrincipalSobre = pathMenuPrincipal
			+ "estatico/campeonato/sobre.png";
	public final static String menuPrincipalFigurinha = pathMenuPrincipal
			+ "estatico/extra/figurinha.png";
	public final static String menuPrincipalUsuario = pathMenuPrincipal
			+ "estatico/extra/usuario.png";
	public final static String menuPrincipalCompra = pathMenuPrincipal
			+ "estatico/extra/compra.png";

	// tentando mover, nome da posicao do meu mais o tipo de movimento v
	// vertical ou h horizontal
	public final static String menuPrincipalJogadoresV1 = pathMenuPrincipal
			+ "transicao/vertical/consultas/jogador1.1.png";
	public final static String menuPrincipalJogadoresV2 = pathMenuPrincipal
			+ "transicao/vertical/consultas/jogador1.2.png";
	public final static String menuPrincipalJogadoresV3 = pathMenuPrincipal
			+ "transicao/vertical/consultas/jogador1.3.png";
	public final static String menuPrincipalJogadoresV4 = pathMenuPrincipal
			+ "transicao/vertical/consultas/jogador1.4.png";
	public final static String menuPrincipalJogadoresV5 = pathMenuPrincipal
			+ "transicao/vertical/consultas/jogador1.5.png";

	public final static String menuPrincipalEstadiosV1 = pathMenuPrincipal
			+ "transicao/vertical/consultas/estadio1.1.png";
	public final static String menuPrincipalEstadiosV2 = pathMenuPrincipal
			+ "transicao/vertical/consultas/estadio1.2.png";
	public final static String menuPrincipalEstadiosV3 = pathMenuPrincipal
			+ "transicao/vertical/consultas/estadio1.3.png";
	public final static String menuPrincipalEstadiosV4 = pathMenuPrincipal
			+ "transicao/vertical/consultas/estadio1.4.png";
	public final static String menuPrincipalEstadiosV5 = pathMenuPrincipal
			+ "transicao/vertical/consultas/estadio1.5.png";

	public final static String menuPrincipalTimesV1 = pathMenuPrincipal
			+ "transicao/vertical/consultas/times1.1.png";
	public final static String menuPrincipalTimesV2 = pathMenuPrincipal
			+ "transicao/vertical/consultas/times1.2.png";
	public final static String menuPrincipalTimesV3 = pathMenuPrincipal
			+ "transicao/vertical/consultas/times1.3.png";
	public final static String menuPrincipalTimesV4 = pathMenuPrincipal
			+ "transicao/vertical/consultas/times1.4.png";
	public final static String menuPrincipalTimesV5 = pathMenuPrincipal
			+ "transicao/vertical/consultas/times1.5.png";

	public final static String menuPrincipalTabelaV1 = pathMenuPrincipal
			+ "transicao/vertical/campeonato/tabela1.1.png";
	public final static String menuPrincipalTabelaV2 = pathMenuPrincipal
			+ "transicao/vertical/campeonato/tabela1.2.png";
	public final static String menuPrincipalTabelaV3 = pathMenuPrincipal
			+ "transicao/vertical/campeonato/tabela1.3.png";
	public final static String menuPrincipalTabelaV4 = pathMenuPrincipal
			+ "transicao/vertical/campeonato/tabela1.4.png";
	public final static String menuPrincipalTabelaV5 = pathMenuPrincipal
			+ "transicao/vertical/campeonato/tabela1.5.png";

	public final static String menuPrincipalClassificacaoV1 = pathMenuPrincipal
			+ "transicao/vertical/campeonato/classificacao1.1.png";
	public final static String menuPrincipalClassificacaoV2 = pathMenuPrincipal
			+ "transicao/vertical/campeonato/classificacao1.2.png";
	public final static String menuPrincipalClassificacaoV3 = pathMenuPrincipal
			+ "transicao/vertical/campeonato/classificacao1.3.png";
	public final static String menuPrincipalClassificacaoV4 = pathMenuPrincipal
			+ "transicao/vertical/campeonato/classificacao1.4.png";
	public final static String menuPrincipalClassificacaoV5 = pathMenuPrincipal
			+ "transicao/vertical/campeonato/classificacao1.5.png";

	public final static String menuPrincipalSobreV1 = pathMenuPrincipal
			+ "transicao/vertical/campeonato/sobre1.1.png";
	public final static String menuPrincipalSobreV2 = pathMenuPrincipal
			+ "transicao/vertical/campeonato/sobre1.2.png";
	public final static String menuPrincipalSobreV3 = pathMenuPrincipal
			+ "transicao/vertical/campeonato/sobre1.3.png";
	public final static String menuPrincipalSobreV4 = pathMenuPrincipal
			+ "transicao/vertical/campeonato/sobre1.4.png";
	public final static String menuPrincipalSobreV5 = pathMenuPrincipal
			+ "transicao/vertical/campeonato/sobre1.5.png";

	public final static String menuPrincipalFigurinhaV1 = pathMenuPrincipal
			+ "transicao/vertical/extra/figurinha1.1.png";
	public final static String menuPrincipalFigurinhaV2 = pathMenuPrincipal
			+ "transicao/vertical/extra/figurinha1.2.png";
	public final static String menuPrincipalFigurinhaV3 = pathMenuPrincipal
			+ "transicao/vertical/extra/figurinha1.3.png";
	public final static String menuPrincipalFigurinhaV4 = pathMenuPrincipal
			+ "transicao/vertical/extra/figurinha1.4.png";
	public final static String menuPrincipalFigurinhaV5 = pathMenuPrincipal
			+ "transicao/vertical/extra/figurinha1.5.png";

	public final static String menuPrincipalUsuarioV1 = pathMenuPrincipal
			+ "transicao/vertical/extra/usuario1.1.png";
	public final static String menuPrincipalUsuarioV2 = pathMenuPrincipal
			+ "transicao/vertical/extra/usuario1.2.png";
	public final static String menuPrincipalUsuarioV3 = pathMenuPrincipal
			+ "transicao/vertical/extra/usuario1.3.png";
	public final static String menuPrincipalUsuarioV4 = pathMenuPrincipal
			+ "transicao/vertical/extra/usuario1.4.png";
	public final static String menuPrincipalUsuarioV5 = pathMenuPrincipal
			+ "transicao/vertical/extra/usuario1.5.png";

	public final static String menuPrincipalCompraV1 = pathMenuPrincipal
			+ "transicao/vertical/extra/compra1.1.png";
	public final static String menuPrincipalCompraV2 = pathMenuPrincipal
			+ "transicao/vertical/extra/compra1.2.png";
	public final static String menuPrincipalCompraV3 = pathMenuPrincipal
			+ "transicao/vertical/extra/compra1.3.png";
	public final static String menuPrincipalCompraV4 = pathMenuPrincipal
			+ "transicao/vertical/extra/compra1.4.png";
	public final static String menuPrincipalCompraV5 = pathMenuPrincipal
			+ "transicao/vertical/extra/compra1.5.png";

	public final static String menuPrincipalConsultaH1 = pathMenuPrincipal
			+ "transicao/horizontal/amarelo1.1.png";
	public final static String menuPrincipalConsultaH2 = pathMenuPrincipal
			+ "transicao/horizontal/amarelo1.2.png";
	public final static String menuPrincipalConsultaH3 = pathMenuPrincipal
			+ "transicao/horizontal/amarelo1.3.png";

	public final static String menuPrincipalCampeonatoH1 = pathMenuPrincipal
			+ "transicao/horizontal/verde1.1.png";
	public final static String menuPrincipalCampeonatoH2 = pathMenuPrincipal
			+ "transicao/horizontal/verde1.2.png";
	public final static String menuPrincipalCampeonatoH3 = pathMenuPrincipal
			+ "transicao/horizontal/verde1.3.png";

	public final static String menuPrincipalExtraH1 = pathMenuPrincipal
			+ "transicao/horizontal/azul1.1.png";
	public final static String menuPrincipalExtraH2 = pathMenuPrincipal
			+ "transicao/horizontal/azul1.2.png";
	public final static String menuPrincipalExtraH3 = pathMenuPrincipal
			+ "transicao/horizontal/azul1.3.png";

	// >>>>>>>>>>>>>>>>>>>>>>>>para menu jogadores
	// estatica

	public final static String pathMenuJogador = pathPrograma
			+ "imagens/telas/menu jogador/";
	public final static String menuJogador = pathMenuJogador
			+ "estatico/jogadoresMenu.png";

	// partes
	public final static String escolhaOp = pathMenuJogador
			+ "partes/escolhaOp.png";
	public final static String escolhidoOp = pathMenuJogador
			+ "partes/escolhidoOp.png";
	public final static String fotoQuadro = pathMenuJogador
			+ "partes/fotoQuadro.png";
	public final static String infoQuadro = pathMenuJogador
			+ "partes/infoQuadro.png";
	public final static String infoRapido = pathMenuJogador
			+ "partes/infoRapido.png";
	public final static String rostoDefault = pathMenuJogador
			+ "partes/rostoDefault.png";

	// >>>>>>>>>>>>>>>>>>>>>>>>para menu selecoes
	public final static String pathMenuSelecao = pathPrograma
			+ "imagens/telas/menu selecoes/";
	// partes
	public final static String mapa = pathMenuSelecao + "partes/mapa.png";
	public final static String marcador1 = pathMenuSelecao
			+ "partes/marcador1.1.png";
	public final static String marcador2 = pathMenuSelecao
			+ "partes/marcador1.2.png";
	public final static String marcador3 = pathMenuSelecao
			+ "partes/marcador1.3.png";
	public final static String mapaDeTimes = pathMenuSelecao
			+ "partes/times.png";
	public final static String quadroSelecao = pathMenuSelecao
			+ "partes/timeEscolhido.png";

	public static final String telaAtalhos = pathPrograma
			+ "imagens/telas/ajuda/telaAtalhos.png";

	// >>>>>>>>>>>>>>>>>>para menu estadio
	public static final String menuEstadioPath = pathPrograma
			+ "imagens/telas/menu estadios";
	public static final String menuEstadio = menuEstadioPath
			+ "/estatica/menuEstadios.png";

	// partes
	public static final String mapaDeSedes = menuEstadioPath
			+ "/partes/mapaSedes.png";
	public static final String quadroSedes = menuEstadioPath
			+ "/partes/quadroSedes.png";

	public static final String infoEstadio = menuEstadioPath
			+ "/partes/infoSedes.png";
	public static final String mapaAfricaDoSul = menuEstadioPath
			+ "/partes/mapaAfricaDoSul.png";;

	// para menu tabela
	// partes
	public static final String menuTabelaPath = pathPrograma
			+ "imagens/telas/menu tabela";

	public static final String tabelaGrupo = menuTabelaPath
			+ "/partes/tabelaFase1.png";
	public static final String letraA = menuTabelaPath + "/partes/letraA.png";
	public static final String letraB = menuTabelaPath + "/partes/letraB.png";
	public static final String letraC = menuTabelaPath + "/partes/letraC.png";
	public static final String letraD = menuTabelaPath + "/partes/letraD.png";
	public static final String letraE = menuTabelaPath + "/partes/letraE.png";
	public static final String letraF = menuTabelaPath + "/partes/letraF.png";
	public static final String letraG = menuTabelaPath + "/partes/letraG.png";
	public static final String letraH = menuTabelaPath + "/partes/letraH.png";
	public static final String oitavasIcone = menuTabelaPath
			+ "/partes/oitavasIcone.png";
	public static final String quartasIcone = menuTabelaPath
			+ "/partes/quartasIcone.png";
	public static final String semiIcone = menuTabelaPath
			+ "/partes/semiIcone.png";
	public static final String finalIcone = menuTabelaPath
			+ "/partes/finalIcone.png";
	public static final String terceiroIcone = menuTabelaPath
			+ "/partes/finalIcone.png";
	public static final String trofeuIcone = menuTabelaPath
			+ "/partes/trofeuIcone.png";
	public static final String grupos = menuTabelaPath + "/partes/grupos.png";
	public static final String oitavas = menuTabelaPath + "/partes/oitavas.png";
	public static final String quartas = menuTabelaPath + "/partes/quartas.png";
	public static final String semi = menuTabelaPath + "/partes/semi.png";
	public static final String finalNome = menuTabelaPath + "/partes/final.png";

	public static final String oitavasGrade = menuTabelaPath
			+ "/partes/oitavasGrade.png";
	public static final String quartasGrade = menuTabelaPath
			+ "/partes/quartasGrade.png";
	public static final String semiGrade = menuTabelaPath
			+ "/partes/semiGrade.png";
	public static final String menuTabela = menuTabelaPath
			+ "/estatica/menuTabela.png";

	// >>>>>>>>>>>>>>>>>>>>>>.para menu times
	public static final String menuTimePath = pathPrograma
			+ "imagens/telas/menu times";
	public static final String menuTime = menuTimePath
			+ "/estatica/menuTimes.png";

	// //>>>>>>>>>>>>>>>>>>..para menu sobre
	public static final String menuSobrePath = pathPrograma
			+ "imagens/telas/menu sobre";
	public static final String menuSobre = menuSobrePath
			+ "/estatica/menuSobre.png";

	// >>>>>>>>>>>>>>>>.para menu figurinha
	public static final String menuFigurinhaPath = pathPrograma
			+ "imagens/telas/menu figurinha";
	public static final String menuFigurinha = menuFigurinhaPath
			+ "/estatica/menuFigurinha.png";
	public static final String moldura = menuFigurinhaPath
			+ "/partes/moldura.png";

	public static HashMap<String, String> emblemas;
	public static HashMap<String, String> estadioImagens;

	public static urls instanceUrls = null;

	public static urls getInstance() {

		if (instanceUrls == null)
			instanceUrls = new urls();
		return instanceUrls;
	}

	private urls() {
		emblemas = new HashMap<String, String>();
		estadioImagens = new HashMap<String, String>();

		// povoando as tabelas hash
		emblemas.put("AFRICA DO SUL", africaDoSulEmblema);
		emblemas.put("ALEMANHA", alemanhaEmblema);
		emblemas.put("ARGENTINA", argentinaEmblema);
		emblemas.put("ARGELIA", argeliaEmblema);
		emblemas.put("AUSTRALIA", australiaEmblema);
		emblemas.put("BRASIL", brasilEmblema);
		emblemas.put("CAMAROES", camaroesEmblema);
		emblemas.put("COSTA DO MARFIM", costaDoMarfimEmblema);
		emblemas.put("COREIA DO NORTE", coreiaDoNorteEmblema);
		emblemas.put("COREIA DO SUL", coreiaDoSulEmblema);
		emblemas.put("DINAMARCA", dinamarcaEmblema);
		emblemas.put("ESLOVENIA", esloveniaEmblema);
		emblemas.put("ESLOVAQUIA", eslovaquiaEmblema);
		emblemas.put("ESPANHA", espanhaEmblema);
		emblemas.put("FRANCA", francaEmblema);
		emblemas.put("GANA", ganaEmblema);
		emblemas.put("GRECIA", greciaEmblema);
		emblemas.put("HOLANDA", holandaEmblema);
		emblemas.put("HONDURAS", hondurasEmblema);
		emblemas.put("ITALIA", italiaEmblema);
		emblemas.put("INGLATERRA", inglaterraEmblema);
		emblemas.put("JAPAO", japaoEmblema);
		emblemas.put("MEXICO", mexicoEmblema);
		emblemas.put("NIGERIA", nigeriaEmblema);
		emblemas.put("ESTADOS UNIDOS", estadosUnidosEmblema);
		emblemas.put("CHILE", chileEmblema);
		emblemas.put("NOVA ZELANDIA", novaZelandiaEmblema);
		emblemas.put("PARAGUAI", paraguaiEmblema);
		emblemas.put("PORTUGAL", portugalEmblema);
		emblemas.put("SUICA", suicaEmblema);
		emblemas.put("SERVIA", serviaEmblema);
		emblemas.put("URUGUAI", uruguaiEmblema);

		estadioImagens.put("ELLIS PARK", ellisParkEstadio);
		estadioImagens.put("FREE STATE", freeStateEstadio);
		estadioImagens.put("GREEN POINT", greenPointEstadio);
		estadioImagens.put("LOFTUS VERSFELD", loftusVersfeldEstadio);
		estadioImagens.put("MBOMBELA", mbombelaEstadio);
		estadioImagens.put("MOSES MABHIDA", mosesMabhidaEstadio);
		estadioImagens.put("NELSON MANDELA BAY", nelsonMandelaBayEstadio);
		estadioImagens.put("PETER MOKABA", peterMokabaEstadio);
		estadioImagens.put("ROYAL BAFOKENG", royalBafokengEstadio);
		estadioImagens.put("SOCCER CITY", soccerCityEstadio);

	}

	public static String getUrlEmblema(String nomePais) {
		if (emblemas.get(nomePais) == null)
			System.out.println("Esta null em emblema" + nomePais);
		return emblemas.get(nomePais);

	}

	public static String getUrlEstadioImagem(String nomeEstadio) {

		return estadioImagens.get(nomeEstadio);

	}
}
