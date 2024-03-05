package dao;

import domain.ProductType;
import hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class ProductTypeDao {
    private SessionFactory sessionFactory;

    public ProductTypeDao() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    public List<ProductType> findAll(){
        Session session = sessionFactory.openSession();
        Query query = session.createQuery(" SELECT u FROM ProductType u ");
        return query.list();
    }
}
