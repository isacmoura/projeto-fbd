package br.com.ufc.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import br.com.ufc.jdbc.jdbc.ConnectionFactory;
import br.com.ufc.jdbc.pojo.Posto;

public class PostoDAO {
private Connection connection;
	
	public PostoDAO(){ }
	
	public boolean addPosto(Posto posto){
		String sql = "INSERT INTO Posto(nome, endereco, cidade, estado) VALUES (?, ?, ?, ?)";
		this.connection = new ConnectionFactory().getConnection();
		
		try{
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, posto.getNome());
			stmt.setString(2, posto.getEndereco());
			stmt.setString(3, posto.getCidade());
			stmt.setString(4, posto.getEstado());
			
			
			int qtdRowsAffected = stmt.executeUpdate();
			stmt.close();
			if(qtdRowsAffected > 0) {
				JOptionPane.showMessageDialog(null, "Posto Adicionado");
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
	
	public ArrayList<Posto> getListPosto() {
		String sql = "SELECT * FROM posto;";
		ArrayList<Posto> listaPosto = new ArrayList<Posto>();
		
		this.connection = new ConnectionFactory().getConnection();
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("idPosto");
				String nome = rs.getString("nome");
				String endereco = rs.getString("endereco");
				String cidade = rs.getString("cidade");
				String estado = rs.getString("estado");
				
				Posto posto = new Posto(id, nome, endereco, cidade, estado);
				
				listaPosto.add(posto);
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
	
	public boolean deletePosto (int idPosto) {
		String sql = "DELETE FROM posto WHERE idPosto = ?";
		
		this.connection = new ConnectionFactory().getConnection();

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			// seta os valores
			stmt.setInt(1, idPosto);

			int qtdRowsAffected = stmt.executeUpdate();
			stmt.close();
			if (qtdRowsAffected > 0){
				JOptionPane.showMessageDialog(null,"Posto deletado com sucesso");
				return true;
			}
			JOptionPane.showMessageDialog(null,"Posto não pode ser deletado ou inexistente");
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
	
	public boolean updatePosto(int id){
		System.out.println(getPostoById(id) + "\n");
		System.out.println("Digite o novo nome:\n");
		Scanner leia = new Scanner(System.in);
		String nvNome = leia.nextLine();
		System.out.println("Digite o novo endereço:\n");
		String nvEnd = leia.nextLine();
		System.out.println("Digite a nova cidade:\n");
		String nvCidade = leia.nextLine();
		System.out.println("Digite o novo estado:\n");
		String nvEstado = leia.nextLine();
		String sql = "UPDATE posto SET nome = ?, endereco = ?, cidade = ?, estado = ? WHERE idPosto = ?";
		
		this.connection = new ConnectionFactory().getConnection();
		
		try{
			PreparedStatement stmt = connection.prepareStatement(sql);
			//atualizar valores no banco
			stmt.setString(1, nvNome);
			stmt.setString(2, nvEnd);
			stmt.setString(3, nvCidade);
			stmt.setString(4, nvEstado);
			stmt.setInt(5, id);
			
			int qtdRowsAffected = stmt.executeUpdate();
			stmt.close();
			if(qtdRowsAffected > 0){
				JOptionPane.showMessageDialog(null,"Posto atualizado com sucesso");
				return true;
			}
			JOptionPane.showMessageDialog(null, "Posto não pode ser atualizado"
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
	
	public Posto getPostoById(int idPosto){
		String sql = "SELECT * FROM posto WHERE idPosto = ?;";

		try {
			// prepared statement para inserção
			PreparedStatement stmt = connection.prepareStatement(sql);

			// seta os valores
			stmt.setInt(1, idPosto);

			// executa
			//stmt.execute();
			
			ResultSet rs = stmt.executeQuery();
			rs.next();

			Posto posto = new Posto(idPosto, rs.getString("nome"), 
									rs.getString("endereco"), rs.getString("cidade"),
									rs.getString("estado"));
			
			stmt.close();
			return posto;
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
