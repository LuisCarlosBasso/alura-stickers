import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    private static List<Filme> filmes;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        filmes = buscarMelhoresFilmes();
        int opcao = mostrarMenu(sc);
        switch (opcao) {
            case 1 -> printarMelhoresFilmes();
            case 2 -> {
                sc.nextLine();
                avaliarFilme(sc);
            }
            default -> {
                System.out.println("Essa opção não existe");
                main(args);
            }
        }
        sc.close();
    }

    private static int mostrarMenu(Scanner sc) {
        System.out.println("Escolha uma das opções abaixo");
        System.out.println("1 - Ver os 250 melhores filmes");
        System.out.println("2 - Avaliar um filme");
        System.out.print("Digite a opção: ");
        return sc.nextInt();
    }

    private static void printarMelhoresFilmes() {
        FilmeUtils.printarFilmes(filmes);
    }

    private static List<Filme> buscarMelhoresFilmes() {
        try {
            String url = "https://api.mocki.io/v2/549a5d8b";
            String body = HttpUtils.sendGet(url).body();
            return JsonParser.parse(body, ApiResponse.class).getItems();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    private static void avaliarFilme(Scanner sc) {
        String nomeFilme = solicitarNomeFilme(sc);
        Filme filmeFiltrado = filmes.stream()
                .filter(filme -> filme.getTitulo().equalsIgnoreCase(nomeFilme))
                .findFirst()
                .orElse(null);
        if (Objects.nonNull(filmeFiltrado)) {
            System.out.print("Digite a nota do filme: ");
            int nota = sc.nextInt();
            System.out.println("Você avaliou " + nomeFilme + " com nota " + nota);
        } else {
            System.out.println("Esse filme não existe");
            avaliarFilme(sc);
        }
    }

    private static String solicitarNomeFilme(Scanner sc) {
        System.out.print("Digite o nome do filme que deseja avaliar: ");
        return sc.nextLine();
    }


}
