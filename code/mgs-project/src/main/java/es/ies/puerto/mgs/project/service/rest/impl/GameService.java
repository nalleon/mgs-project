package es.ies.puerto.mgs.project.service.rest.impl;
import es.ies.puerto.mgs.project.dto.GameDTO;
import es.ies.puerto.mgs.project.mapper.struct.IGameMapper;
import es.ies.puerto.mgs.project.model.db.jpa.dao.IDaoGame;
import es.ies.puerto.mgs.project.model.entities.Game;
import es.ies.puerto.mgs.project.service.interfaces.IService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author nalleon
 */
@Component
public class GameService implements IService<GameDTO> {
    /**
     * Properties
     */
    private final static Logger LOGGER = LoggerFactory.getLogger(GameService.class);

    private IDaoGame repository;

    /**
     * Default constructor of the class
     */
    public GameService(){}

    /**
     * Setter of the dao
     * @param repository
     */
    @Autowired
    public void setiDaoGame(IDaoGame repository) {
        this.repository = repository;
    }

    @Override
    public boolean add(GameDTO gameDTO) {
        if (gameDTO == null){
            return false;
        }
        repository.save(IGameMapper.INSTANCE.toEntity(gameDTO));
        return true;
    }

    @Override
    public boolean update(int id, GameDTO gameDTO) throws Exception {
        try {
            Game toUpdate = repository.findById(id).orElseThrow(() ->
                    new Exception("Element not found for this id :: " + id));

            Game aux = IGameMapper.INSTANCE.toEntity(gameDTO);
            toUpdate.setDirector(aux.getDirector());
            toUpdate.setName(aux.getName());
            toUpdate.setGameCharacters(aux.getGameCharacters());

            repository.save(toUpdate);
            return true;

        } catch (Exception e){
            return false;
        }
    }


    @Override
    public List<GameDTO> getAll() {
        List<Game> games = repository.findAll();
        List<GameDTO> gameDTOS = new ArrayList<>();
        for (Game game : games){
            gameDTOS.add(IGameMapper.INSTANCE.toDTO(game));
        }
        return gameDTOS;
    }

    @Override
    public GameDTO getById(int id) {
        if (!repository.existsById(id)) {
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
        if (!repository.existsById(id)) {
            return false;
        }
        repository.deleteById(id);
        return true;
    }
}
