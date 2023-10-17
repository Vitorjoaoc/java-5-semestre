public class Insercao {

    static class Item {
        int key;

        Item(int key) {
            this.key = key;
        }
    }

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

    public static void main(String[] args) {

        System.out.println("\nINSERÇÃO:\n");

        Item[] quaseOrdenado = {new Item(1), new Item(2), new Item(3), new Item(4), new Item(6), new Item(5), new Item(7), new Item(8), new Item(10), new Item(9)};

        Item[] parcialmenteOrdenado = {new Item(1), new Item(3), new Item(4), new Item(5), new Item(6), new Item(10), new Item(2), new Item(8), new Item(7), new Item(6)};

        Item[] desordenado = {new Item(10), new Item(9), new Item(8), new Item(7), new Item(6), new Item(5), new Item(4), new Item(3), new Item(2), new Item(1)};

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
    }
}
