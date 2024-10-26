package hh.sof03.bookstore.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface bookRepository extends CrudRepository<Book, Long> {
    List<Book> findByTitle(String title);
}
