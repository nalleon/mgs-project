package es.ies.puerto.mgs.project.service.impl;
import es.ies.puerto.mgs.project.dto.DirectorDTO;
import es.ies.puerto.mgs.project.mapper.struct.IDirectorMapper;
import es.ies.puerto.mgs.project.model.db.jpa.dao.IDaoDirector;
import es.ies.puerto.mgs.project.model.entities.Director;
import es.ies.puerto.mgs.project.service.interfaces.IService;
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
public class DirectorService implements IService<DirectorDTO> {
    /**
     * Properties
     */
    private final static Logger LOGGER = LoggerFactory.getLogger(DirectorService.class);

    private IDaoDirector iDaoDirector;

    /**
     * Default constructor of the class
     */
    public DirectorService (){}

    /**
     * Setter of the dao
     * @param iDaoDirector
     */
    @Autowired
    public void setiDaoDirector(IDaoDirector iDaoDirector) {
        this.iDaoDirector = iDaoDirector;
    }

    @Override
    public void add(DirectorDTO directorDTO) {
        iDaoDirector.save(IDirectorMapper.INSTANCE.toEntity(directorDTO));
    }

    @Override
    public void update(DirectorDTO directorDTO) {
        Director director = iDaoDirector.findById(directorDTO.getDirectorId()).orElseThrow(
                () -> new RuntimeException("Can not find by ID")
        );
        iDaoDirector.save(director);
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
        Director director = iDaoDirector.findById(id).orElseThrow(
                () -> new RuntimeException("Cannot find by ID")
        );
        return IDirectorMapper.INSTANCE.toDTO(director);

    }

    @Override
    public void delete(int id) {
        Director director = iDaoDirector.findById(id).orElseThrow(
                () -> new RuntimeException("Cannot find by ID"));
        iDaoDirector.delete(director);
    }
}
