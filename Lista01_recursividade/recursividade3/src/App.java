/*Um problema t ́ıpico em ciencia da computac ̧ ˆ ao consiste em converter um n  ̃ umero da sua  ́
forma decimal para a forma binaria. Por exemplo, o n  ́ umero 12 tem a sua representac ̧  ́ ao ̃
binaria igual a 1100. A forma mais simples de fazer isso  ́ e dividir o n  ́ umero sucessivamente  ́
por 2, onde o resto da i-esima divis  ́ ao vai ser o d  ̃  ́ıgito i do numero bin  ́ ario (da direita para a  ́
esquerda). */

import java.util.Scanner;
public class App {
    public static String conversao(int n){
        if(n == 0){
            System.out.println("0");
            return "0";
        }else if(n == 1){
        return "1";
    }else{
        int resto = n % 2;
        String parteInteira = conversao(n / 2);
        return parteInteira + resto;
    }
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n;

        System.out.println("Digite o número decimal: ");
        n = sc.nextInt();
        System.out.println("O número em binário é: " + conversao(n));;
    }
}
w