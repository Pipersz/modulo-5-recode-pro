package br.com.mercuryviagens.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class Destino implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String descricao;
	
	@OneToMany(orphanRemoval = true, cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_destino_id")
	private List<Imagem> imagens = new ArrayList<>();
	
	public Destino() {}
	
	public Destino(Integer id, String nome, String descricao, List<Imagem> imagens) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.imagens = imagens;
	}

	@Override
	public String toString() {
		String result = "Destino [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", imagens={";
		
		for (Imagem imagem : imagens) {
			result += imagem + ", ";
		}
		
		result += "}]";
		
		return result;
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
		Destino other = (Destino) obj;
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Imagem> getImagens() {
		return imagens;
	}
	
	public Integer getNumImagens() {
		return imagens.size();
	}
	
	public Boolean temImagem() {
		return imagens.size() > 0;
	}
	
	public Imagem getPrimeiraImagem() {
		return imagens.get(0);
	}

	public void setImagens(List<Imagem> imagens) {
		this.imagens = imagens;
	}
	
	public void addImagens(List<Imagem> imagens) {
		this.imagens.addAll(imagens);
	}
	
	public void clearImagens() {
		if (this.imagens == null) return;
		this.imagens.clear();
	}
}
