package kpi.compilers.energybalancemanager.token.matcher.strategy.impl;

import kpi.compilers.energybalancemanager.common.Priority;
import kpi.compilers.energybalancemanager.token.entity.Food;
import kpi.compilers.energybalancemanager.token.entity.Token;
import kpi.compilers.energybalancemanager.token.entity.impl.FoodToken;
import kpi.compilers.energybalancemanager.token.matcher.strategy.TokenMatchingStrategy;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class FoodTokenMatchingStrategy implements TokenMatchingStrategy<Food> {

    @Override
    public boolean isApplicable(String value) {
        return Arrays.stream(Food.values())
                .anyMatch(food -> food.getName().equals(value));
    }

    @Override
    public int getPriority() {
        return Priority.ADD_FOOD.getPriority();
    }

    @Override
    public Token<Food> match(String value) {
        return new FoodToken(
                Arrays.stream(Food.values())
                        .filter(food -> food.getName().equals(value))
                        .findAny()
                        .orElseThrow());
    }
}
