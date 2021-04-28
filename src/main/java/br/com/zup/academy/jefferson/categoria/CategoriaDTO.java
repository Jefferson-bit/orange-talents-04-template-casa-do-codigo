package br.com.zup.academy.jefferson.categoria;

import javax.validation.constraints.NotBlank;

import br.com.zup.academy.jefferson.validator.UniqueValue;

public class CategoriaDTO {

	@NotBlank(message = "Campo não pode ser vazio")
	@UniqueValue(domainClass = Categoria.class, fieldName = "nome")
	private String nome;

	@Deprecated
	public CategoriaDTO() {
	}

	public CategoriaDTO(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}

	public Categoria toModel() {
		return new Categoria(this.nome);
	}

}
