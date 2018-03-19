package springboot.nf.book.book.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import springboot.nf.book.book.model.Author;
//AuthorDAO接口继承JpaRepsitory中的Author通过id来
public interface AuthorDAO extends JpaRepository<Author,Long>{

}
