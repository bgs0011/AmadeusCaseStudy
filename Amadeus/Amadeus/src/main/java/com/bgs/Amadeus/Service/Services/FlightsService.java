package com.bgs.Amadeus.Service.Services;

import com.bgs.Amadeus.Core.Models.Flight;
import com.bgs.Amadeus.Repositories.IFlightsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightsService {

    @Autowired
    private IFlightsRepository repository;
    public Optional<List<Flight>> searchFlights(String DepartureAirport, String ArrivalAirport, String DepartureDate, String ReturnDate){
        return repository.findByParams(DepartureAirport, ArrivalAirport, DepartureDate, ReturnDate);
    }
    public Optional<List<Flight>> searchOneWayFlights(String DepartureAirport, String ArrivalAirport, String DepartureDate){
        return repository.searchOneWayFlightsbyParams(DepartureAirport, ArrivalAirport, DepartureDate);
    }

    public List<Flight> findAll() {
        return repository.findAll();
    }

    public void save(Flight entity) {
        repository.save(entity);
    }

    public Optional<Flight> findById(int id) {
        return repository.findById(id);
    }

    public void delete(Flight entity) {
        repository.delete(entity);
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }

    public long count() {
        return repository.count();
    }
}
