package com.mariusniemet.restapi.repositories;

import com.mariusniemet.restapi.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGamesRepository extends JpaRepository<Game, Long> {
    Game findByName(String name);
}
