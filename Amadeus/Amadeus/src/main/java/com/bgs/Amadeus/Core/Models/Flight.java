package com.bgs.Amadeus.Core.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
@Entity
@Getter
@Setter
@ToString
@Table(name = "Flight")
@NoArgsConstructor
@AllArgsConstructor

public class Flight {
    @Id
    @GeneratedValue
    private int id;

    private String DepartureAirport;
    private String ArrivalAirport;

    private String DepartureDate;
    private String ReturnDate;

    private int Price;

}
