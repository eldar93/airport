package com.assessment.airport.strategy;

import com.assessment.airport.entity.Airport;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SelectionStrategy {

    Page<Airport> getAirportsByName(String name, Pageable pageable);
    Page<Airport> getAirportsByCode(String code, Pageable pageable);

    SelectionType getType();
}
