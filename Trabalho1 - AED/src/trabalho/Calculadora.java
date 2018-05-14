package trabalho;

import fila.FilaVetor;

/**
 * @author Nathan Reiter, Jessica Steinback, Lucas Bueno, Alexandre da Silva
 */
public class Calculadora {

	public double Calcular(String expressao) throws Exception {
		FilaVetor<String> termosInfixada = extrairTermos(expressao);
		FilaVetor<String> termosPosfixada = gerarExprPosfixada(termosInfixada);
		return calcularExprPosfixada(termosPosfixada);
	}

	private FilaVetor<String> extrairTermos(String expressao) throws Exception {
		return Passo_B.extrairTermos(expressao);
	}

	private FilaVetor<String> gerarExprPosfixada(FilaVetor<String> exprInfixada) throws Exception {
		return Passo_C.gerarExprPosfixada(exprInfixada);
	}

	private double calcularExprPosfixada(FilaVetor<String> exprPosfixada) throws Exception {
		return Passo_D.calcularExprPosfixada(exprPosfixada);
	}
}
