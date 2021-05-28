package kpi.compilers.energybalancemanager.expression;

import kpi.compilers.energybalancemanager.common.exception.SyntaxException;
import kpi.compilers.energybalancemanager.expression.matching.ExpressionMatcherStrategy;
import kpi.compilers.energybalancemanager.token.entity.Token;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ExpressionParser {

    private final List<ExpressionMatcherStrategy> expressionMatcherStrategies;

    public List<AbstractExpression> parse(List<Token> tokens) {
        List<AbstractExpression> expressions = new ArrayList<>();
        ExpressionMatcherStrategy strategy = getHighestPriorityStrategy(tokens);
        AbstractExpression expression = strategy.match(tokens);
        expressions.add(expression);
        tokens.removeAll(expression.getTokens());
        if (!tokens.isEmpty()) {
            expressions.addAll(parse(tokens));
        }
        return expressions;
    }

    private ExpressionMatcherStrategy getHighestPriorityStrategy(List<Token> tokens) {
        return expressionMatcherStrategies.stream()
                .filter(s -> s.isApplicable(tokens))
                .sorted()
                .findFirst()
                .orElseThrow(() -> new SyntaxException("Unknown expression"));
    }
}
