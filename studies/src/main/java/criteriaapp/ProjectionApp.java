package criteriaapp;

import dto.ProductDto;
import dto.ProductInformationDto;
import entityservice.ProductEntityService;

import java.util.List;

public class ProjectionApp {
    public static void main(String[] args) {
        ProductEntityService service = new ProductEntityService();
        List<ProductDto> productDtoList = service.findAllProductDtoWithCriteria();
        for (ProductDto productDto : productDtoList){
            System.out.println(productDto);
        }
    }
}
