package br.com.zup.academy.jefferson.pais;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaisRepository extends CrudRepository<Pais, Long>{
	
	@Query("SELECT obj FROM Pais obj LEFT JOIN obj.estados WHERE obj.id = :id")
	Pais findPaisComOuSemEstados(Long id);
}
