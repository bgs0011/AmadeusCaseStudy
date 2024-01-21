package com.bgs.Amadeus.Controller;

import com.bgs.Amadeus.Core.Models.Flight;
import com.bgs.Amadeus.Service.Services.FlightsService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/Flights")
@EnableWebMvc
@OpenAPIDefinition(info = @Info(title = "User Management API", version = "1.0", description = "Documentation User Management API v1.0"))
@SecurityScheme(name = "bearer-jwt", scheme = "Bearer", type = SecuritySchemeType.HTTP, in = SecuritySchemeIn.HEADER )

public class FlightsController {
    @Autowired
    private FlightsService flightsService;
    private Object OpenApi30Config;

    @PostMapping("/save")
    public void SaveFlights(@RequestBody Flight flight){
        flightsService.save(flight);
    }

    @GetMapping("/getall")
    public List<Flight> GetAllFlights(){
        return flightsService.findAll();
    }

    @DeleteMapping("/delete")
    public void DeleteFlight(@RequestBody Flight flight){
        flightsService.delete(flight);
    }

    @GetMapping("/getbyid/{flightid}")
    public Optional GetFlightsById(@PathVariable int flightid){
        return flightsService.findById(flightid);
    }

    @DeleteMapping("/deletebyid/{flightid}")
    public void deleteFlightsById(@PathVariable int flightid){
        flightsService.deleteById(flightid);
    }


    @GetMapping("/getFlightsByParms/{DepartureAirport}/{ArrivalAirport}/{DepartureDate}/{ReturnDate}")
    public Optional<List<Flight>> searchFlights(@PathVariable(name = "DepartureAirport") String DepartureAirport
            , @PathVariable(name = "ArrivalAirport") String ArrivalAirport,
                                                 @PathVariable(name = "DepartureDate") String DepartureDate, @PathVariable(name = "ReturnDate") String ReturnDate){
        return flightsService.searchFlights(DepartureAirport, ArrivalAirport, DepartureDate, ReturnDate);
    }
    @GetMapping("/getFlightsByParms/{DepartureAirport}/{ArrivalAirport}/{DepartureDate}")
    public Optional<List<Flight>> searchFlights(@PathVariable(name = "DepartureAirport") String DepartureAirport
            , @PathVariable(name = "ArrivalAirport") String ArrivalAirport,
                                                 @PathVariable(name = "DepartureDate") String DepartureDate){
        return flightsService.searchOneWayFlights(DepartureAirport, ArrivalAirport, DepartureDate);
    }

}