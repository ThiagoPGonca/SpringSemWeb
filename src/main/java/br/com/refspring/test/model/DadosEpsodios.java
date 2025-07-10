@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosEpsodios(@JsonAlias("Title") String titulo,
                            @JsonAlias("Episode") int numeroEps, 
                            @JsonAlias("imdbRating") String avaliacao, 
                            @JsonAlias("Released") String dataLancamento){

}