package fila;

public class FilaVetor<T> implements Fila<T> {

	private T[] info;
	private int limite;
	private int tamanhoAtual;
	private int indiceInicial;

	public FilaVetor(int limite) {
		info = (T[]) new Object[limite];
		this.limite = limite;
		tamanhoAtual = 0;
		indiceInicial = 0;
	}

	public FilaVetor<T> criarInvertido() {
		FilaVetor f = new FilaVetor<T>(this.limite);
		f.indiceInicial = (this.indiceInicial + this.tamanhoAtual) % this.limite;
		int cont = 0;
		while (cont < tamanhoAtual) {
			f.inserir(this.info[cont]);
			cont++;
		}
		return f;
	}

	public FilaVetor<T> concatenar(FilaVetor<T> f2) {
		FilaVetor<T> f3 = new FilaVetor<>(this.limite + f2.limite);
		int i = getIndiceInicial();
		while (info[i] != null) {
			f3.inserir(info[i]);
			i++;

			if (i == limite) {
				i = 0;
			}
		}

		i = f2.getIndiceInicial();
		while (f2.info[i] != null) {
			f3.inserir(f2.info[i]);
			i++;

			if (i == limite) {
				i = 0;
			}
		}
		return f3;
	}

	public int getIndiceInicial() {
		return indiceInicial;
	}

	@Override
	public String toString() {
		String imprimir = "";
		int indice = indiceInicial;

		while (info[indice] != null) {
			imprimir += imprimir + info[indice] + ", ";
			indice++;

			if (indice == limite) {
				indice = 0;
			}
		}
		return imprimir;
	}

	@Override
	public void inserir(T valor) throws RuntimeException {
		if (tamanhoAtual <= limite) {
			int indiceFinal;
			indiceFinal = (indiceInicial + tamanhoAtual) % limite;
			info[indiceFinal] = valor;
			tamanhoAtual++;
		}
	}

	@Override
	public T retirar() {
		if (estaVazio()) {
			return null;
		}

		T valor = info[indiceInicial];
		info[indiceInicial] = null;
		indiceInicial = (indiceInicial + 1) % limite;
		tamanhoAtual--;
		return valor;
	}

	@Override
	public T peek() {
		if (estaVazio()) {
			return null;
		}
		return info[indiceInicial];
	}

	@Override
	public boolean estaVazio() {
		return tamanhoAtual == 0;
	}

	@Override
	public void liberar() {

		int indice = indiceInicial;
		while (info[indice] != null) {
			info[indice] = null;
			indice++;
		}
		tamanhoAtual = 0;
	}

}
