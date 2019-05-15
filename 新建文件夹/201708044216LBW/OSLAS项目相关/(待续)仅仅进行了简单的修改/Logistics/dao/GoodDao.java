package edu.zut.cs.software.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import edu.zut.cs.software.daomain.Good;

import java.util.List;

/**
 * @Auther: LBW
 * @Date: 2019/5/11
 * @Description: edu.zut.cs.software.dao.dao
 * @version: 1.0
 */
public interface GoodDao extends JpaRepository<Good, String>
{

       Good getByGoodId(String GoodId);

       List<Good> findAllByGoodIdAndAndGoodNames(String GoodId , String GoodNames);

       
}
