package criteriaapp;

import dto.ProductDto;
import dto.ProductInformationDto;
import entityservice.ProductEntityService;

import java.util.List;

public class ProjectionApp {
    public static void main(String[] args) {
        ProductEntityService service = new ProductEntityService();
        List<ProductInformationDto> productDtoList = service.findAllProductInformationDtoWithCriteria();
        for (ProductInformationDto productDto : productDtoList){
            System.out.println(productDto);
        }
    }
}
