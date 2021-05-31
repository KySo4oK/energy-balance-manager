package kpi.compilers.energybalancemanager.expression.impl;

import kpi.compilers.energybalancemanager.expression.AbstractExpression;
import kpi.compilers.energybalancemanager.token.entity.Token;
import kpi.compilers.energybalancemanager.token.entity.impl.FoodToken;
import lombok.Data;

import java.util.List;

@Data
public class AddFoodExpression implements AbstractExpression {
    private double amount;
    private String foodName;
    private List<Token> tokens;

    public AddFoodExpression(double amount) {
        this.amount = amount;
    }

    @Override
    public String translate() {
        foodName = ((FoodToken) tokens.get(1)).getValue().getName();
        return "user.addFoodIntake(" + foodName + ", " + amount + ");";
    }

    @Override
    public boolean isApplicable(List<Token> tokens) {
        return false;
    }

    @Override
    public boolean isValidSemantically() {
        return amount > 0.0;
    }
}
