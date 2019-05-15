package edu.zut.cs.OSALS.admin.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Manager {

    //相当于SessionFactory
    private static EntityManagerFactory factory;
    private static ThreadLocal<EntityManager> tl;

    static {
        factory = Persistence.createEntityManagerFactory("ApplicationEntityManager");
        tl=new ThreadLocal<EntityManager>();
    }

    /**
     * 获取EntityManager对象
     * @return
     */
    public static EntityManager createEntityManager(){
        //从当前线程上获取EntityManager对象
        EntityManager em=tl.get();
        if(em==null){
            em=factory.createEntityManager();
            tl.set(em);
        }
        return tl.get();
    }

    public static void main(String[]args){
        createEntityManager();
    }
}
