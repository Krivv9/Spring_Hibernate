package pl.coderslab.book;

import org.springframework.stereotype.Repository;
import pl.coderslab.author.Author;
import pl.coderslab.publisher.Publisher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class BookDao {
    @PersistenceContext
    EntityManager entityManager;
    public void saveBook(Book book) {
        entityManager.persist(book);
    }

    public Book findById(long id){
        return entityManager.find(Book.class, id);
    }

    public void update(Book book){
        entityManager.merge(book);
    }

    public void delete(Book book) {
        entityManager.remove(entityManager.contains(book) ?
                book : entityManager.merge(book));
    }

    public List<Book> getAll() {
        Query query = entityManager.createQuery("select b from Book b");
        return query.getResultList();
    }

    public List<Book> getRatingList(int rating) {
        Query query = entityManager.createQuery("select b from Book b where b.rating =:rating");
        query.setParameter("rating", rating);
        return query.getResultList();
    }

    public List<Book> getAllBooksWithPublisher() {
        Query query = entityManager.createQuery("select b from Book b JOIN b.publisher");
        return query.getResultList();
    }

    public List<Book> getBooksFromPublisher(Publisher publisher) {
        Query query = entityManager.createQuery("select b from Book b where b.publisher = :publisher");
        query.setParameter("publisher", publisher);
        return query.getResultList();
    }

    public List<Book> getBooksWithAuthor(Author author) {
        Query query = entityManager.createQuery("SELECT b FROM Book b JOIN FETCH b.authors a WHERE a = :author");
        query.setParameter("author", author);
        return query.getResultList();
    }
}
