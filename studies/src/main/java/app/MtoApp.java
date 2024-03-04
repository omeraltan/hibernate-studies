package app;

import domain.City;
import domain.Country;
import hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class MtoApp {
    public static void main(String[] args) {
        Country country = new Country();
        country.setName("Türkiye");

        City city = new City();
        city.setName("İstanbul");
        city.setCountry(country);

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.merge(city);
        transaction.commit();


    }
}
