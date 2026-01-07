import java.util.Scanner;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArquivoService arquivoService = new ArquivoService();

        while (true) {
            exibirMenu();
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            if (opcao == 1) { // ADICIONAR LIVRO
                System.out.print("Digite o nome do livro: ");
                String busca = scanner.nextLine();
                arquivoService.salvarLivro(new Livro(busca.toUpperCase()));
                System.out.println("Livro adicionado!");

            } else if (opcao == 2) { // VER LIVROS
                List<Livro> lista = arquivoService.lerLivros();
                System.out.println("\n--- Livros à Ler ---");
                for (Livro l : lista) {
                    System.out.println("Título: " + l.getTitulo());
                }

            } else if (opcao == 3) { // ADICIONAR FILME
                System.out.print("Digite o nome do Filme: ");
                String busca = scanner.nextLine();
                arquivoService.salvarFilme(new Filme(busca.toUpperCase()));
                System.out.println("Filme adicionado!");

            } else if (opcao == 4) { // VER FILMES
                List<Filme> lista = arquivoService.lerFilmes();
                System.out.println("\n--- Filmes à assistir ---");
                for (Filme f : lista) {
                    System.out.println("Título: " + f.getTitulo());
                }

            } else if (opcao == 5) { // ADICIONAR SERIE
                System.out.print("Digite o nome da Série: ");
                String busca = scanner.nextLine();
                arquivoService.salvarSerie(new Serie(busca.toUpperCase()));
                System.out.println("Série adicionada!");

            } else if (opcao == 6) { // VER SERIES
                List<Serie> lista = arquivoService.lerSeries();
                System.out.println("\n--- Séries à assistir ---");
                for (Serie s : lista) {
                    System.out.println("Título: " + s.getTitulo());
                }

            } else if (opcao == 7) { // ADICIONAR JOGO
                System.out.print("Digite o nome do Jogo: ");
                String busca = scanner.nextLine();
                arquivoService.salvarJogo(new Jogo(busca.toUpperCase()));
                System.out.println("Jogo adicionado!");

            } else if (opcao == 8) { // VER JOGOS
                List<Jogo> lista = arquivoService.lerJogos();
                System.out.println("\n--- Jogos à jogar ---");
                for (Jogo j : lista) {
                    System.out.println("Título: " + j.getTitulo());
                }

            } else if (opcao == 0) { // SAIR
                System.out.println("Saindo... Até logo!");
                break;
            } else {
                System.out.println("Opção inválida!");
            }
        }
    }

    public static void exibirMenu() {
        System.out.println("\n--- LaterAdd ---");
        System.out.println("1. Adicionar Livro | 2. Ver Meus Livros");
        System.out.println("3. Adicionar Filme | 4. Ver Meus Filmes");
        System.out.println("5. Adicionar Serie | 6. Ver Minhas Series");
        System.out.println("7. Adicionar Jogo  | 8. Ver Meus Jogos");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }
}