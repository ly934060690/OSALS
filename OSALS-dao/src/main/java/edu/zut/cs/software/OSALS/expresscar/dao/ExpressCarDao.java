package edu.zut.cs.software.OSALS.expresscar.dao;

import edu.zut.cs.software.OSALS.expresscar.domain.ExpressCar;
import edu.zut.cs.software.base.dao.GenericTreeDao;
import org.springframework.stereotype.Repository;

/**
 * @Author: hyh
 * @Description: 快递车Dao
 * @Date:Created in 18:35 2019/5/16
 * @Modified By:
 */
@Repository("expressCarDao")
public interface ExpressCarDao extends GenericTreeDao<ExpressCar, Long> {
}
