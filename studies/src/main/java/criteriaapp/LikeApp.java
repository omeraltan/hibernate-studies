package criteriaapp;

import domain.ProductType;
import entityservice.ProductTypeEntityService;
import org.hibernate.criterion.MatchMode;

import java.util.List;

public class LikeApp {
    public static void main(String[] args) {
        ProductTypeEntityService service = new ProductTypeEntityService();
        List<ProductType> productTypeList = service.findProductTypeListByNameWithCriteria("F", MatchMode.START);

        for (ProductType productType : productTypeList){
            System.out.println(productType.getName());
        }
    }
}
