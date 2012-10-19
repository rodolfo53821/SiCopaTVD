package menuPartes;

import gerenciadores.Imagens;

import java.awt.Container;

import org.havi.ui.HIcon;

public class bandeiraEstilo extends Container{

	
	
	private HIcon bandeira;
	private int larguraBandeira = 500;
	private int alturaBandeira = 350;
	private Imagens imagens = Imagens.getInstance();
	
	public bandeiraEstilo(String nomeSelecao){
		
		this.setBounds(0,0,larguraBandeira,alturaBandeira);
		String urlSelecao = null;
		
		if(nomeSelecao.equals("AFRICA DO SUL")){
			urlSelecao = util.urls.africaDoSulEstilo;
		}else if(nomeSelecao.equals("ALEMANHA")){
			urlSelecao = util.urls.alemanhaEstilo;
		}else if(nomeSelecao.equals("ARGELIA")){
			urlSelecao = util.urls.argeliaEstilo;
		}else if(nomeSelecao.equals("ARGENTINA")){
			urlSelecao = util.urls.argentinaEstilo;
		}else if(nomeSelecao.equals("AUSTRALIA")){
			urlSelecao = util.urls.australiaEstilo;
		}else if(nomeSelecao.equals("BRASIL")){
			urlSelecao = util.urls.brasilEstilo;
		}else if(nomeSelecao.equals("CAMAROES")){
			urlSelecao = util.urls.camaroesEstilo;
		}else if(nomeSelecao.equals("CHILE")){
			urlSelecao = util.urls.chileEstilo;
		}else if(nomeSelecao.equals("COREIA DO NORTE")){
			urlSelecao = util.urls.coreiaDoNorteEstilo;
		}else if(nomeSelecao.equals("COREIA DO SUL")){
			urlSelecao = util.urls.coreiaDoSulEstilo;
		}else if(nomeSelecao.equals("COSTA DO MARFIM")){
			urlSelecao = util.urls.costaDoMarfimEstilo;
		}else if(nomeSelecao.equals("DINAMARCA")){
			urlSelecao = util.urls.dinamarcaEstilo;
		}else if(nomeSelecao.equals("ESLOVAQUIA")){
			urlSelecao = util.urls.eslovaquiaEstilo;
		}else if(nomeSelecao.equals("ESLOVENIA")){
			urlSelecao = util.urls.esloveniaEstilo;
		}else if(nomeSelecao.equals("ESPANHA")){
			urlSelecao = util.urls.espanhaEstilo;
		}else if(nomeSelecao.equals("ESTADOS UNIDOS")){
			urlSelecao = util.urls.estadosUnidosEstilo;
		}else if(nomeSelecao.equals("FRANCA")){
			urlSelecao = util.urls.francaEstilo;
		}else if(nomeSelecao.equals("GANA")){
			urlSelecao = util.urls.ganaEstilo;
		}else if(nomeSelecao.equals("GRECIA")){
			urlSelecao = util.urls.greciaEstilo;
		}else if(nomeSelecao.equals("HOLANDA")){
			urlSelecao = util.urls.holandaEstilo;
		}else if(nomeSelecao.equals("HONDURAS")){
			urlSelecao = util.urls.hondurasEstilo;
		}else if(nomeSelecao.equals("INGLATERRA")){
			urlSelecao = util.urls.inglaterraEstilo;
		}else if(nomeSelecao.equals("ITALIA")){
			urlSelecao = util.urls.italiaEstilo;
		}else if(nomeSelecao.equals("JAPAO")){
			urlSelecao = util.urls.japaoEstilo;
		}else if(nomeSelecao.equals("MEXICO")){
			urlSelecao = util.urls.mexicoEstilo;
		}else if(nomeSelecao.equals("NIGERIA")){
			urlSelecao = util.urls.nigeriaEstilo;
		}else if(nomeSelecao.equals("NOVA ZELANDIA")){
			urlSelecao = util.urls.novaZelandiaEstilo;
		}else if(nomeSelecao.equals("PARAGUAI")){
			urlSelecao = util.urls.paraguaiEstilo;
		}else if(nomeSelecao.equals("PORTUGAL")){
			urlSelecao = util.urls.portugalEstilo;
		}else if(nomeSelecao.equals("SERVIA")){
			urlSelecao = util.urls.serviaEstilo;
		}else if(nomeSelecao.equals("SUICA")){
			urlSelecao = util.urls.suicaEstilo;
		}else if(nomeSelecao.equals("URUGUAI")){
			urlSelecao = util.urls.uruguaiEstilo;
			
			
			}
		
		
		bandeira = new HIcon(imagens.carregarImagem(util.urls.bandeiraEstilo + urlSelecao),0,0,larguraBandeira,alturaBandeira);
		this.add(bandeira);
	}
	public void setVisible(boolean arg){
		
		bandeira.setVisible(arg);
	}
	
}
