package es.ies.puerto.mgs.project.service.soap.impl;

import es.ies.puerto.mgs.project.dto.outputs.MGSCharacterDTO;
import es.ies.puerto.mgs.project.mapper.struct.IArtistMapper;
import es.ies.puerto.mgs.project.mapper.struct.IMGSCharacterMapper;
import es.ies.puerto.mgs.project.model.entities.MGSCharacter;
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

/**
 * @author nalleon
 */
@Component
@WebService(endpointInterface = "es.ies.puerto.mgs.project.service.interfaces.IServiceSoap")
public class MGSCharacterServiceSoap implements IServiceSoap<MGSCharacterDTO> {
    /**
     * Properties
     */
    private final static Logger LOGGER = LoggerFactory.getLogger(MGSCharacterServiceSoap.class);

    private IService<MGSCharacter> service;

    /**
     * Setter of the service
     * @param service restfull
     */
    @Autowired
    public void setService(IService<MGSCharacter> service) {
        this.service = service;
    }

    /**
     * Default constructor of the class
     */
    public MGSCharacterServiceSoap(){}

    @Override
    public boolean add(MGSCharacterDTO mgsCharacterDTO) {
        return service.add(IMGSCharacterMapper.INSTANCE.toEntity(mgsCharacterDTO));
    }

    @Override
    public boolean update(MGSCharacterDTO mgsCharacterDTO) throws Exception {
        return service.update(mgsCharacterDTO.getId(), IMGSCharacterMapper.INSTANCE.toEntity(mgsCharacterDTO));
    }

    @WebResult(name="mgsCharacter")
    @Override
    public List<MGSCharacterDTO> getAll() {
        return service.getAll().stream()
                .map(item -> new MGSCharacterDTO(
                        item.getId(), item.getName(), item.getCodename(),
                        item.getAge(), item.isStatus(),
                        IArtistMapper.INSTANCE.toDTO(item.getArtist()))).
                collect(Collectors.toList());

    }

    @Override
    public MGSCharacterDTO getById(int id) {
        return IMGSCharacterMapper.INSTANCE.toDTO(service.getById(id));
    }

    @Override
    public boolean delete(int id) {
        return service.delete(id);
    }
}
