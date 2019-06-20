package edu.zut.cs.software.osals.expresscar.service.impl;

import edu.zut.cs.software.base.service.impl.GenericTreeManagerImpl;
import edu.zut.cs.software.osals.expresscar.dao.ExpressCarDao;
import edu.zut.cs.software.osals.expresscar.domain.Enwrap;
import edu.zut.cs.software.osals.expresscar.domain.ExpressCar;
import edu.zut.cs.software.osals.expresscar.service.ExpressCarManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

/**
 * @Author: hyh
 * @Description: ExpressCarManager Impl
 * @Date:Created in 21:05 2019/5/16
 * @Modified By:
 */
@Service("expressCarManager")
@Transactional
public class ExpressCarManagerImpl extends GenericTreeManagerImpl<ExpressCar, Long> implements ExpressCarManager {

    ExpressCarDao expressCarDao;

    @Autowired
    public void setExpressCarDao(ExpressCarDao expressCarDao) {
        this.expressCarDao = expressCarDao;
        this.treeDao = this.expressCarDao;
        this.dao = this.treeDao;
    }

    @Override
    public List<ExpressCar> matchWithName(String name) {
        ExpressCar expressCar=new ExpressCar();
        expressCar.setName(name);
        ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("name",ExampleMatcher.GenericPropertyMatchers.contains());
        Example<ExpressCar> expressCarExample=Example.of(expressCar,matcher);
        List<ExpressCar> list=this.dao.findAll(expressCarExample);
        return list;
    }

    @Override
    public List<Set<Enwrap>> findEnwrapsByName(String name) {
        List<Set<Enwrap>> list=null;
        ListIterator<ExpressCar> iterator=matchWithName(name).listIterator();
        while(iterator.hasNext()){ list.add(iterator.next().getEnwraps());}
        return list;
    }

}

