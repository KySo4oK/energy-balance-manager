package kpi.compilers.energybalancemanager.token.entity.impl;

import kpi.compilers.energybalancemanager.token.entity.Token;
import lombok.Data;

@Data
public class StringToken implements Token<String> {
    private final String value;

    public StringToken(String value) {
        this.value = value;
    }
}
