package kpi.compilers.energybalancemanager.translate.optimization;

import kpi.compilers.energybalancemanager.expression.AbstractExpression;

import java.util.List;

public interface OptimizationStrategy {
    List<AbstractExpression> optimize(List<AbstractExpression> expressions);
}
