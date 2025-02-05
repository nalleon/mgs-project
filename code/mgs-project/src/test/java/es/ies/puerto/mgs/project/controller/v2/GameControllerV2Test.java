package es.ies.puerto.mgs.project.controller.v2;


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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class GameControllerV2Test extends TestUtilities {
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

}
