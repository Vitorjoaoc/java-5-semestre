/*4. Escreva a func ̧ao recursiva que retorna o maior elemento de um vetor v (de n elementos).  */

import java.util.Scanner;
public class App {

    public static int maior(int[] vetor, int indice){
        // Caso base: quando o índice chegar a 0, o elemento atual é o maior
        if (indice == 0) {
            return vetor[0];
        }

        // Chamada recursiva: encontre o maior elemento no restante do vetor
        int maiorNoRestante = maior(vetor, indice - 1);

        // Compare o maior elemento no restante com o elemento atual
        // e retorne o maior dos dois
        return Math.max(maiorNoRestante, vetor[indice]);
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int n;
        System.out.println("Digite o tamanho do vetor: ");
        n = sc.nextInt();
        int[] vetor = new int[n];


        for (int i = 0; i < vetor.length; i++) {
            System.out.printf("Insira o %d valor do vetor: ", i + 1);
            vetor[i] = sc.nextInt();
        }

        
        int maior = maior(vetor, n - 1);

        System.out.printf("O maior elemento do vetor é: %d", maior);

    }
}
''