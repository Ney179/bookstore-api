package com.fernando.myapi.bookstore.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fernando.myapi.bookstore.domain.Livro;
import com.fernando.myapi.bookstore.repositories.LivroRepository;
import com.fernando.myapi.bookstore.services.exceptions.ObjectNotFoundException;


@Service
public class LivroService {
	
	@Autowired
	private LivroRepository repository;
	
	@Autowired
	private CategoriaService service;

	public Livro findById(Integer id) {
		Optional<Livro> obj = repository.findById(id);
		return obj.orElseThrow(() ->
		new ObjectNotFoundException("Objeto não encontrado! " + id + ", Tipo: " + Livro.class.getName()));
	}

	public List<Livro> findAll(Integer id_cat) {
		service.findById(id_cat);
		return repository.findAllByCategoria(id_cat);
	}

}
