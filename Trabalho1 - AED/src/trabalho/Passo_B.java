package trabalho;

import fila.FilaVetor;

public class Passo_B {

	private static FilaVetor<String> fila;

	public static FilaVetor<String> extrairTermos(String expressao) {
		expressao = expressao.trim();
		expressao = expressao.replace("(", "( ").replace(")", " )"); //
		String[] strSplit = expressao.split(" ");

		fila = new FilaVetor<String>(strSplit.length);

		for (String string : strSplit) {
			if (string != null) {
				fila.inserir(string.trim());
			}
		}

		return fila;
	}

}

// teste: (25 + 10) / 3,5