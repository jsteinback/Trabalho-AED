package filaLista;

public class Lista<T> {
    
    //ATRIBUTOS
    protected NoLista primeiro;
    protected NoLista ultimo;
    private int qtdeNos; //PRECISA??????????????????????????/
    

    //CONSTRUTOR
    //INICIALIZA UMA LISTA VAZIA
    public Lista() { 
        primeiro = null;
    }
    
    //INSERE UM NÓ NO IN�?CIO DA LISTA
    public void inserirNoInicio(T valor) {
        //CRIA UM OBJETO E ATRIBUI O VALOR DO PARÂMETRO A ELE
        NoLista<T> novo = new NoLista<>();
        novo.setInfo(valor);        
        novo.setProximo(primeiro);
        primeiro = novo;        
    }       
    
    //INSERE UM NÓ NO FINAL DA LISTA
    public void inserirNoFinal(T valor) {
        NoLista<T> novo = new NoLista<>();
        novo.setInfo(valor);
        novo.setProximo(null);
        
        if (estaVazia()) {
            primeiro = novo;
        } else {
            ultimo.setProximo(novo);
        }
        ultimo = novo;
    }
    
    //Deve remover o primeiro nó que for encontrado que contiver o dado fornecido como argumento.
    public void retirar(T info) {        
        NoLista<T> anterior = null;
        NoLista<T> p = primeiro;
        
        while ((p != null) && (p.getInfo() != info)) {
            anterior = p;
            p = p.getProximo();
        }
        
        if (p != null) {
            if (anterior == null) {
                this.primeiro = p.getProximo();
            } else {
                anterior.setProximo(p.getProximo());
            }
            
            if (p == ultimo) {
                ultimo = anterior;
            }         
        }
    }
    
    //Deve exibir o conteúdo armazenado nos nós da lista encadeada.
    public String exibir() {
        String saida = "";
        NoLista p = primeiro;
        while (p != null) {
            saida = saida + p.getInfo() + "\n";
            p = p.getProximo();
        }
        return saida;
    }
    
    //Deve retornar true se a lista estiver vazia ou false se tiver algum nó.
    public boolean estaVazia() {
        return primeiro == null;
    }
    
    
    //Deve procurar na lista encadeada se há um nó cujo conteúdo seja igual à variável info. 
    //Caso seja localizado, deverá retornar este nó (objeto da classe NoLista). Se não for localizado, deverá retornar null.
    public NoLista buscar(T info) {        
        NoLista p = primeiro;
        while (p != null) {
            if (info == p.getInfo()) {                
                return p;                                
            } 
            p = p.getProximo();
        }
        return null;        
    }
    
    public void liberar() {
        NoLista<T> p = primeiro;
        NoLista<T> anterior;
        while (p != null) {
            anterior = p.getProximo();
            p.setAnterior(null);
            p.setProximo(null);

            p = anterior;
        }
        this.primeiro = null;
    }
       
    //Deverá retornar a quantidade de nós encadeados na lista. 
    //Implemente este método sem criar nova variável de instância na classe Lista.
    public int obterComprimento() {
        
        int qtdeNos = 0;
        
        NoLista p = primeiro;
        
        while (p != null) {
            qtdeNos++;
            p = p.getProximo();
        }
        return qtdeNos;
    }
    
    //Deverá retornar o valor do último nó da lista encadeada, isto é, aquele que está na extremidade oposta do primeiro nós da lista.
    //Caso a lista esteja vazia, deverá lançar exceção ListaVaziaException.
    //Implemente este método sem criar nova variável de instância na classe Lista.
    public T obterUltimo() throws Exception {
        if (estaVazia()) {
            throw new ListaVaziaException();        
        }
        
        NoLista<T> ultimo = null;
        
        NoLista p = primeiro;
        while (p != null) {
            ultimo = p;
            p = p.getProximo();
        }
        return (T) ultimo.getInfo();
    }
    
    
    public NoLista<T> getPrimeiro() {
        return primeiro;
    }
        
}
