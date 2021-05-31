package kpi.compilers.energybalancemanager.token.matcher.strategy.impl;

import kpi.compilers.energybalancemanager.common.Priority;
import kpi.compilers.energybalancemanager.token.entity.KeyWord;
import kpi.compilers.energybalancemanager.token.entity.impl.AddFoodToken;
import kpi.compilers.energybalancemanager.token.entity.impl.AddKcalToken;
import kpi.compilers.energybalancemanager.token.matcher.strategy.TokenMatchingStrategy;
import org.springframework.stereotype.Component;

@Component
public class AddFoodTokenMatchingStrategy implements TokenMatchingStrategy<KeyWord> {

    @Override
    public boolean isApplicable(String value) {
        return KeyWord.ADD_FOOD.getName().equals(value);
    }

    @Override
    public int getPriority() {
        return Priority.ADD_FOOD.getPriority();
    }

    @Override
    public AddFoodToken match(String value) {
        return new AddFoodToken();
    }
}
