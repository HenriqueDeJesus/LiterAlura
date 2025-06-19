package br.com.challenge.books.principal;

import br.com.challenge.books.dto.LivroDTO;
import br.com.challenge.books.dto.ResultadoBusca;
import br.com.challenge.books.model.Autor;
import br.com.challenge.books.model.Livro;
import br.com.challenge.books.repository.AutorRepository;
import br.com.challenge.books.repository.LivroRepository;
import br.com.challenge.books.service.ConsumoApi;
import br.com.challenge.books.service.ConverteDados;

import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Scanner;

public class Principal {

    private Scanner leitura = new Scanner(System.in);
    private ConsumoApi consumo = new ConsumoApi();
    private ConverteDados conversor = new ConverteDados();
    private final String ENDERECO = "https://gutendex.com/books/?search=";
    private LivroRepository repositorioLivro;
    private AutorRepository repositorioAutor;

    public Principal(LivroRepository repositorioLivro, AutorRepository autorRepositorio){
        this.repositorioLivro = repositorioLivro;
        this.repositorioAutor = autorRepositorio;
    }

    public void exibiMenu() {
        var opcao = -1;
        while (opcao != 0) {
            var menu = """
                    ----------------------------------
                    Escolha o número de sua opção
                    1 - Buscar livro
                    2 - Listar livros registrados
                    3 - Listar autores registrados
                    4 - Listar autores vivos em um determinado ano
                    5 - Listar livros em um determinado idioma
                    6 - Estatísticas dos downloads dos livros
                    7 - Top 10 livros baixados
                    8 - Buscar autor por nome
                    9 - Listar autores por ano de nascimento
                    10 - Listar autores por ano de falecimento
                    
                    0 - Sair                                 
                    """;

            System.out.println(menu);
            opcao = leitura.nextInt();
            leitura.nextLine();

            switch (opcao) {
                case 1:
                    buscarLivroWeb();
                    break;

                case 2:
                    listaLivros();
                    break;

                case 3:
                    listarAutores();
                    break;

                case 4:
                    listarAutoresVivosNoAno();
                    break;

                case 5:
                    listarLivrosPorIdioma();
                    break;

                case 6:
                    estatisticasDownloads();
                    break;

                case 7:
                    listarTop10LivrosMaisBaixados();
                    break;

                case 8:
                    buscarAutorPorNome();
                    break;

                case 9:
                    listarAutoresPorAnoNascimento();
                    break;

                case 10:
                    listarAutoresPorAnoFalecimento();
                    break;
            }
        }
    }

    private void buscarLivroWeb() {
        LivroDTO dados = getDadosLivro();
        Livro livro = new Livro(dados);
        repositorioLivro.save(livro);
        System.out.println("\nLivro salvo com sucesso:");
        System.out.println(livro);
    }

    private LivroDTO getDadosLivro() {
        System.out.println("Digite o nome do livro para busca");
        var nomeLivro = leitura.nextLine();
        var json = consumo.obterDados(ENDERECO + nomeLivro.replace(" ", "+"));

        ResultadoBusca resultado = conversor.obterDados(json, ResultadoBusca.class);

        if (resultado.getResultados() != null && !resultado.getResultados().isEmpty()) {
            LivroDTO livro = resultado.getResultados().get(0);
            System.out.println(livro);
            return livro;
        } else {
            System.out.println("Livro não encontrado.");
            return null;
        }
    }

    private void listaLivros(){
        List<Livro> livros = repositorioLivro.findAll();
        if (livros.isEmpty()){
            System.out.println("Nenhum Livro encontrado");
        } else {
            livros.forEach(System.out::println);
        }
    }

    private void listarAutores(){
        List<Autor> autores = repositorioAutor.findAll();
        if (autores.isEmpty()){
            System.out.println("Nenhum autor encontrado");
        } else {
            autores.forEach(System.out::println);
        }
    }

    private void listarAutoresVivosNoAno() {
        System.out.println("Insira o ano que deseja pesquisar: ");
        int ano = leitura.nextInt();
        leitura.nextLine();

        List<Autor> autoresVivos = repositorioAutor.buscarAutoresVivosNoAno(ano);

        if (autoresVivos.isEmpty()) {
            System.out.println("Nenhum autor estava vivo nesse ano.");
        } else {
            autoresVivos.forEach(System.out::println);
        }
    }

    private void listarLivrosPorIdioma() {
        System.out.println("Insira o idioma para realizar a busca:");
        System.out.println("es - espanhol");
        System.out.println("en - inglês");
        System.out.println("fr - francês");
        System.out.println("pt - português");
        String idioma = leitura.nextLine();

        List<Livro> livrosPorIdioma = repositorioLivro.findByIdiomaContainingIgnoreCase(idioma);

        if (livrosPorIdioma.isEmpty()) {
            System.out.println("Nenhum livro encontrado com o idioma: " + idioma);
        } else {
            livrosPorIdioma.forEach(System.out::println);
        }
    }

    private void estatisticasDownloads() {
        List<Livro> livros = repositorioLivro.findAll();

        DoubleSummaryStatistics stats = livros.stream()
                .mapToDouble(l -> l.getDownload() != null ? l.getDownload() : 0)
                .summaryStatistics();

        System.out.println("Estatísticas dos downloads dos livros:");
        System.out.println("Total de livros: " + stats.getCount());
        System.out.println("Mínimo de downloads: " + stats.getMin());
        System.out.println("Máximo de downloads: " + stats.getMax());
        System.out.println("Média de downloads: " + stats.getAverage());
        System.out.println("Soma total de downloads: " + stats.getSum());
    }

    private void listarTop10LivrosMaisBaixados() {
        List<Livro> top10 = repositorioLivro.findTop10ByOrderByDownloadDesc();

        if (top10.isEmpty()) {
            System.out.println("Nenhum livro encontrado.");
        } else {
            System.out.println("Top 10 livros mais baixados:");
            top10.forEach(System.out::println);
        }
    }

    private void buscarAutorPorNome() {
        System.out.println("Digite o nome do autor para busca: ");
        String nome = leitura.nextLine();

        List<Autor> autores = repositorioAutor.findByNomeContainingIgnoreCase(nome);

        if (autores.isEmpty()) {
            System.out.println("Nenhum autor encontrado com o nome: " + nome);
        } else {
            autores.forEach(System.out::println);
        }
    }

    private void listarAutoresPorAnoNascimento() {
        System.out.println("Digite o ano mínimo de nascimento: ");
        int ano = leitura.nextInt();
        leitura.nextLine();

        List<Autor> autores = repositorioAutor.findByAnoDeNascimento(ano);

        if (autores.isEmpty()) {
            System.out.println("Nenhum autor encontrado nascido a partir de " + ano);
        } else {
            autores.forEach(System.out::println);
        }
    }

    private void listarAutoresPorAnoFalecimento() {
        System.out.println("Digite o ano máximo de falecimento: ");
        int ano = leitura.nextInt();
        leitura.nextLine();

        List<Autor> autores = repositorioAutor.findByAnoDeFalecimento(ano);

        if (autores.isEmpty()) {
            System.out.println("Nenhum autor encontrado falecido até " + ano);
        } else {
            autores.forEach(System.out::println);
        }
    }
}
