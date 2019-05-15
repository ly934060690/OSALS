package com.osals.enwrap.admin.service;

import java.util.List;

import com.osals.base.service.GenericManager;
import com.osals.enwrap.admin.domain.Enwrap;

public interface EnwrapManager extends GenericManager<Enwrap,Long> {
	
	String sayHello(String name);

	List<Enwrap> getAll();
}
