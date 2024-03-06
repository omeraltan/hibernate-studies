package spApp;

import domain.Product;
import entityservice.ProductEntityService;

import java.util.List;

public class CallSPWithNoParametersApp {
    public static void main(String[] args) {
        ProductEntityService service = new ProductEntityService();
        List<Product> list = service.callProductFindAll();

        for (Product product : list){
            System.out.println(product.getName());
        }
    }
}
