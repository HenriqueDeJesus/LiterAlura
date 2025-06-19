package br.com.challenge.books.model;

import br.com.challenge.books.dto.LivroDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DadosResultado {
    private List<LivroDTO> results;

    public List<LivroDTO> getResults() {
        return results;
    }

    public void setResults(List<LivroDTO> results) {
        this.results = results;
    }
}
