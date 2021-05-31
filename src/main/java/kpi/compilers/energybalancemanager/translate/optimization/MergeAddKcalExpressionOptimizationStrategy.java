package kpi.compilers.energybalancemanager.translate.optimization;

import kpi.compilers.energybalancemanager.expression.AbstractExpression;
import kpi.compilers.energybalancemanager.expression.impl.AddKcalExpression;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MergeAddKcalExpressionOptimizationStrategy implements OptimizationStrategy {
    @Override
    public List<AbstractExpression> optimize(List<AbstractExpression> expressions) {
        if (numberOfSimilarExpressions(expressions)) {
            for (int i = 1; i < expressions.size(); i++) {
                AbstractExpression first = expressions.get(i - 1);
                AbstractExpression second = expressions.get(i);
                if (first instanceof AddKcalExpression && second instanceof AddKcalExpression) {
                    AddKcalExpression secondKcal = (AddKcalExpression) second;
                    AddKcalExpression firstKcal = (AddKcalExpression) first;
                    secondKcal.setAmount(secondKcal.getAmount() + firstKcal.getAmount());
                    expressions.remove(first);
                    i--;
                }
            }
        }
        return expressions;
    }

    private boolean numberOfSimilarExpressions(List<AbstractExpression> expressions) {
        return expressions.stream().filter(expression -> expression instanceof AddKcalExpression).count() > 1;
    }
}
