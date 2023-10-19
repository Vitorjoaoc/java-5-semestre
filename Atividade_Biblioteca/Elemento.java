public class Elemento {
    public Livro valor;
    private Elemento proximo;

    public Elemento(Livro newValor) {
        this.valor = newValor;
    }

    public Livro getValor() {
        return valor;
    }

    public String getTitulo() {
        return valor.getTitulo();
    }

    public void setValor(Livro valor) {
        this.valor = valor;
    }

    public Elemento getProximo() {
        return proximo;
    }

    public void setProximo(Elemento proximo) {
        this.proximo = proximo;
    }


    public String book(){
        return valor.toString();
    }
}
