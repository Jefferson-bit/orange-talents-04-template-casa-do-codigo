package br.com.zup.academy.jefferson.pais;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.zup.academy.jefferson.cliente.Cliente;
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
	private List<Estado> estados = new ArrayList<>();

	@OneToMany(mappedBy = "pais")
	private List<Cliente> clientes = new ArrayList<>();

	@Deprecated
	public Pais() {
	}
	
	public Long getId() {
		return id;
	}
	
	public Pais(String nome) {
		this.nome = nome;
	}

	public List<Estado> getEstados() {
		return estados;
	}

	public String getNome() {
		return nome;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}
}
