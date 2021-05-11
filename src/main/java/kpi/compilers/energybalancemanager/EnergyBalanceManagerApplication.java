package kpi.compilers.energybalancemanager;

import kpi.compilers.energybalancemanager.console.ConsoleSession;
import kpi.compilers.energybalancemanager.console.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EnergyBalanceManagerApplication implements CommandLineRunner {
    private String username;

    @Autowired
    ConsoleSession consoleSession;

    @Bean
    User getUser() {
        return new User(username);
    }

    public static void main(String[] args) {
        SpringApplicationBuilder builder = new SpringApplicationBuilder(EnergyBalanceManagerApplication.class);

        builder.headless(false);

        ConfigurableApplicationContext context = builder.run(args);
    }

    @Override
    public void run(String... args) throws Exception {
        username = args[0];
        consoleSession.run();
    }
}
