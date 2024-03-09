package com.mariusniemet.restapi.services;

import com.mariusniemet.restapi.entities.Game;
import com.mariusniemet.restapi.repositories.IGamesRepository;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GamesService {
    private final IGamesRepository repository;

    public  GamesService(IGamesRepository repository){
        this.repository = repository;
    }

    public List<Game> findAll() {
        return this.repository.findAll();
    }

    public Game create(Game newGame) throws BadRequestException {
        Game existedGame = this.repository.findByName(newGame.getName());

        if(existedGame != null){
            throw new BadRequestException("The game already exists");
        }
        return this.repository.save(newGame);
    }

    public Game update(Long id, Game gameToUpdate) throws BadRequestException {
        Optional<Game> optionalGame = this.repository.findById(id);

        if(optionalGame.isEmpty()){
            throw new BadRequestException();
        }
        Game existingGame = optionalGame.get();
        existingGame.setName(gameToUpdate.getName());
        return this.repository.save(existingGame);
    }

    public Game remove(Long id) throws BadRequestException {
        Optional<Game> game = this.repository.findById(id);

        if(game.isEmpty()){
            throw new BadRequestException();
        }
        this.repository.delete(game.get());
        return game.get();
    }
}
