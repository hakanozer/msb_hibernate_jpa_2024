package configs;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DB2HibernateUtil {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            Configuration conf = new Configuration();
            SessionFactory sessionFactory = conf.configure("d2hibernate.cfg.xml").buildSessionFactory();
            return sessionFactory;
        }catch (Exception ex) {
            System.out.println("SessionFactory Error : "+ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}
