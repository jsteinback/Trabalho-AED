package trabalho;

import filaLista.FilaLista;

public class Passo_B {

	private static FilaLista<String> fila = new FilaLista<String>();

	public static FilaLista<String> extrairTermos(String expressao) {
		expressao = expressao.replace(" ", "");
		expressao = expressao.replace("(", " ( ").replace(")", " ) ");
		expressao = expressao.replace("+", " + ").replace("-", " - ");
		expressao = expressao.replace("/", " / ").replace("*", " * ");
		expressao = expressao.replace(",", ".");

		String[] strSplit = expressao.split(" ");

		for (int i = 0; i < strSplit.length; i++) {
			if (strSplit[i].equals("-")) {
				if (isOperador(strSplit[i - 1]) || strSplit[i - 1].isEmpty() && isOperador(strSplit[i - 2])) {
					strSplit[i + 1] = "-" + strSplit[i + 1];
					strSplit[i] = "";
				}
			}
		}

		for (String string : strSplit) {
			if (string != null && !string.isEmpty()) {
				fila.inserir(string.trim());
			}
		}

		System.out.println(fila.toString());

		return fila;
	}

	private static boolean isOperador(String string) {
		if (string.equals("+") || string.equals("-") || string.equals("*") || string.equals("/")) {
			return true;
		}
		return false;
	}

}
