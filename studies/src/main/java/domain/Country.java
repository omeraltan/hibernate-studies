package domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "COUNTRY")
public class Country {
    @SequenceGenerator(name = "country", sequenceName = "COUNTRY_ID_SEQ")
    @Id
    @GeneratedValue(generator = "country", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private Long id;
    @Column(name = "NAME", length = 100)
    private String name;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "country", targetEntity = City.class)
    private Set cities = new HashSet<>();

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

    public Set getCities() {
        return cities;
    }

    public void setCities(Set cities) {
        this.cities = cities;
    }
}
