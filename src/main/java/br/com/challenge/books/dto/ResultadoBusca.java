package br.com.challenge.books.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResultadoBusca {
    @JsonAlias("results")
    private List<LivroDTO> resultados;

    public List<LivroDTO> getResultados() {
        return resultados;
    }

    public void setResultados(List<LivroDTO> resultados) {
        this.resultados = resultados;
    }
}
