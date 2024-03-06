package app;

import entityservice.ProductEntityService;

public class CountApp {
    public static void main(String[] args) {
        ProductEntityService service = new ProductEntityService();
        Long countStockAmount = service.countProductAmountByProductTypeId(1L);
        System.out.println(countStockAmount);
    }
}
