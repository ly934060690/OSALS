package zut.base.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import zut.base.domain.BaseEntity;

import java.io.Serializable;
import java.util.List;

public interface GenericManager <T extends BaseEntity, PK extends Serializable> {

    /**
     * * delete entity according given id
     *
     * @param id
     */
    public void delete(PK id);

    /**
     * fetch all entities
     *
     * @return list for all entities
     */
    public List<T> findAll();

    /**
     * @param page
     * @return
     */
    public Page<T> findAll(Pageable page);

    /**
     * fetch specified entity according id;
     *
     * @param id
     *            entity id;
     * @return entity
     */
    public T findById(PK id);

    /**
     * @param entities
     * @return
     */
    public List<T> save(Iterable<T> entities);

    /**
     * save specified entity;
     *
     * @param entity
     *            entity for saving
     * @return saved domain entity
     */
    public T save(T entity);
}
