package domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "POJO_TABLE")
public class Pojo {
    @SequenceGenerator(name = "seq", sequenceName = "POJO_TABLE_ID_SEQ", allocationSize = 1, initialValue = 100)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @Column(name = "ID")
    private Long id;
    @Column(name = "NAME", length = 100, nullable = false)
    private String name;
    @Column(name = "ITEM", precision = 15, scale = 2)
    private BigDecimal item;
    @Column(name = "DATE")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Column(name = "TIME")
    @Temporal(TemporalType.TIME)
    private Date time;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATE_TIME")
    private Date datetime;
    @Transient
    private String value;
    @Lob
    @Column(name = "BIG_STRING")
    private String bigString;
    @Lob
    @Column(name = "BIG_BLOB")
    private byte[] bigBlob;
    @Lob
    @Column(name = "BIG_CLOB")
    private char[] bigClob;

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

    public BigDecimal getItem() {
        return item;
    }

    public void setItem(BigDecimal item) {
        this.item = item;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getBigString() {
        return bigString;
    }

    public void setBigString(String bigString) {
        this.bigString = bigString;
    }

    public byte[] getBigBlob() {
        return bigBlob;
    }

    public void setBigBlob(byte[] bigBlob) {
        this.bigBlob = bigBlob;
    }

    public char[] getBigClob() {
        return bigClob;
    }

    public void setBigClob(char[] bigClob) {
        this.bigClob = bigClob;
    }
}
