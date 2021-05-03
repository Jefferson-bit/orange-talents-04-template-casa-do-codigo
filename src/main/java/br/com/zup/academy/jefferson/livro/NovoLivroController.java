package br.com.zup.academy.jefferson.livro;


import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.academy.jefferson.autor.AutorRepository;
import br.com.zup.academy.jefferson.categoria.CategoriaRepository;

@RestController
@RequestMapping(value = "/livros")
public class NovoLivroController {

	private LivroRepository livroRepository;
	private AutorRepository autorRepository;
	private CategoriaRepository categoiaRepository;

	public NovoLivroController(LivroRepository livroRepository, AutorRepository autorRepository,
			CategoriaRepository categoiaRepository) {
		this.livroRepository = livroRepository;
		this.autorRepository = autorRepository;
		this.categoiaRepository = categoiaRepository;
	}

	@PostMapping
	@Transactional
	public ResponseEntity<LivroDTO> saveLivro(@Valid @RequestBody LivroDTO objDto) {
		Livro livro = objDto.toModel(categoiaRepository, autorRepository);
		livroRepository.save(livro);
		return ResponseEntity.ok(objDto);
	}	
}
