package app;

import entityservice.ProductEntityService;

import java.math.BigDecimal;

public class MinMaxApp {
    public static void main(String[] args) {
        ProductEntityService service = new ProductEntityService();
        BigDecimal minProductPrice = service.findMinProductPrice();
        BigDecimal maxProductPrice = service.findMaxProductPrice();

        System.out.println("Min: -> " + minProductPrice);
        System.out.println("Max: -> " + maxProductPrice);
    }
}
