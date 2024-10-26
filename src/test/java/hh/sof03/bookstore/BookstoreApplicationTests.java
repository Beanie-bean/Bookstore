package hh.sof03.bookstore;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

import hh.sof03.bookstore.web.AppUserController;
import hh.sof03.bookstore.web.BookController;
import hh.sof03.bookstore.web.CategoryController;

@SpringBootTest
class BookstoreApplicationTests {

	@Autowired
	private AppUserController appUserController;
	@Autowired
	private BookController bookController;
	@Autowired 
	private CategoryController categoryController;

	@Test
	void contextLoads() throws Exception {
		assertThat(bookController).isNotNull();
		assertThat(appUserController).isNotNull();
		assertThat(categoryController).isNotNull();
	}
}
