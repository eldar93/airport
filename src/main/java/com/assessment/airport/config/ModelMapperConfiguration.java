package com.assessment.airport.config;

import com.assessment.airport.dto.AirportDto;
import com.assessment.airport.dto.RunwayDto;
import com.assessment.airport.entity.Airport;
import com.assessment.airport.entity.Runway;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.stream.Collectors;

@Configuration
public class ModelMapperConfiguration {

    @Bean
    public ModelMapper modelMapper() {
        final ModelMapper modelMapper = new ModelMapper();
        configureTypeMap(modelMapper);
        modelMapper.getConfiguration().setSkipNullEnabled(true);
        return modelMapper;
    }

    private void configureTypeMap(final ModelMapper mapper) {
        TypeMap<Airport, AirportDto> typeMap = mapper.createTypeMap(Airport.class, AirportDto.class);

        final Converter<List<Runway>, List<RunwayDto>> runwaysConverter =
                ctx -> ctx.getSource() == null ? null :
                        ctx.getSource().stream().map(s -> mapper.map(s, RunwayDto.class)).collect(Collectors.toList());

        typeMap.addMapping(a -> a.getCountry().getName(), AirportDto::setCountryName)
                .addMapping(Airport::getAirportIdent, AirportDto::setAirportId)
                .addMapping(Airport::getName, AirportDto::setAirportName)
                .addMapping(Airport::getType, AirportDto::setAirportType)
                .addMappings(m -> m.using(runwaysConverter).map(Airport::getRunways, AirportDto::setRunways));
    }
}
