package com.mariusniemet.restapi.controllers;

import com.mariusniemet.restapi.entities.Game;
import com.mariusniemet.restapi.services.GamesService;
import org.apache.coyote.BadRequestException;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/games")
public class GamesController {
    private final GamesService service;

    public  GamesController(GamesService service){
        this.service = service;
    }
    @GetMapping
    public ResponseEntity<List<Game>> findAll(){
        List<Game> result = this.service.findAll();
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<Game> create(@RequestBody Game newGame) throws BadRequestException {
        return ResponseEntity.ok(this.service.create(newGame));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Game> update(@RequestBody Game gameToUpdate, @PathVariable Long id) throws BadRequestException {
        Game result = this.service.update(id, gameToUpdate);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Game> remove(@PathVariable Long id)  throws BadRequestException {
        Game result = this.service.remove(id);
        return ResponseEntity.ok(result);
    }
}
