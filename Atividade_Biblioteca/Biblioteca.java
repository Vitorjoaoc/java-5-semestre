import java.util.LinkedList;
import java.util.Scanner;
public class Biblioteca {
    
    //ORDENAÇÃO
    static void quicksort(LinkedList<Livro> lista, int baixo, int alto) {
        if (baixo < alto) {
            int indiceParticao = particao(lista, baixo, alto);

            // Recursivamente ordenar as sub-listas antes e depois da partição
            quicksort(lista, baixo, indiceParticao - 1);
            quicksort(lista, indiceParticao + 1, alto);
        }
    }

    static int particao(LinkedList<Livro> lista, int baixo, int alto) {
        Livro pivot = lista.get(alto);
        int i = baixo - 1;

        for (int j = baixo; j < alto; j++) {
            // Comparar os títulos dos livros
            if (lista.get(j).getTitulo().compareTo(pivot.getTitulo()) < 0) {
                i++;

                // Trocar os livros
                Livro temp = lista.get(i);
                lista.set(i, lista.get(j));
                lista.set(j, temp);
            }
        }

        // Trocar o pivot com o elemento na posição correta
        Livro temp = lista.get(i + 1);
        lista.set(i + 1, lista.get(alto));
        lista.set(alto, temp);

        return i + 1;
    }
    
public static void main(String[] args) {

    int escolha = 0;
    ListaLigada listaLivros = new ListaLigada();
    Scanner sc = new Scanner(System.in);
    String title = new String();
    String autor = new String();
    int numero;

    listaLivros.adicionar(new Livro("O pequeno principe","Jonas Mac", 12));
    listaLivros.adicionar(new Livro("A granola","Autor Two", 6));
    listaLivros.adicionar(new Livro("Clean Code","Herbert Tree", 4));

    System.out.println("BEM VINDO A BIBLIOTECA!");
    do{
        System.out.println("Escolha uma das opções a baixo: ");
        System.out.println("[1] Ordernar por Titulo");
        System.out.println("[2] Ordernar por Autor");
        System.out.println("[3] Adicionar um livro");
        System.out.println("[4] Remover um livro");
        System.out.println("[5] Pegar livro emprestado");
        System.out.println("[6] Devolver um livro");
        System.out.println("[7] Buscar livro por titulo");
        System.out.println("[8] Buscar livro por autor");
        System.out.println("[9] Finalizar");
        escolha = sc.nextInt();

        switch (escolha){
            case 1: // ordenar por titulo
            System.out.println("ordenei por titulo");
            break;

            case 2: //ordernar por autor
        
            break;

            case 3: // adicionar livro
            System.out.println("Adicionando um livro!");
        
            System.out.println("Titulo: ");
            title = sc.nextLine();
            title = sc.nextLine();

            System.out.println("Autor: ");
            autor = sc.nextLine();

            System.out.println("Numero: ");
            numero = sc.nextInt();
            listaLivros.adicionar(new Livro(title, autor, numero));
            System.out.println("Parabéns seu livro foi adicionado com sucesso!");
            
            break;

            case 4: // remover livro
            
            break;

            case 5: // emprestimo
            
            break;

            case 6: //devolução
            
            break;

            case 7:// busca titutlo
            
            break;

            case 8: // busca autor
           
            break;

            case 9://Finalizar
            System.out.println("Finalizando aplicativo...");
            break;
            
            default:// se a entrada for invalida ele solicita novamente
            System.out.println("Desculpe entrada INVALIDA. Por favor tente novamente!");
            escolha = 1;

      }
    }while(escolha > 0 && escolha < 9);


   // System.out.println("ANTES DE ORDENAR:");
    
    Elemento atual = listaLivros.getPrimeiro();
    for (int i = 0; i < listaLivros.getTamanho(); i++) {
        System.out.println(atual.book());
        atual = atual.getProximo();
    }
  
    sc.close();
   
}

}