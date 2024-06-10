package es.ies.puerto.mgs.project.service.interfaces;


import java.util.List;

public interface IServiceMongoDb <T> {
    public void add(T t);
    public void update(T t);
    public List<T> getAll();
    public T getById(int id);
    public void delete(int id);
}
