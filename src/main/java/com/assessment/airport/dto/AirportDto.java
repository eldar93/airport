package com.assessment.airport.dto;

import lombok.Data;
import org.springframework.hateoas.server.core.Relation;

import java.util.List;

@Data
@Relation(itemRelation = "airport", collectionRelation = "airports")
public class AirportDto {

    private String countryName;
    private String airportName;
    private String airportId;
    private String airportType;
    private List<RunwayDto> runways;
}
