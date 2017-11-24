package br.com.ufc.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

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
				JOptionPane.showMessageDialog(null, "Equipamento adicionado!");
				return true;
			}
			JOptionPane.showMessageDialog(null, "Erro ao adicionar!");
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
	
	public ArrayList<Equipamentos> getListEquipamentos() {
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
			JOptionPane.showMessageDialog(null, e.getMessage());
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
		String sql = "DELETE FROM equipamentos WHERE id = ?";
		
		this.connection = new ConnectionFactory().getConnection();

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			// seta os valores
			stmt.setInt(1, id);

			int qtdRowsAffected = stmt.executeUpdate();
			stmt.close();
			if (qtdRowsAffected > 0){
				JOptionPane.showMessageDialog(null,"Equipamento deletado com sucesso");
				return true;
			}
			JOptionPane.showMessageDialog(null, "Equipamento não pode ser deletado"
												+ " ou inexistente");
			return false;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}finally {
			try {
				this.connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	public boolean updateEquipamentos(int id){
		System.out.println(getEquipById(id) + "\n");
		System.out.println("Digite o novo nome:\n");
		Scanner leia = new Scanner(System.in);
		String nvNome = leia.nextLine();
		System.out.println("Digite a nova quantidade:\n");
		int nvQtd = leia.nextInt();
		String sql = "UPDATE equipamentos SET nome = ?, quantidade = ? WHERE id = ?";
		
		this.connection = new ConnectionFactory().getConnection();
		
		try{
			PreparedStatement stmt = connection.prepareStatement(sql);
			//atualizar valores no banco
			stmt.setString(1, nvNome);
			stmt.setInt(2, nvQtd);
			stmt.setInt(3, id);
			
			int qtdRowsAffected = stmt.executeUpdate();
			stmt.close();
			if(qtdRowsAffected > 0){
				JOptionPane.showMessageDialog(null,"Equipamento atualizado com sucesso");
				return true;
			}
			JOptionPane.showMessageDialog(null, "Equipamento não pode ser atualizado"
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
