package com.fernando.myapi.bookstore.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.fernando.myapi.bookstore.domain.Categoria;

public class CategoriaDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@NotEmpty(message = "Campo NOME é requerido")
	@Length(min = 3, max = 100, message = "O Campo NOME deve conter entre 3 e 100 caracteres")
	private String nome;
	
	@NotEmpty(message = "Campo DESCRIÇÂO é requerido")
	@Length(min = 3, max = 100, message = "O Campo DESCRIÇÂO deve conter entre 3 e 100 caracteres")
	private String descricao;

	public CategoriaDTO() {
		super();
	}

	public CategoriaDTO(Categoria obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.descricao = obj.getDescricao();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
