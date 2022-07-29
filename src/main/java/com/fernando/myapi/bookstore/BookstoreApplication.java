package com.fernando.myapi.bookstore;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fernando.myapi.bookstore.domain.Categoria;
import com.fernando.myapi.bookstore.domain.Livro;
import com.fernando.myapi.bookstore.repositories.CategoriaRepository;
import com.fernando.myapi.bookstore.repositories.LivroRepository;

@SpringBootApplication
public class BookstoreApplication implements CommandLineRunner{
	
	@Autowired
	CategoriaRepository categoriaRepository;
	
	@Autowired
	LivroRepository livroRepository;

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Categoria cat1 = new Categoria(null, "Informatica", "Livro de TI");
		Livro l1 = new Livro(null, "Clean code", "Robert Martin", "Loren ipsum", cat1);
		
		cat1.getLivro().addAll(Arrays.asList(l1));
		
		this.categoriaRepository.saveAll(Arrays.asList(cat1));
		this.livroRepository.saveAll(Arrays.asList(l1));
	}

}
