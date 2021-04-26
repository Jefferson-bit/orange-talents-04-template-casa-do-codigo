package br.com.zup.academy.jefferson.categoria;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/categorias")
public class NovaCategoriaController {

	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private  ProblemaEmailDuplicadoCategoriaValidator problemaEmailDuplicadoCategoriaValidator;

	public NovaCategoriaController(CategoriaRepository categoriaRepository) {
		this.categoriaRepository = categoriaRepository;
	}
	
	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(problemaEmailDuplicadoCategoriaValidator);
	}

	@PostMapping
	public ResponseEntity<CategoriaDTO> saveCategoria(@Valid @RequestBody CategoriaDTO objDto) {
		Categoria categoria = objDto.toModel();
		categoriaRepository.save(categoria);
		objDto = new CategoriaDTO(categoria);
		return ResponseEntity.ok(objDto);
	}
}
