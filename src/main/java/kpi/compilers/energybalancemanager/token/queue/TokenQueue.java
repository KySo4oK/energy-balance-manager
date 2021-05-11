package kpi.compilers.energybalancemanager.token.queue;

import kpi.compilers.energybalancemanager.token.entity.impl.ExitToken;
import kpi.compilers.energybalancemanager.token.entity.Token;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Component
public class TokenQueue<T> {
    private final List<Token<T>> queue = new LinkedList<>();

    public void add(Token<T> token) {
        queue.add(token);
    }

    public List<Token<T>> getAll() {
        return new ArrayList<>(queue);
    }

    public boolean isExitCommandFound() {
        return queue.stream()
                .anyMatch(token -> token instanceof ExitToken);
    }
}
