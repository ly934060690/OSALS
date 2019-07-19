package edu.zut.cs.software.osals.nlp.dao;

import edu.zut.cs.software.base.dao.GenericDaoTestCase;
import edu.zut.cs.software.osals.nlp.domain.NlpEntityRelation;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class NlpEntityRelationDaoTest extends GenericDaoTestCase<Long, NlpEntityRelation, NlpEntityRelationDao> {

    NlpEntityRelationDao nlpEntityRelationDao;

    @Autowired
    public void setNlpEntityRelationDao(NlpEntityRelationDao nlpEntityRelationDao) {
        this.nlpEntityRelationDao = nlpEntityRelationDao;
        this.dao=this.nlpEntityRelationDao;
    }

    @Test
    public  void findAll(){
        System.out.println("hello nlp");
    }
}
