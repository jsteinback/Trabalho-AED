package trabalho;

import filaLista.FilaLista;

/**
 * @author Nathan Reiter, Jessica Steinback, Lucas Bueno
 */
public class Calculadora {

	public double Calcular(String expressao) throws Exception {
		FilaLista<String> termosInfixada = extrairTermos(expressao);
		FilaLista<String> termosPosfixada = gerarExprPosfixada(termosInfixada);
		return calcularExprPosfixada(termosPosfixada);
	}

	public FilaLista<String> extrairTermos(String expressao) throws Exception {
		return Passo_B.extrairTermos(expressao);
	}

	public FilaLista<String> gerarExprPosfixada(FilaLista<String> exprInfixada) throws Exception {
		return Passo_C.gerarExprPosfixada(exprInfixada);
	}

	public double calcularExprPosfixada(FilaLista<String> exprPosfixada) throws Exception {
		return Passo_D.calcularExprPosfixada(exprPosfixada);
	}
}
