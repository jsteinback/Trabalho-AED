package trabalho;

import fila.Fila;

/**
 * @author Nathan Reiter, Jessica Steinback & (Lucas Bueno || Alexandre da Silva) 
 */
public class Calculadora {

	public double Calcular(String expressao) {
		Calculadora c = new Calculadora();
		Fila<String> termosInfixada = c.extrairTermos(expressao);
		Fila<String> termosPosfixada = c.gerarExprPosfixada(termosInfixada);
		return c.calcularExprPosfixada(termosPosfixada);
	}

	private Fila<String> extrairTermos(String expressao) {
		return Passo_B.extrairTermos(expressao);
	}

	private Fila<String> gerarExprPosfixada(Fila<String> exprInfixada) {
		return Passo_C.gerarExprPosfixada(exprInfixada);
	}

	private double calcularExprPosfixada(Fila<String> exprPosfixada) {
		return Passo_D.calcularExprPosfixada(exprPosfixada);
	}
}
