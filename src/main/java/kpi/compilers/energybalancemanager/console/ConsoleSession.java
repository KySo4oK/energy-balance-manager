package kpi.compilers.energybalancemanager.console;

import kpi.compilers.energybalancemanager.expression.AbstractExpression;
import kpi.compilers.energybalancemanager.expression.ExpressionParser;
import kpi.compilers.energybalancemanager.token.entity.Token;
import kpi.compilers.energybalancemanager.token.parser.TokenParser;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class ConsoleSession {

    private final User user;
    private final CommandPrinter printer;
    private final Scanner scanner;
    private final TokenParser tokenParser;
    private final ExpressionParser expressionParser;

    public ConsoleSession(User user, CommandPrinter printer, TokenParser tokenParser, ExpressionParser expressionParser) {
        this.user = user;
        this.expressionParser = expressionParser;
        this.scanner = new Scanner(System.in);
        this.printer = printer;
        this.tokenParser = tokenParser;
    }

    public void run() {
        printer.print(Command.HELLO);
        while (true) {
            String line = scanner.nextLine();
            if (!tokenParser.parse(line)) {
                List<Token> tokens = tokenParser.getTokens();
                List<AbstractExpression> expressions = expressionParser.parse(tokens);
                expressions.forEach(AbstractExpression::process);
                break;
            }
        }
        printer.print(Command.EXIT);
    }
}
