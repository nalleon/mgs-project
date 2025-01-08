package es.ies.puerto.mgs.project.service.soap;
import es.ies.puerto.mgs.project.dto.ArtistDTO;
import es.ies.puerto.mgs.project.service.rest.ArtistService;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author nalleon
 */
@WebService(endpointInterface = "es.ies.puerto.mgs.project.service.soap.IServiceSoap")
public class ArtistServiceSoap implements IServiceSoap {

    private ArtistService service;

    @Autowired
    public void setRepository(ArtistService service) {
        this.service = service;
    }
    @WebResult(
            name="artist")
    @Override
    public List<ArtistDTO> getAll() {
        return  service.getAll();
    }
}
