package com.osals.enwrap.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.osals.base.service.impl.GenericManagerImpl;
import com.osals.enwrap.admin.dao.EnwrapDao;
import com.osals.enwrap.admin.domain.Enwrap;
import com.osals.enwrap.admin.service.EnwrapManager;

@Service("enwrapManager")
public class EnwrapManagerImpl extends GenericManagerImpl<Enwrap, Long> implements EnwrapManager{

    EnwrapDao enwrapDao;
	
	@Autowired
	public void setUserDao(EnwrapDao enwrapDao) {
		this.enwrapDao = enwrapDao;
		this.dao = this.enwrapDao;
	}

	@Override
	public String sayHello(String name) {
		String result = "Hello, " + name + "!";
		if (logger.isInfoEnabled()) {
			logger.info("sayHello(String) - String result={}", result); //$NON-NLS-1$
		}

		return result;
	}

	@Override
	public List<Enwrap> getAll() {
		List<Enwrap> all = this.enwrapDao.findAll();
		if (logger.isInfoEnabled()) {
			logger.info("getAll() - List<Enwrap> all={}", all); //$NON-NLS-1$
		}
		return all;
	}
}
