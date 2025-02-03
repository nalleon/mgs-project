package es.ies.puerto.mgs.project.service.rest.impl;

import es.ies.puerto.mgs.project.model.db.jpa.dao.IDaoMGSCharacter;
import es.ies.puerto.mgs.project.model.entities.MGSCharacter;
import es.ies.puerto.mgs.project.service.interfaces.IService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author nalleon
 */
@Component
@Transactional
public class MGSCharacterService implements IService<MGSCharacter> {
    /**
     * Properties
     */
    private final static Logger LOGGER = LoggerFactory.getLogger(MGSCharacterService.class);

    private IDaoMGSCharacter repository;

    /**
     * Default constructor of the class
     */
    public MGSCharacterService(){}

    /**
     * Setter of the dao
     * @param repository of the service
     */
    @Autowired
    public void setDao(IDaoMGSCharacter repository) {
        this.repository = repository;
    }

    @Override
    public boolean add(MGSCharacter mgsCharacter) {
        if (mgsCharacter == null){
            return false;
        }
        if(repository.existsById(mgsCharacter.getId())){
            return false;
        }

        repository.save(mgsCharacter);
        return true;
    }

    @Override
    public boolean update(int id, MGSCharacter mgsCharacter) throws Exception {
        try {
            MGSCharacter toUpdate = repository.findById(id).orElse(null);

            if(toUpdate!= null){
                toUpdate.setCodename(mgsCharacter.getCodename());
                toUpdate.setName(mgsCharacter.getName());
                toUpdate.setAge(mgsCharacter.getAge());
                toUpdate.setArtist(mgsCharacter.getArtist());
                toUpdate.setStatus(mgsCharacter.isStatus());
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
    public List<MGSCharacter> getAll() {
        return repository.findAll();
    }

    @Override
    public MGSCharacter getById(int id) {
       return  repository.findById(id).orElse(null);
    }

    @Override
    public boolean delete(int id) {
        int quantity = repository.deleteItemById(id);
        return quantity > 0;
    }
}
