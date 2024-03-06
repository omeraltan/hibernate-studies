package app;

import entityservice.ProductEntityService;
import enums.EnumUnit;

import java.util.List;

public class DistinctApp {
    public static void main(String[] args) {
        ProductEntityService service = new ProductEntityService();
        List<EnumUnit> unitList = service.findAllProductUnit();
        for (EnumUnit enumUnit : unitList){
            System.out.println(enumUnit.getType());
        }
    }
}
