package hh.sof03.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.sof03.bookstore.domain.Book;
import hh.sof03.bookstore.domain.bookRepository;
import hh.sof03.bookstore.domain.Category;
import hh.sof03.bookstore.domain.categoryRepository;

@SpringBootApplication
public class BookstoreApplication {
		private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(bookRepository brepository, categoryRepository crepository ) {
		return (args) -> {
			Category category1 = new Category("Horror");
			crepository.save(category1);
			Category category2 = new Category("Romance");
			crepository.save(category2);

			brepository.save(new Book("The Fault in Our Stars", "John Green", 2012, "12345-12", 20, category2));
			brepository.save(new Book("The Shining", "Stephen King", 1977, "54321-21", 20, category1));
		
			for (Book book : brepository.findAll()) {
				log.info(book.toString());
			}
		};
	}
}
