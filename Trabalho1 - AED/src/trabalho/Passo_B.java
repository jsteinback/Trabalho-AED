package trabalho;

import filaLista.FilaLista;

public class Passo_B {

	private static FilaLista<String> fila;

	public static FilaLista<String> extrairTermos(String expressao) {
		expressao = expressao.trim();
		expressao = expressao.replace("(", "( ").replace(")", " )"); //
		String[] strSplit = expressao.split(" ");

		fila = new FilaLista<String>();

		for (String string : strSplit) {
			if (string != null) {
				fila.inserir(string.trim());
			}
		}

		return fila;
	}

}
