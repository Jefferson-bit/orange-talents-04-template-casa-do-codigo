package br.com.zup.academy.jefferson.pais;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.zup.academy.jefferson.estado.Estado;

@Entity
@Table(name = "tb_pais")
public class Pais {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true, nullable = false)
	private String nome;

	@OneToMany(mappedBy = "pais")
	private Set<Estado> estados = new HashSet<>();
	
	@Deprecated
	public Pais() {
	}
	
	public Pais(String nome) {
		this.nome = nome;
	}

	public Set<Estado> getEstados() {
		return estados;
	}
	
	public String getNome() {
		return nome;
	}
}
