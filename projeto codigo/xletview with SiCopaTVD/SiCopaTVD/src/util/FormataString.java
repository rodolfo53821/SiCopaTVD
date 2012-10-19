package util;

public class FormataString {

	private static double dpi = 96;
	private static double proporcaoInchToPoint = 72; // 1 inch = 72 pt
	private static double proporcaoPointToPixel = dpi / proporcaoInchToPoint;
	public static String fonteString = "Arial-PLAIN-20";
	public static double fonteTamanhoReal = 9.5;

	public static String formatandoString(String paraFormatar, int larguraCaixa) {
		String formatada;
		double tamanhoLetraPixel = fonteTamanhoReal * proporcaoPointToPixel;

		formatada = " ";

		String palavras[] = paraFormatar.split(" ");
		for (int i = 0; i < palavras.length; i++) {
			System.out.println("Palavra " + i + " -- " + palavras[i]);
		}
		int quantidadeDeLetrasNaLinha = 0;
		for (int i = 0; i < palavras.length; i++) {

			quantidadeDeLetrasNaLinha += palavras[i].length()
					* tamanhoLetraPixel;

			if (quantidadeDeLetrasNaLinha >= larguraCaixa) {
				quantidadeDeLetrasNaLinha = 0;
				if (palavras[i].length() * tamanhoLetraPixel < larguraCaixa) {

					quantidadeDeLetrasNaLinha += palavras[i].length()
							* tamanhoLetraPixel;
					formatada += "\n" + palavras[i];
					formatada += " ";
					quantidadeDeLetrasNaLinha += tamanhoLetraPixel;

				} else {// em caso que uma unica palavra ja seja maior que a
						// propria largura da caixa
					int numeroDelinhaParaAPAlavra = (int) (palavras[i].length()
							* tamanhoLetraPixel / larguraCaixa);

					int ind = 0;
					while (numeroDelinhaParaAPAlavra > 0) {
						int prox = (ind + 1) * larguraCaixa;
						if (prox > palavras.length) {
							prox = palavras[i].length();
							quantidadeDeLetrasNaLinha += (palavras[i].length() - ind
									* larguraCaixa)
									* tamanhoLetraPixel;
						}
						formatada += "\n"
								+ palavras[i].substring(ind * larguraCaixa,
										prox) + "-";
						quantidadeDeLetrasNaLinha += tamanhoLetraPixel;
						numeroDelinhaParaAPAlavra--;
						ind++;
					}
				}

			} else {

				formatada += palavras[i];
				formatada += " ";
				quantidadeDeLetrasNaLinha += tamanhoLetraPixel;
			}

		}
		formatada = formatada.substring(1, formatada.length());

		return formatada;

	}

}
