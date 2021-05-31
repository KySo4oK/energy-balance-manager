package kpi.compilers.energybalancemanager.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Priority {
    DOUBLE(10),
    ADD_KCAL(20),
    REMOVE_KCAL(20),
    STRING(0);
    private final int priority;
}
