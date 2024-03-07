package criteriaapp;

import domain.ProductType;
import dto.ProductTypeDto;
import entityservice.ProductTypeEntityService;

import java.util.List;

public class GroupByApp {
    public static void main(String[] args) {
        ProductTypeEntityService service = new ProductTypeEntityService();
        List<ProductTypeDto> productTypeDtoList = service.findAllProductTypeDtoWithCriteria();

        for (ProductTypeDto productTypeDto : productTypeDtoList){
            System.out.println(productTypeDto);
        }
    }
}
