package com.fernando.myapi.bookstore.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fernando.myapi.bookstore.domain.Categoria;
import com.fernando.myapi.bookstore.domain.Livro;
import com.fernando.myapi.bookstore.repositories.CategoriaRepository;
import com.fernando.myapi.bookstore.repositories.LivroRepository;

@Service
public class DBService {
	
	@Autowired
	CategoriaRepository categoriaRepository;
	
	@Autowired
	LivroRepository livroRepository;

	
	public void instanciaBaseDados() {
		
		Categoria cat1 = new Categoria(null, "Informatica", "Livro de TI");
		Categoria cat2 = new Categoria(null, "Ficção Cientifica", "Ficção Cientifica");
		Categoria cat3 = new Categoria(null, "Biografias", "Livro de Biografias");
		
		
		Livro l1 = new Livro(null, "Clean code", "Robert Martin", "Loren ipsum", cat1);
		Livro l2 = new Livro(null, "Engenharia de Software", "Louis V. Gerstner", "Loren ipsum", cat1);
		Livro l3 = new Livro(null, "The Time Machine", "H. G. Wells", "Loren ipsum", cat2);
		Livro l5 = new Livro(null, "The War of the Worlds", "H.G. Wells", "Loren ipsum", cat2);
		Livro l4 = new Livro(null, "I, Robot", "Isaac Asimov", "Loren ipsum", cat2);
		
		cat1.getLivro().addAll(Arrays.asList(l1, l2));
		cat2.getLivro().addAll(Arrays.asList(l3, l4, l5));
		
		this.categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		this.livroRepository.saveAll(Arrays.asList(l1, l2, l3, l4, l5));
	}
}
