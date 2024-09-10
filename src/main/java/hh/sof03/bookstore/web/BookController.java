package hh.sof03.bookstore.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import hh.sof03.bookstore.domain.Book;
import hh.sof03.bookstore.domain.bookRepository;

@Controller
public class BookController {

    @Autowired
    private bookRepository repository;

    @RequestMapping(value = "/index")
    public String getBooks(Model model) {
        List<Book> books = (List<Book>) repository.findAll();
        model.addAttribute("books", books);
        return "booklist";
    }
}
