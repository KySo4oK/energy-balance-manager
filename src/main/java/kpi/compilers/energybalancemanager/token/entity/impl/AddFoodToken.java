package kpi.compilers.energybalancemanager.token.entity.impl;

import kpi.compilers.energybalancemanager.token.entity.KeyWord;
import kpi.compilers.energybalancemanager.token.entity.Token;

public class AddFoodToken implements Token<KeyWord> {

    @Override
    public KeyWord getValue() {
        return KeyWord.ADD_FOOD;
    }
}
