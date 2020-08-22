package pl.coderslab.book;

import org.springframework.stereotype.Service;
import pl.coderslab.author.Author;
import pl.coderslab.publisher.Publisher;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BookService {
    private final BookDao bookDao;

    public BookService(BookDao bookDao){
        this.bookDao = bookDao;
    }

    public void saveBook(Book book) {
        bookDao.saveBook(book);
    }

    public Book findById(long id) {
        return bookDao.findById(id);
    }

    public void update(Book book) {
        bookDao.update(book);
    }

    public void delete(Book book) {
        bookDao.delete(book);
    }

    public void addAuthor(Book book, Author author) {
        List<Author> authors = book.getAuthors();
        authors.add(author);
    }

    public List<Book> getAll() {
        return bookDao.getAll();
    }

    public List<Book> getRatingList(int rating) {
        return bookDao.getRatingList(rating);
    }

    public List<Book> getBooksFromPublisher(Publisher publisher) {
        return bookDao.getBooksFromPublisher(publisher);
    }

    public List<Book> getAllBooksWithPublisher(){
        return bookDao.getAllBooksWithPublisher();
    }

    public List<Book> getBooksWithAuthor(Author author) {
        return bookDao.getBooksWithAuthor(author);
    }
}
