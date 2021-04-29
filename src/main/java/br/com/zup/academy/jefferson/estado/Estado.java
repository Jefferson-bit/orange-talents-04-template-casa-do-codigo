package br.com.zup.academy.jefferson.estado;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.zup.academy.jefferson.pais.Pais;

@Entity
@Table(name = "tb_estado")
public class Estado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true, nullable = false)
	private String nome;
	
	@ManyToOne
	@JoinColumn(name = "pais_id")
	private Pais pais;
	
	public Estado(String nome, Pais pais) {
		this.nome = nome;
		this.pais = pais;
	}
	
	public String getNome() {
		return nome;
	}
	
	public Pais getPais() {
		return pais;
	}
}
