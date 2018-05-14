package fila;

public class FilaVetor<T> implements Fila<T> {

	private T[] info;
	private int limite;
	private int tamanho;
	private int inicio;

	public FilaVetor(int limite) {
		info = (T[]) new Object[limite];
		this.limite = limite;
		tamanho = 0;
		inicio = 0;
	}

	@Override
	public void inserir(T valor) {
		if (tamanho == limite) {
			throw new FilaCheiaException("Fila está cheia!");
		}
		int posicaoInserir = (inicio + tamanho) % limite;
		info[posicaoInserir] = valor;
		tamanho++;
	}

	@Override
	public boolean estaVazia() {
		if (tamanho == 0) {
			return true;
		}
		return false;
	}

	@Override
	public T peek() {
		if (estaVazia()) {
			throw new FilaVaziaException("Fila está vazia!");
		}
		return info[inicio];
	}

	@Override
	public T retirar() {
		if (estaVazia()) {
			return null;
		}

		T valor = info[inicio];
		info[inicio] = null;
		inicio = (inicio + 1) % limite;
		tamanho--;
		return valor;
	}

	@Override
	public void liberar() {
		int indice = inicio;
		while (info[indice] != null) {
			info[indice] = null;
			indice++;
		}
		tamanho = 0;
	}

}
