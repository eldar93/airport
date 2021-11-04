package com.assessment.airport.repository;

import com.assessment.airport.entity.Airport;
import com.assessment.airport.entity.Country;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AirportRepository extends PagingAndSortingRepository<Airport, String> {

    //Exact selection queries
    @Query("SELECT a FROM Airport a JOIN Country c ON a.country = c AND c.name = :countryName")
    Page<Airport> findAllAirportsByCountryName(String countryName, Pageable pageable);
    @Query("SELECT a FROM Airport a JOIN Country c ON a.country = c AND c.id = :countryCode")
    Page<Airport> findAllAirportsByCountryCode(String countryCode, Pageable pageable);

    //Fuzzy selection queries
    @Query("SELECT a FROM Airport a JOIN Country c ON a.country = c AND c.name like %:countryName%")
    Page<Airport> findAllAirportsByFuzzyName(String countryName, Pageable pageable);
    @Query("SELECT a FROM Airport a JOIN Country c ON a.country = c AND c.id like %:countryCode%")
    Page<Airport> findAllAirportsByFuzzyCode(String countryCode, Pageable pageable);

    @Query("SELECT c FROM Country c JOIN Airport a ON c = a.country GROUP BY c ORDER BY COUNT(a) DESC")
    List<Country> findTopTenCountriesWithAirports(Pageable pageable);

    @Query("SELECT COUNT(a) from Airport a WHERE a.country = :country")
    Integer findAirportsCountForCountry(Country country);

}
