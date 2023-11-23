
public class ListaLigada {
    private Elemento primeiro;
    private Elemento ultimo;
    private int tamanho;
    private String ordenado;

    public ListaLigada() {
        this.tamanho = 0;
        this.ordenado = "Autor";
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

    public String getOrdenado() {
        return ordenado;
    }

    public void setOrdenado(String ordenado) {
        this.ordenado = ordenado;
    }




    public void adicionar(Livro novoValor) {
        Elemento novoelElemento = new Elemento(novoValor);
        if (this.primeiro == null && this.ultimo == null) {
            this.primeiro = novoelElemento;
            this.ultimo = novoelElemento;
        } else {
            this.ultimo.setProximo(novoelElemento);
            this.ultimo = novoelElemento;

        }
        this.tamanho++;
       // ordenacao();
    }

    public void remover(Elemento valorProcurado) {
        Elemento anterior = null;
        Elemento atual = this.primeiro;
        for (int i = 0; i < this.getTamanho(); i++) {

            if (atual.getTitulo().equals(valorProcurado.getTitulo())) {
                if (this.tamanho == 1) {
                    this.primeiro = null;
                    this.ultimo = null;
                    System.out.println("Livro Removido com sucesso!\n");
                } else if (atual == primeiro) {
                    this.primeiro = atual.getProximo();
                    atual.setProximo(null);
                    System.out.println("Livro Removido com sucesso!\n");
                } else if (atual == ultimo) {
                    this.ultimo = anterior;
                    anterior.setProximo(null);
                    System.out.println("Livro Removido com sucesso!\n");
                } else {
                    anterior.setProximo(atual.getProximo());
                    atual = null;
                    System.out.println("Livro Removido com sucesso!\n");
                }

                this.tamanho--;
                //ordenacao();
                break;
            }

            anterior = atual;
            atual = atual.getProximo();
        }

    }

    public Elemento get(int posicao) {
        Elemento atual = this.primeiro;
        for (int i = 0; i < posicao; i++) {
            if (atual.getProximo() != null) {
                atual = atual.getProximo();
            }
        }
        return atual;
    }

    public Elemento getLivroTitulo(String titulo) {
        Elemento atual = this.getPrimeiro();
        while (atual.getProximo() != null) {
            if (atual.getTitulo().equalsIgnoreCase(titulo)) {
                break;
            }
            atual = atual.getProximo();
        }
        return atual;

    }

    public void ordenaPtitulo() {
        // oredena pelo nome
        // BUBBLE SORT
        boolean trocou;
        Elemento anterior = null;

        do {
            trocou = false;
            Elemento atual = getPrimeiro();

            while (atual != null && atual.getProximo() != null) {
                Elemento proximo = atual.getProximo();

                // Comparar títulos e trocar se necessário
                if (atual.getTitulo().compareTo(proximo.getTitulo()) > 0) {
                    // Trocar os elementos
                    if (anterior != null) {
                        anterior.setProximo(proximo);
                    } else {
                        setPrimeiro(proximo);
                    }

                    atual.setProximo(proximo.getProximo());
                    proximo.setProximo(atual);
                    trocou = true;
                }

                anterior = atual;
                atual = atual.getProximo();
            }
        } while (trocou);
        setOrdenado("Titulo");
    }

    public void ordenaPautor() {
        // orddena pelo autor
        // BUBBLE SORT
        boolean trocou;
        Elemento atual;
        Elemento anterior = null;

        do {
            trocou = false;
            atual = primeiro;

            while (atual != null && atual.getProximo() != null) {
                Elemento proximo = atual.getProximo();

                // Comparar títulos e trocar se necessário
                if (atual.getValor().getAutor().compareTo(proximo.getValor().getAutor()) > 0) {
                    // Trocar os elementos
                    if (anterior != null) {
                        anterior.setProximo(proximo);
                    } else {
                        primeiro = proximo;
                    }

                    atual.setProximo(proximo.getProximo());
                    proximo.setProximo(atual);
                    trocou = true;
                }

                anterior = atual;
                atual = atual.getProximo();
            }
        } while (trocou);
        setOrdenado("Autor");
    }

    public void ordenacao(){
        if(getOrdenado().equals("Titulo")){
            ordenaPtitulo();
        }else{
            ordenaPautor();
        }
    }
    

    public void emprestimo(String titulo) {
        // empresta livro e muda a disponibilidade
        Elemento atual = getPrimeiro();
        for (int i = 0; i < tamanho; i++) {
            if (atual.getTitulo().equalsIgnoreCase(titulo)) {
                if (atual.getValor().getDisponibilidade() == true) {
                    System.out.printf("\nParabéns o livro %s foi emprestado com sucesso!\n",
                            atual.getValor().getTitulo());
                    atual.getValor().setDisponibilidade(false);
                    break;
                } else {
                    System.out.println("Desculpe este livro está indisponivel no momento, tente outro dia!");
                    break;
                }

            } else if (atual.getTitulo().equalsIgnoreCase(titulo) == false && i == tamanho - 1) {
                System.out.println("Desculpe o livro não foi encontrado!");
            } else {
                atual = atual.getProximo();

            }
        }
    }

    public void devolucao(String titulo) {
        // devolve livro e muda a disponibilidade
        Elemento atual = getPrimeiro();
        for (int i = 0; i < tamanho; i++) {
            if (atual.getTitulo().equalsIgnoreCase(titulo)) {
                if (atual.getValor().getDisponibilidade() == false) {
                    System.out.println("Parabéns você devolveu seu livro com sucesso!");
                    atual.getValor().setDisponibilidade(true);
                    System.out.println(atual.book());
                    break;
                } else {
                    System.out.println(
                            "Desculpe parece que esse livro já foi devolvido!\nPor favor verifique o nome do livro e tente novamente.");
                    break;
                }

            } else if (atual.getTitulo().equalsIgnoreCase(titulo) == false && i == tamanho - 1) {
                System.out.println("Desculpe o livro não foi encontrado!");
            } else {
                atual = atual.getProximo();

            }
        }
    }

    public String buscaTitulo(String titulo) {
        // busca pelo titulo
        return titulo;
    }

    public String buscaAutor(String autor) {
        // busca pelo autor
        return autor;
    }

    public void listar(ListaLigada lista) {
        System.out.println("LISTA DE LIVROS: \n");
        Elemento atual = lista.getPrimeiro();
        for (int i = 0; i < lista.getTamanho(); i++) {
            System.out.println(atual.book());
            atual = atual.getProximo();
        }
    }

    void imprimirLista() {
        Elemento atual = primeiro;
        while (atual != null) {
            System.out.println(atual.getValor());
            atual = atual.getProximo();
        }
    }

}
