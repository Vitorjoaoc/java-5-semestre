public class Selecao {

    static class Item {
        int key;

        Item(int key) {
            this.key = key;
        }
    }

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
        Item[] quaseOrdenado = new Item[10];
        Item[] parcialmenteOrdenado = new Item[10];
        Item[] desordenado = new Item[10];

        // Preencher os vetores com números aleatórios
        for (int i = 0; i < quaseOrdenado.length; i++) {
            quaseOrdenado[i] = new Item(i);
            parcialmenteOrdenado[i] = new Item((int) (Math.random() * 100));
            desordenado[i] = new Item((int) (Math.random() * 100));
        }

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
    }
}