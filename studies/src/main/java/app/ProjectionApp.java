package app;

import dto.ProductDto;
import entityservice.ProductEntityService;

import java.util.List;

public class ProjectionApp {
    public static void main(String[] args) {
        ProductEntityService service = new ProductEntityService();
        List<ProductDto> productDtoList = service.findAllProductDto();

        for (ProductDto dto : productDtoList){
            System.out.println(dto);
        }
    }
}
