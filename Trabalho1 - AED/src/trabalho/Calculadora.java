package trabalho;

import filaLista.FilaLista;

/**
 * @author Nathan Reiter, Jessica Steinback, Lucas Bueno, Alexandre da Silva
 */
public class Calculadora {

	public double Calcular(String expressao) throws Exception {
		FilaLista<String> termosInfixada = extrairTermos(expressao);
		FilaLista<String> termosPosfixada = gerarExprPosfixada(termosInfixada);
		return calcularExprPosfixada(termosPosfixada);
	}

	private FilaLista<String> extrairTermos(String expressao) throws Exception {
		return Passo_B.extrairTermos(expressao);
	}

	private FilaLista<String> gerarExprPosfixada(FilaLista<String> exprInfixada) throws Exception {
		return Passo_C.gerarExprPosfixada(exprInfixada);
	}

	private double calcularExprPosfixada(FilaLista<String> exprPosfixada) throws Exception {
		return Passo_D.calcularExprPosfixada(exprPosfixada);
	}
}
