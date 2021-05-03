package br.com.zup.academy.jefferson.cliente;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.academy.jefferson.estado.Estado;
import br.com.zup.academy.jefferson.estado.EstadoRepository;
import br.com.zup.academy.jefferson.pais.Pais;
import br.com.zup.academy.jefferson.pais.PaisRepository;

@RestController
public class NovoClienteController {

	private ClienteRepository clienteRepository;
	private PaisRepository paisRepository;

	public NovoClienteController(ClienteRepository clienteRepository, PaisRepository paisRepository,
			EstadoRepository estadoRepository) {
		this.clienteRepository = clienteRepository;
		this.paisRepository = paisRepository;
	}

	@PostMapping(value = "/clientes")
	@Transactional
	public ResponseEntity<ClienteDTO> saveCliente(@Valid @RequestBody ClienteDTO objDto) {
		Pais pais = paisRepository.findPaisComOuSemEstados(objDto.getPaisId());
		Cliente cliente = objDto.toModel(pais, null);	
		for (Estado estado : pais.getEstados()) {
			if(estado.getId() != null) {
				cliente = objDto.toModel(pais, estado);
				clienteRepository.save(cliente);
				return ResponseEntity.ok(objDto); 
			}
		}	
		clienteRepository.save(cliente);
		return ResponseEntity.ok(objDto);   
	}
}
