package com.zcw.osals.osals_base.dao;

import java.io.Serializable;

import com.zcw.osals.osals_base.domain.BaseEntity;

public class GenericTreeDaoTestCase<PK extends Serializable, T extends BaseEntity, M extends GenericTreeDao<T, PK>>
		extends GenericDaoTestCase<PK, T, M> {

}
