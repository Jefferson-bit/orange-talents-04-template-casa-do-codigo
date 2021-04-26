package br.com.zup.academy.jefferson.categoria;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ProblemaEmailDuplicadoCategoriaValidator implements Validator{

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return CategoriaDTO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if(errors.hasErrors()) {
			return;
		}
		CategoriaDTO categoriaDTO = (CategoriaDTO) target;
		Optional<Categoria> categoriaOptional = categoriaRepository.findByNome(categoriaDTO.getNome());
		if(categoriaOptional.isPresent()) {
			errors.rejectValue("nome", null, "Nome não pode ser duplicado: " + categoriaDTO.getNome());
		}
		
	}

}
