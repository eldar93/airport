package com.assessment.airport.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Runway {

    @Id
    private Integer id;
    @Column(name = "LENGTH_FT")
    private Integer length;
    @Column(name = "WIDTH_FT")
    private Integer width;
    private String surface;
    private Boolean lighted;
    private Boolean closed;

    @ManyToOne
    @JoinColumn(name = "AIRPORT_REF", referencedColumnName = "ID")
    private Airport airport;

    Runway() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public String getSurface() {
        return surface;
    }

    public void setSurface(String surface) {
        this.surface = surface;
    }

    public Boolean getLighted() {
        return lighted;
    }

    public void setLighted(Boolean lighted) {
        this.lighted = lighted;
    }

    public Boolean getClosed() {
        return closed;
    }

    public void setClosed(Boolean closed) {
        this.closed = closed;
    }

    public Airport getAirport() {
        return airport;
    }

    public void setAirport(Airport airport) {
        this.airport = airport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Runway runway = (Runway) o;
        return id != null && id.equals(runway.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
