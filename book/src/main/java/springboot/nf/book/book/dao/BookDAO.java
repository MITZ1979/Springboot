package springboot.nf.book.book.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import springboot.nf.book.book.model.Book;

public interface BookDAO extends JpaRepository<Book,Long>{

}
