package es.ies.puerto.mgs.project.controller.v3;

import es.ies.puerto.mgs.project.dto.outputs.GameDTO;
import es.ies.puerto.mgs.project.model.entities.Director;
import es.ies.puerto.mgs.project.model.entities.Game;
import es.ies.puerto.mgs.project.model.entities.MGSCharacter;
import es.ies.puerto.mgs.project.service.rest.impl.GameService;
import es.ies.puerto.mgs.project.utilities.TestUtilities;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class GameControllerTest extends TestUtilities {
    public static final Game TEST_1 = new Game(1, "test1", new HashSet<>(Arrays.asList(new MGSCharacter(1))));
    @Mock
    GameService serviceMock;

    @InjectMocks
    GameController controller;


    @BeforeEach
    public void beforeEach (){
        MockitoAnnotations.openMocks(this);
        controller = new GameController();
        controller.setGameService(serviceMock);
    }
    @Test
    void getAllTest() {
        List<Game> list = new ArrayList<>();
        Game aux = TEST_1;
        aux.setDirector(new Director(1, "directorTest"));
        list.add(TEST_1);
        when(serviceMock.getAll()).thenReturn(list);
        Assertions.assertNotNull(controller.getAll(), MESSAGE_ERROR);
    }


    @Test
    void getOneTest() {
        when(serviceMock.getById(1)).thenReturn(new Game(1));
        Assertions.assertNotNull(controller.getById(1), MESSAGE_ERROR);
    }

    @Test
    void addTest() {
        when(serviceMock.add(any(Game.class))).thenReturn(true);
        Game aux = new Game(1);
        ResponseEntity responseEntity = controller.add(new GameDTO(aux.getId()));
        Assertions.assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode(), MESSAGE_ERROR);
    }


    @Test
    void deleteTest() {
        ResponseEntity responseEntity = controller.delete(1);
        Assertions.assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode(), MESSAGE_ERROR);
    }


    @Test
    void updateTest() {
        Game aux = new Game(1);
        when(serviceMock.add(aux)).thenReturn(true);
        ResponseEntity responseEntity = controller.update(1, new GameDTO(aux.getId()));
        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode(), MESSAGE_ERROR);
    }

    @Test
    void updateExceptionTest() throws Exception {
        Game aux = new Game(1);
        when(serviceMock.update(1, new Game(1))).thenThrow(new RuntimeException("Database error"));
        Assertions.assertThrows(RuntimeException.class, () -> controller.update(1, new GameDTO(aux.getId())), MESSAGE_ERROR);
    }
}
