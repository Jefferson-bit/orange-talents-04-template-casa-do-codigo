package br.com.zup.academy.jefferson.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = {UniqueValueValidator.class})//classe que faz a lógica de vaidação dos campos
@Target({ElementType.FIELD})// Aonde posso utilizar minha anotação customizada
@Retention(RetentionPolicy.RUNTIME)	//minha validação só vai funcionar em tempo de execução
public @interface UniqueValue {
	
	String message() default "{br.com.zup.academy.jefferson.beanvalidator.uniquevalue}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
	
	String fieldName();
	
	Class<?> domainClass();
	
}
