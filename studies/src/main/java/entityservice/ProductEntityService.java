package entityservice;

import dao.ProductDao;
import domain.Product;
import domain.ProductType;
import dto.ProductDto;
import dto.ProductInformationDto;
import dto.ProductTypeDto;
import enums.EnumUnit;

import java.math.BigDecimal;
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

    public Long sumProductAmountByProductTypeId(Long productType){
        return productDao.sumProductAmountByProductTypeId(productType);
    }

    public Long countProductAmountByProductTypeId(Long productTypeId){
        return productDao.countProductAmountByProductTypeId(productTypeId);
    }

    public List<EnumUnit> findAllProductUnit(){
        return productDao.findAllProductUnit();
    }

    public Double findAverageStockAmount(){
        return productDao.findAverageStockAmount();
    }

    public List<ProductDto> findAllProductDto(){
        return productDao.findAllProductDto();
    }

    public List<ProductInformationDto> findAllProductInformationDto(){
        return productDao.findAllProductInformationDto();
    }

    public BigDecimal findMinProductPrice(){
        return productDao.findMinProductPrice();
    }

    public BigDecimal findMaxProductPrice(){
        return productDao.findMaxProductPrice();
    }

    public List<ProductTypeDto> findAllProductTypeDto(){
        return productDao.findAllProductTypeDto();
    }

    public List<Product> callProductFindAll(){
        return productDao.callProductFindAll();
    }

    public List<Product> callFindProductBetween(BigDecimal min, BigDecimal max){
        return productDao.callFindProductBetween(min, max);
    }

    /** Criteria */
    public List<Product> findAllWithCriteria(){
        return productDao.findAllWithCriteria();
    }
}
