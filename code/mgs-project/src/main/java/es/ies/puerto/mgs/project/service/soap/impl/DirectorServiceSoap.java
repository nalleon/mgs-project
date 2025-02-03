package es.ies.puerto.mgs.project.service.soap.impl;
import es.ies.puerto.mgs.project.dto.ArtistDTO;
import es.ies.puerto.mgs.project.dto.DirectorDTO;
import es.ies.puerto.mgs.project.mapper.struct.IDirectorMapper;
import es.ies.puerto.mgs.project.model.db.jpa.dao.IDaoDirector;
import es.ies.puerto.mgs.project.model.entities.Director;
import es.ies.puerto.mgs.project.service.interfaces.IService;
import es.ies.puerto.mgs.project.service.interfaces.IServiceSoap;
import es.ies.puerto.mgs.project.service.rest.impl.DirectorService;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author nalleon
 */
@Component
@WebService(endpointInterface = "es.ies.puerto.mgs.project.service.interfaces.IServiceSoap")
public class DirectorServiceSoap implements IServiceSoap<DirectorDTO> {
    /**
     * Properties
     */
    private final static Logger LOGGER = LoggerFactory.getLogger(DirectorServiceSoap.class);

    private IService<Director> service;

    /**
     * Setter of the service
     * @param service
     */
    @Autowired
    public void setService(IService<Director> service) {
        this.service = service;
    }

    @Override
    public boolean add(DirectorDTO directorDTO) {
        return service.add(IDirectorMapper.INSTANCE.toEntity(directorDTO));
    }

    @Override
    public boolean update(DirectorDTO directorDTO) throws Exception {
        return service.update(directorDTO.getDirectorId(), IDirectorMapper.INSTANCE.toEntity(directorDTO));
    }

    @WebResult(name="director")

    @Override
    public List<DirectorDTO> getAll() {
       return service.getAll().stream()
               .map(item -> new DirectorDTO(item.getDirectorId(), item.getFullName()))
               .collect(Collectors.toList());
    }

    @Override
    public DirectorDTO getById(int id) {
        return IDirectorMapper.INSTANCE.toDTO(service.getById(id));
    }

    @Override
    public boolean delete(int id) {
        return service.delete(id);
    }
}
