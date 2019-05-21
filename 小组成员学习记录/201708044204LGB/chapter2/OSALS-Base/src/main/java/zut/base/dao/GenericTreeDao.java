package zut.base.dao;

import zut.base.domain.BaseTreeEntity;

import java.io.Serializable;
import java.util.List;

public interface GenericTreeDao <T extends BaseTreeEntity<T>, PK extends Serializable>
        extends GenericDao<T, PK>{
    List<T> getRoot();
}
