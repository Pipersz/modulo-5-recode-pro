package br.com.mercuryviagens.domain;

import java.io.Serializable;
import java.util.Base64;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class Imagem implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	
	@Lob
	private byte[] conteudo;
	
	public Imagem() {}
	
	public Imagem(Integer id, String nome, byte[] conteudo) {
		super();
		this.id = id;
		this.nome = nome;
		this.conteudo = conteudo;
	}
	
	public String toBase64() {
		return Base64.getEncoder().encodeToString(conteudo);
	}

	@Override
	public String toString() {
		return "Imagem [id=" + id + ", nome=" + nome + "]";
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
		Imagem other = (Imagem) obj;
		return Objects.equals(id, other.id);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUrl() {
		return nome;
	}

	public void setUrl(String nome) {
		this.nome = nome;
	}
	
	public byte[] getConteudo() {
		return conteudo;
	}

	public void setConteudo(byte[] conteudo) {
		this.conteudo = conteudo;
	}
}
