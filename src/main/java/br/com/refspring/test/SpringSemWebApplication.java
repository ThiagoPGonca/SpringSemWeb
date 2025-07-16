package br.com.refspring.test;

import br.com.refspring.test.model.DadosEpsodios;
import br.com.refspring.test.model.DadosSeries;
import br.com.refspring.test.model.DadosTemporada;
import br.com.refspring.test.service.APIConsumer;
import br.com.refspring.test.service.ConvertData;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringSemWebApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringSemWebApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Spring Sem Web");
        String url = "https://www.omdbapi.com/?t=gilmore+girls&apikey=96feb9b7";
        var consumer = new APIConsumer();
        var json = consumer.consumeAPI(url);
        System.out.println(json);
        ConvertData conversor = new ConvertData();
        DadosSeries dados = conversor.obterDados(json, DadosSeries.class);
        System.out.println(dados);

        json = consumer.consumeAPI("https://www.omdbapi.com/?t=gilmore+girls&Season=1&Episode=2&apikey=96feb9b7"); //add url com episodio
        DadosEpsodios dadosEps = conversor.obterDados(json, DadosEpsodios.class);
        System.out.print(dadosEps);


        List<DadosTemporada> temporadas = new ArrayList<>();
        for(int i = 1; i<dados.totalTemporadas(); i++) {
            json = consumer.consumeAPI("https://www.omdbapi.com/?t=gilmore+girls&Season=" + i + "&apikey=96feb9b7"); //dentro da URL trocar o numero de temporadas por i
            DadosTemporada dadosTemporada = conversor.obterDados(json, DadosTemporada.class);
            temporadas.add(dadosTemporada);
        }
        temporadas.forEach(System.out::println);

        temporadas.forEach(f -> f.episodio().forEach(e -> System.out.println(e.titulo())));

       //pegar os 5 melhores epsódios de uma série
       List<DadosEpsodios> epsodiosDados = temporadas.stream()
                                            .flatMap(t-> t.episodio().stream())
                                            .collect(Collectors.toList());

        epsodiosDados.stream().filter(e->!e.avaliacao().equalsIgnoreCase("N/A"))
                .sorted(Comparator.comparing(DadosEpsodios::avaliacao)
                        .reversed()).limit(5).forEach(System.out::println);
                                            

        
    }
}
