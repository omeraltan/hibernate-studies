package entityservice;

import dao.ProductTypeDao;
import domain.ProductType;

import java.util.List;

public class ProductTypeEntityService {
    private ProductTypeDao productTypeDao;

    public ProductTypeEntityService(){
        productTypeDao = new ProductTypeDao();
    }

    public List<ProductType> findAll(){
        return  productTypeDao.findAll();
    }
}
