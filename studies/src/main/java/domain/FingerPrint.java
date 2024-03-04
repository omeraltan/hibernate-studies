package domain;

import javax.persistence.*;
@Entity
@Table(name = "FINGER_PRINT")
public class FingerPrint {
    @SequenceGenerator(name = "fingerprint", sequenceName = "FINGER_PRINT_ID_SEQ")
    @Id
    @GeneratedValue(generator = "fingerprint", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private Long id;
    @Column(length = 10, name = "FILE_NUMBER")
    private String fileNumber;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true, optional = false)
    private Person person;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFileNumber() {
        return fileNumber;
    }

    public void setFileNumber(String fileNumber) {
        this.fileNumber = fileNumber;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
