/*1. Implemente uma func ̧ao recursiva que, dados dois n  ̃ umeros inteiros x e n, calcula o valor de x^n
. */

import java.util.Scanner;

public class App {

    public static int potencia(int x, int n) {
       if(n == 0){
        return 1;
       }
       
       return x * potencia(x, n - 1 );
    }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int x,n;

        System.out.println("Defina um valor para X: ");
        x = sc.nextInt();

        System.out.println("Defina um valor para N: ");
        n = sc.nextInt();

        System.out.printf("O valor de X é: %d\nO valor de n é: %d\n", x, n);

        System.out.printf("O resultado da potencia entre eles é de: %d", potencia(x, n));


    }
}
