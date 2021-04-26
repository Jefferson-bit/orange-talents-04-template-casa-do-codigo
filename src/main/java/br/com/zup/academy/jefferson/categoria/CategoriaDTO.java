package br.com.zup.academy.jefferson.categoria;

import javax.validation.constraints.NotBlank;

public class CategoriaDTO {

	@NotBlank(message = "Campo não pode ser vazio")
	private String nome;

	@Deprecated
	public CategoriaDTO() {
	}

	public CategoriaDTO(String nome) {
		this.nome = nome;
	}
	
	public CategoriaDTO(Categoria obj) {
		this.nome = obj.getNome();
	}
	
	public String getNome() {
		return nome;
	}

	public Categoria toModel() {
		return new Categoria(this.nome);
	}

}
