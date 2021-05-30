package kpi.compilers.energybalancemanager.console;

import kpi.compilers.energybalancemanager.expression.AbstractExpression;
import kpi.compilers.energybalancemanager.expression.ExpressionParser;
import kpi.compilers.energybalancemanager.semantics.SymantecAnalyser;
import kpi.compilers.energybalancemanager.token.entity.Token;
import kpi.compilers.energybalancemanager.token.parser.TokenParser;
import kpi.compilers.energybalancemanager.translate.Translator;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

@Component
public class ConsoleSession {

    private final User user;
    private final CommandPrinter printer;
    private final Scanner scanner;
    private final TokenParser tokenParser;
    private final ExpressionParser expressionParser;
    private final SymantecAnalyser symantecAnalyser;
    private final Translator translator;

    public ConsoleSession(User user, CommandPrinter printer, TokenParser tokenParser, ExpressionParser expressionParser, SymantecAnalyser symantecAnalyser, Translator translator) {
        this.user = user;
        this.expressionParser = expressionParser;
        this.symantecAnalyser = symantecAnalyser;
        this.translator = translator;
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
                if (symantecAnalyser.isValidSemantically(expressions)) {
                    printer.print(Command.SEMANTICALLY_CORRECT.getDescription() + true);
                    translator.translate(
                            expressions.stream()
                                    .map(AbstractExpression::translate)
                                    .collect(Collectors.joining()));
                } else {
                    printer.print(Command.SEMANTICALLY_CORRECT.getDescription() + false);
                }
                break;
            }
        }
        printer.print(Command.EXIT);
    }
}
