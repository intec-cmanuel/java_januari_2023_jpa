package be.intecbrussel.service;

public interface IEntityService<E, ID> {
    void add(E e);
    E get(ID id);
    void update(E e);
    void delete(ID id);
}
