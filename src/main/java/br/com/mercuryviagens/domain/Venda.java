package br.com.mercuryviagens.domain;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Venda implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "fk_Cliente_cpf")
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name = "fk_pacoteviagem_id")
	private PacoteViagem pacoteViagem;
	
	private Integer numPrestacoes;
	
	public Venda() {}
	
	@Override
	public String toString() {
		return "Venda [id=" + id + ", CPF_cliente=" + cliente.getCpf() + ", ID_pacoteViagem=" + pacoteViagem.getId() + ", numPrestacoes="
				+ numPrestacoes + "]";
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public PacoteViagem getPacoteViagem() {
		return pacoteViagem;
	}
	public void setPacoteViagem(PacoteViagem pacoteViagem) {
		this.pacoteViagem = pacoteViagem;
	}
	public Integer getNumPrestacoes() {
		return numPrestacoes;
	}
	public void setNumPrestacoes(Integer numPrestacoes) {
		this.numPrestacoes = numPrestacoes;
	}
	
	
}
