package app;

import hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ProApp {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        transaction.commit();
    }
}
