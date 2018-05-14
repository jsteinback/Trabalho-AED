package fila;

public interface Fila<T> {

	public void inserir(T valor);

	public T retirar();

	public T peek();

	public boolean estaVazia();

	public void liberar();

}
