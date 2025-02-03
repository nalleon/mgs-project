package es.ies.puerto.mgs.project.service.rest.impl;
import es.ies.puerto.mgs.project.model.db.jpa.dao.IDaoDirector;
import es.ies.puerto.mgs.project.model.entities.Director;
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
public class DirectorService implements IService<Director> {
    /**
     * Properties
     */
    private final static Logger LOGGER = LoggerFactory.getLogger(DirectorService.class);

    private IDaoDirector repository;

    /**
     * Default constructor of the class
     */
    public DirectorService(){}


    /**
     * Setter of the dao
     * @param repository of the service
     */
    @Autowired
    public void setDao(IDaoDirector repository) {
        this.repository = repository;
    }

    @Override
    public boolean add(Director director) {
        if (director == null){
            return false;
        }
        if(repository.existsById(director.getDirectorId())){
            return false;
        }

        repository.save((director));
        return true;
    }

    @Override
    public boolean update(int id, Director director) throws Exception {
        try {
            Director toUpdate = repository.findById(id).orElse(null);

            if(toUpdate!= null){
                toUpdate.setFullName(director.getFullName());
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
    public List<Director> getAll() {
        return repository.findAll();
    }

    @Override
    public Director getById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public boolean delete(int id) {
        int quantity = repository.deleteItemById(id);
        return quantity > 0;
    }
}
