package kpi.compilers.energybalancemanager.console;

import org.springframework.stereotype.Component;

@Component
public class CommandPrinter {
    public void print(Command command) {
        print(command.getDescription());
    }

    public void print(String message) {
        System.out.println(message);
    }
}
