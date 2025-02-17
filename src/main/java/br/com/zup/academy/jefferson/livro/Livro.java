package br.com.zup.academy.jefferson.livro;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.zup.academy.jefferson.autor.Autor;
import br.com.zup.academy.jefferson.categoria.Categoria;

@Entity
@Table(name = "tb_livro")
public class Livro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true, nullable = false)
	private String titulo;
	@Column(nullable = false)
	private String resumo;
	@Column(columnDefinition = "TEXT")
	private String sumario;
	@Column(nullable = false)
	private BigDecimal preco;
	@Column(nullable = false)
	private Integer numeroDePaginas;
	@Column(unique = true, nullable = false)
	private String isbn;
	@Column(nullable = false)
	private LocalDate dataPublicacao;

	@ManyToOne
	@JoinColumn(name = "categoria_id")
	private Categoria categoria;

	@ManyToOne
	@JoinColumn(name = "autor_id")
	private Autor autor;

	@Deprecated
	public Livro() {
	}

	private Livro(String titulo, String resumo, String sumario, BigDecimal preco, Integer numeroDePaginas, String isbn,
			LocalDate dataPublicacao, Categoria categoria, Autor autor) {
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.numeroDePaginas = numeroDePaginas;
		this.isbn = isbn;
		this.dataPublicacao = dataPublicacao;
		this.categoria = categoria;
		this.autor = autor;
	}

	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public Autor getAutor() {
		return autor;
	}

	public LocalDate getDataPublicacao() {
		return dataPublicacao;
	}

	public String getIsbn() {
		return isbn;
	}

	public Integer getNumeroDePaginas() {
		return numeroDePaginas;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public String getResumo() {
		return resumo;
	}

	public String getSumario() {
		return sumario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Livro other = (Livro) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public static class LivroBuilder {
		private String titulo;
		private String resumo;
		private String sumario;
		private BigDecimal preco;
		private Integer numeroDePaginas;
		private String isbn;
		private LocalDate dataPublicacao;
		private Categoria categoria;
		private Autor autor;

		public LivroBuilder() {
		}

		public LivroBuilder titulo(String titulo) {
			this.titulo = titulo;
			return this;
		}

		public LivroBuilder resumo(String resumo) {
			this.resumo = resumo;
			return this;
		}

		public LivroBuilder sumario(String sumario) {
			this.sumario = sumario;
			return this;
		}

		public LivroBuilder preco(BigDecimal preco) {
			this.preco = preco;
			return this;
		}

		public LivroBuilder numeroDePaginas(Integer numeroDePaginas) {
			this.numeroDePaginas = numeroDePaginas;
			return this;
		}

		public LivroBuilder isbn(String isbn) {
			this.isbn = isbn;
			return this;
		}

		public LivroBuilder dataPublicacao(LocalDate dataPublicacao) {
			this.dataPublicacao = dataPublicacao;
			return this;
		}

		public LivroBuilder categoria(Categoria categoria) {
			this.categoria = categoria;
			return this;
		}

		public LivroBuilder autor(Autor autor) {
			this.autor = autor;
			return this;
		}

		public Livro builder() {
			return new Livro(titulo, resumo, sumario, preco, numeroDePaginas, isbn, dataPublicacao, categoria, autor);
		}
	}
}
