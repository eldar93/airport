package com.assessment.airport.controller;

import com.assessment.airport.dto.AirportDto;
import com.assessment.airport.dto.CountryDto;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping(path = "/airports")
public interface AirportController {

    String COUNTRY_NAME_PATH = "/countryName/{name}";
    String COUNTRY_CODE_PATH = "/countryCode/{code}";
    String TOP_TEN_COUNTRIES_PATH = "/topTenCountries";


    @GetMapping(path = COUNTRY_NAME_PATH)
    PagedModel<EntityModel<AirportDto>> getAllAirportsByName(
            @PathVariable String name, Pageable pageable,
            @RequestParam(required = false, defaultValue = "false") Boolean fuzzy);

    @GetMapping(path = COUNTRY_CODE_PATH)
    PagedModel<EntityModel<AirportDto>> getAllAirportsByCode(
            @PathVariable String code, Pageable pageable,
            @RequestParam(required = false, defaultValue = "false") Boolean fuzzy);

    @GetMapping(path = TOP_TEN_COUNTRIES_PATH)
    CollectionModel<CountryDto> getTopTenCountriesWithAirports();
}
