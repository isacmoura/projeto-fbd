package br.com.ufc.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import br.com.ufc.jdbc.jdbc.ConnectionFactory;
import br.com.ufc.jdbc.pojo.Equipamentos;
import br.com.ufc.jdbc.pojo.EquipsEnviados;
import br.com.ufc.jdbc.pojo.Posto;


public class EquipsEnviadosDAO {
	private Connection connection;
	
	public EquipsEnviadosDAO() {
	
	}
	
	public boolean enviarEquips(int equip, int posto){
		String sql = "INSERT INTO equipamentos_has_posto VALUES (?, ?)";
		this.connection = new ConnectionFactory().getConnection();
		
		try{
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setInt(1, equip);
			stmt.setInt(2, posto);
			int qtdRowsAffected = stmt.executeUpdate();
			stmt.close();
			if (qtdRowsAffected > 0){
				JOptionPane.showMessageDialog(null, "Adicionado!");
				return true;
			}
			JOptionPane.showMessageDialog(null, "Erro ao adicionar!");
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
	
	public ArrayList<EquipsEnviados> getListEquipsEnviados() {
		String sql = "SELECT * FROM equipamentos_has_posto;";
		EquipamentosDAO equipDAO = new EquipamentosDAO();
		PostoDAO postoDAO = new PostoDAO();
		EquipsEnviados enviarEquip;
		
		ArrayList<EquipsEnviados> listaEnvios = new ArrayList<EquipsEnviados>();
		
		this.connection = new ConnectionFactory().getConnection();
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				
				int id = Integer.parseInt(rs.getString("id"));
				Equipamentos equip = equipDAO.getEquipById(id);
				
				int idPosto = Integer.parseInt(rs.getString("idPosto"));
				Posto posto = postoDAO.getPostoById(idPosto);
				
				enviarEquip = new EquipsEnviados(equip, posto);
				listaEnvios.add(enviarEquip);
				
				
			}
			
			stmt.close();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}finally {
			try {
				this.connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return listaEnvios;
	}
	
	
}