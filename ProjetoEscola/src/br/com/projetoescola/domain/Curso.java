package br.com.projetoescola.domain;

import java.sql.Date;
import java.sql.Time;

public class Curso {
	private long idCurso;
	private String tituloCurso;
	private String descricao;
	private Date dataInicio;
	private Date dataTermino;
	private Time horarioInicio;
	private Time horarioTermino;
	
	public Curso() {}

	public Curso(long idCurso, String tituloCurso, String descricao, Date dataInicio, Date dataTermino,
			Time horarioInicio, Time horarioTermino) {
		this.idCurso = idCurso;
		this.tituloCurso = tituloCurso;
		this.descricao = descricao;
		this.dataInicio = dataInicio;
		this.dataTermino = dataTermino;
		this.horarioInicio = horarioInicio;
		this.horarioTermino = horarioTermino;
	}

	public long getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(long idCurso) {
		this.idCurso = idCurso;
	}

	public String getTituloCurso() {
		return tituloCurso;
	}

	public void setTituloCurso(String tituloCurso) {
		this.tituloCurso = tituloCurso;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataTermino() {
		return dataTermino;
	}

	public void setDataTermino(Date dataTermino) {
		this.dataTermino = dataTermino;
	}

	public Time getHorarioInicio() {
		return horarioInicio;
	}

	public void setHorarioInicio(Time horarioInicio) {
		this.horarioInicio = horarioInicio;
	}

	public Time getHorarioTermino() {
		return horarioTermino;
	}

	public void setHorarioTermino(Time horarioTermino) {
		this.horarioTermino = horarioTermino;
	}
	
}
