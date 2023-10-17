import java.util.Scanner;

public class App3{

    static class Item {
        int key;

        Item(int key) {
            this.key = key;
        }
    }

    //metodo Bolha
    static void bubbleSort(Item[] arr) {
        int n = arr.length;
        int comparacoes = 0;
        int trocas = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                comparacoes++;
                if (arr[j].key > arr[j + 1].key) {
                    // Trocar os elementos se estiverem na ordem errada
                    Item aux = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = aux;
                    trocas++;
                }
            }
        }

        // Imprimir o número de comparações e trocas realizadas
        System.out.println("\n\nNúmero de comparações: " + comparacoes);
        System.out.println("Número de trocas: " + trocas);
    }

    //metodo inserção
    static void insertionSort(Item[] arr) {
        int n = arr.length;
        int comparacoes = 0;
        int trocas = 0;

        for (int i = 1; i < n; i++) {
            Item chave = arr[i];
            int j = i - 1;

            // Mover os elementos do arr[0..i-1] que são maiores que a chave
            // para uma posição à frente de sua posição atual
            while (j >= 0 && arr[j].key > chave.key) {
                comparacoes++;
                arr[j + 1] = arr[j];
                j = j - 1;
                trocas++;
            }
            arr[j + 1] = chave;
        }

        // Imprimir o número de comparações e trocas realizadas
        System.out.println("\n\nNúmero de comparações: " + comparacoes);
        System.out.println("Número de trocas: " + trocas);
    }

    //metodo seleção
    static void selectionSort(Item[] arr) {
        int n = arr.length;
        int comparacoes = 0;
        int trocas = 0;

        for (int i = 0; i < n - 1; i++) {
            int pm = i; // pm = posição do menor

            // Encontrar a posição do menor elemento na sub-sequência que começa em i
            for (int j = i + 1; j < n; j++) {
                comparacoes++;
                if (arr[j].key < arr[pm].key) {
                    pm = j;
                }
            }

            // Trocar o menor elemento (que está na posição pm) com o elemento da posição i
            Item aux = arr[i];
            arr[i] = arr[pm];
            arr[pm] = aux;
            trocas++;
        }

        // Imprimir o número de comparações e trocas realizadas
        System.out.println("\n\nNúmero de comparações: " + comparacoes);
        System.out.println("Número de trocas: " + trocas);
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        int resp = 0;
        Item[] quaseOrdenado = {new Item(1), new Item(2), new Item(3), new Item(4), new Item(6), new Item(5), new Item(7), new Item(8), new Item(10), new Item(9)};

        Item[] parcialmenteOrdenado = {new Item(1), new Item(3), new Item(4), new Item(5), new Item(6), new Item(10), new Item(2), new Item(8), new Item(7), new Item(6)};

        Item[] desordenado = {new Item(10), new Item(9), new Item(8), new Item(7), new Item(6), new Item(5), new Item(4), new Item(3), new Item(2), new Item(1)};

        System.out.println("Vamos ver a diferença entre os metodos de ordenação!\n");

        //Menu de opções
        do{
            System.out.println("\n[1] Método Bolha");
            System.out.println("[2] Método Seleção");
            System.out.println("[3] Método Inserção");
            System.out.println("[0] Finalizar");

            System.out.println("Selecione uma das opçãoes acima: ");
            resp = sc.nextInt();


            switch (resp){
                case 1:
                //chame o bolha
                System.out.println("\nMÉTODO BOLHAR:\n");
                System.out.println("Vetor Quase Ordenado antes da ordenação:");
                for (Item item : quaseOrdenado) {
                    System.out.print(item.key + " ");
                }
                bubbleSort(quaseOrdenado);
                System.out.println("\nVetor Quase Ordenado após a ordenação:");
                for (Item item : quaseOrdenado) {
                    System.out.print(item.key + " ");
                }
                System.out.println("\n---------------------------");

                System.out.println("Vetor Parcialmente Ordenado antes da ordenação:");
                for (Item item : parcialmenteOrdenado) {
                    System.out.print(item.key + " ");
                }
                bubbleSort(parcialmenteOrdenado);
                System.out.println("\nVetor Parcialmente Ordenado após a ordenação:");
                for (Item item : parcialmenteOrdenado) {
                    System.out.print(item.key + " ");
                }

                System.out.println("\n---------------------------");

                System.out.println("Vetor Desordenado antes da ordenação:");
                for (Item item : desordenado) {
                    System.out.print(item.key + " ");
                }
                bubbleSort(desordenado);
                System.out.println("\nVetor Desordenado após a ordenação:");
                for (Item item : desordenado) {
                    System.out.print(item.key + " ");
                }
                break;
                case 2:
                //chama o selecção
                 System.out.println("\nMÉTODO SELEÇÃO:\n");
                System.out.println("Vetor Quase Ordenado antes da ordenação:");
                for (Item item : quaseOrdenado) {
                    System.out.print(item.key + " ");
                }
                selectionSort(quaseOrdenado);
                System.out.println("\nVetor Quase Ordenado após a ordenação:");
                for (Item item : quaseOrdenado) {
                    System.out.print(item.key + " ");
                }
                System.out.println("\n---------------------------");

                System.out.println("Vetor Parcialmente Ordenado antes da ordenação:");
                for (Item item : parcialmenteOrdenado) {
                    System.out.print(item.key + " ");
                }
                selectionSort(parcialmenteOrdenado);
                System.out.println("\nVetor Parcialmente Ordenado após a ordenação:");
                for (Item item : parcialmenteOrdenado) {
                    System.out.print(item.key + " ");
                }

                System.out.println("\n---------------------------");

                System.out.println("Vetor Desordenado antes da ordenação:");
                for (Item item : desordenado) {
                    System.out.print(item.key + " ");
                }
                selectionSort(desordenado);
                System.out.println("\nVetor Desordenado após a ordenação:");
                for (Item item : desordenado) {
                    System.out.print(item.key + " ");
                }
                break;
                case 3:
                //chame inserção
                 System.out.println("\nMÉTODO inserção:\n");
                System.out.println("Vetor Quase Ordenado antes da ordenação:");
                for (Item item : quaseOrdenado) {
                    System.out.print(item.key + " ");
                }
                insertionSort(quaseOrdenado);
                System.out.println("\nVetor Quase Ordenado após a ordenação:");
                for (Item item : quaseOrdenado) {
                    System.out.print(item.key + " ");
                }
                System.out.println("\n---------------------------");

                System.out.println("Vetor Parcialmente Ordenado antes da ordenação:");
                for (Item item : parcialmenteOrdenado) {
                    System.out.print(item.key + " ");
                }
                insertionSort(parcialmenteOrdenado);
                System.out.println("\nVetor Parcialmente Ordenado após a ordenação:");
                for (Item item : parcialmenteOrdenado) {
                    System.out.print(item.key + " ");
                }

                System.out.println("\n---------------------------");

                System.out.println("Vetor Desordenado antes da ordenação:");
                for (Item item : desordenado) {
                    System.out.print(item.key + " ");
                }
                insertionSort(desordenado);
                System.out.println("\nVetor Desordenado após a ordenação:");
                for (Item item : desordenado) {
                    System.out.print(item.key + " ");
                }
                break;
                case 0:
                System.out.println("Programa finzalizado com sucesso!");
                break;
                default:
                System.out.println("\nDesculpe opção INVALIDA! Tente novamente:\n");

            }

        }while(resp != 0);
            
    }
}