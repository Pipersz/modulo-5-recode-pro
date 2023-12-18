package br.com.mercuryviagens.domain;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Contato implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String telefone;
	private String email;
	private String opcaoContato;
	
	public Contato() {}
	
	public Contato(Integer id, String nome, String telefone, String email, String opcaoContato) {
		super();
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.opcaoContato = opcaoContato;
	}

	@Override
	public String toString() {
		return "Contato [id=" + id + ", nome=" + nome + ", telefone=" + telefone + ", email=" + email
				+ ", opcaoContato=" + opcaoContato + "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contato other = (Contato) obj;
		return Objects.equals(id, other.id);
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getOpcaoContato() {
		return opcaoContato;
	}
	public void setOpcaoContato(String opcaoContato) {
		this.opcaoContato = opcaoContato;
	}
	
	
}
