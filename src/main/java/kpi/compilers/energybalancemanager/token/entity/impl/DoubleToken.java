package kpi.compilers.energybalancemanager.token.entity.impl;

import kpi.compilers.energybalancemanager.token.entity.Token;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@RequiredArgsConstructor
public class DoubleToken implements Token<Double> {
    private final Double value;
}
