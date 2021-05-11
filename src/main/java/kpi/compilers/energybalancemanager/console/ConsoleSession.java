package kpi.compilers.energybalancemanager.console;

import kpi.compilers.energybalancemanager.token.parser.TokenParser;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ConsoleSession {

    private final User user;
    private final CommandPrinter printer;
    private final Scanner scanner;
    private final TokenParser parser;

    public ConsoleSession(User user, CommandPrinter printer, TokenParser parser) {
        this.user = user;
        this.scanner = new Scanner(System.in);
        this.printer = printer;
        this.parser = parser;
    }

    public void run() {
        printer.print(Command.HELLO);
        while (true) {
            String line = scanner.nextLine();
            if (!parser.parse(line)) {
                break;
            }
        }
        printer.print(Command.EXIT);
    }
}
