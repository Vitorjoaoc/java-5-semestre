import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ProblemaMochilaGuloso {

    static class Item implements Comparable<Item> {
        String nome;
        int peso;
        int valor;

        public Item(String nome, int peso, int valor) {
            this.nome = nome;
            this.peso = peso;
            this.valor = valor;
        }

        // Implementação da interface Comparable para ordenar os itens pela relação valor/peso
        @Override
        public int compareTo(Item outroItem) {
            double relacaoEsteItem = (double) this.valor / this.peso;
            double relacaoOutroItem = (double) outroItem.valor / outroItem.peso;

            // Ordem decrescente
            return Double.compare(relacaoOutroItem, relacaoEsteItem);
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

            Collections.sort(itens); // Ordena os itens pela relação valor/peso

            int capacidadeRestante = capacidadeMochila;
            int valorTotal = 0;
            List<Item> itensEscolhidos = new ArrayList<>();

            for (Item item : itens) {
                if (item.peso <= capacidadeRestante) {
                    itensEscolhidos.add(item);
                    valorTotal += item.valor;
                    capacidadeRestante -= item.peso;
                }
            }

            System.out.println("O valor máximo que pode ser colocado na mochila é: " + valorTotal);
            System.out.println("Itens escolhidos:");
            for (Item item : itensEscolhidos) {
                System.out.println("Nome: " + item.nome + ", Peso: " + item.peso + ", Valor: " + item.valor);
            }

        } catch (FileNotFoundException e) {
            System.err.println("Arquivo não encontrado.");
        }
    }
}
