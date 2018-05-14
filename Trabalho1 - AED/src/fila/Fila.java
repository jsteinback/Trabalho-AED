package fila;

public interface Fila<T> {

    void inserir(T valor) throws FilaCheiaException;
    
    T retirar();
    
    T peek();
    
    boolean estaVazio();
    
    void liberar();   
    
}
