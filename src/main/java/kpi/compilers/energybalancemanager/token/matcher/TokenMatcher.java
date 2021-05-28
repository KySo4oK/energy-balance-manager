package kpi.compilers.energybalancemanager.token.matcher;

import kpi.compilers.energybalancemanager.common.exception.LexerException;
import kpi.compilers.energybalancemanager.token.entity.Token;
import kpi.compilers.energybalancemanager.token.matcher.strategy.TokenMatchingStrategy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TokenMatcher {
    private final List<TokenMatchingStrategy> strategies;

    public TokenMatcher(List<TokenMatchingStrategy> strategies) {
        this.strategies = strategies;
    }

    public Token match(String value) {
        return strategies.stream()
                .filter(strategy -> strategy.isApplicable(value))
                .sorted()
                .findAny()
                .orElseThrow(() -> new LexerException("token not found"))
                .match(value);
    }
}
