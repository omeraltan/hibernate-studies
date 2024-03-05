package app;

import domain.ProductType;
import entityservice.ProductTypeEntityService;
import java.util.List;

public class ProductApp {
    public static void main(String[] args) {
        ProductTypeEntityService service = new ProductTypeEntityService();
        List<ProductType> productTypeList = service.findAll();

        for(ProductType productType : productTypeList){
            System.out.println(productType.getName());
        }
    }
}
