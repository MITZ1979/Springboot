
package springboot.nf.book.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;
import springboot.nf.book.book.dao.AuthorDAO;
import springboot.nf.book.book.dao.BookDAO;
import springboot.nf.book.book.model.Book;

import javax.validation.Valid;

@Controller
@RequestMapping("/book")
public class BookController extends WebMvcConfigurerAdapter {

    @Autowired //自动注入BookDAO类
    private BookDAO bookDAO;

    @Autowired //自动注入AuthorDAO类
    private AuthorDAO authorDAO;

    @GetMapping("/index")
    public String listting(Model model){
        model.addAttribute("books",bookDAO.findAll());
        return "book/index";
    }

    @GetMapping("/add")
    public String add(Book book, Model model){
        model.addAttribute("authors",authorDAO.findAll());
        return "book/add";
    }


/**@Valid Book book
     *验证Book中@NotNull(message = "怎么，你想免费发给被人发书，太高尚了，鼓掌")@Min(value = 10 ,message = "要想赚更多钱，心要狠，价更高")@Size(min = 2,max = 9)
     *@Size(min = 2,max = 9)
     *信息是否符合条件
     *BindingResult errors:绑定Book book 信息到对象中显示
     */

    @PostMapping("/add")
    public String save(@Valid Book book, BindingResult errors , Model model){
            if (book.getAuthor() == null || book.getAuthor().getId()<1){
                errors.rejectValue("author",null,"你需要填写作者信息哦！");
            }
            if (errors.hasErrors()){
                model.addAttribute("authors",authorDAO.findAll());
                return "book/add";
            }
             bookDAO.save(book);

             return "redirect:index";
    }

    @GetMapping("/update")
    public String toEdit(Model model ,Long id) {
        model.addAttribute("book",bookDAO.getOne(id));
        model.addAttribute("authors",authorDAO.findAll());
        return "book/update";
    }

    @PostMapping("/update")
    public String edit(@Valid Book book, BindingResult result, Model model , RedirectAttributesModelMap flash) {
        if (invalidBook(book, result,model)) {
            return "book/update";
        }
        bookDAO.save(book);
        flash.addFlashAttribute("msg","保存成功！");
        return "redirect:index";
    }

    private boolean invalidBook(Book book, BindingResult result, Model model) {
        if (book.getAuthor() == null || book.getAuthor().getId()< 1){
            result.rejectValue("author",null,"您需要填写作者的信息哦!");
        }
        if (result.hasErrors()){
            model.addAttribute("authors",authorDAO.findAll());
        }
        return result.hasErrors();
    }

    @GetMapping("/delete")
    public String deleteBook(Long id , RedirectAttributesModelMap flash){
            bookDAO.delete(id);
            flash.addFlashAttribute("msg","删除成功");
            return "redirect:index";
    }


}

