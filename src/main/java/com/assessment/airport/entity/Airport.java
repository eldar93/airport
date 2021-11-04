package com.assessment.airport.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Airport {

    @Id
    private Integer id;
    private String airportIdent;
    private String type;
    private String name;

    @ManyToOne
    @JoinColumn(name = "ISO_COUNTRY", referencedColumnName = "ID")
    private Country country;

    @OneToMany(mappedBy = "airport", fetch = FetchType.EAGER)
    private List<Runway> runways;

    Airport() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAirportIdent() {
        return airportIdent;
    }

    public void setAirportIdent(String airportIdent) {
        this.airportIdent = airportIdent;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public List<Runway> getRunways() {
        return runways;
    }

    public void setRunways(List<Runway> runways) {
        this.runways = runways;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Airport airport = (Airport) o;
        return Objects.equals(id, airport.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
