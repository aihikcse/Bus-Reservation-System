package org.bus.service;

import org.bus.model.Bus;
import org.bus.repository.BusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class BusServiceImpl implements IBusService{

    @Autowired
    public BusRepository busRepository;
    
   
    

    @Override
    public Bus addBus(Bus bus) {
        return busRepository.save(bus);
    }

    @Override
    public Bus updateBus(Bus bus) {
        return busRepository.save(bus);
    }

    @Override
    public Bus deleteBus(Integer busId) {
        Optional<Bus> opt = busRepository.findById(busId);
        if(opt.isPresent()){
            Bus bus = opt.get();
            busRepository.delete(bus);
            return bus;
        }
        return null;
    }

    @Override
    public Bus viewBus(Integer busId) {
        return busRepository.findById(busId).get();
    }

    @Override
    public List<Bus> viewBusByType(String busType) {
        return busRepository.findByBusType(busType);
    }

    @Override
    public List<Bus> viewAllBus() {
        return busRepository.findAll();
    }
}
