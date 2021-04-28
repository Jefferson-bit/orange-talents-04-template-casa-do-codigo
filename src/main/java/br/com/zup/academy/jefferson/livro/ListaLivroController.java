package br.com.zup.academy.jefferson.livro;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ListaLivroController {
	
	private LivroRepository livroRepository;
	
	public ListaLivroController(LivroRepository livroRepository) {
		this.livroRepository = livroRepository;
	}

	@GetMapping(value = "/listaLivros")
	public ResponseEntity<List<ListaLivroDTO>> findAll(){
		Iterable<Livro> findAll = livroRepository.findAll();
		List<ListaLivroDTO> listLivroDTO = StreamSupport.stream(findAll.spliterator(), false)
		.map(obj -> new ListaLivroDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok(listLivroDTO);
	}
}
