package br.com.ufc.jdbc;

import javax.swing.JOptionPane;

import br.com.ufc.jdbc.dao.EquipamentosDAO;
import br.com.ufc.jdbc.dao.EquipsEnviadosDAO;
import br.com.ufc.jdbc.dao.PacienteDAO;
import br.com.ufc.jdbc.dao.PostoDAO;
import br.com.ufc.jdbc.pojo.EquipsEnviados;

public class Main{

	public  static  void  main ( String [] args ) {
		
		
		PacienteDAO pacienteDAO = new PacienteDAO();
		PostoDAO postoDAO = new PostoDAO();
		EquipamentosDAO equipDAO = new EquipamentosDAO();
		EquipsEnviadosDAO equipsEnviadosDAO = new EquipsEnviadosDAO();
		
		int option;
		boolean end = false;
		
		JOptionPane.showMessageDialog(null,"Seja bem vindo ao nosso sistema de equipamentos enviados aos postos de saúde da região!");
		
		while(!end){
			option = Integer.parseInt(JOptionPane.showInputDialog("\n| 1 | - Menu Paciente"
																+ "\n| 2 | - Menu Posto"
																+ "\n| 3 | - Menu Equipamentos"
																+ "\n| 4 | - Menu Enviar Equipamentos"
																+ "\n| 0 | - Sair"));
			
			switch(option){
			case 1:
				menuPaciente(pacienteDAO);
				break;
			case 2:
				menuPosto(postoDAO);
				break;
			case 3:
				menuEquipamentos(equipDAO);
				break;
			case 4:
				menuEnviarEquipamentos(postoDAO, equipDAO, equipsEnviadosDAO);
				break;
			default:
				end = true;
				break;
			}
		}
		
		
		
	}

	private static void menuEquipamentos(EquipamentosDAO euipDAO) {
		int option;
		boolean end = false;
		
		while(!end){
			option = Integer.parseInt(JOptionPane.showInputDialog("Menu Equipamentos"
																+ "\n| 1 | - Adicionar Equipamento"
																+ "\n| 2 | - Remover Equipamento"
																+ "\n| 3 | - Listar Equipamentos"
																+ "\n| 4 | - Buscar Equipamento"
																+ "\n| 5 | - Atualizar Equipamento"
																+ "\n| 0 | - Voltar ao Menu Geral"));
			switch(option){
			case 1:
				break;
			case 2:	
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			default:
				end = true;
				break;
			}
		}
		
	}

	private static void menuEnviarEquipamentos(PostoDAO postoDAO, 
											   EquipamentosDAO euipDAO, 
											   EquipsEnviadosDAO equipsEnviadosDAO) {
			
		int option;
		boolean end = false;
		
		while(!end){
			option = Integer.parseInt(JOptionPane.showInputDialog("Menu Enviar Equipentos"
																+ "\n| 1 | - Enviar Equipamentos"
																+ "\n| 2 | - Listar Equipamentos Enviados"
																+ "\n| 0 | - Voltar ao Menu Geral"));														
			switch(option){
			case 1:
				break;
			case 2:	
				break;
			default:
				end = true;
				break;
			}
		}
	}

	private static void menuPosto(PostoDAO postoDAO) {
		int option;
		boolean end = false;
		
		while(!end){
			option = Integer.parseInt(JOptionPane.showInputDialog("Menu Posto"
																+ "\n| 1 | - Adicionar Posto"
																+ "\n| 2 | - Remover Posto"
																+ "\n| 3 | - Listar Postos"
																+ "\n| 4 | - Buscar Posto"
																+ "\n| 5 | - Atualizar Posto"
																+ "\n| 0 | - Voltar ao Menu Geral"));
			
			switch(option){
			case 1:
				
				break;
			case 2:
				
				break;
			case 3:
				
				break;
			case 4:
				
				break;
			case 5:
				break;
			default:
				end = true;
				break;
			}
		}
		
	}

	private static void menuPaciente(PacienteDAO pacienteDAO) {
		int option;
		boolean end = false;
		
		while(!end){
			option = Integer.parseInt(JOptionPane.showInputDialog("Menu Paciente"
																+ "\n| 1 | - Adicionar Paciente"
																+ "\n| 2 | - Remover Paciente"
																+ "\n| 3 | - Listar Pacientes"
																+ "\n| 4 | - Buscar Paciente"
																+ "\n| 5 | - Atualizar Paciente"
																+ "\n| 0 | - Voltar ao Menu Geral"));
			
			switch(option){
			case 1:
				
				break;
			case 2:
				
				break;
			case 3:
				
				break;
			case 4:
				
				break;
			case 5:
				break;
			default:
				end = true;
				break;
			}
		}
		
	}

}