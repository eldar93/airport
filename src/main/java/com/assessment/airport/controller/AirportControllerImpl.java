package com.assessment.airport.controller;

import com.assessment.airport.dto.AirportDto;
import com.assessment.airport.dto.CountryDto;
import com.assessment.airport.service.AirportService;
import com.assessment.airport.strategy.SelectionType;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@RestController
@AllArgsConstructor
public class AirportControllerImpl implements AirportController {

    @Autowired
    private final AirportService airportService;
    @Autowired
    private final PagedResourcesAssembler<AirportDto> assembler;

    @Override
    public PagedModel<EntityModel<AirportDto>> getAllAirportsByName(String name, Pageable pageable, Boolean fuzzy) {
        SelectionType selectionType = fuzzy ? SelectionType.FUZZY : SelectionType.EXACT;
        Page<AirportDto> responseDtoList = airportService.getAllAirportsByCountryName(name, pageable, selectionType);
        return assembler.toModel(responseDtoList);
    }

    @Override
    public PagedModel<EntityModel<AirportDto>> getAllAirportsByCode(String code, Pageable pageable, Boolean fuzzy) {
        SelectionType selectionType = fuzzy ? SelectionType.FUZZY : SelectionType.EXACT;
        Page<AirportDto> responseDtoList = airportService.getAllAirportsByCountryCode(code, pageable, selectionType);
        return assembler.toModel(responseDtoList);
    }

    @Override
    public CollectionModel<CountryDto> getTopTenCountriesWithAirports() {
        List<CountryDto> responseDtoList = airportService.getTopTenCountriesWithAirports();
        return CollectionModel.of(responseDtoList,
                linkTo(methodOn(AirportController.class).getTopTenCountriesWithAirports()).withSelfRel());
    }
}
