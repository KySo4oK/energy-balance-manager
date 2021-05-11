package kpi.compilers.energybalancemanager.token.parser;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DelimiterMatcher {
    private List<Character> delimiters = List.of(';', ':', ',', '=', '.', '{', '}', '[', ']');

    public boolean match(char character) {
        return delimiters.stream()
                .anyMatch(delimiter -> delimiter.equals(character));
    }
}
