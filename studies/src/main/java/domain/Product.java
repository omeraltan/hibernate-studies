package domain;

import enums.EnumUnit;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "PRODUCT", indexes = @Index(name = "IX_PRODUCT_PRODUCT_TYPE", columnList = "ID_PRODUCT_TYPE"))
public class Product {

    @GeneratedValue(generator = "product", strategy = GenerationType.SEQUENCE)
    @Id
    @SequenceGenerator(name = "product", sequenceName = "PRODUCT_ID_SEQ")
    private Long id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "PRICE", precision = 15, scale = 2)
    private BigDecimal price;
    @Temporal(TemporalType.DATE)
    @Column(name = "EXPIRATION_DATE")
    private Date expirationDate;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_PRODUCT_TYPE", foreignKey = @ForeignKey(name = "FK_PRODUCT_TYPE"))
    private ProductType productType;
    @Column(name = "STOCK_AMOUNT")
    private Long stockAmount;
    @Enumerated(EnumType.STRING)
    @Column(name = "ENUM_UNIT", length = 30)
    private EnumUnit enumUnit;

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

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public Long getStockAmount() {
        return stockAmount;
    }

    public void setStockAmount(Long stockAmount) {
        this.stockAmount = stockAmount;
    }

    public EnumUnit getEnumUnit() {
        return enumUnit;
    }

    public void setEnumUnit(EnumUnit enumUnit) {
        this.enumUnit = enumUnit;
    }
}
