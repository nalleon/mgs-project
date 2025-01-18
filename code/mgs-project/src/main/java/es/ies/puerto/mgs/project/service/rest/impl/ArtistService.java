package es.ies.puerto.mgs.project.service.rest.impl;
import es.ies.puerto.mgs.project.dto.ArtistDTO;
import es.ies.puerto.mgs.project.mapper.struct.IArtistMapper;
import es.ies.puerto.mgs.project.mapper.struct.IWeaponMapper;
import es.ies.puerto.mgs.project.model.db.jpa.dao.IDaoArtist;
import es.ies.puerto.mgs.project.model.entities.Artist;
import es.ies.puerto.mgs.project.service.interfaces.IService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * @author nalleon
 */
@Component
public class ArtistService implements IService<ArtistDTO> {
    /**
     * Properties
     */
    private final static Logger LOGGER = LoggerFactory.getLogger(ArtistService.class);

    private IDaoArtist repository;

    /**
     * Default constructor of the class
     */
    public ArtistService(){}

    /**
     * Setter of the dao
     * @param repository
     */
    @Autowired
    public void setDao(IDaoArtist repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public boolean add(ArtistDTO artistDTO) {
        if (artistDTO == null){
            return false;
        }
        if(repository.existsById(artistDTO.getArtistId())){
            return false;
        }

        repository.save(IArtistMapper.INSTANCE.toEntity(artistDTO));
        return true;
    }

    @Override
    @Transactional
    public boolean update(int id, ArtistDTO artistDTO) throws Exception {
        try {
            Artist toUpdate = repository.findById(id).orElse(null);

            if(toUpdate!= null){
                toUpdate.setFullName(artistDTO.getFullName());
                return true;
            } else {
                return false;
            }


        } catch (RuntimeException e){
            return false;
        }
    }


    @Override
    public List<ArtistDTO> getAll() {
        return repository.findAll()
                .stream()
                .map(IArtistMapper.INSTANCE::toDTO)
                .toList();
    }

    @Override
    public ArtistDTO getById(int id) {
        Artist result = repository.findById(id).orElse(null);;

         if(result != null) {
             return IArtistMapper.INSTANCE.toDTO(result);
         }

         return null;
    }

    @Override
    @Transactional
    public boolean delete(int id) {
        int quantity = repository.deleteItemById(id);
        return quantity > 0;
    }
}
