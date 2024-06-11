package es.ies.puerto.mgs.project.service.impl;
import es.ies.puerto.mgs.project.dto.GameDTO;
import es.ies.puerto.mgs.project.dto.MGSCharacterDTO;
import es.ies.puerto.mgs.project.mapper.struct.IArtistMapper;
import es.ies.puerto.mgs.project.mapper.struct.IGameMapper;
import es.ies.puerto.mgs.project.model.db.jpa.dao.IDaoGame;
import es.ies.puerto.mgs.project.model.entities.Game;
import es.ies.puerto.mgs.project.service.interfaces.IServiceJPA;
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
public class GameService implements IServiceJPA<GameDTO> {
    /**
     * Properties
     */
    private final static Logger LOGGER = LoggerFactory.getLogger(GameService.class);

    private IDaoGame iDaoGame;

    /**
     * Default constructor of the class
     */
    public GameService(){}

    /**
     * Setter of the dao
     * @param iDaoGame
     */
    @Autowired
    public void setiDaoGame(IDaoGame iDaoGame) {
        this.iDaoGame = iDaoGame;
    }

    @Override
    public boolean addUpdate(GameDTO gameDTO) {
        if (gameDTO == null){
            return false;
        }
        iDaoGame.save(IGameMapper.INSTANCE.toEntity(gameDTO));
        return true;
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
        if (!iDaoGame.existsById(id)) {
            return null;
        }

        GameDTO result = null;

        List<GameDTO> list = getAll();

        for (GameDTO gameDTO: list){
            if (gameDTO.getId() == id){
                result = gameDTO;
                break;
            }
        }
        return result;

    }

    @Override
    public boolean delete(int id) {
        if (!iDaoGame.existsById(id)) {
            return false;
        }
        iDaoGame.deleteById(id);
        return true;
    }
}
