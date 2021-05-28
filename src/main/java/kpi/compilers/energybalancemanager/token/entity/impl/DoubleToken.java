package kpi.compilers.energybalancemanager.token.entity.impl;

import kpi.compilers.energybalancemanager.token.entity.Token;
import lombok.ToString;

@ToString
public class DoubleToken implements Token<Double> {
    private final Double value;

    public DoubleToken(Double value) {
        this.value = value;
    }

    @Override
    public Double getValue() {
        return this.value;
    }
}
