package dao;

import domain.Product;
import domain.ProductType;
import hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
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

    public ProductType findById(Long id){
        Session session = sessionFactory.openSession();
        Query query = session.createQuery(" SELECT u FROM ProductType u " + "WHERE  id = :id ");
        query.setParameter("id", id);
        return (ProductType) query.uniqueResult();
    }

    public List<ProductType> findProductTypeListByName(String name, MatchMode matchMode){
        Session session = sessionFactory.openSession();
        Query query = session.createQuery(" SELECT u FROM ProductType u " + " WHERE u.name LIKE :name");

        switch (matchMode){
            case EXACT:
                query.setParameter("name", name);
                break;

            case START:
                query.setParameter("name", name + "%");
                break;
            case END:
                query.setParameter("name","%" + name);
                break;
            case ANYWHERE:
                query.setParameter("name", "%" + name + "%");
                break;
        }
        return query.list();
    }


}
