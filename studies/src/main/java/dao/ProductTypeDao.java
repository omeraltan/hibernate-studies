package dao;

import domain.Product;
import domain.ProductType;
import dto.ProductTypeDto;
import hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;
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

    // Criteria Api
    public List<ProductType> findProductTypeListByNameWithCriteria(String name, MatchMode matchMode){

        String parameter = "";
        switch (matchMode){
            case EXACT:
                parameter = name;
                break;
            case START:
                parameter = name + "%";
                break;
            case END:
                parameter = "%" + name;
                break;
            case ANYWHERE:
                parameter = "%" + name + "%";
                break;
        }

        Session session = sessionFactory.openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<ProductType> query = criteriaBuilder.createQuery(ProductType.class);
        Root<ProductType> root = query.from(ProductType.class);
        query.select(root).where(criteriaBuilder.like(root.get("name"), parameter));
        return session.createQuery(query).list();
    }

    public List<ProductTypeDto> findAllProductTypeDtoWithCriteria(){
        Session session = sessionFactory.openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<ProductTypeDto> query = criteriaBuilder.createQuery(ProductTypeDto.class);
        Root<Product> root = query.from(Product.class);
        root.join("productType", JoinType.INNER);
        query.groupBy(root.get("productType").get("id"));
        query.select(criteriaBuilder.construct(ProductTypeDto.class,
            root.get("productType").get("id"),
            root.get("productType").get("name"),
            criteriaBuilder.min(root.get("price")),
            criteriaBuilder.max(root.get("price")),
            criteriaBuilder.avg(root.get("price")),
            criteriaBuilder.sum(root.get("stockAmount")),
            criteriaBuilder.count(root.get("id"))
        ));
        return session.createQuery(query).list();
    }



}
