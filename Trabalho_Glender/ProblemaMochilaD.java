import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProblemaMochilaD {

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

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("KNAPDATA40.txt"));

            int capacidadeMochila = Integer.parseInt(scanner.nextLine().trim());
            int totalItens = Integer.parseInt(scanner.nextLine().trim());

            Item[] itens = new Item[totalItens];

            for (int i = 0; i < totalItens; i++) {
                String[] linha = scanner.nextLine().split(",");
                String nomeItem = linha[0].trim();
                int pesoItem = Integer.parseInt(linha[1].trim());
                int valorItem = Integer.parseInt(linha[2].trim());

                itens[i] = new Item(nomeItem, pesoItem, valorItem);
            }

            scanner.close();

            int[][] tabela = new int[totalItens + 1][capacidadeMochila + 1];

            for (int i = 0; i <= totalItens; i++) {
                for (int w = 0; w <= capacidadeMochila; w++) {
                    if (i == 0 || w == 0) {
                        tabela[i][w] = 0;
                    } else if (itens[i - 1].peso <= w) {
                        tabela[i][w] = Math.max(itens[i - 1].valor + tabela[i - 1][w - itens[i - 1].peso], tabela[i - 1][w]);
                    } else {
                        tabela[i][w] = tabela[i - 1][w];
                    }
                }
            }

            int resultado = tabela[totalItens][capacidadeMochila];
            System.out.println("O valor máximo que pode ser colocado na mochila é: " + resultado);

            List<Item> itensEscolhidos = obterItensEscolhidos(tabela, itens, capacidadeMochila, totalItens);
            System.out.println("Itens escolhidos:");
            for (Item item : itensEscolhidos) {
                System.out.println("Nome: " + item.nome + ", Peso: " + item.peso + ", Valor: " + item.valor);
            }

        } catch (FileNotFoundException e) {
            System.err.println("Arquivo não encontrado.");
        }
    }

    private static List<Item> obterItensEscolhidos(int[][] tabela, Item[] itens, int capacidade, int totalItens) {
        List<Item> itensEscolhidos = new ArrayList<>();
        int w = capacidade;
        for (int i = totalItens; i > 0 && w > 0; i--) {
            if (tabela[i][w] != tabela[i - 1][w]) {
                itensEscolhidos.add(itens[i - 1]);
                w -= itens[i - 1].peso;
            }
        }
        return itensEscolhidos;
    }
}
