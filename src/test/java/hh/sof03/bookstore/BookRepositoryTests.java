package hh.sof03.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import hh.sof03.bookstore.domain.AppUserRepository;
import hh.sof03.bookstore.domain.Book;
import hh.sof03.bookstore.domain.Category;
import hh.sof03.bookstore.domain.bookRepository;
import hh.sof03.bookstore.domain.categoryRepository;


@DataJpaTest
public class BookRepositoryTests {

    @Autowired
	private AppUserRepository appUserRepository;
    @Autowired
	private bookRepository bookRepository;
    @Autowired
	private categoryRepository categoryRepository;


    @Test
    public void findByBookTitle() {
        List<Book> books = bookRepository.findByTitle("The Shining");

        assertThat(books).hasSize(1);
        assertThat(books.get(0).getAuthor()).isEqualTo("Stephen King");
    }

    @Test
    public void addNewBook() {
        Book book = new Book("The Hobbit or There and Back Again","J. R. R. Tolkien" , 1937, "87654-21", 40, new Category("Fantasy"));
        bookRepository.save(book);
        assertThat(book.getId()).isNotNull();
    }
}
