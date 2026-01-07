import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArquivoService {
    // Constantes para os nomes dos arquivos
    private static final String ARQUIVO_LIVROS = "meus_livros.txt";
    private static final String ARQUIVO_FILMES = "meus_filmes.txt";
    private static final String ARQUIVO_JOGOS = "meus_jogos.txt";
    private static final String ARQUIVO_SERIES = "minhas_series.txt";

    // --- MÉTODOS PARA SALVAR ---

    public void salvarLivro(Livro livro) {
        salvarGenerico(ARQUIVO_LIVROS, livro.getTitulo());
    }

    public void salvarFilme(Filme filme) {
        salvarGenerico(ARQUIVO_FILMES, filme.getTitulo());
    }

    public void salvarJogo(Jogo jogo) {
        salvarGenerico(ARQUIVO_JOGOS, jogo.getTitulo());
    }

    public void salvarSerie(Serie serie) {
        salvarGenerico(ARQUIVO_SERIES, serie.getTitulo());
    }

    // Método auxiliar para não repetir o código de salvar (DRY - Don't Repeat Yourself)
    private void salvarGenerico(String nomeArquivo, String titulo) {
        try {
            FileWriter fw = new FileWriter(nomeArquivo, true);
            BufferedWriter writer = new BufferedWriter(fw);
            writer.write(titulo);
            writer.newLine();
            writer.newLine(); // Linha vazia separadora
            writer.close();
        } catch (Exception e) {
            System.out.println("Erro ao salvar no arquivo " + nomeArquivo + ": " + e.getMessage());
        }
    }

    // --- MÉTODOS PARA LER ---

    public List<Livro> lerLivros() {
        ArrayList<Livro> lista = new ArrayList<>();
        File arquivo = new File(ARQUIVO_LIVROS);
        if (!arquivo.exists()) return lista;

        try (Scanner sc = new Scanner(Paths.get(ARQUIVO_LIVROS))) {
            while (sc.hasNextLine()) {
                String linha = sc.nextLine();
                if (!linha.trim().isEmpty()) {
                    lista.add(new Livro(linha));
                }
            }
        } catch (Exception e) { System.out.println("Erro ao ler livros."); }
        return lista;
    }

    public List<Filme> lerFilmes() {
        ArrayList<Filme> lista = new ArrayList<>();
        File arquivo = new File(ARQUIVO_FILMES);
        if (!arquivo.exists()) return lista;

        try (Scanner sc = new Scanner(Paths.get(ARQUIVO_FILMES))) {
            while (sc.hasNextLine()) {
                String linha = sc.nextLine();
                if (!linha.trim().isEmpty()) {
                    lista.add(new Filme(linha));
                }
            }
        } catch (Exception e) { System.out.println("Erro ao ler filmes."); }
        return lista;
    }

    public List<Jogo> lerJogos() {
        ArrayList<Jogo> lista = new ArrayList<>();
        File arquivo = new File(ARQUIVO_JOGOS);
        if (!arquivo.exists()) return lista;

        try (Scanner sc = new Scanner(Paths.get(ARQUIVO_JOGOS))) {
            while (sc.hasNextLine()) {
                String linha = sc.nextLine();
                if (!linha.trim().isEmpty()) {
                    lista.add(new Jogo(linha));
                }
            }
        } catch (Exception e) { System.out.println("Erro ao ler jogos."); }
        return lista;
    }

    public List<Serie> lerSeries() {
        ArrayList<Serie> lista = new ArrayList<>();
        File arquivo = new File(ARQUIVO_SERIES);
        if (!arquivo.exists()) return lista;

        try (Scanner sc = new Scanner(Paths.get(ARQUIVO_SERIES))) {
            while (sc.hasNextLine()) {
                String linha = sc.nextLine();
                if (!linha.trim().isEmpty()) {
                    lista.add(new Serie(linha));
                }
            }
        } catch (Exception e) { System.out.println("Erro ao ler séries."); }
        return lista;
    }
}