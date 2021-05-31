package kpi.compilers.energybalancemanager.token.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Food {
    PIZZA(400.0, "pizza"),
    ICE_CREAM(500.0, "ice-cream"),
    APPLE(300.0, "apple");
    private final double kcalPer100g;
    private final String name;
}
