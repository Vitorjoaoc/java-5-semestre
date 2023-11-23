public class Lista {
    static class Livro {
        String titulo;
        String autor;
        int numero;
        boolean disponibilidade;

        public Livro(String titulo, String autor, int numero) {
            this.titulo = titulo;
            this.autor = autor;
            this.numero = numero;
            this.disponibilidade = true;
        }

        @Override
        public String toString() {
            return "Titulo: " + titulo + '\n' +
                    "Autor: " + autor + '\n' +
                    "Numero: " + numero + '\n' +
                    "Disponibilidade: " + disponibilidade +
                    "\n------------------------------";
        }
    }

    static class Elemento {
        Livro livro;
        Elemento proximo;

        public Elemento(Livro livro) {
            this.livro = livro;
            this.proximo = null;
        }
    }

    static class ListaLigada {
        Elemento primeiro;
        Elemento ultimo;
        int tamanho;
        String ordenado;

        public ListaLigada() {
            this.primeiro = null;
            this.ultimo = null;
            this.tamanho = 0;
            this.ordenado = "Autor";
        }

        // Adiciona um livro à lista
        public void adicionar(Livro livro) {
            Elemento novoElemento = new Elemento(livro);
            if (this.primeiro == null) {
                this.primeiro = novoElemento;
                this.ultimo = novoElemento;
            } else {
                this.ultimo.proximo = novoElemento;
                this.ultimo = novoElemento;
            }
            this.tamanho++;
        }

        public void remover(Elemento valorProcurado) {
            Elemento anterior = null;
            Elemento atual = this.primeiro;
            for (int i = 0; i < this.tamanho; i++) {
    
                if (atual.livro.titulo.equals(valorProcurado.livro.titulo)) {
                    if (this.tamanho == 1) {
                        this.primeiro = null;
                        this.ultimo = null;
                        System.out.println("Livro Removido com sucesso!\n");
                    } else if (atual == primeiro) {
                        this.primeiro = atual.proximo;
                        atual.proximo = null;
                        System.out.println("Livro Removido com sucesso!\n");
                    } else if (atual == ultimo) {
                        this.ultimo = anterior;
                        anterior.proximo = null;
                        System.out.println("Livro Removido com sucesso!\n");
                    } else {
                        anterior.proximo = atual.proximo;
                        atual = null;
                        System.out.println("Livro Removido com sucesso!\n");
                    }
    
                    this.tamanho--;
                    //ordenacao();
                    break;
                }
                anterior = atual;
                atual = atual.proximo;
            }
        }

        // Método para imprimir a lista ligada
        void imprimirLista() {
            Elemento atual = primeiro;
            while (atual != null) {
                System.out.println(atual.livro);
                atual = atual.proximo;
            }
        }
    }

    // Método para realizar o merge de duas listas ordenadas
    static Elemento merge(Elemento esquerda, Elemento direita) {
        Elemento resultado = new Elemento(null);
        Elemento atual = resultado;

        while (esquerda != null && direita != null) {
            if (esquerda.livro.titulo.compareTo(direita.livro.titulo) < 0) {
                atual.proximo = esquerda;
                esquerda = esquerda.proximo;
            } else {
                atual.proximo = direita;
                direita = direita.proximo;
            }
            atual = atual.proximo;
        }

        // Adiciona os elementos restantes, se houver
        if (esquerda != null) {
            atual.proximo = esquerda;
        } else if (direita != null) {
            atual.proximo = direita;
        }

        return resultado.proximo;
    }

    // Método principal para realizar o merge sort na lista ligada
    static Elemento mergeSort(Elemento inicio) {
        if (inicio == null || inicio.proximo == null) {
            return inicio;
        }

        // Divide a lista em duas metades
        Elemento[] metades = dividirLista(inicio);

        // Recursivamente ordena as duas metades
        Elemento esquerda = mergeSort(metades[0]);
        Elemento direita = mergeSort(metades[1]);

        // Combina as duas metades ordenadas
        return merge(esquerda, direita);
    }

    // Método para dividir a lista em duas metades
    static Elemento[] dividirLista(Elemento inicio) {
        if (inicio == null || inicio.proximo == null) {
            return new Elemento[] { inicio, null };
        }

        Elemento lento = inicio;
        Elemento rapido = inicio.proximo;

        while (rapido != null && rapido.proximo != null) {
            lento = lento.proximo;
            rapido = rapido.proximo.proximo;
        }

        Elemento esquerda = inicio;
        Elemento direita = lento.proximo;
        lento.proximo = null;

        return new Elemento[] { esquerda, direita };
    }
}