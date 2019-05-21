package com.osals.base.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.osals.base.dao.GenericTreeDao;
import com.osals.base.domain.BaseTreeEntity;
import com.osals.base.service.GenericTreeManager;

@Transactional
public class GenericTreeManagerImpl<T extends BaseTreeEntity<T>, PK extends Serializable>
		extends GenericManagerImpl<T, PK> implements GenericTreeManager<T, PK> {

	protected GenericTreeDao<T, PK> treeDao;

	//@Ovsserride
	public List<T> getAncestors(PK id) {
		List<T> ancestors = new ArrayList<T>();
		T entity = this.treeDao.getOne(id);
		T parent = entity.getParent();
		while (parent != null) { // ×·Êö×æÏÈ
			ancestors.add(parent);
			entity = parent;
			parent = entity.getParent();
		}
		return ancestors;
	}

	//@Override
	public List<T> getChildren(PK id) {
		T entity = this.treeDao.getOne(id);
		return entity.getChildren();
	}

	//@Override
	public List<T> getDescendants(PK id) {
		List<T> descendants = new ArrayList<T>();
		List<T> children = this.getChildren(id);
		if (children != null && children.size() > 0) { // ×·¼Ó×ÓËï
			descendants.addAll(children);
			for (T t : children) {
				@SuppressWarnings("unchecked")
				List<T> descendants2 = this.getDescendants((PK) t.getId());
				descendants.addAll(descendants2);
			}
		}
		// if (children != null && children.size() > 0) {
		// descendants.addAll(children);
		// for (T t : children) {
		// @SuppressWarnings("unchecked")
		// List<T> descendants2 = this.getDescendants((PK) t.getId());
		// descendants.addAll(descendants2);
		// }
		// }
		return descendants;
	}

	//@Override
	public List<T> getRoot() {
		return this.treeDao.getRoot();
	}
}

