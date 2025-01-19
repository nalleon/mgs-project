package es.ies.puerto.mgs.project.service.rest.impl;
import es.ies.puerto.mgs.project.dto.DirectorDTO;
import es.ies.puerto.mgs.project.mapper.struct.IArtistMapper;
import es.ies.puerto.mgs.project.mapper.struct.IDirectorMapper;
import es.ies.puerto.mgs.project.model.db.jpa.dao.IDaoDirector;
import es.ies.puerto.mgs.project.model.entities.Artist;
import es.ies.puerto.mgs.project.model.entities.Director;
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
public class DirectorService implements IService<DirectorDTO> {
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
     * @param repository
     */
    @Autowired
    public void setDao(IDaoDirector repository) {
        this.repository = repository;
    }

    @Override
    public boolean add(DirectorDTO directorDTO) {
        if (directorDTO == null){
            return false;
        }
        if(repository.existsById(directorDTO.getDirectorId())){
            return false;
        }

        repository.save(IDirectorMapper.INSTANCE.toEntity(directorDTO));
        return true;
    }

    @Override
    public boolean update(int id, DirectorDTO directorDTO) throws Exception {
        try {
            Director toUpdate = repository.findById(id).orElse(null);

            if(toUpdate!= null){
                toUpdate.setFullName(directorDTO.getFullName());
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
    public List<DirectorDTO> getAll() {
        return repository.findAll()
                .stream()
                .map(IDirectorMapper.INSTANCE::toDTO)
                .toList();
    }

    @Override
    public DirectorDTO getById(int id) {
        Director result = repository.findById(id).orElse(null);;

        if(result != null) {
            return IDirectorMapper.INSTANCE.toDTO(result);
        }

        return null;
    }

    @Override
    public boolean delete(int id) {
        int quantity = repository.deleteItemById(id);
        return quantity > 0;
    }
}
