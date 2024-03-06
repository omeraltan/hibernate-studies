package dao;

import domain.Product;
import domain.ProductType;
import hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class ProductDao {
    private SessionFactory sessionFactory;

    public ProductDao() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    public List<Product> findAll(){
        Session session = sessionFactory.openSession();
        Query query = session.createQuery(" SELECT u FROM Product u ");
        return query.list();
    }

    public Product findById(Long id){
        Session session = sessionFactory.openSession();
        Query query = session.createQuery(" SELECT u FROM Product u " + "WHERE  id = :id ");
        query.setParameter("id", id);
        return (Product) query.uniqueResult();
    }

    public List<Product> findAllProductListByStockAmountMinAndMax(Long min, Long max){
        Session session = sessionFactory.openSession();
        Query query = session.createQuery(" SELECT u FROM Product  u " + "WHERE u.stockAmount <= :max " + " and u.stockAmount >= :min ");
        query.setParameter("min", min);
        query.setParameter("max", max);

        return query.list();
    }

    public List<Product> findAllProductListByStockAmountBetweenMinAndMax(Long min, Long max){
        Session session = sessionFactory.openSession();
        Query query = session.createQuery(" SELECT u FROM Product  u " + "WHERE u.stockAmount BETWEEN :min AND :max ");
        query.setParameter("min", min);
        query.setParameter("max", max);

        return query.list();
    }
}