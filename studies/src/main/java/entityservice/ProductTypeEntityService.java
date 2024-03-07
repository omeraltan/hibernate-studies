package entityservice;

import dao.ProductTypeDao;
import domain.Product;
import domain.ProductType;
import org.hibernate.criterion.MatchMode;

import java.util.List;

public class ProductTypeEntityService {
    private ProductTypeDao productTypeDao;

    public ProductTypeEntityService(){
        productTypeDao = new ProductTypeDao();
    }

    public List<ProductType> findAll(){
        return  productTypeDao.findAll();
    }

    public ProductType findById(Long id){
        return productTypeDao.findById(id);
    }

    public List<ProductType> findProductTypeListByName(String name, MatchMode matchMode){
        return productTypeDao.findProductTypeListByName(name, matchMode);
    }

    public List<ProductType> findProductTypeListByNameWithCriteria(String name, MatchMode matchMode){
        return productTypeDao.findProductTypeListByNameWithCriteria(name, matchMode);
    }
}
