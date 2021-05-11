package kpi.compilers.energybalancemanager.token.matcher.strategy.priority;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Priority {
    DOUBLE(10);
    private final int priority;

}
