package kpi.compilers.energybalancemanager.semantics;

import kpi.compilers.energybalancemanager.expression.AbstractExpression;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SymantecAnalyser {

    public boolean isValidSemantically(List<AbstractExpression> expressions) {
        return expressions.stream()
                .allMatch(AbstractExpression::isValidSemantically);
    }
}
