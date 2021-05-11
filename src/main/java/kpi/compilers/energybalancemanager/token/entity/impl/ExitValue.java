package kpi.compilers.energybalancemanager.token.entity.impl;

public class ExitValue {
    private static ExitValue instance;
    public static String exitCommand = "!!";

    public static ExitValue getInstance() {
        return instance;
    }
}
