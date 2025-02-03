package es.ies.puerto.mgs.project.service.rest.impl;
import es.ies.puerto.mgs.project.exception.NotFoundException;
import es.ies.puerto.mgs.project.mapper.struct.IArtistMapper;
import es.ies.puerto.mgs.project.mapper.struct.IWeaponMapper;
import es.ies.puerto.mgs.project.model.db.jpa.dao.IDaoArtist;
import es.ies.puerto.mgs.project.model.entities.Artist;
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
public class ArtistService implements IService<Artist> {
    /**
     * Properties
     */
    private final static Logger LOGGER = LoggerFactory.getLogger(ArtistService.class);

    private IDaoArtist repository;

    /**
     * Default constructor of the class
     */
    public ArtistService(){}


    /**
     * Setter of the dao
     * @param repository of the service
     */
    @Autowired
    public void setDao(IDaoArtist repository) {
        this.repository = repository;
    }

    @Override
    public boolean add(Artist artist){
        if (artist == null){
            return false;
        }
        if(repository.existsById(artist.getArtistId())){
            return false;
        }

        repository.save(artist);
        return true;
    }

    @Override
    public boolean update(int id, Artist artist) throws Exception {
        try {
            Artist toUpdate = repository.findById(id).orElse(null);

            if(toUpdate!= null){
                toUpdate.setFullName(artist.getFullName());
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
    public List<Artist> getAll() {
        return repository.findAll();
    }

    @Override
    public Artist getById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public boolean delete(int id) {
        int quantity = repository.deleteItemById(id);
        return quantity > 0;
    }
}
