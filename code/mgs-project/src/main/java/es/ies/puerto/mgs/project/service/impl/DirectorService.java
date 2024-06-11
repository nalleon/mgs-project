package es.ies.puerto.mgs.project.service.impl;
import es.ies.puerto.mgs.project.dto.DirectorDTO;
import es.ies.puerto.mgs.project.mapper.struct.IArtistMapper;
import es.ies.puerto.mgs.project.mapper.struct.IDirectorMapper;
import es.ies.puerto.mgs.project.model.db.jpa.dao.IDaoDirector;
import es.ies.puerto.mgs.project.model.entities.Director;
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
public class DirectorService implements IServiceJPA<DirectorDTO> {
    /**
     * Properties
     */
    private final static Logger LOGGER = LoggerFactory.getLogger(DirectorService.class);

    private IDaoDirector iDaoDirector;

    /**
     * Default constructor of the class
     */
    public DirectorService(){}

    /**
     * Setter of the dao
     * @param iDaoDirector
     */
    @Autowired
    public void setiDaoDirector(IDaoDirector iDaoDirector) {
        this.iDaoDirector = iDaoDirector;
    }

    @Override
    public boolean add(DirectorDTO directorDTO) {
        if (!iDaoDirector.existsById(directorDTO.getDirectorId())){
            iDaoDirector.save(IDirectorMapper.INSTANCE.toEntity(directorDTO));
        }
        return true;
    }

    @Override
    public boolean update(DirectorDTO directorDTO) {
        if (iDaoDirector.existsById(directorDTO.getDirectorId())) {
            iDaoDirector.save(IDirectorMapper.INSTANCE.toEntity(directorDTO));
            return true;
        } else {
            throw new RuntimeException("Cannot find by ID");
        }
    }

    @Override
    public List<DirectorDTO> getAll() {
        List<Director> directors = iDaoDirector.findAll();
        List<DirectorDTO> directorDTOS = new ArrayList<>();
        for (Director director : directors){
            directorDTOS.add(IDirectorMapper.INSTANCE.toDTO(director));
        }
        return directorDTOS;
    }

    @Override
    public DirectorDTO getById(int id) {
        return IDirectorMapper.INSTANCE.toDTO(iDaoDirector.getById(id));
    }

    @Override
    public boolean delete(int id) {
        if (iDaoDirector.existsById(id)) {
            iDaoDirector.deleteById(id);
            return true;
        } else {
            throw new RuntimeException("Cannot find by ID");
        }
    }
}
