package br.com.challenge.books;

import br.com.challenge.books.principal.Principal;
import br.com.challenge.books.repository.AutorRepository;
import br.com.challenge.books.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BooksApplication implements CommandLineRunner {

	@Autowired
	private LivroRepository livroRepositorio;

	@Autowired
	private AutorRepository autorRepositorio;

	public static void main(String[] args) {
		SpringApplication.run(BooksApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception{
		Principal principal = new Principal(livroRepositorio, autorRepositorio);
		principal.exibiMenu();
	}

}
