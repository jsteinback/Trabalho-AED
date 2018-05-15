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
			String str = exprInfixada.retirar();

			if (str.equals("(")) {
				pilha.push(str);
			} else if (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")) {

				/*
				 * Desempilhe todos os termos que estiverem na pilha “B” e
				 * adicione-os na fila “C”, isto é, conforme você desempilhar um
				 * termo, adicione-o na fila “C”.
				 * 
				 * Este procedimento deve ser aplicado para todos os termos
				 * armazenados na pilha “B”, porém quando for desempilhado da
				 * pilha “B” um “parêntese de abertura”, esta regra deve ser
				 * interrompida.
				 * 
				 * Neste caso, o parêntese de abertura não deve ser adicionado
				 * na fila “C”.
				 */
			} else if (str.equals(")")) {
				while (!pilha.peek().equals("(") || pilha.peek() != null) {
					
				}

				exprPosfixada.inserir(pilha.pop());
			} else {
				exprPosfixada.inserir(str);
			}
		}

		return exprPosfixada;
	}

}
