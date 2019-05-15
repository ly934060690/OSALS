package edu.zut.cs.software.sun.admin.domain.impl;

import edu.zut.cs.software.sun.admin.domain.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @Auther: LBW
 * @Date: 2019/4/28
 * @Description: edu.zut.cs.software.sun.admin.domain
 * @version: 1.0
 */
@Repository
public class HibernateImpl implements Hibernate
{
    @Autowired
    private SessionFactory sessionFactory;

    public Session getSession()
    {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void  FindNameByID(Integer id) {
        String hql = "SELECT name from baseentity where id = ?";
        Query  query = getSession().createQuery(hql).setInteger(0 , id);   //这里的0代表是第一个问号
        System.out.println(query.uniqueResult());
    }

}
