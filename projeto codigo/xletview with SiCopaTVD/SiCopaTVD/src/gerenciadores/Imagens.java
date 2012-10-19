package gerenciadores;

import java.awt.Image;
import java.awt.MediaTracker;

import java.awt.image.ImageObserver;

import javax.imageio.ImageReader;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import org.havi.ui.HComponent;
import org.havi.ui.HScreen;

import java.awt.Toolkit;
import java.util.HashMap;

public class Imagens extends HComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private HashMap<String, Image> imagensMapeadas;
	public static Imagens Instance = null;

	public static synchronized Imagens getInstance() {
		if (Instance == null)
			Instance = new Imagens();
		return Instance;
	}

	private Imagens() {
		imagensMapeadas = new HashMap<String, Image>();

	}

	public Image carregarImagem(String caminho) {

		if (imagensMapeadas.get(caminho) != null) {
			return imagensMapeadas.get(caminho);
		} else {

			Image img = Toolkit.getDefaultToolkit().createImage(caminho);

			MediaTracker tracker = new MediaTracker(this);

			
			tracker.addImage(img, 0);

			try {
				// System.out.println("Esperando imagem");

				tracker.waitForID(0);
				// tracker.waitForAll();

				//System.out.println("Extra...." + tracker.isErrorAny());
				imagensMapeadas.put(caminho, img);
				return img;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			return null;
		}
	}

}