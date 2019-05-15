package edu.zut.cs.software.sun.admin.domain;

import org.hibernate.Session;

/**
 * @Auther: LBW
 * @Date: 2019/4/28
 * @Description: edu.zut.cs.software.sun.admin.domain
 * @version: 1.0
 */
public interface Hibernate {
    public Session getSession();
    public void FindNameByID(Integer id);
}
