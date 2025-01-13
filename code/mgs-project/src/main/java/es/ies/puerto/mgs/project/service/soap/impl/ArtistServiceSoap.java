package es.ies.puerto.mgs.project.service.soap.impl;
import es.ies.puerto.mgs.project.dto.ArtistDTO;
import es.ies.puerto.mgs.project.service.interfaces.IService;
import es.ies.puerto.mgs.project.service.interfaces.IServiceSoap;
import es.ies.puerto.mgs.project.service.rest.impl.ArtistService;

import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author nalleon
 */
@Component
@WebService(endpointInterface = "es.ies.puerto.mgs.project.service.interfaces.IServiceSoap")
public class ArtistServiceSoap implements IServiceSoap<ArtistDTO> {
    /**
     * Properties
     */
    private final static Logger LOGGER = LoggerFactory.getLogger(ArtistServiceSoap.class);
    private IService<ArtistDTO> service;

    /**
     * Setter of the service
     * @param service
     */
    @Autowired
    public void setService(ArtistService service) {
        this.service = service;
    }

    @Override
    public boolean add(@WebParam(name = "artist") ArtistDTO artistDTO) {
        return service.add(artistDTO);
    }

    @Override
    public boolean update(ArtistDTO artistDTO) throws Exception {
        return service.update(artistDTO.getArtistId(), artistDTO);
    }

    @WebResult(name="artist")
    @Override
    public List<ArtistDTO> getAll() {
        return service.getAll();
    }

    @Override
    public ArtistDTO getById(int id) {
        return service.getById(id);
    }

    @Override
    public boolean delete(int id) {
        return service.delete(id);
    }
}
