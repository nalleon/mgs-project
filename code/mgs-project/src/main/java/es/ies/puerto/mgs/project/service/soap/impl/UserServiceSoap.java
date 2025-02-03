package es.ies.puerto.mgs.project.service.soap.impl;

import es.ies.puerto.mgs.project.dto.UserDTO;
import es.ies.puerto.mgs.project.mapper.struct.IRoleMapper;
import es.ies.puerto.mgs.project.mapper.struct.IUserMapper;
import es.ies.puerto.mgs.project.model.entities.User;
import es.ies.puerto.mgs.project.model.entities.Weapon;
import es.ies.puerto.mgs.project.service.interfaces.IService;
import es.ies.puerto.mgs.project.service.interfaces.IServiceSoap;
import es.ies.puerto.mgs.project.service.rest.impl.UserService;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

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

    private IService<User> service;

    /**
     * Setter of the service
     * @param service restfull
     */
    @Autowired
    public void setService(IService<User> service) {
        this.service = service;
    }


    /**
     * Default constructor of the class
     */
    public UserServiceSoap(){}


    @Override
    public boolean add(UserDTO userDTO) {
        return service.add(IUserMapper.INSTANCE.toEntity(userDTO));
    }

    @Override
    public boolean update(UserDTO userDTO) throws Exception {
        return service.update(userDTO.getId(), IUserMapper.INSTANCE.toEntity(userDTO));
    }

    @WebResult(name="user")
    @Override
    public List<UserDTO> getAll() {
        List<UserDTO> filteredList = service.getAll().stream()
                .map(item -> new UserDTO(item.getId(), item.getName(), item.getEmail(),
                        null, IRoleMapper.INSTANCE.toDTO(item.getRole())))
                .collect(Collectors.toList());

        return filteredList;
    }

    @Override
    public UserDTO getById(int id) {
        return IUserMapper.INSTANCE.toDTO(service.getById(id));
    }

    @Override
    public boolean delete(int id) {
        return service.delete(id);
    }
}