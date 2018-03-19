/*
package springboot.nf.book.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import springboot.nf.book.book.dao.AuthorDAO;
import springboot.nf.book.book.model.Author;

@Controller
@RequestMapping("/book")
public class AuthorController {

    @Autowired
    private AuthorDAO authorDAO;

    @GetMapping("/add_author")
    public String add(){
        return "/book/add_author";
    }

    @PostMapping("/add_author")
    public String store(Author author, Model model){
        authorDAO.save(author);
        return "redirect:add_author";
    }
}
*/
