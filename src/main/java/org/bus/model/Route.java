package org.bus.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;
@Entity
@Table(name="route")

public class Route {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer routeId;
	@Column(name="routeFrom", nullable=false)
    private String routeFrom;
	@Column(name="routeTo", nullable=false)
    private String routeTo;
	@Column(name="distance", nullable=false)
    private Integer distance;
    @OneToMany
    private List<Bus> busList;

    public Route() {
    }

    public Route(Integer routeId, String routeFrom, String routeTo, Integer distance) {
        this.routeId = routeId;
        this.routeFrom = routeFrom;
        this.routeTo = routeTo;
        this.distance = distance;
    }

    public Integer getRouteId() {
        return routeId;
    }

    public void setRouteId(Integer routeId) {
        this.routeId = routeId;
    }

    public String getRouteFrom() {
        return routeFrom;
    }

    public void setRouteFrom(String routeFrom) {
        this.routeFrom = routeFrom;
    }

    public String getRouteTo() {
        return routeTo;
    }

    public void setRouteTo(String routeTo) {
        this.routeTo = routeTo;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "Route{" +
                "routeId=" + routeId +
                ", routeFrom='" + routeFrom + '\'' +
                ", routeTo='" + routeTo + '\'' +
                ", distance=" + distance +
                ", busList=" + busList +
                '}';
    }
}
