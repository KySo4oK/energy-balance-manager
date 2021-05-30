package kpi.compilers.energybalancemanager.console;

import lombok.Getter;

@Getter
public enum Command {
    HELLO("Hello there"),
    EXIT("Exit command found"),
    SEMANTICALLY_CORRECT("Is semantically correct: ");
    private final String description;

    Command(String description) {
        this.description = description;
    }
}
