package menuPartes;

import gerenciadores.Imagens;

import java.awt.Container;

import org.havi.ui.HIcon;

public class emblemaENome extends Container {

	Imagens imagens = Imagens.getInstance();
	private HIcon emblemaIcone, nomeTimeIcone;

	private final int larguraEmblemaIcone = 60;
	private final int alturaEmblemaIcone = 60;
	private final int larguraNomeTimeIcone = 195;
	private final int alturaNomeTimeIcone = 50;
	private final int posXNomeTimeIcone = 0;
	private final int posYNomeTimeIcone = alturaEmblemaIcone - 30;

	public emblemaENome(String nomeSelecao) {
		this.setBounds(0, 0, larguraNomeTimeIcone, alturaEmblemaIcone
				+ alturaNomeTimeIcone);
		System.out.println(nomeSelecao + " <<<<<<<<<<<<<<<<<");

		String urlEmblema = util.urls.getInstance().emblemas.get(nomeSelecao);
		emblemaIcone = new HIcon(imagens.carregarImagem(urlEmblema),
				(larguraNomeTimeIcone - larguraEmblemaIcone) / 2, 0,
				larguraEmblemaIcone, alturaEmblemaIcone);

		nomeTimeIcone = new HIcon();
		nomeTimeIcone.setBounds(posXNomeTimeIcone, posYNomeTimeIcone,
				larguraNomeTimeIcone, alturaNomeTimeIcone);

		if (nomeSelecao.equals("AFRICA DO SUL")) {
			nomeTimeIcone.setGraphicContent(imagens
					.carregarImagem(util.urls.nomeAfricaDoSul),
					org.havi.ui.HVisible.NORMAL_STATE);
		} else if (nomeSelecao.equals("ALEMANHA")) {
			nomeTimeIcone.setGraphicContent(imagens
					.carregarImagem(util.urls.nomeAlemanha),
					org.havi.ui.HVisible.NORMAL_STATE);
		} else if (nomeSelecao.equals("ARGELIA")) {
			nomeTimeIcone.setGraphicContent(imagens
					.carregarImagem(util.urls.nomeArgelia),
					org.havi.ui.HVisible.NORMAL_STATE);
		} else if (nomeSelecao.equals("ARGENTINA")) {
			nomeTimeIcone.setGraphicContent(imagens
					.carregarImagem(util.urls.nomeArgentina),
					org.havi.ui.HVisible.NORMAL_STATE);
		} else if (nomeSelecao.equals("AUSTRALIA")) {
			nomeTimeIcone.setGraphicContent(imagens
					.carregarImagem(util.urls.nomeAustralia),
					org.havi.ui.HVisible.NORMAL_STATE);
		} else if (nomeSelecao.equals("BRASIL")) {
			nomeTimeIcone.setGraphicContent(imagens
					.carregarImagem(util.urls.nomeBrasil),
					org.havi.ui.HVisible.NORMAL_STATE);
		} else if (nomeSelecao.equals("CAMAROES")) {
			nomeTimeIcone.setGraphicContent(imagens
					.carregarImagem(util.urls.nomeCamaroes),
					org.havi.ui.HVisible.NORMAL_STATE);
		} else if (nomeSelecao.equals("CHILE")) {
			nomeTimeIcone.setGraphicContent(imagens
					.carregarImagem(util.urls.nomeChile),
					org.havi.ui.HVisible.NORMAL_STATE);
		} else if (nomeSelecao.equals("COREIA DO NORTE")) {
			nomeTimeIcone.setGraphicContent(imagens
					.carregarImagem(util.urls.nomeCoreiaDoNorte),
					org.havi.ui.HVisible.NORMAL_STATE);
		} else if (nomeSelecao.equals("COREIA DO SUL")) {
			nomeTimeIcone.setGraphicContent(imagens
					.carregarImagem(util.urls.nomeCoreiaDoSul),
					org.havi.ui.HVisible.NORMAL_STATE);
		} else if (nomeSelecao.equals("COSTA DO MARFIM")) {
			nomeTimeIcone.setGraphicContent(imagens
					.carregarImagem(util.urls.nomeCostaDoMarfim),
					org.havi.ui.HVisible.NORMAL_STATE);
		} else if (nomeSelecao.equals("DINAMARCA")) {
			nomeTimeIcone.setGraphicContent(imagens
					.carregarImagem(util.urls.nomeDinamarca),
					org.havi.ui.HVisible.NORMAL_STATE);
		} else if (nomeSelecao.equals("ESLOVAQUIA")) {
			nomeTimeIcone.setGraphicContent(imagens
					.carregarImagem(util.urls.nomeEslovaquia),
					org.havi.ui.HVisible.NORMAL_STATE);
		} else if (nomeSelecao.equals("ESLOVENIA")) {
			nomeTimeIcone.setGraphicContent(imagens
					.carregarImagem(util.urls.nomeEslovenia),
					org.havi.ui.HVisible.NORMAL_STATE);
		} else if (nomeSelecao.equals("ESPANHA")) {
			nomeTimeIcone.setGraphicContent(imagens
					.carregarImagem(util.urls.nomeEspanha),
					org.havi.ui.HVisible.NORMAL_STATE);
		} else if (nomeSelecao.equals("ESTADOS UNIDOS")) {
			nomeTimeIcone.setGraphicContent(imagens
					.carregarImagem(util.urls.nomeEstadosUnidos),
					org.havi.ui.HVisible.NORMAL_STATE);
		} else if (nomeSelecao.equals("FRANCA")) {
			nomeTimeIcone.setGraphicContent(imagens
					.carregarImagem(util.urls.nomeFranca),
					org.havi.ui.HVisible.NORMAL_STATE);
		} else if (nomeSelecao.equals("GANA")) {
			nomeTimeIcone.setGraphicContent(imagens
					.carregarImagem(util.urls.nomeGana),
					org.havi.ui.HVisible.NORMAL_STATE);
		} else if (nomeSelecao.equals("GRECIA")) {
			nomeTimeIcone.setGraphicContent(imagens
					.carregarImagem(util.urls.nomeGrecia),
					org.havi.ui.HVisible.NORMAL_STATE);
		} else if (nomeSelecao.equals("HOLANDA")) {
			nomeTimeIcone.setGraphicContent(imagens
					.carregarImagem(util.urls.nomeHolanda),
					org.havi.ui.HVisible.NORMAL_STATE);
		} else if (nomeSelecao.equals("HONDURAS")) {
			nomeTimeIcone.setGraphicContent(imagens
					.carregarImagem(util.urls.nomeHonduras),
					org.havi.ui.HVisible.NORMAL_STATE);
		} else if (nomeSelecao.equals("INGLATERRA")) {
			nomeTimeIcone.setGraphicContent(imagens
					.carregarImagem(util.urls.nomeInglaterra),
					org.havi.ui.HVisible.NORMAL_STATE);
		} else if (nomeSelecao.equals("ITALIA")) {
			nomeTimeIcone.setGraphicContent(imagens
					.carregarImagem(util.urls.nomeItalia),
					org.havi.ui.HVisible.NORMAL_STATE);
		} else if (nomeSelecao.equals("JAPAO")) {
			nomeTimeIcone.setGraphicContent(imagens
					.carregarImagem(util.urls.nomeJapao),
					org.havi.ui.HVisible.NORMAL_STATE);
		} else if (nomeSelecao.equals("MEXICO")) {
			nomeTimeIcone.setGraphicContent(imagens
					.carregarImagem(util.urls.nomeMexico),
					org.havi.ui.HVisible.NORMAL_STATE);
		} else if (nomeSelecao.equals("NIGERIA")) {
			nomeTimeIcone.setGraphicContent(imagens
					.carregarImagem(util.urls.nomeNigeria),
					org.havi.ui.HVisible.NORMAL_STATE);
		} else if (nomeSelecao.equals("NOVA ZELANDIA")) {
			nomeTimeIcone.setGraphicContent(imagens
					.carregarImagem(util.urls.nomeNovaZelandia),
					org.havi.ui.HVisible.NORMAL_STATE);
		} else if (nomeSelecao.equals("PARAGUAI")) {
			nomeTimeIcone.setGraphicContent(imagens
					.carregarImagem(util.urls.nomeParaguai),
					org.havi.ui.HVisible.NORMAL_STATE);
		} else if (nomeSelecao.equals("PORTUGAL")) {
			nomeTimeIcone.setGraphicContent(imagens
					.carregarImagem(util.urls.nomePortugal),
					org.havi.ui.HVisible.NORMAL_STATE);
		} else if (nomeSelecao.equals("SERVIA")) {
			nomeTimeIcone.setGraphicContent(imagens
					.carregarImagem(util.urls.nomeServia),
					org.havi.ui.HVisible.NORMAL_STATE);
		} else if (nomeSelecao.equals("SUICA")) {
			nomeTimeIcone.setGraphicContent(imagens
					.carregarImagem(util.urls.nomeSuica),
					org.havi.ui.HVisible.NORMAL_STATE);
		} else if (nomeSelecao.equals("URUGUAI")) {
			nomeTimeIcone.setGraphicContent(imagens
					.carregarImagem(util.urls.nomeUruguai),
					org.havi.ui.HVisible.NORMAL_STATE);
		}

		this.add(emblemaIcone);
		this.add(nomeTimeIcone);

	}

}
