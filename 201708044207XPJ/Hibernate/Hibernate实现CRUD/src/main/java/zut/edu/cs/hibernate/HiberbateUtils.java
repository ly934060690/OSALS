package zut.edu.cs.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HiberbateUtils {

    public static final Configuration cfg;
    public static final SessionFactory sf;

    static {
        cfg = new Configuration().configure();
        sf = cfg.buildSessionFactory();
    }

    public static Session openSession(){
        return sf.openSession();
    }

}
