package kpi.compilers.energybalancemanager.expression.matching.impl;

import kpi.compilers.energybalancemanager.common.Priority;
import kpi.compilers.energybalancemanager.expression.AbstractExpression;
import kpi.compilers.energybalancemanager.expression.impl.RemoveKcalExpression;
import kpi.compilers.energybalancemanager.expression.matching.ExpressionMatcherStrategy;
import kpi.compilers.energybalancemanager.token.entity.Token;
import kpi.compilers.energybalancemanager.token.entity.impl.DoubleToken;
import kpi.compilers.energybalancemanager.token.entity.impl.RemoveKcalToken;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RemoveKcalExpressionMatchingStrategy<T> implements ExpressionMatcherStrategy<RemoveKcalExpression> {
    @Override
    public boolean isApplicable(List<Token> tokens) {
        return tokens.size() >= 2 &&
                tokens.get(0) instanceof RemoveKcalToken &&
                tokens.get(1) instanceof DoubleToken;
    }

    @Override
    public int getPriority() {
        return Priority.REMOVE_KCAL.getPriority();
    }

    @Override
    public AbstractExpression match(List<Token> tokens) {
        RemoveKcalExpression expression = new RemoveKcalExpression(((Double) tokens.get(1).getValue()));
        expression.setTokens(List.of(tokens.get(0), tokens.get(1)));
        return expression;
    }
}
