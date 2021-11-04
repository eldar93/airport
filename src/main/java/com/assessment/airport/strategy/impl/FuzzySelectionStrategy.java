package com.assessment.airport.strategy.impl;

import com.assessment.airport.entity.Airport;
import com.assessment.airport.repository.AirportRepository;
import com.assessment.airport.strategy.SelectionStrategy;
import com.assessment.airport.strategy.SelectionType;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component(SelectionType.StrategyNames.FUZZY_STRATEGY_NAME)
@AllArgsConstructor
public class FuzzySelectionStrategy implements SelectionStrategy {

    @Autowired
    private final AirportRepository airportRepository;

    @Override
    public Page<Airport> getAirportsByName(String name, Pageable pageable) {
        Page<Airport> airports = airportRepository.findAllAirportsByFuzzyName(name, pageable);
        return airports;
    }

    @Override
    public Page<Airport> getAirportsByCode(String code, Pageable pageable) {
        Page<Airport> airports = airportRepository.findAllAirportsByFuzzyCode(code, pageable);
        return airports;
    }

    @Override
    public SelectionType getType() {
        return SelectionType.FUZZY;
    }
}
