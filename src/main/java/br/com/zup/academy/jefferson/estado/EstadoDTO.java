package br.com.zup.academy.jefferson.estado;

import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

import br.com.zup.academy.jefferson.pais.Pais;
import br.com.zup.academy.jefferson.validator.UniqueValue;

public class EstadoDTO {

	@NotBlank(message = "Nome do Estado é obrigatório")
	@UniqueValue(domainClass = Estado.class, fieldName = "nome", message = "Estado existente")
	private String nome;
	@NotNull
	private Long paisId;
	
	public EstadoDTO(String nome, Long paisId) {
		this.nome = nome;
		this.paisId = paisId;
	}

	public Estado toModel(Pais pais) {
		return new Estado(nome, pais);
	}

	public String getNome() {
		return nome;
	}
	
	public Long getPaisId() {
		return paisId;
	}
}
