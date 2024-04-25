package org.bus.service;

import org.bus.model.Bus;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface IBusService {
    public Bus addBus(Bus bus);
    public Bus updateBus(Bus bus);
    public Bus deleteBus(Integer busId);
    public Bus viewBus(Integer busId);
    public List<Bus>viewBusByType(String busType);
    public List<Bus>viewAllBus();

}
