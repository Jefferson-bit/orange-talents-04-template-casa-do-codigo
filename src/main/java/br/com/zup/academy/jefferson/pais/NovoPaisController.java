package br.com.zup.academy.jefferson.pais;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NovoPaisController {
	
	private PaisRepository paisRepository;
	
	public NovoPaisController(PaisRepository paisRepository) {
		this.paisRepository = paisRepository;
	}

	@PostMapping(value = "/paises")
	@Transactional
	public ResponseEntity<PaisDTO> savePais(@Valid @RequestBody PaisDTO objDto){
		Pais pais = objDto.toModel();
		paisRepository.save(pais);
		return ResponseEntity.ok(objDto);
	}
}
