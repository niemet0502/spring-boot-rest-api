package com.mariusniemet.restapi.controllers;

import com.mariusniemet.restapi.entities.Game;
import com.mariusniemet.restapi.services.GamesService;
import org.apache.coyote.BadRequestException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;


public class GamesControllerTest {
    @Mock
    GamesService service;

    GamesController controller;

    @BeforeEach
    public  void setup(){
        MockitoAnnotations.openMocks(this);
        controller = new GamesController(service);
    }

    @Test
    public void findAll(){
        List<Game> expectedResult = Arrays.asList(
                new Game(),
                new Game(),
                new Game()
        );
        when(service.findAll()).thenReturn(expectedResult);

        // act
        ResponseEntity<List<Game>> response = controller.findAll();

        // assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedResult, response.getBody());
    }

    @Test
    public void create() throws BadRequestException {
        // arrange
        Game newGame = new Game();
        newGame.setName("Assassin Creed");

        when(service.create(newGame)).thenReturn(newGame);

        // act
        ResponseEntity<Game> response = controller.create(newGame);

        // assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(newGame, response.getBody());

    }

    @Test
    public void createShouldThrowBadRequestException() throws BadRequestException {
        // arrange
        Game newGame = new Game();
        newGame.setName("Assassin Creed");

        when(service.create(newGame)).thenThrow(BadRequestException.class);

        // act and assert
        assertThrows(BadRequestException.class, () -> controller.create(newGame));
    }

    @Test
    public void update() throws BadRequestException {
        Long gameId = 1L;
        Game gametoUpdate = new Game();
        gametoUpdate.setName("Assassin creed");

        when(service.update(gameId, gametoUpdate)).thenReturn(gametoUpdate);

        // act
        ResponseEntity<Game> response = controller.update(gametoUpdate, gameId);

        // assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(gametoUpdate, response.getBody());
    }
}
