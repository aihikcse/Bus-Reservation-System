package org.bus.service;


import org.bus.model.Route;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface IRouteService {
    public Route addRoute(Route route);
    public Route updateRoute(Route route);
    public Route deleteRoute(Integer routeId);
    public Route viewRoute(Integer routeId);
    public List<Route> viewAllRoute();
}
