package pl.coderslab.book;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.author.Author;
import pl.coderslab.author.AuthorService;
import pl.coderslab.publisher.Publisher;
import pl.coderslab.publisher.PublisherService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BookController {
    private final BookService bookService;
    private final PublisherService publisherService;
    private final AuthorService authorService;


    public BookController(BookService bookService,PublisherService publisherService, AuthorService authorService) {
        this.bookService = bookService;
        this.publisherService = publisherService;
        this.authorService = authorService;
    }

    @RequestMapping("/book/all")
    @ResponseBody
    public String getAll() {
        return bookService.getAll().toString();
    }

    @RequestMapping("/book/all/{rating}")
    @ResponseBody
    public String getRatingList(@PathVariable int rating) {
        return bookService.getRatingList(rating).toString();
    }

    @RequestMapping("/book/all/publisher/{id}")
    @ResponseBody
    public String getBooksFromPublisher(@PathVariable long id) {
        Publisher publisher = publisherService.findById(id);
        return bookService.getBooksFromPublisher(publisher).toString();
    }

    @RequestMapping("/book/all/author/{id}")
    @ResponseBody
    public String getBooksWithAuthor(@PathVariable long id) {
        Author author = authorService.findById(id);
        return bookService.getBooksWithAuthor(author).toString();
    }

    @RequestMapping("book/all/publisher")
    @ResponseBody
    public String getAllBooksWithPublisher() {
        return bookService.getAllBooksWithPublisher().toString();
    }

    @RequestMapping("/book/add")
    @ResponseBody
    public String hello() {
        Author author1 = authorService.findById(1);
        Author author2 = authorService.findById(2);
        Book book = new Book();
        Publisher publisher = new Publisher();
        publisher.setName("Helion");
        publisherService.addPublisher(publisher);

        book.setTitle("Thinking in Java");
        book.setDescription("Programing");
        book.setRating(2);
        book.setPublisher(publisher);
        bookService.addAuthor(book, author1);
        bookService.addAuthor(book, author2);
        bookService.saveBook(book);
        return "Id dodanej książki to:"
                + book.getId();
    }

    @RequestMapping("/book/get/{id}")
    @ResponseBody
    public String getBook(@PathVariable long id) {
        Book book = bookService.findById(id);
        return book.toString();
    }

    @RequestMapping("/book/update/{id}/{title}")
    @ResponseBody
    public String updateBook(@PathVariable long id, @PathVariable String title ) {
        Book book = bookService.findById(id);
        book.setTitle(title);
        bookService.update(book);
        return book.toString();
    }

    @RequestMapping("/book/delete/{id}")
    @ResponseBody
    public String deleteBook(@PathVariable long id) {
        Book book = bookService.findById(id);
        bookService.delete(book);
        return "deleted";
    }


}