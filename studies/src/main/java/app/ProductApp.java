package app;

import domain.Product;
import domain.ProductType;
import entityservice.ProductEntityService;
import entityservice.ProductTypeEntityService;
import java.util.List;

public class ProductApp {
    public static void main(String[] args) {
        /*ProductTypeEntityService service = new ProductTypeEntityService();
        List<ProductType> productTypeList = service.findAll();

        for(ProductType productType : productTypeList){
            System.out.println(productType.getName());
        }*/

        /*ProductEntityService service = new ProductEntityService();
        List<Product> productList = service.findAll();
        for (Product product : productList){
            System.out.println(product.getName());
        }*/

        /*ProductEntityService service = new ProductEntityService();
        Product product = service.findById(1L);
        System.out.println(product.getName());*/

        ProductTypeEntityService service = new ProductTypeEntityService();
        ProductType productType = service.findById(1L);
        System.out.println(productType.getName());

    }
}
