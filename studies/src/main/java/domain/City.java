package domain;

import javax.persistence.*;

@Entity
@Table(name = "CITY", indexes = {
    @Index(name = "IX_CITY_NAME_ID", columnList = "NAME, ID", unique = true),
    @Index(name = "IX_CITY_NAME_COUNTRY", columnList = "ID_COUNTRY", unique = true)
})
public class City {
    @SequenceGenerator(name = "city", sequenceName = "CITY_ID_SEQ")
    @Id
    @GeneratedValue(generator = "city", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private Long id;
    @Column(name = "NAME", length = 100)
    private String name;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_COUNTRY", nullable = false, foreignKey = @ForeignKey(name = "FK_CITY_COUNTRY", value = ConstraintMode.CONSTRAINT))
    private Country country;

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

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
