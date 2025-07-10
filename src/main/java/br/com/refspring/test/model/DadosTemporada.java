package br.com.refspring.test.model;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosTemporada(@JsonAlias("Season") Integer numero,@JsonAlias("Episodes") List<DadosEpsodios> episodio) {

}