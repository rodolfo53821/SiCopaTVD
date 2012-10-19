package menuPartes;

import gerenciadores.Imagens;

import java.awt.Container;

import org.havi.ui.HIcon;

public class logoPrograma extends Container {

	private Imagens imagens = Imagens.getInstance();
	private HIcon logo;
	private int larguraLogo = 110;
	private int alturaLogo = 40;

	public logoPrograma() {
		this.setBounds(0, 0, larguraLogo, alturaLogo);
		logo = new HIcon(imagens.carregarImagem(util.urls.logoPrograma), 0, 0,
				larguraLogo, alturaLogo);
		this.add(logo);

	}

	public void setVisible(boolean arg) {
		logo.setVisible(arg);

	}

}
