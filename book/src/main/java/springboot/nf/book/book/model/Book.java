package springboot.nf.book.book.model;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
public class Book {

    @Id
    @GeneratedValue
    private Long id;

    //@Size(min = 2,max = 9)
    @NotBlank
    private String name;

    @NotNull(message = "怎么，你想免费发给被人发书，太高尚了，鼓掌")
    @Min(value = 10 ,message = "要想赚更多钱，心要狠，价更高")
    private double price;

    @ManyToOne
    private Author author;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
