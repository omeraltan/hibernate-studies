package domain;

import javax.persistence.*;
@Entity
@Table(name = "PERSON")
public class Person {
    @SequenceGenerator(name = "person", sequenceName = "PERSON_ID_SEQ")
    @Id
    @GeneratedValue(generator = "person", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private Long id;
    @Column(length = 100, name = "NAME")
    private String name;
    @OneToOne(fetch = FetchType.LAZY,mappedBy = "person")
    private FingerPrint fingerPrint;

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

    public FingerPrint getFingerPrint() {
        return fingerPrint;
    }

    public void setFingerPrint(FingerPrint fingerPrint) {
        this.fingerPrint = fingerPrint;
    }
}
