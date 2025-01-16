package es.ies.puerto.mgs.project.service.rest.impl;
import es.ies.puerto.mgs.project.dto.ArtistDTO;
import es.ies.puerto.mgs.project.mapper.struct.IArtistMapper;
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
//@Transactional()
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
    public boolean add(ArtistDTO artistDTO) {
        if (artistDTO == null){
            return false;
        }
        repository.save(IArtistMapper.INSTANCE.toEntity(artistDTO));
        return true;
    }

    @Override
    public boolean update(int id, ArtistDTO artistDTO) throws Exception {
        try {
            Artist toUpdate = repository.findById(id).orElseThrow(() ->
                    new Exception("Element not found for this id :: " + id));

            toUpdate.setFullName(artistDTO.getFullName());
            repository.save(toUpdate);
            return true;

        } catch (Exception e){
            return false;
        }
    }


    @Override
    public List<ArtistDTO> getAll() {
        List<Artist> artists = repository.findAll();
        List<ArtistDTO> artistDTOS = new ArrayList<>();
        for (Artist artist : artists){
            artistDTOS.add(IArtistMapper.INSTANCE.toDTO(artist));
        }
        return artistDTOS;
    }

    @Override
    public ArtistDTO getById(int id) {
        if (!repository.existsById(id)) {
            return null;
        }

        ArtistDTO result = null;

        List<ArtistDTO> list = getAll();

        for (ArtistDTO artistDTO: list){
            if (artistDTO.getArtistId() == id){
                result = artistDTO;
                break;
            }
        }
        return result;
    }

    @Override
    public boolean delete(int id) {
        if (!repository.existsById(id)) {
            return false;
        }
        repository.deleteById(id);
        return true;
    }
}
