package es.ies.puerto.mgs.project.service.interfaces;

import es.ies.puerto.mgs.project.dto.ArtistDTO;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;

import java.util.List;

@WebService(targetNamespace = "es.ies.puerto.mgs.project.service.interfaces")
public interface IServiceSoap<T> {
    @WebMethod
    boolean add(T t);
    @WebMethod
    boolean update(@WebParam(name = "item") T t) throws Exception;
    @WebMethod
    List<T> getAll();
    @WebMethod
    T getById(@WebParam(name = "id") int id);
    @WebMethod
    boolean delete(@WebParam(name = "id") int id);
}
