package fila;

public interface Fila<T> {

    void inserir(T valor);
    
    T retirar();
    
    T peek();
    
    boolean estaVazio();
    
    void liberar();   
    
}
