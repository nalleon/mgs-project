package es.ies.puerto.mgs.project.service.rest.impl;
import es.ies.puerto.mgs.project.repository.jpa.dao.IDaoGame;
import es.ies.puerto.mgs.project.model.entities.Game;
import es.ies.puerto.mgs.project.service.interfaces.IService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

/**
 * @author nalleon
 */
@Component
@Transactional
public class GameService implements IService<Game> {
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
     * @param repository of the service
     */
    @Autowired
    public void setiDaoGame(IDaoGame repository) {
        this.repository = repository;
    }

    @Override
    public boolean add(Game game) {
        if (game == null){
            return false;
        }
        if(repository.existsById(game.getId())){
            return false;
        }

        repository.save((game));
        return true;
    }

    @Override
    public boolean update(int id, Game game) throws Exception {
        try {
            Game toUpdate = repository.findById(id).orElse(null);

            if(toUpdate!= null){
                toUpdate.setDirector(game.getDirector());
                toUpdate.setName(game.getName());
                toUpdate.setGameCharacters(game.getGameCharacters());
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
    public List<Game> getAll() {
        return repository.findAll();
    }

    @Override
    public Game getById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public boolean delete(int id) {
        int quantity = repository.deleteItemById(id);
        return quantity > 0;
    }
}
