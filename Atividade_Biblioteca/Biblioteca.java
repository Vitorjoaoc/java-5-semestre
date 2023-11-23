import java.util.Scanner;
public class Biblioteca {
    
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
        System.out.println("[9] LISTAR LIVROS");
        System.out.println("[10] Finalizar");
        escolha = sc.nextInt();

        switch (escolha){
            case 1: // ordenar por titulo
            
            //listaLivros.ordenaPtitulo();
            System.out.println("Tamanho da lista: " + listaLivros.getTamanho());
            System.out.println("Lista antes de ordenar: ");
            listaLivros.imprimirLista();
            listaLivros.ordenaPautor();
            

            System.out.println("\nLista depois de ordenada:\n");
            listaLivros.imprimirLista();
            //listaLivros.listar(listaLivros);
            System.out.println("Tamanho da lista: " + listaLivros.getTamanho());

            System.out.printf("A lista esta ordenada pelo %s \n", listaLivros.getOrdenado());
            break;

            case 2: //ordernar por autor
            listaLivros.ordenaPautor();
            System.out.printf("A lista esta ordenada pelo %s \n", listaLivros.getOrdenado());
        
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
            System.out.println("Lista ordenada pelo: " + listaLivros.getOrdenado());
            listaLivros.imprimirLista();
            break;

            case 4: // remover livro
            System.out.println("Digite o nome do livro: ");
            title = sc.nextLine();
            title = sc.nextLine();
            listaLivros.remover(listaLivros.getLivroTitulo(title));
            break;

            case 5: // emprestimo
            System.out.println("Digite o nome do livro: ");
            title = sc.nextLine();
            title = sc.nextLine();
            listaLivros.emprestimo(title);
            break;

            case 6: //devolução
            System.out.println("Digite o nome do livro: ");
            title = sc.nextLine();
            title = sc.nextLine();
            listaLivros.devolucao(title);
            break;

            case 7:// busca titutlo
            
            break;

            case 8: // busca autor
           
            break;

            case 9://Listar livros
            listaLivros.listar(listaLivros);
            break;

            case 10://Finalizar
            System.out.println("Finalizando aplicativo...");
            break;
            
            default:// se a entrada for invalida ele solicita novamente
            System.out.println("Desculpe entrada INVALIDA. Por favor tente novamente!");
            escolha = 1;

      }
    }while(escolha > 0 && escolha < 10);


   // System.out.println("ANTES DE ORDENAR:");

  
    sc.close();
   
}

}