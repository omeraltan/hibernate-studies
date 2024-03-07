package criteriaapp;

import entityservice.ProductEntityService;

public class CountApp {
    public static void main(String[] args) {
        ProductEntityService service = new ProductEntityService();
        Long deger = service.countProductAmountByProductTypeIdWithCriteria(1L);
        System.out.println(deger);

    }
}
