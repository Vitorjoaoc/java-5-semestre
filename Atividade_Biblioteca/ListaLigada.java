public class ListaLigada {
    private Elemento primeiro;
    private Elemento ultimo;
    private int tamanho;
    private String ordenado;

    public ListaLigada() {
        this.tamanho = 0;
    }
    public Elemento getPrimeiro() {
        return primeiro;
    }
    public void setPrimeiro(Elemento primeiro) {
        this.primeiro = primeiro;
    }
    public Elemento getUltimo() {
        return ultimo;
    }
    public void setUltimo(Elemento ultimo) {
        this.ultimo = ultimo;
    }
    public int getTamanho() {
        return tamanho;
    }
    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public void adicionar(Livro novoValor){
        Elemento novoelElemento = new Elemento(novoValor);
        if (this.primeiro == null && this.ultimo == null){
            this.primeiro = novoelElemento;
            this.ultimo = novoelElemento;
        }else{
            this.ultimo.setProximo(novoelElemento);
            this.ultimo = novoelElemento;
            
        }
        this.tamanho++;
    }

    public void remover(Elemento valorProcurado){
        Elemento anterior = null;
        Elemento atual = this.primeiro;
        for (int i = 0; i < this.getTamanho(); i++) {
           
            if (atual.getValor().equals(valorProcurado)){
                if(this.tamanho == 1){
                    this.primeiro = null;
                    this.ultimo = null;
                }
                else if(atual == primeiro){
                   this.primeiro = atual.getProximo(); 
                   atual.setProximo(null);
                }else if(atual ==  ultimo){
                    this.ultimo = anterior;
                    anterior.setProximo(null);
                }else{
                    anterior.setProximo(atual.getProximo());
                    atual = null;
                }
                
                this.tamanho--;
                break;
            }
            anterior = atual;
            atual = atual.getProximo();
        }

    }

    public Elemento get(int posicao){
        Elemento atual = this.primeiro;
        for(int i = 0; i < posicao; i++){
            if (atual.getProximo() != null){
                atual = atual.getProximo();
            }
        }
        return atual;
    }

    public void ordenaPnome(){
        //oredena pelo nome
    }
    
    public void ordenaPautor(){
        //orddena pelo autor
    }

    public void emprestimo(String titulo){
        //empresta livro e muda a disponibilidade
        Elemento atual = getPrimeiro();
        for (int i = 0; i < tamanho; i++){
            if(atual.getTitulo().equalsIgnoreCase(titulo)){
                if(atual.getValor().getDisponibilidade() == true){
                System.out.printf("\nParabéns o livro %s foi emprestado com sucesso!\n", atual.getValor().getTitulo());
                atual.getValor().setDisponibilidade(false);
                break;
                }else{
                    System.out.println("Desculpe esté livro estpa indisponivel no momento, tente outro dia!");
                    break;
                }
                
            }else if(atual.getTitulo().equalsIgnoreCase(titulo) == false && i == tamanho - 1){
                System.out.println("Desculpe o livro não foi encontrado!");
            }
            else{
                atual = atual.getProximo();
                
            }
        }
    }
    
    public void devolucao(String titulo){
        //devolve livro e muda a disponibilidade
        Elemento atual = getPrimeiro();
        for (int i = 0; i < tamanho; i++){
            if(atual.getTitulo().equalsIgnoreCase(titulo)){
                if(atual.getValor().getDisponibilidade() == false){
                    System.out.println("Parabéns você devolveu seu livro com sucesso!");
                    atual.getValor().setDisponibilidade(true);
                    System.out.println(atual.book());
                    break;
                }else{
                    System.out.println("Desculpe parece que esse livro já foi devolvido!\nPor favor verifique o nome do livro e tente novamente.");
                    break;
                }
               
            }else if(atual.getTitulo().equalsIgnoreCase(titulo) == false && i == tamanho - 1){
                System.out.println("Desculpe o livro não foi encontrado!");
            }
            else{
                atual = atual.getProximo();
                
            }
        }
    }

    public String buscaTitulo(String titulo){
        //busca pelo titulo
        return titulo;
    }

    public String buscaAutor(String autor){
        //busca pelo autor
        return autor;
    }


}

