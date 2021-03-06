package kpi.compilers.energybalancemanager.token.matcher.strategy.impl;

import kpi.compilers.energybalancemanager.common.Priority;
import kpi.compilers.energybalancemanager.token.entity.impl.StringToken;
import kpi.compilers.energybalancemanager.token.matcher.strategy.TokenMatchingStrategy;
import org.springframework.stereotype.Component;

@Component
public class StringMatchingStrategy implements TokenMatchingStrategy<String> {
    @Override
    public boolean isApplicable(String value) {
        return true;
    }

    @Override
    public int getPriority() {
        return Priority.STRING.getPriority();
    }

    @Override
    public StringToken match(String value) {
        return new StringToken(value);
    }
}
