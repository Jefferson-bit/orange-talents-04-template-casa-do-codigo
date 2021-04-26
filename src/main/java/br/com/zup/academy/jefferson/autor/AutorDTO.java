package br.com.zup.academy.jefferson.autor;

import java.time.Instant;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AutorDTO {

	@NotBlank(message = "Campo nome é obrigatório")
	private String nome;
	@Email(message = "Email invalido")
	@NotBlank(message = "Campo e-mail é obrigatório")
	private String email;
	@NotBlank(message = "Campo descrição é obrigatório")
	@Size(max = 400, message = "A descrição máxima é 400 caracteres")
	private String descricao;

	private Instant instante = Instant.now();

	@Deprecated
	public AutorDTO() {
	}

	public AutorDTO(@NotBlank(message = "Campo nome é obrigatório") String nome,
			@Email(message = "Email invalido") @NotBlank(message = "Campo e-mail é obrigatório") String email,
			@NotBlank(message = "Campo descrição é obrigatório") @Size(max = 400, message = "A descrição máxima é 400 caracteres") String descricao) {
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
	}
	
	public AutorDTO(Autor autor) {
		this.nome = autor.getNome();
		this.email = autor.getEmail();
		this.descricao = autor.getDescricao();
	}

	public String getDescricao() {
		return descricao;
	}

	public String getEmail() {
		return email;
	}

	public String getNome() {
		return nome;
	}

	public Autor toModel() {
		return new Autor(this.nome, this.email, this.descricao);
	}

	public Instant getInstante() {
		return instante;
	}

}
