package com.fernando.myapi.bookstore.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fernando.myapi.bookstore.domain.Livro;
import com.fernando.myapi.bookstore.services.LivroService;

@Controller
@RequestMapping(value = "/livros")
public class LivroResource {

	
	@Autowired
	private LivroService service;
	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Livro> findById(@PathVariable Integer id){
		Livro obj = service.findById(id);
		return ResponseEntity.ok().body(obj);	
	}
}
