package br.com.refspring.test.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosEpsodios(@JsonAlias("Title") String titulo,
                            @JsonAlias("Episode") int numeroEps, 
                            @JsonAlias("imdbRating") String avaliacao, 
                            @JsonAlias("Released") String dataLancamento){

}