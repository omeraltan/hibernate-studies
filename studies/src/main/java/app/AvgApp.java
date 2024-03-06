package app;

import entityservice.ProductEntityService;

public class AvgApp {
    public static void main(String[] args) {
        ProductEntityService service = new ProductEntityService();
        Double avgStockAmount = service.findAverageStockAmount();
        System.out.println(avgStockAmount);
    }
}
