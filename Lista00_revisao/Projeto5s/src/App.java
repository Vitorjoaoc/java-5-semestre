import java.util.Scanner;
import java.io.File;

public class App {


public static void main(String[] args)  {
        Scanner input = new Scanner(System.in);
        Agenda agenda = new Agenda();
        
        System.out.println("Iniciando seu aplicativo de agenda...\n\n");

        //Colocar o conteúdo do csv na lista em Agenda
        agenda.leiaAgenda("AgendaBD.csv");

        //Da as opção de escolha para cada ação do programa
        int resp = 0;
        do {
            System.out.println("DIGITE UM NÚMERO PARA NAVEGAR ENTRE AS OPÇÕES ABAIXO: ");
            System.out.println("[1] Adicionar contato");
            System.out.println("[2] Remover contato");
            System.out.println("[3] Buscar contato por nome");
            System.out.println("[4] Buscar contato por email");
            System.out.println("[5] Buscar contato por telefone");
            System.out.println("[6] Consultar tamanho da Agenda");     
            System.out.println("[7] Finalizar\n");
            resp = input.nextInt();

            //Ações para cada opção 
            switch (resp){
                  case 1:
                  //adicionar contato
                  agenda.adicionarContato();
                  break;

                  case 2:
                  //Remover contato
                  agenda.removerContato();
                  break;

                  case 3:
                  //busca contato pelo nome
                  agenda.buscaContatoNome();
                  break;

                  case 4:
                  //busca contato pelo e-mail
                  agenda.buscaContatoEmail();
                  break;

                  case 5:
                  //busca contato pelo telefone
                  agenda.buscaContatoTelefone();
                  break;

                  case 6:
                  //consulta tamanho da agenda
                  agenda.consutaTamnhoAgenda();
                  break;

                  case 7://Finalizar
                  agenda.salvaArquivo("AgendaBD.csv");
                  System.out.println("O aplicativo foi encerrado com sucesso!!!");
                  System.out.println("Volte sempre!!!");
                  break;
                  
                  default:// se a entrada for invalida ele solicita novamente
                  System.out.println("Desculpe entrada INVALIDA. Por favor tente novamente!");
                  resp = 1;

            }

        } while (resp > 0 && resp < 7);

        input.close();
    }

}