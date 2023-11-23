public class MergeSort{
    
    // Método para realizar o merge de duas listas ordenadas
    static Elemento merge(Elemento esquerda, Elemento direita) {
        Elemento resultado = new Elemento(null);
        Elemento atual = resultado;

        while (esquerda != null && direita != null) {
            if (esquerda.getValor().titulo.compareTo(direita.getValor().titulo) < 0) {
                atual.setProximo(esquerda);
                esquerda = esquerda.getProximo();
            } else {
                atual.setProximo(direita);
                direita = direita.getProximo();
            }
            atual = atual.getProximo();
        }

        // Adiciona os elementos restantes, se houver
        if (esquerda != null) {
            atual.setProximo(esquerda);
        } else if (direita != null) {
            atual.setProximo(direita);
        }

        return resultado.getProximo();
    }

    // Método principal para realizar o merge sort na lista ligada
    static Elemento mergeSort(Elemento inicio) {
        if (inicio == null || inicio.getProximo() == null) {
            return inicio;
        }

        // Divide a lista em duas metades
        Elemento[] metades = dividirLista(inicio);

        // Recursivamente ordena as duas metades
        Elemento esquerda = mergeSort(metades[0]);
        Elemento direita = mergeSort(metades[1]);

        // Combina as duas metades ordenadas
        return merge(esquerda, direita);
    }

    // Método para dividir a lista em duas metades
    static Elemento[] dividirLista(Elemento inicio) {
        if (inicio == null || inicio.getProximo() == null) {
            return new Elemento[]{inicio, null};
        }

        Elemento lento = inicio;
        Elemento rapido = inicio.getProximo();

        while (rapido != null && rapido.getProximo() != null) {
            lento = lento.getProximo();
            rapido = rapido.getProximo().getProximo();
        }

        Elemento esquerda = inicio;
        Elemento direita = lento.getProximo();
        lento.setProximo(null);

        return new Elemento[]{esquerda, direita};
    }

}