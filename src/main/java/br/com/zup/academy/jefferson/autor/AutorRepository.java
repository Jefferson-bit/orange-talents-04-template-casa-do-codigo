package br.com.zup.academy.jefferson.autor;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends CrudRepository<Autor, Long> {

}
