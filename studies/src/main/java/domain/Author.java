package domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "AUTHOR")
public class Author {

    @SequenceGenerator(name = "author", sequenceName = "AUTHOR_ID_SEQ")
    @Id
    @GeneratedValue(generator = "author",strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private Long id;
    @Column(name = "NAME", length = 100)
    private String name;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "authors")
    private Set<Book> books = new HashSet<>();

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

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
}
