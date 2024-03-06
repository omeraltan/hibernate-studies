package dto;

import enums.EnumProductType;

import java.math.BigDecimal;

public class ProductInformationDto {
    private Long id;
    private String name;
    private BigDecimal price;
    private String productTypeName;
    private EnumProductType enumProductType;

    public ProductInformationDto(Long id, String name, BigDecimal price, String productTypeName, EnumProductType enumProductType) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.productTypeName = productTypeName;
        this.enumProductType = enumProductType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getProductTypeName() {
        return productTypeName;
    }

    public void setProductTypeName(String productTypeName) {
        this.productTypeName = productTypeName;
    }

    public EnumProductType getEnumProductType() {
        return enumProductType;
    }

    public void setEnumProductType(EnumProductType enumProductType) {
        this.enumProductType = enumProductType;
    }

    @Override
    public String toString() {
        return "ProductInformationDto{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", price=" + price +
            ", productTypeName='" + productTypeName + '\'' +
            ", enumProductType=" + enumProductType +
            '}';
    }
}
