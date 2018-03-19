package springboot.nf.book.book.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Author {
    @Id//基于annotation的hibernate主键标识
    @GeneratedValue
    private Long id;

    private String name;

    private String telephone;

    // 不要让双方都去维护关系，不然会有冲突或重复。
    // 一般情况下，需要让多的一端维护关系即可。这里用 mappedBy 表名，自己当甩手掌柜。
    @OneToMany(mappedBy = "author")
    private List<Book> books;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
