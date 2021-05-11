package kpi.compilers.energybalancemanager.token.matcher.strategy;

import kpi.compilers.energybalancemanager.token.entity.Token;

public interface TokenMatchingStrategy<T> extends Comparable {
    boolean isApplicable(String value);

    int getPriority();

    Token<T> match(String value);

    default int compareTo(Object o) {
        if (!(o instanceof TokenMatchingStrategy)) {
            throw new ClassCastException();
        }
        TokenMatchingStrategy<?> other = (TokenMatchingStrategy<?>) o;
        return other.getPriority() - getPriority();
    }
}
