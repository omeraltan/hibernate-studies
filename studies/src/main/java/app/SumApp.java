package app;

import entityservice.ProductEntityService;

public class SumApp {
    public static void main(String[] args) {
        ProductEntityService service = new ProductEntityService();
        Long sumStockAmount = service.sumProductAmountByProductTypeId(1L);
        System.out.println(sumStockAmount);
    }
}
