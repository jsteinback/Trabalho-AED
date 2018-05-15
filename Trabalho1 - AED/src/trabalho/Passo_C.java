package trabalho;

import fila.FilaVetor;
import pilha.PilhaVetor;

public class Passo_C {

	private static FilaVetor<String> exprPosfixada;
	private static PilhaVetor<String> pilha;

	public static FilaVetor<String> gerarExprPosfixada(FilaVetor<String> exprInfixada) {
		// TODO limite temporario
		exprInfixada = new FilaVetor<>(100);
		pilha = new PilhaVetor<>(100);

		while (!exprInfixada.estaVazia()) {
			String termo = exprInfixada.retirar();

			if (termo.equals("(")) {
				pilha.push(termo);
			} else if (termo.equals("+") || termo.equals("-") || termo.equals("*") || termo.equals("/")) {
				while (pilha.peek() != null && isNumero(pilha.peek())) {
					exprPosfixada.inserir(pilha.pop());
				}
				pilha.push(termo);
			} else if (termo.equals(")")) {
				while (!pilha.peek().equals("(") || pilha.peek() != null) {
					exprPosfixada.inserir(pilha.pop());
				}
			} else {
				exprPosfixada.inserir(termo);
			}
		}

		return exprPosfixada;
	}

	private static boolean isNumero(String termo) {
		if (termo.equals("(") || termo.equals(")") || termo.equals("+") || termo.equals("-") || termo.equals("*")
				|| termo.equals("/")) {
			return false;
		}
		return true;
	}

}
