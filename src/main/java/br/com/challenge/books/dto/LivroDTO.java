package br.com.challenge.books.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LivroDTO {
    @JsonAlias("title")
    private String titulo;

    @JsonAlias("languages")
    private List<String> idioma;

    @JsonAlias("download_count")
    private Integer download;

    @JsonAlias("authors")
    private List<AutorDTO> autores;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<String> getIdioma() {
        return idioma;
    }

    public void setIdioma(List<String> idioma) {
        this.idioma = idioma;
    }

    public Integer getDownload() {
        return download;
    }

    public void setDownload(Integer download) {
        this.download = download;
    }

    public List<AutorDTO> getAutores() {
        return autores;
    }

    public void setAutores(List<AutorDTO> autores) {
        this.autores = autores;
    }

    @Override
    public String toString() {
        return "DadosLivro{" +
                "titulo='" + titulo + '\'' +
                ", idioma=" + idioma +
                ", download=" + download +
                '}';
    }
}
