package br.com.refspring.test;

import br.com.refspring.test.model.DadosEpsodios;
import br.com.refspring.test.model.DadosSeries;
import br.com.refspring.test.model.DadosTemporada;
import br.com.refspring.test.service.APIConsumer;
import br.com.refspring.test.service.ConvertData;

import java.util.List;

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
        json = consumeAPI.obterDados(url); //add url com episodio
        DadosEpsodios dadosEps = conversor.obterDados(json, DadosEpsodios.class);
        System.out.print(dadosEps);

        List<DadosTemporada> temporadas = new ArrayList<>();
        for(int i = 1; i<dados.totalTemporadas(); i++){
            json = consumeAPI.obterDados(url); //dentro da URL trocar o numero de temporadas por i
            DadosTemporada dadosTemporada = conversor.obterDados(json, DadosTemporada.class);
            temporadas.add(dadosTemporada);
        }

        temporadas.forEach(System.out::println);
    }
}
