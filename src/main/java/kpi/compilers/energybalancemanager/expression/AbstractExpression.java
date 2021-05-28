package kpi.compilers.energybalancemanager.expression;

import kpi.compilers.energybalancemanager.token.entity.Token;

import java.util.List;

public interface AbstractExpression {
    void process();

    void setTokens(List<Token> tokens);

    boolean isApplicable(List<Token> tokens);

    List<Token> getTokens();
}
