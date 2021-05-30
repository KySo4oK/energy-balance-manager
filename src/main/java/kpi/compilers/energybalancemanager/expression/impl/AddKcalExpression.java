package kpi.compilers.energybalancemanager.expression.impl;

import kpi.compilers.energybalancemanager.expression.AbstractExpression;
import kpi.compilers.energybalancemanager.token.entity.Token;

import java.util.List;

public class AddKcalExpression implements AbstractExpression {
    private final double amount;
    private List<Token> tokens;

    public AddKcalExpression(double amount) {
        this.amount = amount;
    }

    @Override
    public void process() {
        System.out.println("|will be removed| adding " + amount + " kcal");
    }

    @Override
    public void setTokens(List<Token> tokens) {
        this.tokens = tokens;
    }

    @Override
    public boolean isApplicable(List<Token> tokens) {
        return false;
    }

    @Override
    public List<Token> getTokens() {
        return tokens;
    }

    @Override
    public boolean isValidSemantically() {
        return amount > 0.0;
    }
}
