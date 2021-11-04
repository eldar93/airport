package com.assessment.airport.strategy;

public enum SelectionType {
    EXACT(StrategyNames.EXACT_STRATEGY_NAME),
    FUZZY(StrategyNames.FUZZY_STRATEGY_NAME);

    private final String strategyName;

    SelectionType(String strategyName) {
        this.strategyName = strategyName;
    }

    @Override
    public String toString() {
        return this.strategyName;
    }

    public interface StrategyNames {

        String EXACT_STRATEGY_NAME = "exactStrategy";
        String FUZZY_STRATEGY_NAME = "fuzzyStrategy";
    }
}
