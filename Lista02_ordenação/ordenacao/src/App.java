/*Explique como seria possível melhorar o metodo bubblesort, armazenando não apenas a  ̃
informação da troca, mas também a posição do vetor onde ocorreu a troca. Implemente essa  ̃
modificac ̧ao.  ̃ */

public class App {

    static class Item {
        int key; 
    }

    static class PosicaoChave {
        int posicao;
        int chave;

        PosicaoChave(int posicao, int chave) {
            this.posicao = posicao;
            this.chave = chave;
        }
    }

    static void bubbleSort(PosicaoChave[] arr, int n) {
        PosicaoChave aux;
        boolean trocou = true;

        for (int i = 0; i < n - 1 && trocou; i++) {
            trocou = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j].chave > arr[j + 1].chave) {
                    trocou = true;
                    aux = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = aux;
                }
            }
        }
    }

    public static void main(String[] args) {
        // Exemplo de uso:
        PosicaoChave[] array = new PosicaoChave[5];
        for (int i = 0; i < 5; i++) {
            array[i] = new PosicaoChave(i, (int) (Math.random() * 100)); // Geração de chaves aleatórias para exemplo
        }

        System.out.println("Array antes da ordenação:");
        for (PosicaoChave pc : array) {
            System.out.print(pc.chave + " ");
        }

        bubbleSort(array, array.length);

        System.out.println("\nArray após a ordenação:");
        for (PosicaoChave pc : array) {
            System.out.print(pc.chave + " ");
        }

        System.out.println("\nPosições após a ordenação:");
        for (PosicaoChave pc : array) {
            System.out.print(pc.posicao + " ");
        }
    }
}


