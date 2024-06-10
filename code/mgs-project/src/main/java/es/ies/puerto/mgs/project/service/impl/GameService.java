package es.ies.puerto.mgs.project.service.impl;
import es.ies.puerto.mgs.project.dto.GameDTO;
import es.ies.puerto.mgs.project.mapper.struc.IGameMapper;
import es.ies.puerto.mgs.project.mapper.struc.IMGSCharacterMapper;
import es.ies.puerto.mgs.project.model.db.jpa.dao.IDaoGame;
import es.ies.puerto.mgs.project.model.db.jpa.dao.IDaoMGSCharacter;
import es.ies.puerto.mgs.project.model.entities.Game;
import es.ies.puerto.mgs.project.model.entities.MGSCharacter;
import es.ies.puerto.mgs.project.service.interfaces.IService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author nalleon
 */
@Service
public class GameService implements IService<GameDTO> {
    /**
     * Properties
     */
    private final static Logger LOGGER = LoggerFactory.getLogger(GameService.class);

    private IDaoGame iDaoGame;

    /**
     * Default constructor of the class
     */
    public GameService (){}

    /**
     * Setter of the dao
     * @param iDaoGame
     */
    @Autowired
    public void setiDaoGame(IDaoGame iDaoGame) {
        this.iDaoGame = iDaoGame;
    }

    @Override
    public void add(GameDTO gameDTO) {
        iDaoGame.save(IGameMapper.INSTANCE.toEntity(gameDTO));
    }

    @Override
    public void update(GameDTO gameDTO) {
        Game game = iDaoGame.findById(gameDTO.getId()).orElseThrow(
                () -> new RuntimeException("Can not find by ID")
        );
        iDaoGame.save(game);
    }

    @Override
    public List<GameDTO> getAll() {
        List<Game> games = iDaoGame.findAll();
        List<GameDTO> gameDTOS = new ArrayList<>();
        for (Game game : games){
            gameDTOS.add(IGameMapper.INSTANCE.toDTO(game));
        }
        return gameDTOS;
    }

    @Override
    public GameDTO getById(int id) {
        Game game = iDaoGame.findById(id).orElseThrow(
                () -> new RuntimeException("Cannot find by ID")
        );
        return IGameMapper.INSTANCE.toDTO(game);

    }

    @Override
    public void delete(int id) {
        Game game = iDaoGame.findById(id).orElseThrow(
                () -> new RuntimeException("Cannot find by ID"));
        iDaoGame.delete(game);
    }
}
