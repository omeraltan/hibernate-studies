package criteriaapp;

import domain.Product;
import entityservice.ProductEntityService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class DateApp {
    public static void main(String[] args) {
        ProductEntityService service = new ProductEntityService();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date expirationDate = null;
        try {
            expirationDate = format.parse("2010-02-10");
        }catch (ParseException e){
            e.printStackTrace();
        }
        List<Product> productList = service.findAllProductListByExpirationDateGeWithCriteria(expirationDate);
        for (Product product : productList){
            System.out.println(product.getName() + " - " + format.format(product.getExpirationDate()));
        }

    }
}
