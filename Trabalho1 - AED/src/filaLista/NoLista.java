package filaLista;

public class NoLista<T> {
    
    protected T info;
    private NoLista proximo; //multiplicidade de 0...1
    private NoLista<T> anterior;

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public NoLista getProximo() {
        return proximo;
    }

    public void setProximo(NoLista proximo) {
        this.proximo = proximo;
    }

    public NoLista<T> getAnterior() {
        return anterior;
    }

    public void setAnterior(NoLista<T> anterior) {
        this.anterior = anterior;
    }  
    
}
