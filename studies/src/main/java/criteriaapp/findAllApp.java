package criteriaapp;

import domain.Product;
import entityservice.ProductEntityService;

import java.util.List;

public class findAllApp {

    public static void main(String[] args) {
        ProductEntityService service = new ProductEntityService();
        List<Product> productList = service.findAllWithCriteria();
        for (Product product : productList){
            System.out.println(product.getName());
        }
    }

}
