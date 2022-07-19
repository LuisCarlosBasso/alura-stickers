import java.util.List;

public class FilmeUtils {

    public static void printarFilmes(List<Filme> filmes) {
        for (Filme filme : filmes) {
            System.out.println(AnsiConstants.ANSI_PURPLE + "Titulo: " +
                    AnsiConstants.ANSI_RESET +
                    AnsiConstants.ANSI_GREEN + filme.getTitulo() +
                    AnsiConstants.ANSI_RESET);

            System.out.println(AnsiConstants.ANSI_PURPLE + "Imagem: "+
                    AnsiConstants.ANSI_RESET +
                    filme.getImagem());

            System.out.println(AnsiConstants.ANSI_PURPLE + "Avaliação: " +
                    converterAvaliacao(filme.getAvaliacao()) + " ("+filme.getAvaliacao()+")" +
                    AnsiConstants.ANSI_RESET);

            System.out.println("-".repeat(20));
        }
    }

    private static String converterAvaliacao(String avaliacao) {
        double rating = Double.parseDouble(avaliacao);
        rating = Math.floor(rating);
        StringBuilder estrelas = new StringBuilder();
        estrelas.append(AnsiConstants.ANSI_YELLOW);
        for (int i = 0; i < 10; i++) {
            if (i < rating) {
                estrelas.append(AnsiConstants.ANSI_FILLED_STAR);
                continue;
            }
            estrelas.append(AnsiConstants.ANSI_EMPTY_STAR);
        }
        estrelas.append(AnsiConstants.ANSI_RESET);
        return estrelas.toString();
    }
}
