package kpi.compilers.energybalancemanager.token.entity.impl;

import kpi.compilers.energybalancemanager.token.entity.Food;
import kpi.compilers.energybalancemanager.token.entity.Token;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FoodToken implements Token<Food> {
    private final Food food;

    @Override
    public Food getValue() {
        return food;
    }
}
