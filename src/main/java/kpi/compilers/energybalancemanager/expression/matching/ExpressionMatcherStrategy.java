package kpi.compilers.energybalancemanager.expression.matching;

import kpi.compilers.energybalancemanager.expression.AbstractExpression;
import kpi.compilers.energybalancemanager.token.entity.Token;

import java.util.List;

public interface ExpressionMatcherStrategy<T> extends Comparable {

    boolean isApplicable(List<Token> tokens);

    int getPriority();

    AbstractExpression match(List<Token> tokens);

    default int compareTo(Object o) {
        if (!(o instanceof ExpressionMatcherStrategy)) {
            throw new ClassCastException();
        }
        ExpressionMatcherStrategy<?> other = (ExpressionMatcherStrategy<?>) o;
        return other.getPriority() - getPriority();
    }
}
