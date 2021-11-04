package com.assessment.airport.service;

import com.assessment.airport.dto.AirportDto;
import com.assessment.airport.dto.CountryDto;
import com.assessment.airport.strategy.SelectionType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface AirportService {

    Page<AirportDto> getAllAirportsByCountryName(String countryName, Pageable pageable, SelectionType type);

    Page<AirportDto> getAllAirportsByCountryCode(String countryCode, Pageable pageable, SelectionType type);

    List<CountryDto> getTopTenCountriesWithAirports();
}
