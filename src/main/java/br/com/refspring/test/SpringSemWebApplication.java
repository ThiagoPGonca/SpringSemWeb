package br.com.refspring.test;

import br.com.refspring.test.model.DadosSeries;
import br.com.refspring.test.service.APIConsumer;
import br.com.refspring.test.service.ConvertData;
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
    }
}
