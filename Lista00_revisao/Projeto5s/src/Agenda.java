import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.util.HashSet;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Agenda {
    //Atributos
    List <Contato> listaContato = new ArrayList<>();
    
    int tamanho;
    
    //Metodos
    public void leiaAgenda(String nomeArquivo){
       try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(",");
                if (dados.length == 3) {
                    String nome = dados[0].trim();
                    String email = dados[1].trim();
                    String telefone = dados[2].trim();

                    Contato contato = new Contato();
                    contato.criaContato(nome, email, telefone);
                    listaContato.add(contato);

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
       }
    }


    public void adicionarContato(){
        Contato c1 = new Contato();
        String nome = new String();
        String email = new String();
        String tel;
        Scanner input = new Scanner(System.in);
        System.out.println("Adicionando um novo Contato\n");
        System.out.println("Digite o Nome: ");
        nome = input.nextLine();

        System.out.println("Digite o E-mail: ");
        email = input.nextLine();

        System.out.println("Digite o Telefone: ");
        tel = input.nextLine();
        
        c1.criaContato(nome, email, tel);
        this.listaContato.add(c1);
        
        
        System.out.println("Contato adicionado com sucesso!\n");
        
    }

    void removerContato(){
        String nome;
        Scanner input = new Scanner(System.in);
        System.out.println("Digite o nome do contato que deseja remover: ");
        nome = input.nextLine();
        for (int i = 0; i < listaContato.size(); i++) {
            if(listaContato.get(i).nome.equals(nome)){
                listaContato.remove(i);
                tamanho = listaContato.size();
                System.out.println("Contato removido com Sucesso!");
                System.out.printf("Sua Agenda tem agora %d contatos! \n\n", tamanho);
                break;
            }else if(listaContato.get(i).nome!= nome && i == listaContato.size() - 1){
                System.out.println("A operação falhou! O contato não foi encontrado.\n\n");
            }
            
        }
            
        }

    void buscaContatoNome(){
        String nome;
        Scanner input = new Scanner(System.in);
        System.out.println("Digite o nome do contato que deseja buscar: ");
        nome = input.nextLine();
        for (int i = 0; i < listaContato.size(); i++) {
            if (listaContato.get(i).nome.equals(nome)){
                System.out.println("Contato encontrado: ");
                System.out.printf("Nome: %s\n", listaContato.get(i).nome);
                System.out.printf("E-mail: %s\n", listaContato.get(i).email);
                System.out.printf("Telefone: %d\n\n", listaContato.get(i).telefone);
                break;
            }else if(listaContato.get(i).nome!= nome && i == listaContato.size() - 1){
                System.out.printf("Desculpe não consegui encontrar nenhum contato com o nome: %s\n\n", nome);
            }
        }

    }

    void buscaContatoEmail(){
        String email;
        Scanner input = new Scanner(System.in);
        System.out.println("Digite o email do contato que deseja buscar: ");
        email = input.nextLine();
        for (int i = 0; i < listaContato.size(); i++) {
            if (listaContato.get(i).email.equals(email)){
                System.out.println("Contato encontrado: ");
                System.out.printf("Nome: %s\n", listaContato.get(i).nome);
                System.out.printf("E-mail: %s\n", listaContato.get(i).email);
                System.out.printf("Telefone: %s\n\n", listaContato.get(i).telefone);
                break;
            }else if(listaContato.get(i).email!= email && i == listaContato.size() - 1){
                System.out.printf("Desculpe não consegui encontrar nenhum contato com o e-mail: %s\n\n", email);
            }
        }
        
    }

    void buscaContatoTelefone(){
        String telefone;
        Scanner input = new Scanner(System.in);
        System.out.println("Digite o telefone do contato que deseja buscar: ");
        telefone = input.nextLine();
        for (int i = 0; i < listaContato.size(); i++) {
            if (listaContato.get(i).telefone == telefone){
                System.out.println("Contato encontrado: ");
                System.out.printf("Nome: %s\n", listaContato.get(i).nome);
                System.out.printf("E-mail: %s\n", listaContato.get(i).email);
                System.out.printf("Telefone: %s\n\n", listaContato.get(i).telefone);
                break;
            }else if(listaContato.get(i).telefone!= telefone && i == listaContato.size() - 1){
                System.out.printf("Desculpe não consegui encontrar nenhum contato com o telefone: %s\n\n", telefone);
            }
        }

    }

    void consutaTamnhoAgenda(){
        
        int tamanho = listaContato.size();
        System.out.printf("Você tem %d contatos cadastrados! \n\n", tamanho);
    
    }

    public void salvaArquivo(String nomeArquivo){
        try(FileWriter writer = new FileWriter(nomeArquivo, true)) {
            
            //Escreve os dados no csv
            for (Contato contato : listaContato) {
                writer.append(contato.getNome())
                    .append(",")
                    .append(contato.getEmail())
                    .append(",")
                    .append(contato.getTelefone())
                    .append("\n");
            }
            System.out.printf("Os contatos foram salvos em %s\n", nomeArquivo);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void mostrarAgendaCompleta(){
        
    }
}
