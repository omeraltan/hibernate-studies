package app;

import dto.ProductTypeDto;
import entityservice.ProductEntityService;

import java.util.List;

public class GroupByApp {
    public static void main(String[] args) {
        ProductEntityService service = new ProductEntityService();
        List<ProductTypeDto> productTypeDto = service.findAllProductTypeDto();
        for (ProductTypeDto dto : productTypeDto){
            System.out.println(dto);
        }
    }
}
