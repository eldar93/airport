package com.assessment.airport.strategy;

public interface SelectionStrategyFactory {

    SelectionStrategy get(SelectionType type);
}
