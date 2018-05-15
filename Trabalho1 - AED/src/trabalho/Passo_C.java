package trabalho;

import filaLista.FilaLista;
import pilhaLista.PilhaLista;

public class Passo_C {

	private static FilaLista<String> exprPosfixada = new FilaLista<>();
	private static PilhaLista<String> pilha = new PilhaLista<>();

	public static FilaLista<String> gerarExprPosfixada(FilaLista<String> exprInfixada) {
		while (!exprInfixada.estaVazio()) {
			String termo = exprInfixada.retirar();

			if (termo.equals("(")) {
				// Parenteses na Inicio
				pilha.push(termo);

			} else if (termo.equals("+") || termo.equals("-") || termo.equals("*") || termo.equals("/")) {
				// Operador
				if (!pilha.estaVazia()) {
					try {
						while (pilha.peek() != null || !isNumero(pilha.peek()) || isOperadorMenor(termo)) {
							if (pilha.peek().equals("(")) {
								pilha.pop();
							} else {
								exprPosfixada.inserir(pilha.pop());
							}
						}
					} catch (Exception e) {
					}
				}
				pilha.push(termo);

			} else if (termo.equals(")")) {
				// Parenteses no Fechamento
				if (!pilha.estaVazia()) {
					try {
						while (!pilha.peek().equals("(") || pilha.peek() != null) {
							exprPosfixada.inserir(pilha.pop());
						}

					} catch (Exception e) {
					}
				}

			} else {
				// Operando
				exprPosfixada.inserir(termo);
			}
		}

		while (!pilha.estaVazia()) {
			exprPosfixada.inserir(pilha.pop());
		}

		return exprPosfixada;
	}
	// (25 + 10) / 3,5

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
