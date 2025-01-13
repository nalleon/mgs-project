package es.ies.puerto.mgs.project.service.soap.impl;

import es.ies.puerto.mgs.project.dto.UserDTO;
import es.ies.puerto.mgs.project.dto.UserDTO;
import es.ies.puerto.mgs.project.mapper.struct.IUserMapper;
import es.ies.puerto.mgs.project.model.db.jpa.dao.IDaoUser;
import es.ies.puerto.mgs.project.model.entities.User;
import es.ies.puerto.mgs.project.service.interfaces.IService;
import es.ies.puerto.mgs.project.service.interfaces.IServiceSoap;
import es.ies.puerto.mgs.project.service.rest.impl.UserService;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
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
@WebService(endpointInterface = "es.ies.puerto.mgs.project.service.interfaces.IServiceSoap")
public class UserServiceSoap implements IServiceSoap<UserDTO> {
    /**
     * Properties
     */
    private final static Logger LOGGER = LoggerFactory.getLogger(UserServiceSoap.class);

    private IService<UserDTO> service;

    /**
     * Default constructor of the class
     */
    public UserServiceSoap(){}

    /**
     * Setter of the service
     * @param service
     */
    @Autowired
    public void setService(UserService service) {
        this.service = service;
    }

    @Override
    public boolean add(UserDTO userDTO) {
        return service.add(userDTO);
    }

    @Override
    public boolean update(UserDTO userDTO) throws Exception {
        return service.update(userDTO.getId(), userDTO);
    }

    @WebResult(name="user")
    @Override
    public List<UserDTO> getAll() {
        return service.getAll();
    }

    @Override
    public UserDTO getById(int id) {
        return service.getById(id);
    }

    @Override
    public boolean delete(int id) {
        return service.delete(id);
    }
}
