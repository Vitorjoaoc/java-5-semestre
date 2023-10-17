public class Bolha {

    static class Item {
        int key;

        Item(int key) {
            this.key = key;
        }
    }

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

    public static void main(String[] args) {
        
        System.out.println("\nBUBBLE SORT:\n");
        Item[] quaseOrdenado = {new Item(1), new Item(2), new Item(3), new Item(4), new Item(6), new Item(5), new Item(7), new Item(8), new Item(10), new Item(9)};

        Item[] parcialmenteOrdenado = {new Item(1), new Item(3), new Item(4), new Item(5), new Item(6), new Item(10), new Item(2), new Item(8), new Item(7), new Item(6)};

        Item[] desordenado = {new Item(10), new Item(9), new Item(8), new Item(7), new Item(6), new Item(5), new Item(4), new Item(3), new Item(2), new Item(1)};

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
    }
}