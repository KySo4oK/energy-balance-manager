package kpi.compilers.energybalancemanager.expression.matching.impl;

import kpi.compilers.energybalancemanager.common.Priority;
import kpi.compilers.energybalancemanager.expression.AbstractExpression;
import kpi.compilers.energybalancemanager.expression.impl.AddKcalExpression;
import kpi.compilers.energybalancemanager.expression.matching.ExpressionMatcherStrategy;
import kpi.compilers.energybalancemanager.token.entity.Token;
import kpi.compilers.energybalancemanager.token.entity.impl.AddKcalToken;
import kpi.compilers.energybalancemanager.token.entity.impl.DoubleToken;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AddKcalExpressionMatchingStrategy<T> implements ExpressionMatcherStrategy<AddKcalExpression> {
    @Override
    public boolean isApplicable(List<Token> tokens) {
        return tokens.size() >= 2 &&
                tokens.get(0) instanceof AddKcalToken &&
                tokens.get(1) instanceof DoubleToken;
    }

    @Override
    public int getPriority() {
        return Priority.ADD_KCAL.getPriority();
    }

    @Override
    public AbstractExpression match(List<Token> tokens) {
        AddKcalExpression expression = new AddKcalExpression(((Double) tokens.get(1).getValue()));
        expression.setTokens(List.of(tokens.get(0), tokens.get(1)));
        return expression;
    }
}
