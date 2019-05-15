package edu.zut.cs.OSALS.base.dao;

import edu.zut.cs.OSALS.base.domain.BaseTreeEntity;

import java.io.Serializable;

/**
 * 
 * @author liuxiaoming
 *
 * @param <PK>
 * @param <T>
 * @param <M>
 */
public class GenericTreeDaoTestCase<PK extends Serializable, T extends BaseTreeEntity<T>, M extends GenericTreeDao<T, PK>>
		extends GenericDaoTestCase<PK, T, M> {

}
