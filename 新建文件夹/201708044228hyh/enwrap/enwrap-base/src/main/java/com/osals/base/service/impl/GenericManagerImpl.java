package com.osals.base.service.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import com.osals.base.dao.GenericDao;
import com.osals.base.domain.BaseEntity;
import com.osals.base.service.GenericManager;

@Transactional
public class GenericManagerImpl<T extends BaseEntity, PK extends Serializable> implements GenericManager<T, PK> {
	/**
	 * Logger for this class
	 */
	protected static final Logger logger = LogManager.getLogger(GenericManagerImpl.class.getName());

	protected GenericDao<T, PK> dao;

	public void delete(PK id) {
		this.dao.deleteById(id);
	}

	public List<T> findAll() {
		return this.dao.findAll();
	}

	public Page<T> findAll(Pageable page) {
		Page<T> result = this.dao.findAll(page);
		return result;
	}

	public T findById(PK id) {
		return this.dao.getOne(id);
	}

	public List<T> save(Iterable<T> entities) {
		//return this.dao.saveAll(entities);
		return null;
	}

	public T save(T entity) {
		return this.dao.saveAndFlush(entity);
	}

}

