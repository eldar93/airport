package com.assessment.airport.service;

import com.assessment.airport.dto.AirportDto;
import com.assessment.airport.dto.CountryDto;
import com.assessment.airport.entity.Airport;
import com.assessment.airport.entity.Country;
import com.assessment.airport.repository.AirportRepository;
import com.assessment.airport.strategy.SelectionStrategyFactory;
import com.assessment.airport.strategy.SelectionType;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class AirportServiceImpl implements AirportService {

    @Autowired
    private final AirportRepository airportRepository;
    @Autowired
    private final SelectionStrategyFactory strategyFactory;
    @Autowired
    private final ModelMapper modelMapper;

    @Override
    public Page<AirportDto> getAllAirportsByCountryName(String countryName, Pageable pageable, SelectionType type) {
        Page<Airport> airports = strategyFactory.get(type).getAirportsByName(countryName, pageable);
        List<AirportDto> responseList = airports.stream().map(a -> modelMapper.map(a, AirportDto.class)).collect(Collectors.toList());
        return new PageImpl<>(responseList, pageable, airports.getTotalElements());
    }

    @Override
    public Page<AirportDto> getAllAirportsByCountryCode(String countryCode, Pageable pageable, SelectionType type) {
        Page<Airport> airports = strategyFactory.get(type).getAirportsByCode(countryCode, pageable);
        List<AirportDto> responseList = airports.stream().map(a -> modelMapper.map(a, AirportDto.class)).collect(Collectors.toList());
        return new PageImpl<>(responseList, pageable, airports.getTotalElements());
    }

    @Override
    public List<CountryDto> getTopTenCountriesWithAirports() {
        Pageable topTen = PageRequest.of(0, 10);
        List<Country> countries = airportRepository.findTopTenCountriesWithAirports(topTen);
        List<CountryDto> responseList = new ArrayList<>(countries.size());
        responseList = countries.stream().map(
                c -> new CountryDto()
                        .setName(c.getName())
                        .setCode(c.getId())
                        .setAirportsCount(airportRepository.findAirportsCountForCountry(c)))
                .collect(Collectors.toList());
        return responseList;
    }
}
