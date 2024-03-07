package criteriaapp;

import domain.Product;
import entityservice.ProductEntityService;

public class FindByIdApp {
    public static void main(String[] args) {
        ProductEntityService service = new ProductEntityService();
        Product product = service.findByIdWithCriteria(1L);
        System.out.println(product.getName());
    }
}
