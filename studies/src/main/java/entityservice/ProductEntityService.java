package entityservice;

import dao.ProductDao;
import domain.Product;
import domain.ProductType;

import java.util.Date;
import java.util.List;

public class ProductEntityService {

    private ProductDao productDao;

    public ProductEntityService() {
        productDao = new ProductDao();
    }

    public List<Product> findAll(){
        return  productDao.findAll();
    }

    public Product findById(Long id){
        return productDao.findById(id);
    }

    public List<Product> findAllProductListByStockAmountMinAndMax(Long min, Long max){
        return productDao.findAllProductListByStockAmountMinAndMax(min,max);
    }

    public List<Product> findAllProductListByStockAmountBetweenMinAndMax(Long min, Long max){
        return productDao.findAllProductListByStockAmountBetweenMinAndMax(min, max);
    }

    public List<Product> findAllWithOrder(){
        return productDao.findAllWithOrder();
    }
    public List<Product> findAllWithOrderByLimit(int maxResult){
        return productDao.findAllWithOrderByLimit(maxResult);
    }

    public List<Product> findAllProductListByExpirationDateGe(Date date){
        return productDao.findAllProductListByExpirationDateGe(date);
    }
}
