package pilha;

public class PilhaVetor<T> implements Pilha<T> {

	private T info[];
	private int limite;
	private int tamanhoAtual;

	@SuppressWarnings("unchecked")
	public PilhaVetor(int limite) {
		info = (T[]) new Object[limite];
		tamanhoAtual = 0;
		this.limite = limite;
	}

	public PilhaVetor<T> mesclarPilhas(PilhaVetor<T> p2) {
		PilhaVetor<T> p1 = this;
		int somaLimites = p1.tamanhoAtual + p2.tamanhoAtual;

		PilhaVetor<T> mescla = new PilhaVetor<T>(somaLimites);
		while (!p1.estaVazia() || !p2.estaVazia()) {
			if (!p1.estaVazia()) {
				mescla.push(p1.pop());
			}
			if (!p2.estaVazia()) {
				mescla.push(p2.pop());
			}
		}

		PilhaVetor<T> result = new PilhaVetor<T>(mescla.limite);
		while (!mescla.estaVazia()) {
			result.push(mescla.pop());
		}
		return result;
	}

	@Override
	public void push(T valor) {
		if (limite == tamanhoAtual) {
			throw new RuntimeException("Capacidade Esgotada");
		}

		info[tamanhoAtual] = valor;
		tamanhoAtual++;
	}

	@Override
	public T pop() {
		if (estaVazia()) {
			return null;
		}

		T valor = info[tamanhoAtual - 1];
		info[tamanhoAtual - 1] = null;
		tamanhoAtual--;
		return valor;
	}

	@Override
	public T peek() {
		T valor = info[tamanhoAtual - 1];
		return valor;
	}

	@Override
	public boolean estaVazia() {
		return tamanhoAtual == 0;
	}

	@Override
	public void liberar() {
		for (int i = 0; i < tamanhoAtual; i++) {
			info[i] = null;
		}
		tamanhoAtual = 0;
	}

	@Override
	public String toString() {
		if (estaVazia()) {
			return null;
		}

		String saida = "";
		for (int i = tamanhoAtual - 1; i >= 0; i--) {
			saida += info[i] + "\n";
		}
		return saida;
	}
}
