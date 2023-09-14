//Criando a Classe Contato
public class Contato {
    String nome;
    String email;
    String telefone;

    public String getNome(){
        return this.nome;
    }

    private void setNome(String n){
        this.nome = n;
    }

    public String getEmail(){
        return this.email;
    }

    private void setEmail(String e){
        this.email = e;
    }

    public String getTelefone(){
        return this.telefone;
    }

    public void setTelefone(String t){
        this.telefone = t;
    }


   void criaContato(String n, String e, String t){
        this.setNome(n);
        this.setEmail(e);
        this.setTelefone(t);
    }


}
