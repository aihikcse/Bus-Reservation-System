package org.bus.service;

import org.bus.model.Route;
import org.bus.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class RouteServiceImpl implements IRouteService{

    @Autowired
    private RouteRepository routeRepository;

    @Override
    public Route addRoute(Route route) {
        return routeRepository.save(route);
    }

    @Override
    public Route updateRoute(Route route) {
        return routeRepository.save(route);
    }

    @Override
    public Route deleteRoute(Integer routeId) {
        Optional<Route> optionalRoute = routeRepository.findById(routeId);
        if (optionalRoute.isPresent()){
            Route route = optionalRoute.get();
            routeRepository.delete(route);
            return route;
        }
        return null;
    }

    @Override
    public Route viewRoute(Integer routeId) {
        return routeRepository.findByRouteId(routeId);
    }

    @Override
    public List<Route> viewAllRoute() {
        return routeRepository.findAll();
    }
}
