package br.com.challenge.books.model;

import br.com.challenge.books.dto.AutorDTO;
import br.com.challenge.books.dto.LivroDTO;
import jakarta.persistence.*;

@Entity
@Table(name = "livros")
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true)
    private String titulo;
    private String idioma;
    private Integer download;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "autor_id")
    private Autor autor;

    public Livro(){}

    public Livro(LivroDTO dadosLivro){
        this.titulo = dadosLivro.getTitulo();
        this.idioma = dadosLivro.getIdioma().isEmpty() ? "Indefinido" : dadosLivro.getIdioma().get(0);;
        this.download = dadosLivro.getDownload();

        if (dadosLivro.getAutores() != null && !dadosLivro.getAutores().isEmpty()) {
            AutorDTO autorDTO = dadosLivro.getAutores().get(0); // pegando o primeiro autor
            this.autor = new Autor(
                    new DadosAutor(
                            autorDTO.getNome(),
                            autorDTO.getAnoDeNascimento(),
                            autorDTO.getAnoDeFalecimento()
                    )
            );
        }
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public Integer getDownload() {
        return download;
    }

    public void setDownload(Integer download) {
        this.download = download;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "----- Livro ----- " + '\n' +
                "Título: " + titulo + '\n' +
                "Autor: " + (autor != null ? autor.getNome() : "Autor não informado") + '\n' +
                "Idioma: " + idioma + '\n' +
                "Número de downloads: " + download + '\n' +
                "-----------------" + '\n';
    }
}
