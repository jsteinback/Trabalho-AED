package trabalho;

import filaLista.FilaLista;
import pilhaLista.PilhaLista;

public class Passo_D {

	private static PilhaLista<String> pilhaAuxiliar = new PilhaLista<>();

	public static double calcularExprPosfixada(FilaLista<String> exprPosfixada) {

		while (!exprPosfixada.estaVazio()) {
			String termo = exprPosfixada.retirar();

			if (isNumero(termo)) {
				pilhaAuxiliar.push(termo);
			} else {
				pilhaAuxiliar.push(valorCalculado(termo));
			}
		}

		String resultado = pilhaAuxiliar.pop();
		return Double.parseDouble(resultado);
	}

	private static String valorCalculado(String termo) {
		Double resultado = Double.parseDouble(pilhaAuxiliar.pop().replaceAll(",", "."));

		while (!pilhaAuxiliar.estaVazia()) {
			if (termo.equals("+")) {
				resultado += Double.parseDouble(pilhaAuxiliar.pop());
			} else if (termo.equals("-")) {
				resultado -= Double.parseDouble(pilhaAuxiliar.pop());
			} else if (termo.equals("*")) {
				resultado = Double.parseDouble(pilhaAuxiliar.pop()) * resultado;
			} else {
				resultado = Double.parseDouble(pilhaAuxiliar.pop()) / resultado;
			}
		}
		return resultado.toString();
	}

	private static boolean isNumero(String termo) {
		if (termo.equals("(") || termo.equals(")") || termo.equals("+") || termo.equals("-") || termo.equals("*")
				|| termo.equals("/")) {
			return false;
		}
		return true;
	}

}
