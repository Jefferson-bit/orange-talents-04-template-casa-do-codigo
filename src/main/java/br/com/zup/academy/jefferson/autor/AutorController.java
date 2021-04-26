package br.com.zup.academy.jefferson.autor;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/autores")
public class AutorController {

	private AutorRepository autorRepository;

	public AutorController(AutorRepository autorRepository) {
		this.autorRepository = autorRepository;
	}

	@PostMapping
	@Transactional
	public ResponseEntity<AutorDTO> saveAutor(@Valid @RequestBody AutorDTO objDto){
		Autor autor = objDto.toModel();
		autorRepository.save(autor);
		objDto = new AutorDTO(autor);
		return ResponseEntity.ok(objDto);
	}

}
