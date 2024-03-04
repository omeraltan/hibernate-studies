package app;

import domain.FingerPrint;
import domain.Person;
import hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class OtoApp {
    public static void main(String[] args) {
        Person person = new Person();
        person.setName("Omer");

        FingerPrint fingerPrint = new FingerPrint();
        fingerPrint.setFileNumber("25A");

        person.setFingerPrint(fingerPrint);
        fingerPrint.setPerson(person);


        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        fingerPrint = (FingerPrint) session.merge(fingerPrint);
        transaction.commit();

        FingerPrint fingerPrint1 = session.find(FingerPrint.class, fingerPrint.getId());
        Person person1 = null;
        if (fingerPrint1 != null){
            person1 = fingerPrint1.getPerson();
        }
        System.out.println("Name : " + person1.getName());
    }
}
