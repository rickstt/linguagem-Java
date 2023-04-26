package com.projeto.spring.curso.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Turma {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(nullable=false)
	private Long idturma;
	
	@Column(nullable=false)
	private String descricao;
	
	@Column(nullable=false)
	private String horario;
	
	@Column(nullable=false)
	private Long idcurso;
	
	@Column(nullable=false)
	private Long idsala;

	public Turma() {
	}

	public Turma(Long idturma, String descricao, String horario, Long idcurso, Long idsala) {
		this.idturma = idturma;
		this.descricao = descricao;
		this.horario = horario;
		this.idcurso = idcurso;
		this.idsala = idsala;
	}

	public Long getIdturma() {
		return idturma;
	}

	public void setIdturma(Long idturma) {
		this.idturma = idturma;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public Long getIdcurso() {
		return idcurso;
	}

	public void setIdcurso(Long idcurso) {
		this.idcurso = idcurso;
	}

	public Long getIdsala() {
		return idsala;
	}

	public void setIdsala(Long idsala) {
		this.idsala = idsala;
	}
}
