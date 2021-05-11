package kpi.compilers.energybalancemanager.token.matcher.strategy.impl;

import jdk.jfr.Category;
import kpi.compilers.energybalancemanager.token.entity.Token;
import kpi.compilers.energybalancemanager.token.entity.impl.DoubleToken;
import kpi.compilers.energybalancemanager.token.matcher.strategy.TokenMatchingStrategy;
import kpi.compilers.energybalancemanager.token.matcher.strategy.priority.Priority;
import org.springframework.stereotype.Component;

@Component
public class DoubleTokenMatchingStrategy<T> implements TokenMatchingStrategy<Double> {
    @Override
    public boolean isApplicable(String value) {
        try {
            Double.parseDouble(value);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public int getPriority() {
        return Priority.DOUBLE.getPriority();
    }

    @Override
    public Token<Double> match(String value) {
        return new DoubleToken(Double.parseDouble(value));
    }
}
