package edu.zut.cs.software.osals.expresscar.service.impl;

import edu.zut.cs.software.base.service.impl.GenericManagerImpl;
import edu.zut.cs.software.osals.expresscar.dao.EnwrapDao;
import edu.zut.cs.software.osals.expresscar.domain.Enwrap;
import edu.zut.cs.software.osals.expresscar.domain.ExpressCar;
import edu.zut.cs.software.osals.expresscar.service.EnwrapManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.ListIterator;

/**
 * @Author: hyh
 * @Description: EnwrapManager impl
 * @Date:Created in 21:12 2019/5/16
 * @Modified By:
 */
@Service
@Transactional
public class EnwrapManagerImpl extends GenericManagerImpl<Enwrap, Long> implements EnwrapManager {

    EnwrapDao enwrapDao;

    @Autowired
    public void setEnwrapDao(EnwrapDao enwrapDao){
        this.enwrapDao=enwrapDao;
        this.dao=enwrapDao;
    }


    @Override
    public List<ExpressCar> findExpressCarByName(String name) {
        List<ExpressCar> expressCars=null;
        ListIterator<Enwrap> iterator=matchWithName(name).listIterator();
        while(iterator.hasNext()){expressCars.add(iterator.next().getExpressCar());}
        return expressCars;
    }

    @Override
    public List<Enwrap> matchWithName(String name) {
        Enwrap enwrap=new Enwrap();
        enwrap.setName(name);
        ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("name",ExampleMatcher.GenericPropertyMatchers.startsWith());
        Example<Enwrap> example=Example.of(enwrap,matcher);
        List<Enwrap> list=this.dao.findAll(example);
        return list;
    }

}
