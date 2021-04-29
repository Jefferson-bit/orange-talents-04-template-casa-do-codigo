package br.com.zup.academy.jefferson.livro;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.academy.jefferson.exception.ResourceNotFoundException;

@RestController
@RequestMapping(value = "/livros")
public class RecursoParaBuscarLivroController {
	
	private LivroRepository livroRepository;
	
	public RecursoParaBuscarLivroController(LivroRepository livroRepository) {
		this.livroRepository = livroRepository;
	}

	@GetMapping(value = "/listaLivros")
	public ResponseEntity<List<ListaLivroDTO>> findAll(){
		Iterable<Livro> findAll = livroRepository.findAll();
		List<ListaLivroDTO> listLivroDTO = StreamSupport.stream(findAll.spliterator(), false)
		.map(obj -> new ListaLivroDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok(listLivroDTO);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<DetalhesLivroDTO> findById(@PathVariable Long id){
		Optional<Livro> livroOptional = livroRepository.findById(id);
		Livro livro = livroOptional.orElseThrow(() -> new ResourceNotFoundException("Id Not Found " + id));
		return ResponseEntity.ok(new DetalhesLivroDTO(livro));
	}
}
