package br.com.zup.academy.jefferson.livro;

public class ListaLivroDTO {
	
	private Long id;
	private String titulo;
	
	public ListaLivroDTO() {
	}
		
	public ListaLivroDTO(Livro obj) {
			id = obj.getId();
			titulo = obj.getTitulo();
	}
	
	public Long getId() {
		return id;
	}
	public String getTitulo() {
		return titulo;
	}
}
