package trabalho;

import fila.FilaVetor;

/**
 * @author Nathan Reiter, Jessica Steinback, Lucas Bueno, Alexandre da Silva
 */
public class Calculadora {

	public double Calcular(String expressao) {
		FilaVetor<String> termosInfixada = extrairTermos(expressao);
		FilaVetor<String> termosPosfixada = gerarExprPosfixada(termosInfixada);
		return calcularExprPosfixada(termosPosfixada);
	}

	private FilaVetor<String> extrairTermos(String expressao) {
		return Passo_B.extrairTermos(expressao);
	}

	private FilaVetor<String> gerarExprPosfixada(FilaVetor<String> exprInfixada) {
		return Passo_C.gerarExprPosfixada(exprInfixada);
	}

	private double calcularExprPosfixada(FilaVetor<String> exprPosfixada) {
		return Passo_D.calcularExprPosfixada(exprPosfixada);
	}
}
