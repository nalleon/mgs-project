package es.ies.puerto.mgs.project.service.soap.impl;

import es.ies.puerto.mgs.project.dto.WeaponDTO;
import es.ies.puerto.mgs.project.service.interfaces.IService;
import es.ies.puerto.mgs.project.service.interfaces.IServiceSoap;
import es.ies.puerto.mgs.project.service.rest.impl.WeaponService;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@WebService(endpointInterface = "es.ies.puerto.mgs.project.service.interfaces.IServiceSoap")
public class WeaponServiceSoap implements IServiceSoap<WeaponDTO> {
    /**
     * Properties
     */
    private final static Logger LOGGER = LoggerFactory.getLogger(WeaponServiceSoap.class);

    private IService<WeaponDTO> service;

    /**
     * Default constructor of the class
     */
    public WeaponServiceSoap(){}

    /**
     * Setter of the service
     * @param service
     */
    @Autowired
    public void setService(WeaponService service) {
        this.service = service;
    }

    @Override
    public boolean add(WeaponDTO weaponDTO) {
        return service.add(weaponDTO);
    }

    @Override
    public boolean update(WeaponDTO weaponDTO) throws Exception {
        return service.update(weaponDTO.getId(), weaponDTO);
    }

    @WebResult(name="weapon")
    @Override
    public List<WeaponDTO> getAll() {
        return service.getAll();
    }

    @Override
    public WeaponDTO getById(int id) {
        return service.getById(id);
    }

    @Override
    public boolean delete(int id) {
        return service.delete(id);
    }
}
