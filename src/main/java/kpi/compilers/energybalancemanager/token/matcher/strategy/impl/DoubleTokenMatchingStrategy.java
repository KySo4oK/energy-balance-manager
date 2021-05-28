package kpi.compilers.energybalancemanager.token.matcher.strategy.impl;

import kpi.compilers.energybalancemanager.common.Priority;
import kpi.compilers.energybalancemanager.token.entity.Token;
import kpi.compilers.energybalancemanager.token.entity.impl.DoubleToken;
import kpi.compilers.energybalancemanager.token.matcher.strategy.TokenMatchingStrategy;
import org.springframework.stereotype.Component;

@Component
public class DoubleTokenMatchingStrategy implements TokenMatchingStrategy<Double> {
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
