package es.ies.puerto.mgs.project.service.soap.impl;
import es.ies.puerto.mgs.project.dto.ArtistDTO;
import es.ies.puerto.mgs.project.service.interfaces.IService;
import es.ies.puerto.mgs.project.service.interfaces.IServiceSoap;
import es.ies.puerto.mgs.project.service.rest.impl.ArtistService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author nalleon
 */


@Component
@WebService(endpointInterface = "es.ies.puerto.mgs.project.service.interfaces.IServiceSoap")
public class ArtistServiceSoap implements IServiceSoap<ArtistDTO> {
    private IService<ArtistDTO> service;

    @Autowired
    public void setRepository(IService<ArtistDTO> service) {
        this.service = service;
    }

    @Override
    public boolean add(ArtistDTO artistDTO) {
        return service.add(artistDTO);
    }

    /**@Override
    public boolean update(int id, ArtistDTO artistDTO) throws Exception {
        return false;
    }*/

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
        return delete(id);
    }
}
