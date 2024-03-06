package spApp;

import domain.Product;
import entityservice.ProductEntityService;

import java.math.BigDecimal;
import java.util.List;

public class CallSPWithParameters {
    public static void main(String[] args) {
        ProductEntityService service = new ProductEntityService();
        BigDecimal min = BigDecimal.ONE;
        BigDecimal max = new BigDecimal("5000");

        List<Product> list = service.callFindProductBetween(min, max);

        for (Product lst : list){
            System.out.println(lst.getName());
        }
    }
}
