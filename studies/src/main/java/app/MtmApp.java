package app;

import domain.Author;
import domain.Book;
import hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Set;

public class MtmApp {
    public static void main(String[] args) {
        Book book = new Book();
        book.setName("Calikusu");

        Author author = new Author();
        author.setName("Resat Nuri Guntekin");

        book.getAuthors().add(author);
        author.getBooks().add(book);

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        book = (Book)session.merge(book);
        transaction.commit();

        Book book1 = session.find(Book.class, book.getId());
        Set authors = book1.getAuthors();

        for (Object author1 : authors){
            Author author2 = (Author) author1;
            System.out.println(author2.getName());
        }
    }
}
