package criteriaapp;

import entityservice.ProductEntityService;

import java.math.BigDecimal;

public class MinMaxApp {
    public static void main(String[] args) {
        ProductEntityService service = new ProductEntityService();
        BigDecimal min = service.findMinProductPriceWithCriteria();
        BigDecimal max = service.findMaxProductPriceWithCriteria();

        System.out.println("Min : " + min);
        System.out.println("Max : " + max);
    }
}
