package es.ies.puerto.mgs.project.service.impl;
import es.ies.puerto.mgs.project.dto.DirectorDTO;
import es.ies.puerto.mgs.project.dto.MGSCharacterDTO;
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
    public boolean addUpdate(DirectorDTO directorDTO) {
        if (directorDTO == null){
            return false;
        }

        iDaoDirector.save(IDirectorMapper.INSTANCE.toEntity(directorDTO));
        return true;
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
        if (!iDaoDirector.existsById(id)) {
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
        if (!iDaoDirector.existsById(id)) {
            return false;
        }
        iDaoDirector.deleteById(id);
        return true;
    }
}
