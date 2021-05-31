package kpi.compilers.energybalancemanager.expression.impl;

import kpi.compilers.energybalancemanager.expression.AbstractExpression;
import kpi.compilers.energybalancemanager.token.entity.Token;
import lombok.Data;

import java.util.List;

@Data
public class AddKcalExpression implements AbstractExpression {
    private double amount;
    private List<Token> tokens;

    public AddKcalExpression(double amount) {
        this.amount = amount;
    }

    @Override
    public String translate() {
        return "user.addCalories(" + amount + ");";
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
