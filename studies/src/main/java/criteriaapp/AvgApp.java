package criteriaapp;

import entityservice.ProductEntityService;

public class AvgApp {
    public static void main(String[] args) {
        ProductEntityService service = new ProductEntityService();
        Double avg = service.findAverageStockAmountWithCriteria();

        System.out.println(avg);
    }
}
