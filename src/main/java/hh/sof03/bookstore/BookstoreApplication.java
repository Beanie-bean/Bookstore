package hh.sof03.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.sof03.bookstore.domain.Book;
import hh.sof03.bookstore.domain.bookRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(bookRepository repository) {
		return (args) -> {
			Book book1 = new Book("A Farewell to Arms", "Ernest Hemingway", 1929, "1232323-21", 20);
			Book book2 = new Book("Animal Farm", "George Orwell", 1945, "2212343-5", 20);
			repository.save(book1);
			repository.save(book2);

		};
	}
}
