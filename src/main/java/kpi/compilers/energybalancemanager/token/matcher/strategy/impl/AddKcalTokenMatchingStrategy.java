package kpi.compilers.energybalancemanager.token.matcher.strategy.impl;

import kpi.compilers.energybalancemanager.common.Priority;
import kpi.compilers.energybalancemanager.token.entity.KeyWord;
import kpi.compilers.energybalancemanager.token.entity.impl.AddKcalToken;
import kpi.compilers.energybalancemanager.token.matcher.strategy.TokenMatchingStrategy;
import org.springframework.stereotype.Component;

@Component
public class AddKcalTokenMatchingStrategy implements TokenMatchingStrategy<KeyWord> {

    @Override
    public boolean isApplicable(String value) {
        return KeyWord.ADD_KCAL.getName().equals(value);
    }

    @Override
    public int getPriority() {
        return Priority.ADD_KCAL.getPriority();
    }

    @Override
    public AddKcalToken match(String value) {
        return new AddKcalToken();
    }
}
