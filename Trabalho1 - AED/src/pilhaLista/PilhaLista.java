package pilhaLista;

public class PilhaLista<T> implements Pilha<T> {

	private Lista<T> lista;

	public PilhaLista() {
		lista = new Lista<>();
	}

	@Override
	public void push(T valor) {
		lista.inserir(valor);
	}

	@Override
	public T pop() {
		if (estaVazia()) {
			throw new RuntimeException("A Pilha ja esta vazia");
		}

		T valor = lista.getTopo().getInfo();
		lista.retirar(valor);
		return valor;
	}

	@Override
	public T peek() {
		if (estaVazia()) {
			throw new RuntimeException("esta vazia");
		}
		return lista.getTopo().getInfo();
	}

	@Override
	public boolean estaVazia() {
		return lista.estaVazia();
	}

	@Override
	public void liberar() {
		// while (!estaVazia()) {
		// pop();
		// }

		lista.liberar();
	}

	@Override
	public String toString() {
		if (estaVazia()) {
			throw new RuntimeException("Pilha esta vazia");
		}

		return lista.exibir();
	}

}
