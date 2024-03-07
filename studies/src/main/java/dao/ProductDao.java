package dao;

import domain.Product;
import domain.ProductType;
import dto.ProductDto;
import dto.ProductInformationDto;
import dto.ProductTypeDto;
import enums.EnumProductType;
import enums.EnumUnit;
import hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import javax.persistence.TemporalType;
import javax.persistence.criteria.*;
import java.math.BigDecimal;
import java.util.ArrayList;
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

    public List<Product> findAllWithCriteria(){
        Session session = sessionFactory.openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Product> query = criteriaBuilder.createQuery(Product.class);
        query.from(Product.class);
        return session.createQuery(query).getResultList();
    }

    public Product findById(Long id){
        Session session = sessionFactory.openSession();
        Query query = session.createQuery(" SELECT u FROM Product u " + "WHERE  id = :id ");
        query.setParameter("id", id);
        return (Product) query.uniqueResult();
    }
    // Find By id With Criteria
    public Product findByIdWithCriteria(Long id){
        Session session = sessionFactory.openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Product> query = criteriaBuilder.createQuery(Product.class);
        Root<Product> root = query.from(Product.class);
        query.select(root).where(criteriaBuilder.equal(root.get("id"), id));
        return session.createQuery(query).uniqueResult();
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

    // Find All ProductList By Stock Amount Between Min And Max With Criteria
    public List<Product> findAllProductListByStockAmountBetweenMinAndMaxWithCriteria(Long min, Long max){
        Session session = sessionFactory.openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Product> query = criteriaBuilder.createQuery(Product.class);
        Root<Product> root = query.from(Product.class);
        query.select(root).where(criteriaBuilder.between(root.get("stockAmount"), min, max));
        return session.createQuery(query).list();
    }

    public List<Product> findAllWithOrder(){
        Session session = sessionFactory.openSession();
        Query query = session.createQuery(" SELECT u FROM Product u" + " ORDER BY u.stockAmount, u.name");
        return query.list();
    }

    public List<Product> findAllWithOrderWithCriteria(){
        Session session = sessionFactory.openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Product> query = criteriaBuilder.createQuery(Product.class);
        Root<Product> root = query.from(Product.class);
        query.select(root);
        // single order
        // query.orderBy(criteriaBuilder.asc(root.get("stockAmount")));

        // multiple order
        // Order stockAmount = criteriaBuilder.asc(root.get("stockAmount"));
        // Order name = criteriaBuilder.asc(root.get("name"));
        // query.orderBy(stockAmount, name);

        List<Order> orderList = new ArrayList<>();
        orderList.add(criteriaBuilder.asc(root.get("stockAmount")));
        orderList.add(criteriaBuilder.asc(root.get("name")));
        query.orderBy(orderList);
        return session.createQuery(query).list();
    }

    public List<Product> findAllWithOrderByLimit(int maxResult){
        Session session = sessionFactory.openSession();
        Query query = session.createQuery(" SELECT u FROM Product u" + " ORDER BY u.stockAmount DESC , u.name ASC ");
        query.setMaxResults(maxResult);
        return query.list();
    }

    public List<Product> findAllWithOrderByLimitWithCriteria(int maxResult){
        Session session = sessionFactory.openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Product> query = criteriaBuilder.createQuery(Product.class);
        Root<Product> root = query.from(Product.class);
        query.select(root);
        query.orderBy(criteriaBuilder.asc(root.get("id")));

        return session.createQuery(query).setMaxResults(maxResult).list();
    }

    public List<Product> findAllProductListByExpirationDateGe(Date date){
        Session session = sessionFactory.openSession();
        Query query = session.createQuery(" SELECT u FROM Product u WHERE u.expirationDate >= :date");
        query.setParameter("date",date);
        return query.list();
    }

    public List<Product> findAllProductListByExpirationDateGeWithCriteria(Date expirationDate){
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Product> query = builder.createQuery(Product.class);
        Root<Product> root = query.from(Product.class);
        ParameterExpression<Date> parameter = builder.parameter(Date.class);
        Predicate tarih = builder.greaterThanOrEqualTo(root.get("expirationDate").as(Date.class), parameter);
        query.where(tarih);
        return session.createQuery(query).setParameter(parameter, expirationDate, TemporalType.DATE).list();
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

    public Long countProductAmountByProductTypeIdWithCriteria(Long productTypeId){
        Session session = sessionFactory.openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Long> query = criteriaBuilder.createQuery(Long.class);
        Root<Product> root = query.from(Product.class);
        query.select(criteriaBuilder.count(root.get("id")));
        query.where(criteriaBuilder.equal(root.get("productType").get("id"), productTypeId));
        return session.createQuery(query).uniqueResult();
    }

    public Long sumProductAmountByProductTypeIdWithCriteria(){
        Session session = sessionFactory.openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Long> query = criteriaBuilder.createQuery(Long.class);
        Root<Product> root = query.from(Product.class);
        query.select(criteriaBuilder.sumAsLong(root.get("stockAmount")));
        return session.createQuery(query).uniqueResult();
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

    public Double findAverageStockAmountWithCriteria(){
        Session session = sessionFactory.openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Double> query = criteriaBuilder.createQuery(Double.class);
        Root<Product> root = query.from(Product.class);
        query.select(criteriaBuilder.avg(root.get("stockAmount")));
        return session.createQuery(query).uniqueResult();
    }

    public List<ProductDto> findAllProductDto(){
        Session session = sessionFactory.openSession();
        Query query = session.createQuery(" SELECT " + " new dto.ProductDto(u.id, u.name, u.price) " + " FROM Product u");
        return query.list();
    }

    public List<ProductDto> findAllProductDtoWithCriteria(){
        Session session = sessionFactory.openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<ProductDto> query = criteriaBuilder.createQuery(ProductDto.class);
        Root<Product> root = query.from(Product.class);
        query.select(criteriaBuilder.construct(ProductDto.class,
            root.get("id"),
            root.get("name"),
            root.get("price")
            ));
        return session.createQuery(query).list();
    }

    public List<ProductInformationDto> findAllProductInformationDto(){
        Session session = sessionFactory.openSession();
        Query query = session.createQuery(" SELECT " +
            " new dto.ProductInformationDto( u.id,u.name, u.price, t.name, t.enumProductType ) " +
            " FROM Product u, ProductType t" +
            " WHERE u.productType.id = t.id ");

        return query.list();
    }

    public List<ProductInformationDto> findAllProductInformationDtoWithCriteria(){
        Session session = sessionFactory.openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<ProductInformationDto> query = criteriaBuilder.createQuery(ProductInformationDto.class);
        Root<Product> root = query.from(Product.class);
        root.join("productTypeName", JoinType.INNER);
        query.select(criteriaBuilder.construct(
            ProductInformationDto.class,
            root.get("id"),
            root.get("name"),
            root.get("price")
            //root.get("productTypeName"),
            //root.get("enumProductType")
        ));
        return session.createQuery(query).list();
    }

    public BigDecimal findMinProductPrice(){
        Session session = sessionFactory.openSession();
        Query query = session.createQuery(" SELECT MIN (u.price) FROM Product u");
        return (BigDecimal) query.uniqueResult();
    }

    public BigDecimal findMinProductPriceWithCriteria(){
        Session session = sessionFactory.openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<BigDecimal> query = criteriaBuilder.createQuery(BigDecimal.class);
        Root<Product> root = query.from(Product.class);
        query.select(criteriaBuilder.min(root.get("price")));
        return session.createQuery(query).uniqueResult();
    }

    public BigDecimal findMaxProductPrice(){
        Session session = sessionFactory.openSession();
        Query query = session.createQuery(" SELECT MAX (u.price) FROM Product u");
        return (BigDecimal) query.uniqueResult();
    }

    public BigDecimal findMaxProductPriceWithCriteria(){
        Session session = sessionFactory.openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<BigDecimal> query = criteriaBuilder.createQuery(BigDecimal.class);
        Root<Product> root = query.from(Product.class);
        query.select(criteriaBuilder.max(root.get("price")));
        return session.createQuery(query).uniqueResult();
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
