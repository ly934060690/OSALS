package edu.zut.cs.network.example.base.service.impl;

import java.io.Serializable;
import java.util.List;

import edu.zut.cs.network.example.base.BaseObject;
import edu.zut.cs.network.example.base.service.BaseManager;

public class BaseManagerImpl<PK extends Serializable, E extends BaseObject<PK>> implements BaseManager<PK, E> {

	List<E> entityList;

	@Override
	public E findbyId(PK id) {
		return null;
	}

}
