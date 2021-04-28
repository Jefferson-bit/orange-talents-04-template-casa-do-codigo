package br.com.zup.academy.jefferson.categoria;


import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/categorias")
public class NovaCategoriaController {

	private CategoriaRepository categoriaRepository;

	public NovaCategoriaController(CategoriaRepository categoriaRepository) {
		this.categoriaRepository = categoriaRepository;
	}

	@PostMapping
	@Transactional
	public ResponseEntity<CategoriaDTO> saveCategoria(@Valid @RequestBody CategoriaDTO objDto) {
		Categoria categoria = objDto.toModel();
		categoriaRepository.save(categoria);
		return ResponseEntity.ok(objDto);
	}
}
