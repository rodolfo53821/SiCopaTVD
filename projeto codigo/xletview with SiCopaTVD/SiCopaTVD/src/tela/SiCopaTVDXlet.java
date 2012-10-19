package tela;

import java.io.File;

import javax.media.MediaLocator;
import javax.media.Player;
import javax.tv.xlet.Xlet;
import javax.tv.xlet.XletContext;
import javax.tv.xlet.XletStateChangeException;

import org.havi.ui.HScene;
import org.havi.ui.HSceneFactory;
import org.havi.ui.HScreen;

import persistencia.Copa;

import scanner.ScannerDb;

public class SiCopaTVDXlet implements Xlet {

	private HScene cena;
	private XletContext contexto;
	public Copa copa;
	public static ScannerDb bancoLocal;

	public SiCopaTVDXlet() {

	}

	public void destroyXlet(boolean arg0) throws XletStateChangeException {
		contexto.notifyDestroyed();
		this.cena.removeAll();
		cena.dispose();

	}

	public void initXlet(XletContext contexto) throws XletStateChangeException {

		this.contexto = contexto;
		

	}

	public void pauseXlet() {
		// TODO Auto-generated method stub

	}

	public void startXlet() throws XletStateChangeException {

		
		// construindo cena
		HSceneFactory hsceneFactory = HSceneFactory.getInstance();
		cena = HSceneFactory.getInstance().getFullScreenScene(
				HScreen.getDefaultHScreen().getDefaultHGraphicsDevice());
		cena.setLayout(null);
		cena.setVisible(true);

		// escaneando o banco de dados local
		
		ScannerDb sc = new ScannerDb();
		

		// abrindo a tela de login

		// TODO vamos saltar diretamente pra tela de menu principal
		TelaMenuPrincipal menuPrincipal = TelaMenuPrincipal.getInstance(cena);
		menuPrincipal.inicia(TelaMenuPrincipal.subMenuJogadores);

	}

}
