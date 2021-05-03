package br.com.zup.academy.jefferson.cliente;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.zup.academy.jefferson.estado.Estado;
import br.com.zup.academy.jefferson.pais.Pais;

@Entity
@Table(name = "tb_cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String nome;
	@Column(unique = true, nullable = false)
	private String sobreNome;
	@Column(nullable = false)
	private String email;
	@Column(unique = true, nullable = false)
	private String cpfOuCnpj;
	@Column(nullable = false)
	private String endereco;
	@Column(nullable = false)
	private String complemento;
	@Column(nullable = false)
	private String cidade;
	@ManyToOne
	@JoinColumn(name = "pais_id")
	private Pais pais;
	@ManyToOne
	@JoinColumn(name = "estado_id")
	private Estado estado;
	@Column(nullable = false)
	private Integer telefone;
	@Column(nullable = false)
	private Integer cep;

	public Cliente(String nome, String sobreNome, String email, String cpfOuCnpj, String endereco, String complemento,
			String cidade, Pais pais, Estado estado, Integer telefone, Integer cep) {
		this.nome = nome;
		this.sobreNome = sobreNome;
		this.email = email;
		this.cpfOuCnpj = cpfOuCnpj;
		this.endereco = endereco;
		this.complemento = complemento;
		this.cidade = cidade;
		this.pais = pais;
		this.estado = estado;
		this.telefone = telefone;
		this.cep = cep;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getEndereco() {
		return endereco;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getCidade() {
		return cidade;
	}

	public Pais getPais() {
		return pais;
	}

	public Estado getEstado() {
		return estado;
	}

	public Integer getTelefone() {
		return telefone;
	}

	public Integer getCep() {
		return cep;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public String getSobreNome() {
		return sobreNome;
	}

	public static class ClienteBuilder {
		private String nome;
		private String sobreNome;
		private String email;
		private String cpfOuCnpj;
		private String endereco;
		private String complemento;
		private String cidade;
		private Pais pais;
		private Integer telefone;
		private Integer cep;
		private Estado estado;

		public ClienteBuilder() {
		}

		public ClienteBuilder nome(String nome) {
			this.nome = nome;
			return this;
		}

		public ClienteBuilder sobreNome(String sobreNome) {
			this.sobreNome = sobreNome;
			return this;
		}

		public ClienteBuilder email(String email) {
			this.email = email;
			return this;
		}

		public ClienteBuilder cpfOuCnpj(String cpfOuCnpj) {
			this.cpfOuCnpj = cpfOuCnpj;
			return this;
		}

		public ClienteBuilder endereco(String endereco) {
			this.endereco = endereco;
			return this;
		}

		public ClienteBuilder complemento(String complemento) {
			this.complemento = complemento;
			return this;
		}

		public ClienteBuilder cidade(String cidade) {
			this.cidade = cidade;
			return this;
		}

		public ClienteBuilder pais(Pais pais) {
			this.pais = pais;
			return this;
		}

		public ClienteBuilder estado(Estado estado) {
			this.estado = estado;
			return this;
		}

		public ClienteBuilder telefone(Integer telefone) {
			this.telefone = telefone;
			return this;
		}

		public ClienteBuilder cep(Integer cep) {
			this.cep = cep;
			return this;
		}

		public Cliente builder() {
			return new Cliente(nome, sobreNome, email, cpfOuCnpj, endereco, complemento, cidade, pais, estado, telefone,
					cep);
		}
	}

}
