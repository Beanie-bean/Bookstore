package hh.sof03.bookstore.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.sof03.bookstore.domain.Book;
import hh.sof03.bookstore.domain.bookRepository;
import hh.sof03.bookstore.domain.categoryRepository;

@Controller
public class BookController {

    @Autowired
    private bookRepository brepository;

    @Autowired
    private categoryRepository crepository;

    @RequestMapping(value = "/index")
    public String getBooks(Model model) {
        List<Book> books = (List<Book>) brepository.findAll();
        model.addAttribute("books", books);
        return "listpage";
    }

    @RequestMapping(value = "/addBook", method = RequestMethod.GET)
    public String addBook(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("categories", crepository.findAll());
        return "addbook";
    }

    @RequestMapping(value = "/saveBook", method = RequestMethod.POST) 
    public String saveBook(Book book) {
        brepository.save(book);
        return "redirect:index";
    }

    @RequestMapping(value = "/deleteBook/{id}", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('ADMIN')")
    public String deleteBook(@PathVariable("id") Long id, Model model ) {
        brepository.deleteById(id);
        return "redirect:/index";
    }

    @RequestMapping(value = "/editBook/{id}")
    public String editBook(@PathVariable("id") Long id, Model model) {
        model.addAttribute("book", brepository.findById(id));
        model.addAttribute("categories", crepository.findAll());
        return "editbook";
    }

}