package br.com.zup.academy.jefferson.autor;

public class DetalhesAutorDTO {

	private String nome;
	private String descricao;

	public DetalhesAutorDTO(Autor autor) {
		nome = autor.getNome();
		descricao = autor.getDescricao();
	}

	public String getDescricao() {
		return descricao;
	}

	public String getNome() {
		return nome;
	}
}
