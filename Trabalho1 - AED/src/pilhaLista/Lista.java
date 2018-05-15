package pilhaLista;

public class Lista<T> {
        
    private NoLista topo; //Multiplicidade: 0...1

    //Construtor da classe. Deve inicializar uma lista vazia.
    public Lista() { 
        topo = null;
    }

    public NoLista<T> getTopo() {
        return topo;
    }
    
    //Deve inserir um novo nó no início da lista. Este novo nó deve armazenar o valor recebido na variável paramétrica info.
    public void inserir(T info) {
        NoLista novoTermo = new NoLista();
        novoTermo.setInfo(info);
        if (topo != null) {
            novoTermo.setProximo(topo);
            this.topo = novoTermo; 
        } else {
            this.topo = novoTermo; //Object é o tipo de qualquer classe 
        }                              
    }       
     
    //Deve exibir o conteúdo armazenado nos nós da lista encadeada.
    public String exibir() {
        String saida = "";
        NoLista p = topo;
        while (p != null) {
            saida = saida + p.getInfo() + "\n";
            p = p.getProximo();
        }
        return saida;
    }
    
    //Deve retornar true se a lista estiver vazia ou false se tiver algum nó.
    public boolean estaVazia() {
        return topo == null;
    }
    
    //Deve procurar na lista encadeada se há um nó cujo conteúdo seja igual à variável info. 
    //Caso seja localizado, deverá retornar este nó (objeto da classe NoLista). Se não for localizado, deverá retornar null.
    public NoLista buscar(T info) {        
        NoLista p = topo;
        while (p != null) {
            if (info == p.getInfo()) {                
                return p;                                
            } 
            p = p.getProximo();
        }
        return null;        
    }
    
    //Deve remover o primeiro nó que for encontrado que contiver o dado fornecido como argumento.
    public void retirar(T info) {
        
        NoLista<T> anterior = null;
        NoLista<T> p = topo;
        
        while ((p != null) && (!p.getInfo().equals(info))) {
            anterior = p;
            p = p.getProximo();
        }
        
        if (p != null) {
            if (anterior == null) {
                this.topo = p.getProximo();
            } else {
                anterior.setProximo(p.getProximo());
            }
        }
    }
    
    //Deverá retornar a quantidade de nós encadeados na lista. 
    //Implemente este método sem criar nova variável de instância na classe Lista.
    public int obterComprimento() {
        
        int qtdeNos = 0;
        
        NoLista p = topo;
        
        while (p != null) {
            qtdeNos++;
            p = p.getProximo();
        }
        return qtdeNos;
    }
    
    //Deverá retornar o valor do último nó da lista encadeada, isto é, aquele que está na extremidade oposta do primeiro nós da lista.
    //Caso a lista esteja vazia, deverá lançar exceção ListaVaziaException.
    //Implemente este método sem criar nova variável de instância na classe Lista.
    public T obterUltimo() {
        if (estaVazia()) {
            throw new ListaVaziaException();        
        }
        
        NoLista ultimo = null;
        
        NoLista p = topo;
        while (p != null) {
            ultimo = p;
            p = p.getProximo();
        }
        return (T) ultimo.getInfo();
    }   
    
    public void liberar() {
        topo = null;
//        NoLista<T> p = topo;
//        NoLista<T> anterior;
//        while (p != null) {
//            anterior = p.getProximo();
//            p.setAnterior(null);
//            p.setProximo(null);
//
//            p = anterior;
//        }
//        this.topo = null;
    }
    
}
