package br.com.zup.academy.jefferson.livro;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.zup.academy.jefferson.autor.DetalhesAutorDTO;

public class DetalhesLivroDTO {
	
	private DetalhesAutorDTO autor;
	private String titulo;
	private BigDecimal preco;
	private String resumo;
	private String sumario;
	private Integer numeroDePaginas;
	private String isbn;
	private LocalDate dataDaPublicacao;

	public DetalhesLivroDTO() {
	}
	
	public DetalhesLivroDTO(Livro livro) {
		titulo = livro.getTitulo();
		preco = livro.getPreco();
		resumo = livro.getResumo();
		sumario = livro.getSumario();
		numeroDePaginas = livro.getNumeroDePaginas();
		isbn = livro.getIsbn();
		dataDaPublicacao = livro.getDataPublicacao();
		autor = new DetalhesAutorDTO(livro.getAutor());
	}
	
	public DetalhesAutorDTO getAutor() {
		return autor;
	}

	public LocalDate getDataDaPublicacao() {
		return dataDaPublicacao;
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

	public String getTitulo() {
		return titulo;
	}
}
