package br.com.zup.academy.jefferson.livro;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import br.com.zup.academy.jefferson.autor.Autor;
import br.com.zup.academy.jefferson.autor.AutorRepository;
import br.com.zup.academy.jefferson.categoria.Categoria;
import br.com.zup.academy.jefferson.categoria.CategoriaRepository;
import br.com.zup.academy.jefferson.exception.ResourceNotFoundException;
import br.com.zup.academy.jefferson.validator.UniqueValue;

public class LivroDTO {
	
	@NotBlank(message = "Titulo é obrigatório")
	@UniqueValue(domainClass = Livro.class, fieldName = "titulo", message = "Título existente")
	private String titulo;
	@NotBlank(message = "Resumo é obrigatório")
	@Size(max = 500, message = "Suporte máximo é de 500 caracter")
	private String resumo;
	@NotBlank
	private String sumario;
	@NotNull(message = "Preço é obrigatório")
	@Min(value = 20, message = "Preço minimo é de 20 mangos")
	private BigDecimal preco;
	@NotNull(message = "Paginação é obrigatório")
	@Min(value = 100, message = "Paginação minima é de 100")
	private Integer numeroDePaginas;
	@NotNull(message = "ISBN é obrigatório")
	@UniqueValue(domainClass = Livro.class, fieldName = "isbn", message = "ISBN existente")
	private String isbn;
	@NotNull
	@Future
	@JsonFormat(pattern = "dd/MM/yyyy", shape = Shape.STRING)
	private LocalDate dataPublicacao;
	@NotNull
	private Long categoriaId;
	@NotNull
	private Long autorId;

	public LivroDTO() {
	}
	DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	public LivroDTO(@NotBlank(message = "Titulo é obrigatório") String titulo,
			@NotBlank(message = "Resumo é obrigatório") @Size(max = 500, message = "Suporte máximo é de 500 caracter") String resumo,
			@NotBlank String sumario,
			@NotNull(message = "Preço é obrigatório") @Min(value = 20, message = "Preço minimo é de 20 mangos") BigDecimal preco,
			@NotNull(message = "Paginação é obrigatório") @Min(value = 100, message = "Paginação minima é de 100") Integer numeroDePaginas,
			String isbn, LocalDate dataPublicacao, @NotNull Long categoriaId, @NotNull Long autorId) {
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.numeroDePaginas = numeroDePaginas;
		this.isbn = isbn;
		this.dataPublicacao = dataPublicacao;
		this.categoriaId = categoriaId;
		this.autorId = autorId;
	}
	public Livro toModel(CategoriaRepository categoriaRepository, AutorRepository autorRepository) {
		Categoria categoria = categoriaRepository.findById(categoriaId)
		.orElseThrow(() -> new ResourceNotFoundException("ID Categoria Not Found"));
		Autor autor = autorRepository.findById(autorId)
		.orElseThrow(() -> new ResourceNotFoundException("ID Autor Not Found"));
		
		return new Livro.LivroBuilder().titulo(titulo).resumo(resumo).sumario(sumario)
		.numeroDePaginas(numeroDePaginas).preco(preco).isbn(isbn).dataPublicacao(dataPublicacao)
		.categoria(categoria).autor(autor).builder();
	}
				
	public String getTitulo() {
		return titulo;
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

	public BigDecimal getPreco() {
		return preco;
	}

	public String getResumo() {
		return resumo;
	}

	public String getSumario() {
		return sumario;
	}

	public Long getCategoriaId() {
		return categoriaId;
	}

	public Long getAutorId() {
		return autorId;
	}
}
