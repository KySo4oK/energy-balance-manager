package kpi.compilers.energybalancemanager.token.matcher.strategy.impl;

import kpi.compilers.energybalancemanager.common.Priority;
import kpi.compilers.energybalancemanager.token.entity.KeyWord;
import kpi.compilers.energybalancemanager.token.entity.impl.RemoveKcalToken;
import kpi.compilers.energybalancemanager.token.matcher.strategy.TokenMatchingStrategy;
import org.springframework.stereotype.Component;

@Component
public class RemoveKcalTokenMatchingStrategy implements TokenMatchingStrategy<KeyWord> {

    @Override
    public boolean isApplicable(String value) {
        return KeyWord.REMOVE_KCAL.getName().equals(value);
    }

    @Override
    public int getPriority() {
        return Priority.REMOVE_KCAL.getPriority();
    }

    @Override
    public RemoveKcalToken match(String value) {
        return new RemoveKcalToken();
    }
}
