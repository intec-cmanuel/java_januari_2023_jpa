package be.intecbrussel.repository;

public interface IEntityRepository<E> {
    void create(E entity);
    E read(Class<E> returnClass, Object id);
    void update(E entity);
    void delete(Class<E> entityClass, Object id);

}
