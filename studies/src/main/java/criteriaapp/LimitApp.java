package criteriaapp;

import domain.Product;
import entityservice.ProductEntityService;

import java.util.List;

public class LimitApp {
    public static void main(String[] args) {
        ProductEntityService service = new ProductEntityService();
        List<Product> list = service.findAllWithOrderByLimitWithCriteria(3);

        for (Product product : list){
            System.out.println(product.getId() + " - " + product.getStockAmount());
        }
    }
}
