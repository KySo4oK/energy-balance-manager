package kpi.compilers.energybalancemanager.token.matcher.strategy.impl;

import kpi.compilers.energybalancemanager.token.entity.impl.ExitToken;
import kpi.compilers.energybalancemanager.token.entity.impl.ExitValue;
import kpi.compilers.energybalancemanager.token.matcher.strategy.TokenMatchingStrategy;
import org.springframework.stereotype.Component;

@Component
public class ExitTokenMatchingStrategy implements TokenMatchingStrategy<ExitValue> {
    @Override
    public boolean isApplicable(String value) {
        return ExitValue.exitCommand.equals(value);
    }

    @Override
    public int getPriority() {
        return Integer.MAX_VALUE;
    }

    @Override
    public ExitToken match(String value) {
        return new ExitToken(value);
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
