import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProblemaMochilaDivisaoConquista {

    static class Item {
        String nome;
        int peso;
        int valor;

        public Item(String nome, int peso, int valor) {
            this.nome = nome;
            this.peso = peso;
            this.valor = valor;
        }
    }

    public static int mochilaDivisaoConquista(List<Item> itens, int capacidade) {
        return mochilaRecursiva(itens, itens.size() - 1, capacidade);
    }

    private static int mochilaRecursiva(List<Item> itens, int index, int capacidade) {
        if (index < 0 || capacidade == 0) {
            return 0;
        }

        Item currentItem = itens.get(index);

        if (currentItem.peso > capacidade) {
            return mochilaRecursiva(itens, index - 1, capacidade);
        } else {
            int incluirItem = currentItem.valor + mochilaRecursiva(itens, index - 1, capacidade - currentItem.peso);
            int excluirItem = mochilaRecursiva(itens, index - 1, capacidade);
            return Math.max(incluirItem, excluirItem);
        }
    }

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("KNAPDATA40.txt"));

            int capacidadeMochila = Integer.parseInt(scanner.nextLine().trim());
            int totalItens = Integer.parseInt(scanner.nextLine().trim());

            List<Item> itens = new ArrayList<>();

            for (int i = 0; i < totalItens; i++) {
                String[] linha = scanner.nextLine().split(",");
                String nomeItem = linha[0].trim();
                int pesoItem = Integer.parseInt(linha[1].trim());
                int valorItem = Integer.parseInt(linha[2].trim());

                itens.add(new Item(nomeItem, pesoItem, valorItem));
            }

            scanner.close();

            int valorMaximo = mochilaDivisaoConquista(itens, capacidadeMochila);

            System.out.println("O valor máximo que pode ser colocado na mochila é: " + valorMaximo);

        } catch (FileNotFoundException e) {
            System.err.println("Arquivo não encontrado.");
        }
    }
}