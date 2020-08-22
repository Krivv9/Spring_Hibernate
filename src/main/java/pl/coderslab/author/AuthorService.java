package pl.coderslab.author;

import org.springframework.stereotype.Service;
import pl.coderslab.book.Book;
import pl.coderslab.book.BookDao;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AuthorService {
    private final AuthorDao authorDao;

    public AuthorService(AuthorDao authorDao){
        this.authorDao = authorDao;
    }

    public void createAuthor(Author author) {
        authorDao.createAuthor(author);
    }

    public Author findById(long id) {
        return authorDao.findById(id);
    }

    public void update(Author author) {
        authorDao.update(author);
    }

    public void delete(Author author) {
        authorDao.delete(author);
    }

    public List<Author> getAll() {
        return authorDao.getAll();
    }
}