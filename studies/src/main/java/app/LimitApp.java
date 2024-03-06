package app;

import domain.Product;
import entityservice.ProductEntityService;

import java.util.List;

public class LimitApp {
    public static void main(String[] args) {
        ProductEntityService service = new ProductEntityService();
        List<Product> productList = service.findAllWithOrderByLimit(3);
        for (Product product : productList){
            System.out.println(product.getName() + " - " + product.getStockAmount());
        }
    }
}
