package domain;

import enums.EnumProductType;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "PRODUCT_TYPE")
public class ProductType {
    @GeneratedValue(generator = "producttype", strategy = GenerationType.SEQUENCE)
    @Id
    @SequenceGenerator(name = "producttype", sequenceName = "PRODUCT_TYPE_ID_SEQ")
    private Long id;
    @Column(name = "NAME", length = 100)
    private String name;
    @Enumerated(EnumType.STRING)
    @Column(name = "TYPE", length = 30)
    private EnumProductType enumProductType;
    @OneToMany(mappedBy = "productType", cascade = CascadeType.ALL)
    private Set<Product> products = new HashSet<>();

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

    public EnumProductType getEnumProductType() {
        return enumProductType;
    }

    public void setEnumProductType(EnumProductType enumProductType) {
        this.enumProductType = enumProductType;
    }

    public Set getProducts() {
        return products;
    }

    public void setProducts(Set products) {
        this.products = products;
    }
}
