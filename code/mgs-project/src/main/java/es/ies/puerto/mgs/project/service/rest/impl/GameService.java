package es.ies.puerto.mgs.project.service.rest.impl;
import es.ies.puerto.mgs.project.dto.GameDTO;
import es.ies.puerto.mgs.project.mapper.struct.IArtistMapper;
import es.ies.puerto.mgs.project.mapper.struct.IDirectorMapper;
import es.ies.puerto.mgs.project.mapper.struct.IGameMapper;
import es.ies.puerto.mgs.project.model.db.jpa.dao.IDaoGame;
import es.ies.puerto.mgs.project.model.entities.Artist;
import es.ies.puerto.mgs.project.model.entities.Game;
import es.ies.puerto.mgs.project.service.interfaces.IService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.List;

/**
 * @author nalleon
 */
@Component
@Transactional
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
        if(repository.existsById(gameDTO.getId())){
            return false;
        }

        repository.save(IGameMapper.INSTANCE.toEntity(gameDTO));
        return true;
    }

    @Override
    public boolean update(int id, GameDTO gameDTO) throws Exception {
        try {
            Game toUpdate = repository.findById(id).orElse(null);

            if(toUpdate!= null){
                Game aux = IGameMapper.INSTANCE.toEntity(gameDTO);
                toUpdate.setDirector(aux.getDirector());
                toUpdate.setName(aux.getName());
                toUpdate.setGameCharacters(aux.getGameCharacters());
                repository.save(toUpdate);
                return true;
            } else {
                return false;
            }

        } catch (RuntimeException e){
            return false;
        }
    }


    @Override
    public List<GameDTO> getAll() {
        return repository.findAll()
                .stream()
                .map(IGameMapper.INSTANCE::toDTO)
                .toList();
    }

    @Override
    public GameDTO getById(int id) {
        Game result = repository.findById(id).orElse(null);;

        if(result != null) {
            return IGameMapper.INSTANCE.toDTO(result);
        }

        return null;

    }

    @Override
    public boolean delete(int id) {
        int quantity = repository.deleteItemById(id);
        return quantity > 0;
    }
}
