package kpi.compilers.energybalancemanager.token.entity.impl;

import kpi.compilers.energybalancemanager.token.entity.Token;

public class ExitToken implements Token<ExitValue> {
    private final String value;

    public ExitToken(String value) {
        this.value = value;
    }

    @Override
    public ExitValue getValue() {
        return ExitValue.getInstance();
    }
}
