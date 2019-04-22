package edu.zut.cs.network.example.base.service;

import java.io.Serializable;

import edu.zut.cs.network.example.base.BaseObject;

public interface BaseManager<PK extends Serializable, E extends BaseObject<PK>> {
	E findbyId(PK id);

}
