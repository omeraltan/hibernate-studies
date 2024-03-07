package criteriaapp;

import domain.Product;
import entityservice.ProductEntityService;

import java.util.List;

public class OrderApp {
    public static void main(String[] args) {
        ProductEntityService service = new ProductEntityService();
        List<Product> list = service.findAllWithOrderWithCriteria();
        for (Product product : list){
            System.out.println(product.getName() + " - " + product.getStockAmount());
        }
    }
}
