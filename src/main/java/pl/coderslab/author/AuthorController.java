package pl.coderslab.author;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthorController {
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @RequestMapping("/author/all")
    @ResponseBody
    public String getAll() {
        return authorService.getAll().toString();
    }

    @RequestMapping("/author/add")
    @ResponseBody
    public String hello() {
        Author author = new Author();
        author.setFirstName("Artur");
        author.setLastName("Hacia");
        authorService.createAuthor(author);
        return "Dodano autora o id: "
                + author.getId();
    }

    @RequestMapping("/author/get/{id}")
    @ResponseBody
    public String getAuthor(@PathVariable long id) {
        Author author = authorService.findById(id);
        return author.toString();
    }
    @RequestMapping("/author/update/{id}/{lastName}")
    @ResponseBody
    public String updateAuthor(@PathVariable long id, @PathVariable String lastName ) {
        Author author = authorService.findById(id);
        author.setLastName(lastName);
        authorService.update(author);
        return author.toString();
    }
    @RequestMapping("/author/delete/{id}")
    @ResponseBody
    public String deleteAuthor(@PathVariable long id) {
        Author author = authorService.findById(id);
        authorService.delete(author);
        return "deleted";
    }
}