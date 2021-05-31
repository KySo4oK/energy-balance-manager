package kpi.compilers.energybalancemanager.token.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum KeyWord {
    ADD_KCAL("add-kcal"),
    REMOVE_KCAL("remove-kcal");

    private final String name;
}
