package br.com.refspring.test.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosSeries(@JsonAlias("Title") String titulo,
                          @JsonAlias("totalSeasons") int totalTemporadas,
                          @JsonAlias("imdbRating")String avaliação) {

}
