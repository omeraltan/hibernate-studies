package dto;

import java.math.BigDecimal;

public class ProductTypeDto {
    private Long id;
    private String name;
    private BigDecimal minPrice;
    private BigDecimal maxPrice;
    private Double avgPrice;
    private Long sumStockAmount;
    private Long sumProductCount;

    public ProductTypeDto(Long id, String name, BigDecimal minPrice, BigDecimal maxPrice, Double avgPrice, Long sumStockAmount, Long sumProductCount) {
        this.id = id;
        this.name = name;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.avgPrice = avgPrice;
        this.sumStockAmount = sumStockAmount;
        this.sumProductCount = sumProductCount;
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

    public BigDecimal getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(BigDecimal minPrice) {
        this.minPrice = minPrice;
    }

    public BigDecimal getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(BigDecimal maxPrice) {
        this.maxPrice = maxPrice;
    }

    public Double getAvgPrice() {
        return avgPrice;
    }

    public void setAvgPrice(Double avgPrice) {
        this.avgPrice = avgPrice;
    }

    public Long getSumStockAmount() {
        return sumStockAmount;
    }

    public void setSumStockAmount(Long sumStockAmount) {
        this.sumStockAmount = sumStockAmount;
    }

    public Long getSumProductCount() {
        return sumProductCount;
    }

    public void setSumProductCount(Long sumProductCount) {
        this.sumProductCount = sumProductCount;
    }

    @Override
    public String toString() {
        return "ProductTypeDto{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", minPrice=" + minPrice +
            ", maxPrice=" + maxPrice +
            ", avgPrice=" + avgPrice +
            ", sumStockAmount=" + sumStockAmount +
            ", sumProductCount=" + sumProductCount +
            '}';
    }
}
