package br.com.zup.academy.jefferson.autor;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ProibeEmaiDuplicadoAutorValidator implements Validator {

	@Autowired
	private AutorRepository autorRepository;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return AutorDTO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
			if(errors.hasErrors()) {
				return;
			}
		AutorDTO autorDTO = (AutorDTO) target;
		Optional<Autor> autorOptional = autorRepository.findByEmail(autorDTO.getEmail());
		
		if(autorOptional.isPresent()) {
			errors.rejectValue("email", null, "Email não pode ser duplicado" + autorDTO.getEmail());
		}
	} 

	
	
	
}