package com.osals.base.dao;

import java.io.Serializable;

import com.osals.base.domain.BaseTreeEntity;

public class GenericTreeDaoTestCase<PK extends Serializable, T extends BaseTreeEntity<T>, M extends GenericTreeDao<T, PK>>
extends GenericDaoTestCase<PK, T, M> {

}
