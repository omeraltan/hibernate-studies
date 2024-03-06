package app;

import domain.Product;
import entityservice.ProductEntityService;

import java.util.List;

public class BetweenApp {
    public static void main(String[] args) {
        ProductEntityService service = new ProductEntityService();
        //List<Product> productList = service.findAllProductListByStockAmountMinAndMax(100L, 500L);
        List<Product> productList = service.findAllProductListByStockAmountBetweenMinAndMax(100L, 500L);

        for (Product product : productList){
            System.out.println(product.getName() + " - " + product.getStockAmount());
        }
    }
}
