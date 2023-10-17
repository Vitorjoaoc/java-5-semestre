public class ShellSort {

    // Implementação do algoritmo Shell Sort
    public static void shellSort(int[] array) {
        int h = 1;
        int n = array.length;
        while (h < n) {
            h = h * 3 + 1;
        }
        h = (int) Math.floor(h / 3);

        int elemento, j;
        while (h > 0) {
            for (int i = h; i < n; i++) {
                elemento = array[i];
                j = i;
                while (j >= h && array[j - h] > elemento) {
                    array[j] = array[j - h];
                    j = j - h;
                }
                array[j] = elemento;

                // Exibindo o estado do array após cada passo
                imprimirArray(array);
            }
            h = h / 2;
        }
    }

    // Método para imprimir um array
    public static void imprimirArray(int[] array) {
        for (int valor : array) {
            System.out.print(valor + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] vetor = {3, 4, 9, 2, 5, 8, 2, 1, 7, 4, 6, 2, 9, 8, 5, 1};

        System.out.println("Array antes da ordenação:");
        imprimirArray(vetor);
        System.out.println();

        shellSort(vetor);

        System.out.println("\nArray depois da ordenação:");
        imprimirArray(vetor);
    }
}
