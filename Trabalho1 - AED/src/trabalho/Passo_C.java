package trabalho;

import filaLista.FilaLista;
import pilhaLista.PilhaLista;

public class Passo_C {

	private static FilaLista<String> exprPosfixada = new FilaLista<>();
	private static PilhaLista<String> pilha = new PilhaLista<>();

	public static FilaLista<String> gerarExprPosfixada(FilaLista<String> exprInfixada) {
		while (!exprInfixada.estaVazio()) {
			String termo = exprInfixada.retirar();

			if (isNumero(termo)) {
				// Operando
				exprPosfixada.inserir(termo);

			} else if (termo.equals("(")) {
				// Parenteses na Abertura
				pilha.push(termo);

			} else if (termo.equals("+") || termo.equals("-") || termo.equals("*") || termo.equals("/")) {
				// Operador
				while (!pilha.estaVazia()) {
					if (pilha.peek().equals("(") || pilha.peek().equals(")")
							|| (!isOperadorMenor(termo) && isOperadorMenor(pilha.peek()))) {
						break;
					} else {
						exprPosfixada.inserir(pilha.pop());
					}
				}
				pilha.push(termo);

			} else if (termo.equals(")")) {
				// Parenteses no Fechamento
				while (!pilha.estaVazia()) {
					if (pilha.peek().equals("(")) {
						pilha.pop();
						break;
					} else {
						exprPosfixada.inserir(pilha.pop());
					}
				}
			}
		}

		while (!pilha.estaVazia()) {
			exprPosfixada.inserir(pilha.pop());
		}

		return exprPosfixada;
	}

	private static boolean isOperadorMenor(String termo) {
		if (termo.equals("+") || termo.equals("-")) {
			return true;
		}
		return false;
	}

	private static boolean isNumero(String termo) {
		if (termo.equals("(") || termo.equals(")") || termo.equals("+") || termo.equals("-") || termo.equals("*")
				|| termo.equals("/")) {
			return false;
		}
		return true;
	}

}
