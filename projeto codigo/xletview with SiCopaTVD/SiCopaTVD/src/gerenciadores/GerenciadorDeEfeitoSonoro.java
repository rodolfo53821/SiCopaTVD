package gerenciadores;

import java.io.File;
import java.io.IOException;

import javax.media.MediaLocator;
import javax.media.NoPlayerException;
import javax.media.Player;
import javax.media.Time;
import org.dvb.event.*;
import org.havi.ui.event.HRcEvent;

import com.sun.tv.media.GainControlAdapter;

public class GerenciadorDeEfeitoSonoro {

	private MediaLocator localizadorDeEfeito;
	private Player tocadorDeEfeito;
	File arquivoDeEfeito;

	public GerenciadorDeEfeitoSonoro(String urlEfeito) {

		arquivoDeEfeito = new File(urlEfeito);

		try {
			localizadorDeEfeito = new javax.media.MediaLocator(arquivoDeEfeito
					.toURL().toExternalForm());
			tocadorDeEfeito = javax.media.Manager
					.createPlayer(localizadorDeEfeito);

			tocadorDeEfeito.prefetch();
			tocadorDeEfeito.realize();

		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}

	public void iniciaEfeito() {
		// tocadorDeEfeito.syncStart(new Time(0));
		tocadorDeEfeito.start();

	}

	public void aumentaVolume(int opcao) {
		if (this.tocadorDeEfeito.getState() != javax.media.Controller.Unrealized) {
			int proporcao = 5;
			if (opcao == HRcEvent.VK_CHANNEL_DOWN)
				proporcao = proporcao * (-1);
			System.out.println(tocadorDeEfeito.getGainControl().getDB() + " "
					+ tocadorDeEfeito.getState() + " "
					+ javax.media.Controller.Unrealized + " "
					+ javax.media.Controller.Started + " "
					+ javax.media.Controller.Realizing);
			if ((tocadorDeEfeito.getGainControl().getDB() >= -75 && proporcao < 0)
					|| ((tocadorDeEfeito.getGainControl().getDB() <= 1 && proporcao > 0)))
				tocadorDeEfeito.getGainControl().setDB(
						tocadorDeEfeito.getGainControl().getDB() + proporcao);
			// tocadorDeEfeito.getGainControl().setLevel(tocadorDeEfeito.getGainControl().getLevel()
			// + proporcao);
		}

	}

	public void paraEfeito() {
		tocadorDeEfeito.stop();
	}

}
