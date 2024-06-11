package es.ies.puerto.mgs.project.service.interfaces;
import java.util.List;
/**
 * @author nalleon
 */
public interface IServiceJPA<T> {
    public boolean addUpdate(T t);
    public List<T> getAll();
    public T getById(int id);
    public boolean delete(int id);
}