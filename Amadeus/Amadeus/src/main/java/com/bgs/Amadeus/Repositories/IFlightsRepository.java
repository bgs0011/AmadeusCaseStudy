package com.bgs.Amadeus.Repositories;

import com.bgs.Amadeus.Core.Models.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import java.util.Optional;

public interface IFlightsRepository extends JpaRepository<Flight,Integer> {
    @Query("SELECT f FROM Flight f WHERE (f.DepartureAirport = :DepartureAirport AND f.ArrivalAirport = :ArrivalAirport AND f.DepartureDate= :DepartureDate AND f.ReturnDate = :ReturnDate ) OR" +
            " (f.DepartureAirport = :ArrivalAirport AND f.ArrivalAirport = :DepartureAirport)")
    Optional<List<Flight>> findByParams(String DepartureAirport, String ArrivalAirport, String DepartureDate, String ReturnDate);

    @Query("SELECT f FROM Flight f WHERE f.DepartureAirport = :DepartureAirport AND f.ArrivalAirport = :ArrivalAirport AND f.DepartureDate= :DepartureDate")
    Optional<List<Flight>> searchOneWayFlightsbyParams(String DepartureAirport, String ArrivalAirport, String DepartureDate);


}
