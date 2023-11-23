import java.util.Scanner;
public class Biblioteca {

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

        public Elemento get(int posicao) {
            Elemento atual = this.primeiro;
            for (int i = 0; i < posicao; i++) {
                if (atual.proximo != null) {
                    atual = atual.proximo;
                }
            }
            return atual;
        }
    
        public Elemento getLivroTitulo(String titulo) {
            Elemento atual = this.primeiro;
            while (atual.proximo != null) {
                if (atual.livro.titulo.equalsIgnoreCase(titulo)) {
                    break;
                }
                atual = atual.proximo;
            }
            return atual;
    
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

    
public static void main(String[] args) {

    int escolha = 0;
    ListaLigada listaLivros = new ListaLigada();
    Scanner sc = new Scanner(System.in);
    String title = new String();
    String autor = new String();
    int numero;

    listaLivros.adicionar(new Livro("O pequeno principe","Jonas Mac", 12));
    listaLivros.adicionar(new Livro("A granola","Autor Two", 6));
    listaLivros.adicionar(new Livro("Clean Code","Herbert Tree", 4));

    System.out.println("BEM VINDO A BIBLIOTECA!");
    do{
        System.out.println("Escolha uma das opções a baixo: ");
        System.out.println("[1] Ordernar por Titulo");
        System.out.println("[2] Ordernar por Autor");
        System.out.println("[3] Adicionar um livro");
        System.out.println("[4] Remover um livro");
        System.out.println("[5] Pegar livro emprestado");
        System.out.println("[6] Devolver um livro");
        System.out.println("[7] Buscar livro por titulo");
        System.out.println("[8] Buscar livro por autor");
        System.out.println("[9] LISTAR LIVROS");
        System.out.println("[10] Finalizar");
        escolha = sc.nextInt();

        switch (escolha){
            case 1: // ordenar por titulo
            
            //listaLivros.ordenaPtitulo();
            System.out.println("Tamanho da lista: " + listaLivros.tamanho);
            
            mergeSort(listaLivros.primeiro);

            System.out.println("Lista depois de ordenada:");
            listaLivros.imprimirLista();
            //listaLivros.listar(listaLivros);
            System.out.println("Tamanho da lista: " + listaLivros.tamanho);

            System.out.printf("A lista esta ordenada pelo %s \n", listaLivros.ordenado);
            break;

            case 2: //ordernar por autor
           // listaLivros.ordenaPautor();
            System.out.printf("A lista esta ordenada pelo %s \n", listaLivros.ordenado);
        
            break;

            case 3: // adicionar livro
            System.out.println("Adicionando um livro!");
        
            System.out.println("Titulo: ");
            title = sc.nextLine();
            title = sc.nextLine();

            System.out.println("Autor: ");
            autor = sc.nextLine();

            System.out.println("Numero: ");
            numero = sc.nextInt();
            listaLivros.adicionar(new Livro(title, autor, numero));
            System.out.println("Parabéns seu livro foi adicionado com sucesso!");
            //listaLivros.ordenacao();
            break;

            case 4: // remover livro
            System.out.println("Digite o nome do livro: ");
            title = sc.nextLine();
            title = sc.nextLine();
            listaLivros.remover(listaLivros.getLivroTitulo(title));
            break;

            case 5: // emprestimo
            System.out.println("Digite o nome do livro: ");
            title = sc.nextLine();
            title = sc.nextLine();
            listaLivros.emprestimo(title);
            break;

            case 6: //devolução
            System.out.println("Digite o nome do livro: ");
            title = sc.nextLine();
            title = sc.nextLine();
            listaLivros.devolucao(title);
            break;

            case 7:// busca titutlo
            
            break;

            case 8: // busca autor
           
            break;

            case 9://Listar livros
            listaLivros.listar(listaLivros);
            break;

            case 10://Finalizar
            System.out.println("Finalizando aplicativo...");
            break;
            
            default:// se a entrada for invalida ele solicita novamente
            System.out.println("Desculpe entrada INVALIDA. Por favor tente novamente!");
            escolha = 1;

      }
    }while(escolha > 0 && escolha < 10);


   // System.out.println("ANTES DE ORDENAR:");

  
    sc.close();
   
}

}