package es.ies.puerto.mgs.project.service.rest.impl;
import es.ies.puerto.mgs.project.dto.DirectorDTO;
import es.ies.puerto.mgs.project.mapper.struct.IDirectorMapper;
import es.ies.puerto.mgs.project.model.db.jpa.dao.IDaoDirector;
import es.ies.puerto.mgs.project.model.entities.Director;
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
    public void setiDaoDirector(IDaoDirector repository) {
        this.repository = repository;
    }

    @Override
    public boolean add(DirectorDTO directorDTO) {
        if (directorDTO == null){
            return false;
        }

        repository.save(IDirectorMapper.INSTANCE.toEntity(directorDTO));
        return true;
    }

    @Override
    public boolean update(int id, DirectorDTO directorDTO) throws Exception {
        try {
            Director toUpdate = repository.findById(id).orElseThrow(() ->
                    new Exception("Element not found for this id :: " + id));

            toUpdate.setFullName(directorDTO.getFullName());
            repository.save(toUpdate);
            return true;

        } catch (Exception e){
            return false;
        }
    }


    @Override
    public List<DirectorDTO> getAll() {
        List<Director> directors = repository.findAll();
        List<DirectorDTO> directorDTOS = new ArrayList<>();
        for (Director director : directors){
            directorDTOS.add(IDirectorMapper.INSTANCE.toDTO(director));
        }
        return directorDTOS;
    }

    @Override
    public DirectorDTO getById(int id) {
        if (!repository.existsById(id)) {
            return null;
        }

        DirectorDTO result = null;

        List<DirectorDTO> list = getAll();

        for (DirectorDTO directorDTO: list){
            if (directorDTO.getDirectorId() == id){
                result = directorDTO;
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
