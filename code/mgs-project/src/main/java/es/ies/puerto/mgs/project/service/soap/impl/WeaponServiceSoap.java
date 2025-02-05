package es.ies.puerto.mgs.project.service.soap.impl;

import es.ies.puerto.mgs.project.dto.outputs.WeaponDTO;
import es.ies.puerto.mgs.project.mapper.struct.IWeaponMapper;
import es.ies.puerto.mgs.project.model.documents.Weapon;
import es.ies.puerto.mgs.project.service.interfaces.IService;
import es.ies.puerto.mgs.project.service.interfaces.IServiceSoap;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@WebService(endpointInterface = "es.ies.puerto.mgs.project.service.interfaces.IServiceSoap")
public class WeaponServiceSoap implements IServiceSoap<WeaponDTO> {
    /**
     * Properties
     */
    private final static Logger LOGGER = LoggerFactory.getLogger(WeaponServiceSoap.class);

    private IService<Weapon> service;

    /**
     * Setter of the service
     * @param service restfull
     */
    @Autowired
    public void setService(IService<Weapon> service) {
        this.service = service;
    }

    /**
     * Default constructor of the class
     */
    public WeaponServiceSoap(){}

    @Override
    public boolean add(WeaponDTO weaponDTO) {
        return service.add(IWeaponMapper.INSTANCE.toEntity(weaponDTO));
    }

    @Override
    public boolean update(WeaponDTO weaponDTO) throws Exception {
        return service.update(weaponDTO.getId(), IWeaponMapper.INSTANCE.toEntity(weaponDTO));
    }

    @WebResult(name="weapon")
    @Override
    public List<WeaponDTO> getAll() {
        return service.getAll().stream()
                .map(item -> new WeaponDTO(item.getId(), item.getType(), item.getName()))
                .collect(Collectors.toList());
    }

    @Override
    public WeaponDTO getById(int id) {
        return IWeaponMapper.INSTANCE.toDTO(service.getById(id));
    }

    @Override
    public boolean delete(int id) {
        return service.delete(id);
    }
}
