package dao;

import domain.Product;
import domain.ProductType;
import dto.ProductDto;
import dto.ProductInformationDto;
import dto.ProductTypeDto;
import enums.EnumUnit;
import hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import java.math.BigDecimal;
import java.util.Date;
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

    public List<Product> findAllWithOrder(){
        Session session = sessionFactory.openSession();
        Query query = session.createQuery(" SELECT u FROM Product u" + " ORDER BY u.stockAmount, u.name");
        return query.list();
    }

    public List<Product> findAllWithOrderByLimit(int maxResult){
        Session session = sessionFactory.openSession();
        Query query = session.createQuery(" SELECT u FROM Product u" + " ORDER BY u.stockAmount DESC , u.name ASC ");
        query.setMaxResults(maxResult);
        return query.list();
    }

    public List<Product> findAllProductListByExpirationDateGe(Date date){
        Session session = sessionFactory.openSession();
        Query query = session.createQuery(" SELECT u FROM Product u WHERE u.expirationDate >= :date");
        query.setParameter("date",date);
        return query.list();
    }

    public Long sumProductAmountByProductTypeId(Long productType){
        Session session = sessionFactory.openSession();
        Query query = session.createQuery(" SELECT SUM(u.stockAmount) FROM Product u" + " WHERE productType.id = :productType");
        query.setParameter("productType",productType);
        return (Long) query.uniqueResult();
    }

    public Long countProductAmountByProductTypeId(Long productTypeId){
        Session session = sessionFactory.openSession();
        Query query = session.createQuery(" SELECT COUNT(u) FROM Product u" + " WHERE productType.id = :productTypeId");
        query.setParameter("productTypeId",productTypeId);
        return (Long) query.uniqueResult();
    }

    public List<EnumUnit> findAllProductUnit(){
        Session session = sessionFactory.openSession();
        Query query = session.createQuery(" SELECT DISTINCT (u.enumUnit) FROM Product u");
        return query.list();
    }

    public Double findAverageStockAmount(){
        Session session = sessionFactory.openSession();
        Query query = session.createQuery(" SELECT AVG (u.stockAmount) FROM Product u");
        return (Double) query.uniqueResult();
    }

    public List<ProductDto> findAllProductDto(){
        Session session = sessionFactory.openSession();
        Query query = session.createQuery(" SELECT " + " new dto.ProductDto(u.id, u.name, u.price) " + " FROM Product u");
        return query.list();
    }

    public List<ProductInformationDto> findAllProductInformationDto(){
        Session session = sessionFactory.openSession();
        Query query = session.createQuery(" SELECT " +
            " new dto.ProductInformationDto( u.id,u.name, u.price, t.name, t.enumProductType ) " +
            " FROM Product u, ProductType t" +
            " WHERE u.productType.id = t.id ");

        return query.list();
    }

    public BigDecimal findMinProductPrice(){
        Session session = sessionFactory.openSession();
        Query query = session.createQuery(" SELECT MIN (u.price) FROM Product u");
        return (BigDecimal) query.uniqueResult();
    }

    public BigDecimal findMaxProductPrice(){
        Session session = sessionFactory.openSession();
        Query query = session.createQuery(" SELECT MAX (u.price) FROM Product u");
        return (BigDecimal) query.uniqueResult();
    }

    public List<ProductTypeDto> findAllProductTypeDto(){
        Session session = sessionFactory.openSession();
        Query query = session.createQuery(" SELECT new dto.ProductTypeDto( " +
            " b.id, " +
            " b.name, " +
            " min(a.price), " +
            " max(a.price), " +
            " avg(a.price), " +
            " sum(a.stockAmount), " +
            " count(a.id) " +
            " ) " +
            " FROM Product a, ProductType  b " +
            " WHERE a.id = b.id " +
            " GROUP BY a.id, b.id");

        return query.list();
    }

    public List<Product> callProductFindAll(){
        Session session = sessionFactory.openSession();
        NativeQuery<Product> nativeQuery = session.createNativeQuery(" {call product_findAll()} ", Product.class);
        return nativeQuery.list();
    }

    public List<Product> callFindProductBetween(BigDecimal min, BigDecimal max){
        Session session = sessionFactory.openSession();
        NativeQuery<Product> nativeQuery = session.createNativeQuery(" { call find_product_between(:min, :max)} ", Product.class);
        nativeQuery.setParameter("min", min);
        nativeQuery.setParameter("max", max);

        return nativeQuery.list();
    }
}
