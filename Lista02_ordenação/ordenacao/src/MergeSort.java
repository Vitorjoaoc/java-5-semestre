public class MergeSort {

    public static void mergeSort(int[] array) {
        if (array.length <= 1) {
            return;
        }

        int meio = array.length / 2;
        int[] parteEsquerda = new int[meio];
        int[] parteDireita = new int[array.length - meio];

        // Copiar elementos para as partes esquerda e direita
        System.arraycopy(array, 0, parteEsquerda, 0, meio);
        System.arraycopy(array, meio, parteDireita, 0, array.length - meio);

        // Chamadas recursivas para as partes esquerda e direita
        mergeSort(parteEsquerda);
        mergeSort(parteDireita);

        // Merge das partes ordenadas
        merge(array, parteEsquerda, parteDireita);

        // Imprimir o estado do array após cada passo
        imprimirArray(array);
    }

    private static void merge(int[] array, int[] parteEsquerda, int[] parteDireita) {
        int i = 0; // Índice para a parte esquerda
        int j = 0; // Índice para a parte direita
        int k = 0; // Índice para o array principal

        // Mesclar as partes esquerda e direita no array principal
        while (i < parteEsquerda.length && j < parteDireita.length) {
            if (parteEsquerda[i] <= parteDireita[j]) {
                array[k] = parteEsquerda[i];
                i++;
            } else {
                array[k] = parteDireita[j];
                j++;
            }
            k++;
        }

        // Copiar os elementos restantes, se houver, das partes esquerda e direita
        System.arraycopy(parteEsquerda, i, array, k, parteEsquerda.length - i);
        System.arraycopy(parteDireita, j, array, k, parteDireita.length - j);
    }

    public static void main(String[] args) {
        int[] vetor = {3, 4, 9, 2, 5, 8, 2, 1, 7, 4, 6, 2, 9, 8, 5, 1};

        System.out.println("Array antes da ordenação:");
        imprimirArray(vetor);
        System.out.println();
        mergeSort(vetor);

        System.out.println("\nArray depois da ordenação:");
        imprimirArray(vetor);
    }

    private static void imprimirArray(int[] vetor) {
        for (int value : vetor) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
