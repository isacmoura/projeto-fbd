package br.com.ufc.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.ufc.jdbc.jdbc.ConnectionFactory;
import br.com.ufc.jdbc.pojo.Equipamentos;


public class EquipamentosDAO {
	private Connection connection;
	
	public EquipamentosDAO(){ }
	
	public boolean addEquip(Equipamentos equip){
		String sql = "INSERT INTO Equipamentos(nome, quantidade) VALUES (?, ?)";
		this.connection = new ConnectionFactory().getConnection();
		
		try{
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, equip.getNome());
			stmt.setInt(2, equip.getQuantidade());
			
			int qtdRowsAffected = stmt.executeUpdate();
			stmt.close();
			if(qtdRowsAffected > 0) {
				System.out.println("Equipamento adicionado!");
				return true;
			}
			System.out.println("Erro ao adicionar!");
			return false;
		}catch(SQLException e){
			System.err.println(e.getMessage());
		}finally{
			try{
				this.connection.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return false;
	}
	
	public ArrayList<Equipamentos> getListUser() {
		String sql = "SELECT * FROM equipamentos;";
		ArrayList<Equipamentos> listaEquipamentos = new ArrayList<Equipamentos>();
		
		this.connection = new ConnectionFactory().getConnection();
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String nome = rs.getString("nome");
				int quantidade = rs.getInt("quantidade");
				
				Equipamentos equip = new Equipamentos(id, nome, quantidade);
				
				listaEquipamentos.add(equip);
			}
			stmt.close();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		} finally {
			try {
				this.connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return listaEquipamentos;
	}
	
	public boolean deleteEquip (int id) {
		String sql = "DELETE FROM usuario WHERE id = ?";
		
		this.connection = new ConnectionFactory().getConnection();

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			// seta os valores
			stmt.setInt(1, id);

			int qtdRowsAffected = stmt.executeUpdate();
			stmt.close();
			if (qtdRowsAffected > 0){
				System.out.println("Equipamento deletado com sucesso");
				return true;
			}
			System.out.println("Equipamento não pode ser deletado");
			return false;
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}finally {
			try {
				this.connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	public Equipamentos getEquipById(int id){
		String sql = "SELECT * FROM equipamentos WHERE id = ?;";

		try {
			// prepared statement para inserção
			PreparedStatement stmt = connection.prepareStatement(sql);

			// seta os valores
			stmt.setInt(1, id);

			// executa
			//stmt.execute();
			
			ResultSet rs = stmt.executeQuery();
			rs.next();

			Equipamentos equipamento = new Equipamentos(id, rs.getString("nome"), 
														rs.getInt("quantidade"));
			
			stmt.close();
			return equipamento;
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}finally {
			try {
				this.connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println("NADA ENCONTRADO");
		return null;
	}
	
}
