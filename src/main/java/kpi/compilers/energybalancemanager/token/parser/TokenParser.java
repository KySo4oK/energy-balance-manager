package kpi.compilers.energybalancemanager.token.parser;

import kpi.compilers.energybalancemanager.token.entity.Token;
import kpi.compilers.energybalancemanager.token.entity.impl.ExitToken;
import kpi.compilers.energybalancemanager.token.entity.impl.ExitValue;
import kpi.compilers.energybalancemanager.token.matcher.LexerException;
import kpi.compilers.energybalancemanager.token.matcher.TokenMatcher;
import kpi.compilers.energybalancemanager.token.queue.TokenQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TokenParser {
    private final TokenMatcher matcher;
    private final DelimiterMatcher delimiterMatcher;
    private final TokenQueue queue;

    public TokenParser(TokenMatcher matcher, DelimiterMatcher delimiterMatcher, TokenQueue queue) {
        this.matcher = matcher;
        this.delimiterMatcher = delimiterMatcher;
        this.queue = queue;
    }

    public boolean parse(String line) {
        StringBuilder currentTokenValue = new StringBuilder();
        Token token = null;
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (delimiterMatcher.match(c)) {
                token = matcher.match(currentTokenValue.toString());
                queue.add(token);

                currentTokenValue = new StringBuilder();
            } else {
                currentTokenValue.append(c);
            }
        }
        token = matcher.match(currentTokenValue.toString());
        if (isExitToken(token)) {
            return false;
        }
        if (currentTokenValue.length() > 0) {
            throw new LexerException("delimiter not found in the end of line");
        }
        return true;
    }

    private boolean isExitToken(Token token) {
        return token instanceof ExitToken;
    }

    public List getTokens() {
        return queue.getAll();
    }
}
