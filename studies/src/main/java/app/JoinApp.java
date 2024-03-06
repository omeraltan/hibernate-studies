package app;

import dto.ProductInformationDto;
import entityservice.ProductEntityService;

import java.util.List;

public class JoinApp {
    public static void main(String[] args) {
        ProductEntityService service = new ProductEntityService();
        List<ProductInformationDto> productInformationList = service.findAllProductInformationDto();

        for (ProductInformationDto productInformationDto : productInformationList){
            System.out.println(productInformationDto);
        }
    }
}
