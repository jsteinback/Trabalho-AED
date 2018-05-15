package filaLista;

public class FilaLista<T> implements Fila<T>{

    private Lista<T> fila;

    public FilaLista() {
        fila = new Lista<>();
    }
        
    @Override
    public void inserir(T valor) {
        fila.inserirNoFinal(valor);
    }
    
    @Override
    public T retirar() {    	
        if (estaVazio()) {
            throw new RuntimeException("A Fila esta Vazia");
        }
        
        T valor = fila.getPrimeiro().getInfo();
        fila.retirar(valor);
        
        return valor;
    }

    @Override
    public T peek() {
        if (estaVazio()) {
            throw new RuntimeException("A Fila esta Vazia");
        }
        
        T valor = fila.getPrimeiro().getInfo();
        return valor;
    }

    @Override
    public boolean estaVazio() {
        return fila.estaVazia();
    }

    @Override
    public void liberar() {
        fila.liberar();
    }
    
    @Override
    public String toString() {
        if (estaVazio()) {
            throw new RuntimeException("Pilha esta vazia");
        }
        
        return fila.exibir();
    }
    
}
