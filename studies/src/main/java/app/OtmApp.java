package app;

import domain.City;
import domain.Country;
import hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class OtmApp {
    public static void main(String[] args) {
        Country country = new Country();
        country.setName("Türkiye");

        City city = new City();
        city.setName("İstanbul");
        city.setCountry(country);

        City city1 = new City();
        city1.setName("Cankiri");
        city1.setCountry(country);

        country.getCities().add(city);
        country.getCities().add(city1);

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.merge(country);
        transaction.commit();
    }
}
