package criteriaapp;

import entityservice.ProductEntityService;

public class SumApp {
    public static void main(String[] args) {
        ProductEntityService service = new ProductEntityService();
        Long stockAmount = service.sumProductAmountByProductTypeIdWithCriteria();
        System.out.println(stockAmount);
    }
}
