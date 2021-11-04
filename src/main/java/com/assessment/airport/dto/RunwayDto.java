package com.assessment.airport.dto;

import lombok.Data;
import org.springframework.hateoas.server.core.Relation;

@Data
@Relation(itemRelation = "runway", collectionRelation = "runways")
public class RunwayDto {

    private Integer id;
    private Integer length;
    private Integer width;
    private String surface;
    private Boolean lighted;
    private Boolean closed;
}
