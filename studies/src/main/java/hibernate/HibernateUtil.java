package hibernate;

import domain.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            Configuration cfg = new Configuration();
            //cfg.addAnnotatedClass(Pojo.class);
            //cfg.addAnnotatedClass(Person.class);
            //cfg.addAnnotatedClass(FingerPrint.class);
            //cfg.addAnnotatedClass(Book.class);
            //cfg.addAnnotatedClass(Author.class);
            cfg.addAnnotatedClass(Country.class);
            cfg.addAnnotatedClass(City.class);
            SessionFactory sessionFactory = cfg.configure("hibernate.cfg.xml").buildSessionFactory();
            return sessionFactory;
        }catch (Exception e){
            System.out.println("Session factory oluşturulurken hata oluştu" + e);
            throw new ExceptionInInitializerError(e);
        }
    }

    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }


}
