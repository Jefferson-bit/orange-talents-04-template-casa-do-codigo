package br.com.zup.academy.jefferson.cliente;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.zup.academy.jefferson.estado.Estado;
import br.com.zup.academy.jefferson.pais.Pais;
import br.com.zup.academy.jefferson.validator.CpfAndCnpj;
import br.com.zup.academy.jefferson.validator.UniqueValue;

@JsonIgnoreProperties({"estadoId"})
public class ClienteDTO {

	@NotBlank(message = "Nome é obrigatório")
	private String nome;
	@NotBlank(message = "Sobrenome é obrigatório")
	private String sobreNome;
	@Email(message = "E-mail invalido")
	@NotBlank(message = "E-mail obrigatório")
	@UniqueValue(domainClass = Cliente.class, fieldName = "email", message = "E-mail Existente")
	private String email;
	@NotBlank(message = "CPF/CNPJ obrigatório")
	@CpfAndCnpj
	@UniqueValue(domainClass = Cliente.class, fieldName = "cpfOuCnpj", message = "CPF/CNPJ já existe")
	private String cpfOuCnpj;
	@NotBlank(message = "Endereço Obrigatório")
	private String endereco;
	@NotBlank(message = "Complemento Obrigatório")
	private String complemento;
	@NotBlank(message = "Cidade Obrigatório")
	private String cidade;
	@NotNull
	private Long paisId;
	@NotNull(message = "Telefone Obrigatório")
	private Integer telefone;
	@NotNull(message = "CEP Obrigatório")
	private Integer cep;
	private Long estadoId;
	
	public Cliente toModel(Pais pais, Estado estado) {
		return new Cliente.ClienteBuilder().nome(nome).sobreNome(sobreNome).email(email)
		.cpfOuCnpj(cpfOuCnpj).endereco(endereco).complemento(complemento).cidade(cidade)
		.telefone(telefone).cep(cep).pais(pais).estado(estado).builder();
	} 
	
	public Integer getCep() {
		return cep;
	}
	
	public Long getEstadoId() {
		return estadoId;
	}
	
	public String getCidade() {
		return cidade;
	}

	public String getComplemento() {
		return complemento;
	}
 
	public String getEmail() {
		return email;
	}

	public String getEndereco() {
		return endereco;
	}

	public String getNome() {
		return nome;
	}

	public String getSobreNome() {
		return sobreNome;
	}

	public Long getPaisId() {
		return paisId;
	}

	public Integer getTelefone() {
		return telefone;
	}
	
	public String getCpfOuCnpj() {
		return cpfOuCnpj;
	}
}
