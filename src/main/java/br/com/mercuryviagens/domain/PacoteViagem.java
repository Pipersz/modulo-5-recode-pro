package br.com.mercuryviagens.domain;

import java.io.Serializable;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "pacoteviagem")
public class PacoteViagem implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nome;
	
	@ManyToOne
	@JoinColumn(name = "fk_destino_id")
	private Destino destino;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataIda;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataVolta;
	private Float preco;
	private Integer numMaxPrestacoes;
	
	public PacoteViagem() {}
	
	public PacoteViagem(Integer id, String nome, Destino destino, LocalDate dataIda, LocalDate dataVolta, Float preco,
			Integer numMaxPrestacoes) {
		super();
		this.id = id;
		this.nome = nome;
		this.destino = destino;
		this.dataIda = dataIda;
		this.dataVolta = dataVolta;
		this.preco = preco;
		this.numMaxPrestacoes = numMaxPrestacoes;
	}

	@Override
	public String toString() {
		return "PacoteViagem [id=" + id + ", nome=" + nome + ", destino=" + destino + ", dataIda=" + dataIda + ", dataVolta=" + dataVolta
				+ ", preco=" + preco + ", numMaxPrestacoes=" + numMaxPrestacoes + "]";
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
		PacoteViagem other = (PacoteViagem) obj;
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

	public Destino getDestino() {
		return destino;
	}

	public void setDestino(Destino destino) {
		this.destino = destino;
	}

	public LocalDate getDataIda() {
		return dataIda;
	}
	
	public String getDataIdaFormatted() {
		DateTimeFormatter formatters = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	    String text = dataIda.format(formatters);
	    return text;
	}

	public void setDataIda(LocalDate dataIda) {
		this.dataIda = dataIda;
	}

	public LocalDate getDataVolta() {
		return dataVolta;
	}
	
	public String getDataVoltaFormatted() {
		DateTimeFormatter formatters = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	    String text = dataVolta.format(formatters);
	    return text;
	}

	public void setDataVolta(LocalDate dataVolta) {
		this.dataVolta = dataVolta;
	}

	public Float getPreco() {
		return preco;
	}

	public void setPreco(Float preco) {
		this.preco = preco;
	}

	public Integer getNumMaxPrestacoes() {
		return numMaxPrestacoes;
	}

	public void setNumMaxPrestacoes(Integer numMaxPrestacoes) {
		this.numMaxPrestacoes = numMaxPrestacoes;
	}
	
	public Long getDuration() {
		long d = ChronoUnit.DAYS.between(dataIda, dataVolta);
		return d;
	}
}
