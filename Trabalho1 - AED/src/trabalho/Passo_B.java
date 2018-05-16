package trabalho;

import filaLista.FilaLista;

public class Passo_B {

	private static FilaLista<String> fila;

	public static FilaLista<String> extrairTermos(String expressao) {
		expressao = expressao.trim();
		expressao = expressao.replace("(", "( ").replace(")", " )").replace(",", "."); //
		String[] strSplit = expressao.split(" ");

		fila = new FilaLista<String>();
        String caracterAnterior = "";
        boolean contenSinal = false;
		for (String string : strSplit) {
			if(string != null && !string.isEmpty() &&!contenSinal)
			{
			  if(isOperadorMaiorMenor(caracterAnterior) && !isOperadorMaiorMenor(string))
			  {	 
				  string = caracterAnterior + string;
				  caracterAnterior = "";
			  }
		
			  if(string.equals("(")||(!isOperador(caracterAnterior) ||caracterAnterior.isEmpty()))
			     fila.inserir(string.trim());
			  caracterAnterior = string;
		      
				   
			}		
		}

		return fila;
	}
	
	private static boolean isOperador(String operador)
	{
		return (operador.trim().equals("-") || operador.trim().equals("+") || operador.trim().equals("/") || operador.trim().equals("*"));
		
	}
	private static boolean isOperadorMaiorMenor(String operador)
	{
		return (operador.trim().equals("-") || operador.trim().equals("+") );
		
	}

}
