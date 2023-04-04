package br.com.projetoescola.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.projetoescola.domain.Curso;

public class CRUDCurso extends Conexao implements CRUD<Curso> {

	@Override
	public String gravar(Curso obj) {
		String msg = "";
		try {
			abrirConexao();
			String sql = "insert into curso(tituloCurso,descricao,dataInicio,dataTermino,horarioInicio,horarioTermino)values(?,?,?,?,?,?)";
			pst = conn.prepareStatement(sql);
			//Passar os parâmetros para os pontos de interrogação
			pst.setString(1, obj.getTituloCurso());
			pst.setString(2, obj.getDescricao());
			pst.setDate(3, obj.getDataInicio());
			pst.setDate(4, obj.getDataTermino());
			pst.setTime(5, obj.getHorarioInicio());
			pst.setTime(6, obj.getHorarioTermino());
			//Quando executamos a consulta usando o comando executeUpdate. Ele retorn um número que pode 
			//ser 1 ou 0. Sendo 1 quando o dado é inserido e 0 quando o dado não é inserido.
			int i = pst.executeUpdate();
			if(i > 0) {
				msg = "Curso cadastrado com sucesso.";
			}
			else {
				msg = "Não foi possível realizar o cadastro do curso.";
			}
		}
		catch(SQLException se){
			msg = "Erro de SQL -> " + se.getMessage();
		}
		catch(Exception e) {
			msg = "Erro inesperado -> " + e.getMessage();
		}
		finally {
			fecharConexao();
		}
		return msg;
	}

	@Override
	public List<Curso> listar() {
		/*
		 * Vamos criar uma lista de cursos onde sua implementação é um array
		 * de cursos no formato de uma lista de cursos. Assim teremos linhas e 
		 * colunas para os cursos
		 * 
		 * */
		List<Curso> lstCurso = new ArrayList<Curso>();
		
		try {
			abrirConexao();
			String sql = "Select * from curso";
			// Prepara a consulta para ser executada
			pst = conn.prepareStatement(sql);
			/*
			 * O comando executeQuery é utilizado para executar comandos
			 * de SELECT. O retorno do executeQuery é um ResultSet,
			 * portanto é necessário que haja uma váriavel do tipo ResultSet
			 * para guardar o retorno da execução. Estamos usando a variavel rs
			 * que foi declarada na classe Conexao
			 * */
			rs = pst.executeQuery();
			
			/*
			 * Enquanto houver dados na tabela de banco de dados o laço 
			 * continua a buscar os dados. O comando next() do rs captura 
			 * dados da tabela e adiciona em novo curso.
			 * */
			while(rs.next()) {
				Curso curso = new Curso();
				curso.setIdCurso(rs.getLong(1));
				curso.setTituloCurso(rs.getString(2));
				curso.setDescricao(rs.getString(3));
				curso.setDataInicio(rs.getDate(4));
				curso.setDataTermino(rs.getDate(5));
				curso.setHorarioInicio(rs.getTime(6));
				curso.setHorarioTermino(rs.getTime(7));
				
				//Adiciona um novo curso na lista de curso.
				lstCurso.add(curso);
			}
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			fecharConexao();
		}
		return lstCurso;
	}

	@Override
	public List<Curso> listar(Curso obj) {
		/*
		 * Vamos criar uma lista de cursos onde sua implementação é um array
		 * de cursos no formato de uma lista de cursos. Assim teremos linhas e 
		 * colunas para os cursos
		 * 
		 * */
		List<Curso> lstCurso = new ArrayList<Curso>();
		
		try {
			abrirConexao();
			String sql = "";
			
			if(obj.getIdCurso() != 0) {
				sql = "Select * from curso WHERE idCurso=" + obj.getIdCurso();
			}
			else if(obj.getTituloCurso() != null) {
				sql = "Select * from curso WHERE tituloCurso like " + obj.getTituloCurso() + "%";
			}
			else if(obj.getDescricao() != null) {
				sql = "Select * from curso WHERE descricao like %" + obj.getDescricao() + "%";
			}
			else {
				sql = "Select * from curso";
			}
			
			// Prepara a consulta para ser executada
			pst = conn.prepareStatement(sql);
			/*
			 * O comando executeQuery é utilizado para executar comandos
			 * de SELECT. O retorno do executeQuery é um ResultSet,
			 * portanto é necessário que haja uma váriavel do tipo ResultSet
			 * para guardar o retorno da execução. Estamos usando a variavel rs
			 * que foi declarada na classe Conexao
			 * */
			rs = pst.executeQuery();
			
			/*
			 * Enquanto houver dados na tabela de banco de dados o laço 
			 * continua a buscar os dados. O comando next() do rs captura 
			 * dados da tabela e adiciona em novo curso.
			 * */
			while(rs.next()) {
				Curso curso = new Curso();
				curso.setIdCurso(rs.getLong(1));
				curso.setTituloCurso(rs.getString(2));
				curso.setDescricao(rs.getString(3));
				curso.setDataInicio(rs.getDate(4));
				curso.setDataTermino(rs.getDate(5));
				curso.setHorarioInicio(rs.getTime(6));
				curso.setHorarioTermino(rs.getTime(7));
				
				//Adiciona um novo curso na lista de curso.
				lstCurso.add(curso);
			}
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			fecharConexao();
		}
		return lstCurso;
	}

	@Override
	public Curso atualizar(Curso obj) {
		Curso curso = new Curso();
		try {
			abrirConexao();
			String sql = "UPDATE curso SET tituloCurso=?,descricao=?,dataInicio=?,dataTermino=?,horarioInicio=?,horarioTermino=? "
					+ "WHERE idCurso=?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, obj.getTituloCurso());
			pst.setString(2, obj.getDescricao());
			pst.setDate(3, obj.getDataInicio());
			pst.setDate(4, obj.getDataTermino());
			pst.setTime(5, obj.getHorarioInicio());
			pst.setTime(6, obj.getHorarioTermino());
			pst.setLong(7, obj.getIdCurso());
			
			int i = pst.executeUpdate();
			if(i > 0) {
				curso = obj;
			}
			else {
				//Exibir mensagem de erro mesmo sem retorno de string
				throw new Exception("Não foi possível atuaizar os dados");
			}
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			fecharConexao();
		}
		return curso;
	}

	@Override
	public String apagar(Curso obj) {
		String msg = "";
		try {
			abrirConexao();
			String sql = "DELETE FROM curso WHERE idCurso=?";
			pst = conn.prepareStatement(sql);
			pst.setLong(1, obj.getIdCurso());
			
			int i = pst.executeUpdate();
			if(i > 0) {
				msg = "Curso apagado.";
			}
			else {
				msg = "Não foi possível apagar o curso.";
			}
		}
		catch(SQLException se) {
			msg = "Erro na consulta de SQL -> " + se.getMessage();
		}
		catch(Exception e) {
			msg = "Ocorreu um erro inesperado durante a consulta -> " + e.getMessage();
		}
		finally {
			fecharConexao();
		}
		return msg;
	}


}
