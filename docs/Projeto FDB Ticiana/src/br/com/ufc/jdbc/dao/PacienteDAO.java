package br.com.ufc.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import com.sun.xml.internal.messaging.saaj.packaging.mime.internet.ParseException;

import br.com.ufc.jdbc.jdbc.ConnectionFactory;
import br.com.ufc.jdbc.pojo.Paciente;

public class PacienteDAO {
	private Connection connection;

	public PacienteDAO(){ }
	
	public boolean addPaciente(Paciente paciente){
		String sql = "INSERT INTO Paciente(cpf, nome, endereco, cidade, "
				+ "estado, dataNasc) VALUES (?, ?, ?, ?, ?, ?)";
		
		this.connection = new ConnectionFactory().getConnection();
		
		try{
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, paciente.getCpf());
			stmt.setString(2, paciente.getNome());
			stmt.setString(3, paciente.getEndereco());
			stmt.setString(4, paciente.getCidade());
			stmt.setString(5, paciente.getEstado());
			stmt.setDate(6,paciente.getDataNasc());
			
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
				
				Paciente paciente = new Paciente(cpf, nome, endereco,
												cidade, estado, dataNasc);
				
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
			JOptionPane.showMessageDialog(null,"Paciente n�o pode ser deletado "
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
	
	public boolean updatePaciente(String CPF){
		Date dataNasc = null;
		System.out.println(getPacienteById(CPF) + "\n");
		System.out.println("Digite o novo nome:\n");
		Scanner leia = new Scanner(System.in);
		String nvNome = leia.nextLine();
		System.out.println("Digite o novo endere�o:\n");
		String nvEnd = leia.nextLine();
		System.out.println("Digite a nova cidade:\n");
		String nvCidade = leia.nextLine();
		System.out.println("Digite o novo estado:\n");
		String nvEstado = leia.nextLine();
		System.out.println("Digite a nova data de nascimento:" + "no formato dd/mm/yyyy");
		String nvDataNasc = leia.nextLine();
		
		DateFormat format = new SimpleDateFormat ("dd/MM/yyyy");
		
			try {
				dataNasc = (Date)format.parse(nvDataNasc);
			} catch (java.text.ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		String sql = "UPDATE paciente SET nome = ?, endereco = ?, cidade = ?, estado = ?, datanasc = ? WHERE CPF = ?";
		this.connection = new ConnectionFactory().getConnection();
		
		try{
			PreparedStatement stmt = connection.prepareStatement(sql);
			//atualizar valores no banco
			stmt.setString(1, nvNome);
			stmt.setString(2, nvEnd);
			stmt.setString(3, nvCidade);
			stmt.setString(4, nvEstado);
			stmt.setDate(5, dataNasc);
			stmt.setString(6, CPF);
			
			int qtdRowsAffected = stmt.executeUpdate();
			stmt.close();
			if(qtdRowsAffected > 0){
				JOptionPane.showMessageDialog(null,"Paciente atualizado com sucesso");
				return true;
			}
			JOptionPane.showMessageDialog(null, "Paciente n�o pode ser atualizado"
					+ " ou inexistente");
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
	
	public Paciente getPacienteById(String cpf){
		String sql = "SELECT * FROM paciente WHERE cpf = ?;";

		try {
			// prepared statement para inser��o
			PreparedStatement stmt = connection.prepareStatement(sql);

			// seta os valores
			stmt.setString(1, cpf);

			// executa
			//stmt.execute();
			
			ResultSet rs = stmt.executeQuery();
			rs.next();

			Paciente paciente = new Paciente(cpf, rs.getString("nome"), 
									rs.getString("endereco"), rs.getString("cidade"),
									rs.getString("estado"), rs.getDate("dataNasc"));
			
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