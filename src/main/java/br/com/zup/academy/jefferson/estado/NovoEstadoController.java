package br.com.zup.academy.jefferson.estado;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.academy.jefferson.exception.ResourceNotFoundException;
import br.com.zup.academy.jefferson.pais.Pais;
import br.com.zup.academy.jefferson.pais.PaisRepository;

@RestController
public class NovoEstadoController {

	private EstadoRepository estadoRepository;
	private PaisRepository paisRepository;

	public NovoEstadoController(EstadoRepository estadoRepository, PaisRepository paisRepository) {
		this.estadoRepository = estadoRepository;
		this.paisRepository = paisRepository;
	}

	@PostMapping(value = "/estados")
	@Transactional
	public ResponseEntity<EstadoDTO>saveEstado(@Valid @RequestBody EstadoDTO objDto){
		Optional<Pais> paisOptional = paisRepository.findById(objDto.getPaisId());
		Pais pais = paisOptional.orElseThrow(() -> new ResourceNotFoundException("ID Not found " + objDto.getPaisId()));
		Estado estado = objDto.toModel(pais);
		estadoRepository.save(estado);
		return ResponseEntity.ok(objDto);
	}

}
 