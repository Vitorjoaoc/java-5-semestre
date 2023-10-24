import java.util.LinkedList;

class Livro {
    String titulo;
    String autor;
    int numero;
    boolean disponibilidade;

    Livro(String titulo, String autor, int numero, boolean disponibilidade) {
        this.titulo = titulo;
        this.autor = autor;
        this.numero = numero;
        this.disponibilidade = disponibilidade;
    }
}

public class teste {

    static class Node {
        Livro livro;
        Node next;

        Node(Livro livro) {
            this.livro = livro;
        }
    }

    public static void main(String[] args) {
        LinkedList<Livro> listaLivros = new LinkedList<>();
        listaLivros.add(new Livro("copa do mundo", "Autor2", 2, true));
        listaLivros.add(new Livro("A zebra", "Autor1", 1, true));
        listaLivros.add(new Livro("A coperativa", "Autor3", 3, false));

        Node head = criarListaLigada(listaLivros);

        System.out.println("Lista de livros antes da ordenação:");
        exibirListaLigada(head);

        // Ordenar a lista por título usando o algoritmo Quicksort
        head = quicksort(head);

        System.out.println("\nLista de livros depois da ordenação:");
        exibirListaLigada(head);
    }

    static Node quicksort(Node head) {
        // Base do caso recursivo: se a lista estiver vazia ou tiver apenas um elemento
        if (head == null || head.next == null) {
            return head;
        }

        // Escolher um pivô (neste caso, o último elemento)
        Node pivot = getTail(head);
        Node[] partes = particionar(head);

        // Recursivamente ordenar as sublistas antes e depois do pivô
        partes[0] = quicksort(partes[0]);
        partes[1] = quicksort(partes[1]);

        // Juntar as sublistas ordenadas e o pivô
        return concatenar(partes[0], pivot, partes[1]);
    }

    static Node[] particionar(Node head) {
        // Particionar a lista em relação ao último elemento (pivô)
        Node pivot = getTail(head);
        Node menor = null;
        Node igual = null;
        Node maior = null;

        Node current = head;
        while (current != null) {
            if (current.livro.titulo.compareTo(pivot.livro.titulo) < 0) {
                menor = addToEnd(menor, current.livro);
            } else if (current.livro.titulo.compareTo(pivot.livro.titulo) == 0) {
                igual = addToEnd(igual, current.livro);
            } else {
                maior = addToEnd(maior, current.livro);
            }
            current = current.next;
        }

        return new Node[]{menor, igual, maior};
    }

    static Node addToEnd(Node head, Livro livro) {
        // Adicionar um nó ao final da lista
        Node newNode = new Node(livro);
        if (head == null) {
            return newNode;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        return head;
    }

    static Node concatenar(Node menor, Node igual, Node maior) {
        // Juntar as sublistas ordenadas e o pivô
        Node result = menor;

        Node current = menor;
        while (current != null && current.next != null) {
            current = current.next;
        }

        if (current != null) {
            current.next = igual;
        } else {
            result = igual;
        }

        current = igual;
        while (current != null && current.next != null) {
            current = current.next;
        }

        if (current != null) {
            current.next = maior;
        } else {
            result = maior;
        }

        return result;
    }

    static Node getTail(Node head) {
        // Obter o último nó da lista
        if (head == null) {
            return null;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }

        return current;
    }

    static Node criarListaLigada(LinkedList<Livro> listaLivros) {
        // Criar uma lista ligada a partir da LinkedList
        Node head = null;

        for (Livro livro : listaLivros) {
            head = addToEnd(head, livro);
        }

        return head;
    }

    static void exibirListaLigada(Node head) {
        // Exibir os elementos da lista ligada
        Node current = head;
        while (current != null) {
            System.out.println("Título: " + current.livro.titulo + ", Autor: " + current.livro.autor);
            current = current.next;
        }
    }
}
