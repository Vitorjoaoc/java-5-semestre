public class QuickSort {

    static void quicksort(int[] vetor, int esquerda, int direita) {
        if (esquerda < direita) {
            int p = particao(vetor, esquerda, direita);

            // chamada recursiva
            quicksort(vetor, esquerda, p);
            quicksort(vetor, p + 1, direita);
        }
    }

    static int particao(int[] vetor, int esquerda, int direita) {
        int meio = (esquerda + direita) / 2;
        int pivot = vetor[meio];
        int i = esquerda - 1;
        int j = direita + 1;
        int count = 0;
        while (true) {
            do {
                i++;
            } while (vetor[i] < pivot);
            do {
                j--;
            } while (vetor[j] > pivot);

            if (i >= j) {
                return j;
            }

            // realizando a troca
            int aux = vetor[i];
            vetor[i] = vetor[j];
            vetor[j] = aux;
        }
    }

    static void imprimiVetor(int[] vetor) {
        for (int i = 0; i < vetor.length; i++) {
            System.out.printf("%d ", vetor[i]);
        }
        System.out.println(); // Adicionando uma quebra de linha para melhorar a legibilidade
    }

    public static void main(String[] args) {
        int[] vetor = {3, 4, 9, 2, 5, 8, 2, 1, 7, 4, 6, 2, 9, 8, 5, 1};

        System.out.println("Vetor antes da ordenação: ");
        imprimiVetor(vetor);
        System.out.println();

        quicksort(vetor, 0, vetor.length - 1);
        System.out.println("\nVetor depois da ordenação: ");
        imprimiVetor(vetor);
    }
}
