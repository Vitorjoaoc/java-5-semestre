public class Livro {
   public String titulo;
   private String autor;
   private int numero;
   private boolean disponibilidade;
  
   

public Livro(String titulo, String autor, int numero) {
    this.titulo = titulo;
    this.autor = autor;
    this.numero = numero;
    this.disponibilidade = true;
}

public Livro(Livro livro){
    this.titulo = livro.getTitulo();
    this.autor = livro.getAutor();
    this.numero = livro.getNumero();
    this.disponibilidade = true;
}

public String getTitulo() {
    return titulo;
}

public void setTitulo(String titulo) {
    this.titulo = titulo;
}

public String getAutor() {
    return autor;
}

public void setAutor(String autor) {
    this.autor = autor;
}

public int getNumero() {
    return numero;
}

public void setNumero(int numero) {
    this.numero = numero;
}

public boolean getDisponibilidade() {
    return disponibilidade;
}

public void setDisponibilidade(boolean disponibilidade) {
    this.disponibilidade = disponibilidade;
}

@Override
public String toString(){
    return 
    "Titulo: " + titulo + '\n' +
    "Autor: " + autor + '\n' +
    "Numero: " + numero + '\n'+
    "Disponibilidade: " + disponibilidade +
    "\n------------------------------";
}


   
}
