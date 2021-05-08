package kpi.compilers.energybalancemanager;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EnergyBalanceManagerApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(EnergyBalanceManagerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
