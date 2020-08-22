package pl.coderslab.publisher;

import org.springframework.stereotype.Service;
import pl.coderslab.book.Book;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PublisherService {
    private final PublisherDao publisherDao;

    public List<Publisher> getAll() {
        return publisherDao.getAll();
    }

    public PublisherService(PublisherDao publisherDao) {
        this.publisherDao = publisherDao;
    }

    public void addPublisher(Publisher publisher) {
        publisherDao.addPublisher(publisher);
    }

    public Publisher findById(long id) {
        return publisherDao.findById(id);
    }

    public void update(Publisher publisher) {
        publisherDao.update(publisher);
    }

    public void delete(Publisher publisher) {
        publisherDao.delete(publisher);
    }
}
