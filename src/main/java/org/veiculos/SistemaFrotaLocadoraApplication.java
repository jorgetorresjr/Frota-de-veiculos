package org.veiculos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(
        exclude = { DataSourceAutoConfiguration.class } // desativa configuração automática de banco
)
public class SistemaFrotaLocadoraApplication {

    public static void main(String[] args) {
        SpringApplication.run(SistemaFrotaLocadoraApplication.class, args);
    }
}
