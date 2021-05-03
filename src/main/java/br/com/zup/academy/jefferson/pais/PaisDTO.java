package br.com.zup.academy.jefferson.pais;

import javax.validation.constraints.NotBlank;

import br.com.zup.academy.jefferson.validator.UniqueValue;

public class PaisDTO {
	
	@NotBlank(message = "Nome do País é obrigatório")
	@UniqueValue(domainClass = Pais.class, fieldName = "nome", message = "País existente")
	private String nome;
	
	@Deprecated
	public PaisDTO() {
	}
	
	public PaisDTO(@NotBlank(message = "Nome do País é obrigatório") String nome) {
		this.nome = nome;
	}
	
	public PaisDTO (Pais pais) {
		nome = pais.getNome();
	}
	
	public Pais toModel() {
		return new Pais(this.nome);
	}
	
	public String getNome() {
		return nome;
	}
	
}
