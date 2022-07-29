package com.fernando.myapi.bookstore.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fernando.myapi.bookstore.domain.Livro;
import com.fernando.myapi.bookstore.dtos.LivroDTO;
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
	
	
	@GetMapping
	public ResponseEntity<List<LivroDTO>> findAll(@RequestParam(value = "categorias", defaultValue = "0") Integer id_cat){
		List<Livro> list = service.findAll(id_cat);
		List<LivroDTO> listDTO = list.stream()
				.map(obj -> new LivroDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
}
