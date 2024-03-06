package app;

import domain.ProductType;
import entityservice.ProductEntityService;
import entityservice.ProductTypeEntityService;
import org.hibernate.criterion.MatchMode;

import java.util.List;

public class LikeApp {
    public static void main(String[] args) {
        ProductTypeEntityService service = new ProductTypeEntityService();
        //List<ProductType> productTypeList = service.findProductTypeListByName("Food", MatchMode.EXACT);
        //List<ProductType> productTypeList = service.findProductTypeListByName("F", MatchMode.START);
        //List<ProductType> productTypeList = service.findProductTypeListByName("K", MatchMode.END);
        List<ProductType> productTypeList = service.findProductTypeListByName("oo", MatchMode.ANYWHERE);

        for (ProductType type : productTypeList){
            System.out.println(type.getName());
        }
    }
}
