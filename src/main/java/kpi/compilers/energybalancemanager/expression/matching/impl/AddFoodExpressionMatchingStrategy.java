package kpi.compilers.energybalancemanager.expression.matching.impl;

import kpi.compilers.energybalancemanager.common.Priority;
import kpi.compilers.energybalancemanager.expression.AbstractExpression;
import kpi.compilers.energybalancemanager.expression.impl.AddFoodExpression;
import kpi.compilers.energybalancemanager.expression.matching.ExpressionMatcherStrategy;
import kpi.compilers.energybalancemanager.token.entity.Token;
import kpi.compilers.energybalancemanager.token.entity.impl.AddFoodToken;
import kpi.compilers.energybalancemanager.token.entity.impl.DoubleToken;
import kpi.compilers.energybalancemanager.token.entity.impl.FoodToken;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AddFoodExpressionMatchingStrategy<T> implements ExpressionMatcherStrategy<AddFoodExpression> {
    @Override
    public boolean isApplicable(List<Token> tokens) {
        return tokens.size() >= 3 &&
                tokens.get(0) instanceof AddFoodToken &&
                tokens.get(1) instanceof FoodToken &&
                tokens.get(2) instanceof DoubleToken;
    }

    @Override
    public int getPriority() {
        return Priority.ADD_FOOD.getPriority();
    }

    @Override
    public AbstractExpression match(List<Token> tokens) {
        AddFoodExpression expression = new AddFoodExpression(((Double) tokens.get(2).getValue()));
        expression.setTokens(List.of(tokens.get(0), tokens.get(1), tokens.get(2)));
        return expression;
    }
}
