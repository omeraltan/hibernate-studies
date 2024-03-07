package criteriaapp;

import dto.ProductInformationDto;
import entityservice.ProductEntityService;

import java.util.List;

public class JoinApp {
    public static void main(String[] args) {
        ProductEntityService service = new ProductEntityService();
        List<ProductInformationDto> productInformationDtoList = service.findAllProductInformationDtoWithCriteria();
        for (ProductInformationDto productInformationDto : productInformationDtoList){
            System.out.println(productInformationDto);
        }
    }
}
