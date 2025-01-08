package es.ies.puerto.mgs.project.service.soap;

import es.ies.puerto.mgs.project.dto.ArtistDTO;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;

import java.util.List;

@WebService(targetNamespace = "es.ies.puerto.mgs.project.service.soap")
public interface IServiceSoap{
    @WebMethod
    @WebResult(name="artist")

    List<ArtistDTO> getAll();
}
