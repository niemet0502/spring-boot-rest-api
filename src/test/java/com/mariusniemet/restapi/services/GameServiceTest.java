package com.mariusniemet.restapi.services;

import com.mariusniemet.restapi.entities.Game;
import com.mariusniemet.restapi.repositories.IGamesRepository;
import org.apache.coyote.BadRequestException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class GameServiceTest {

    @Mock
    IGamesRepository repository;


    GamesService service;
    @BeforeEach
    public void setup(){
        MockitoAnnotations.openMocks(this);
        service = new GamesService(repository);
    }

    @Test
    public  void findAll(){
        // arrange
        List<Game> expectedResult = List.of(new Game(), new Game(), new Game());
        when(repository.findAll()).thenReturn(expectedResult);

        // act
        List<Game> result = service.findAll();

        // assert
        assertEquals(3, result.size());
    }

    @Test
    public  void createShouldThrowBadRequestException() {
        // arrange
        Game newGame = new Game();
        newGame.setName("Elden ring");

        when(repository.findByName(newGame.getName())).thenReturn(newGame);

        // act and assert
        assertThrows(BadRequestException.class, () -> service.create(newGame));

    }

    @Test
    public void create() throws BadRequestException {
        // arrange
        Game newGame = new Game();
        newGame.setName("Elden ring");

        when(repository.findByName(newGame.getName())).thenReturn(null);
        when(service.create(newGame)).thenReturn(newGame);

        // act
        Game result = service.create(newGame);

        // assert
        assertEquals(newGame.getName(), result.getName());
    }

    @Test
    public void remove() throws BadRequestException {
        // arrange
        Long id = 1L;
        Game game = new Game();
        game.setId(id);
        when(repository.findById(id)).thenReturn(Optional.of(game));
        doNothing().when(repository).delete(game); // Stubbing the void method

        // act
        Game result = service.remove(id);

        // assert
        assertNotNull(result);
        assertEquals(id, result.getId());
        verify(repository, times(1)).delete(game);
    }

    @Test
    public void removeShouldThrowBadRequestException(){
        // arrange
        Long id = 1L;
        when(repository.findById(id)).thenReturn(Optional.empty());

        // act and assert
        assertThrows(BadRequestException.class, () -> service.remove(id));
    }
}
