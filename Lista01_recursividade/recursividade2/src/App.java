/*2. Dado n e uma sequencia com n n ˆ umeros inteiros, imprimir a sequ encia na ordem inversa a  que foi lida, sem usar um vetor. */

import java.util.Scanner;
public class App {
    public static void inversa(int n){
       // Caso base: quando n for igual a 1, imprima o número.
        Scanner sc = new Scanner(System.in);
       if (n == 1) {
        int numero = sc.nextInt();
        System.out.println(numero);
    } else {
        // Caso recursivo: leia um número e, em seguida, chame a função recursiva com n-1.
        int numero = sc.nextInt();
        inversa(n - 1);
        System.out.println(numero);
    }
    
    }


    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int n;

        System.out.println("Digite a quantidade de números: ");
        n = sc.nextInt();

        System.out.println("Digite a sequencia: ");
        
        inversa(n);



    }
}
