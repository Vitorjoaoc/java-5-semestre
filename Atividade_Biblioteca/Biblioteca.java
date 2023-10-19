import java.util.LinkedList;
public class Biblioteca {
    //FUNÇÕES
    public void ordenaPnome(LinkedList<Livro> lista, int primeiro, int ultimo){
        quicksort(lista, primeiro, ultimo);

        //oredena pelo nome
    }
    
    public void ordenaPautor(){
        //orddena pelo autor
    }

    public void emprestimo(String titulo){
        //empresta livro e muda a disponibilidade
       
    }

    public void devolucao(){
        //devolve livro e muda a disponibilidade
    }

    public String buscaTitulo(String titulo){
        //busca pelo titulo
        return titulo;
    }

    public String buscaAutor(String autor){
        //busca pelo autor
        return autor;
    }
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

    ListaLigada listaLivros = new ListaLigada();

    listaLivros.adicionar(new Livro("O pequeno principe","Jonas Mac", 12));
    listaLivros.adicionar(new Livro("A granola","Autor Two", 6));
    listaLivros.adicionar(new Livro("Clean Code","Herbert Tree", 4));


   // System.out.println("ANTES DE ORDENAR:");
    

    listaLivros.emprestimo("A granola");
    listaLivros.devolucao("A granola");
    listaLivros.devolucao("A granola");
   

   
}

}