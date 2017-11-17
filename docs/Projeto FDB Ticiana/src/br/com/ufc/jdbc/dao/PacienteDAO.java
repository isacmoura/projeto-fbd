package br.com.ufc.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



import javax.swing.JOptionPane;

import br.com.ufc.jdbc.jdbc.ConnectionFactory;
import br.com.ufc.jdbc.pojo.Paciente;

public class PacienteDAO {
	private Connection connection;

	public PacienteDAO(){ }
	
	public boolean addPosto(Paciente paciente){
		String sql = "INSERT INTO Paciente(cpf, nome, dataNasc, endereco, cidade, "
				+ "estado) VALUES (?, ?, ?, ?, ?, ?)";
		this.connection = new ConnectionFactory().getConnection();
		
		try{
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, paciente.getCpf());
			stmt.setString(2, paciente.getNome());
			stmt.setDate(3,paciente.getDataNasc());
			stmt.setString(4, paciente.getEndereco());
			stmt.setString(5, paciente.getCidade());
			stmt.setString(6, paciente.getEstado());
			
			
			int qtdRowsAffected = stmt.executeUpdate();
			stmt.close();
			if(qtdRowsAffected > 0) {
				JOptionPane.showMessageDialog(null, "Paciente Adicionado");
				return true;
			}
			JOptionPane.showMessageDialog(null, "Erro ao Adicionar");
			return false;
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null, e.getMessage());
		}finally{
			try{
				this.connection.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return false;
	}
	
	public ArrayList<Paciente> getListPaciente() {
		String sql = "SELECT * FROM paciente;";
		ArrayList<Paciente> listaPosto = new ArrayList<Paciente>();
		
		this.connection = new ConnectionFactory().getConnection();
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String cpf = rs.getString("cpf");
				String nome = rs.getString("nome");
				Date dataNasc = rs.getDate("dataNasc");
				String endereco = rs.getString("endereco");
				String cidade = rs.getString("cidade");
				String estado = rs.getString("estado");
				
				Paciente paciente = new Paciente(cpf, nome, dataNasc, endereco,
												cidade, estado);
				
				listaPosto.add(paciente);
			}
			stmt.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} finally {
			try {
				this.connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return listaPosto;
	}
	
	public boolean deletePaciente (String cpf) {
		String sql = "DELETE FROM paciente WHERE cpf = ?";
		
		this.connection = new ConnectionFactory().getConnection();

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			// seta os valores
			stmt.setString(1, cpf);

			int qtdRowsAffected = stmt.executeUpdate();
			stmt.close();
			if (qtdRowsAffected > 0){
				JOptionPane.showMessageDialog(null,"Paciente deletado com sucesso");
				return true;
			}
			JOptionPane.showMessageDialog(null,"Paciente não pode ser deletado "
												+ "ou inexistente");
			return false;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,e.getMessage());
		}finally {
			try {
				this.connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	public Paciente getPacienteById(String cpf){
		String sql = "SELECT * FROM paciente WHERE cpf = ?;";

		try {
			// prepared statement para inserção
			PreparedStatement stmt = connection.prepareStatement(sql);

			// seta os valores
			stmt.setString(1, cpf);

			// executa
			//stmt.execute();
			
			ResultSet rs = stmt.executeQuery();
			rs.next();

			Paciente paciente = new Paciente(cpf, rs.getString("nome"), rs.getDate("dataNasc"), 
									rs.getString("endereco"), rs.getString("cidade"),
									rs.getString("estado"));
			
			stmt.close();
			return paciente;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,e.getMessage());
		}finally {
			try {
				this.connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		JOptionPane.showMessageDialog(null, "NADA ENCONTRADO");
		return null;
	}
}