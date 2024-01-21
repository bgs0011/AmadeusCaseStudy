package com.bgs.Amadeus.Core.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
@Entity
@Getter
@Setter
@ToString
@Table(name = "Airport")
@NoArgsConstructor
@AllArgsConstructor

public class Airport {
    @Id
    @GeneratedValue
    private int id;
    private String City;
}
