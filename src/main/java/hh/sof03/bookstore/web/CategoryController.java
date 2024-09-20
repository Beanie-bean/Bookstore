package hh.sof03.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import org.springframework.ui.Model;

import hh.sof03.bookstore.domain.Category;
import hh.sof03.bookstore.domain.categoryRepository;

@Controller
public class CategoryController {
    @Autowired
    private categoryRepository crepository;

    @RequestMapping(value="/categorylist")
    public String categoryList(Model model) {
        model.addAttribute("categories", crepository.findAll());
        return "categorylist";
    }

    @RequestMapping(value="/addcategory", method = RequestMethod.GET)
    public String addCategory(Model model) {
        model.addAttribute("category", new Category());
        return "addcategory";
    }

    @RequestMapping(value="/savecategory", method = RequestMethod.POST)
    public String saveCategory(Category category) {
        crepository.save(category);
        return "redirect:categorylist";
    }
}
