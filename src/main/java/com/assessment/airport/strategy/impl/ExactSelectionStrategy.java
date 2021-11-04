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


@Component(SelectionType.StrategyNames.EXACT_STRATEGY_NAME)
@AllArgsConstructor
public class ExactSelectionStrategy implements SelectionStrategy {

    @Autowired
    private final AirportRepository airportRepository;

    @Override
    public Page<Airport> getAirportsByName(String name, Pageable pageable) {
        Page<Airport> airports = airportRepository.findAllAirportsByCountryName(name, pageable);
        return airports;
    }

    @Override
    public Page<Airport> getAirportsByCode(String code, Pageable pageable) {
        Page<Airport> airports = airportRepository.findAllAirportsByCountryCode(code, pageable);
        return airports;
    }

    @Override
    public SelectionType getType() {
        return SelectionType.EXACT;
    }
}
