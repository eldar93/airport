package com.assessment.airport.dto;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.hateoas.server.core.Relation;

@Data
@Accessors(chain = true)
@Relation(itemRelation = "country", collectionRelation = "countries")
public class CountryDto {

    private String name;
    private String code;
    private Integer airportsCount;
}
