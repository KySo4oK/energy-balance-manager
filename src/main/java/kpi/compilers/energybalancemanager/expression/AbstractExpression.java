package kpi.compilers.energybalancemanager.expression;

import kpi.compilers.energybalancemanager.token.entity.Token;

import java.util.List;

public interface AbstractExpression {
    String translate();

    void setTokens(List<Token> tokens);

    boolean isApplicable(List<Token> tokens);

    List<Token> getTokens();

    boolean isValidSemantically();
}
