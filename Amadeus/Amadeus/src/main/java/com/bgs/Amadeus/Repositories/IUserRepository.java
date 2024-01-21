package com.bgs.Amadeus.Repositories;

import com.bgs.Amadeus.Core.Models.Flight;
import com.bgs.Amadeus.Core.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<User,Integer> {
    Optional<User> findByEmail(String email);

}
