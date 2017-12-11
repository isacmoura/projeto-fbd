
package br.com.ufc.jdbc;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import br.com.ufc.jdbc.dao.EquipamentosDAO;
import br.com.ufc.jdbc.dao.EquipsEnviadosDAO;
import br.com.ufc.jdbc.dao.PacienteDAO;
import br.com.ufc.jdbc.dao.PostoDAO;
import br.com.ufc.jdbc.pojo.Equipamentos;
import br.com.ufc.jdbc.pojo.EquipsEnviados;
import br.com.ufc.jdbc.pojo.Paciente;
import br.com.ufc.jdbc.pojo.Posto;


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

	private static void menuEquipamentos(EquipamentosDAO equipDAO) {
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
				String nome; int qtd;
				nome = JOptionPane.showInputDialog("Digite o nome do equipamento:");
				qtd = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade:"));
				
				Equipamentos equip = new Equipamentos(nome, qtd);
				if(validaEquipamento(equip)) equipDAO.addEquip(equip);
				break;
			case 2:	
				int id = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do equipamento:"));
				equipDAO.deleteEquip(id);
				
				break;
			case 3:
				String equipamentos = "";
				ArrayList<Equipamentos> listaEquip = equipDAO.getListEquipamentos();
				if(listaEquip.size() == 0){
					JOptionPane.showMessageDialog(null, "Lista Vazia!");
				}else{
					for(Equipamentos equips : listaEquip){
						equipamentos += equips.toString();
					}
					JOptionPane.showMessageDialog(null, equipamentos);
				}
				break;
			case 4:
				int idBusca = Integer.parseInt(JOptionPane.showInputDialog("Digite o id a ser procurado:"));
				Equipamentos equipBusca = equipDAO.getEquipById(idBusca);
				
				if(equipBusca != null) 
					JOptionPane.showMessageDialog(null, equipBusca.toString());
				break;
			case 5:
				int idUpd = Integer.parseInt(JOptionPane.showInputDialog("Digite o id a ser atualizado:"));
				Equipamentos equipUpd = equipDAO.getEquipById(idUpd);
				if(equipUpd != null){
					String nomeNew = JOptionPane.showInputDialog("Digite o novo nome:");
					int qtdNew =Integer.parseInt(JOptionPane.showInputDialog("Digite a nova quantidade:"));
					
					equipUpd.setNome(nomeNew);
					equipUpd.setQuantidade(qtdNew);
					
					equipDAO.updateEquipamentos(idUpd, equipUpd);
				}
				break;
			default:
				end = true;
				break;
			}
		}
		
	}

	private static void menuEnviarEquipamentos(PostoDAO postoDAO, 
											   EquipamentosDAO equipDAO, 
											   EquipsEnviadosDAO equipsEnviadosDAO) {
			
		int option;
		boolean end = false;
		
		while(!end){
			option = Integer.parseInt(JOptionPane.showInputDialog("Menu Enviar Equipamentos"
																+ "\n| 1 | - Enviar Equipamentos"
																+ "\n| 2 | - Listar Equipamentos Enviados"
																+ "\n| 0 | - Voltar ao Menu Geral"));														
			switch(option){
			
				case 1:
					int idEquip, idPosto;
					idEquip = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do equipamento:"));
					idPosto = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do posto:"));
					
					Equipamentos equip = equipDAO.getEquipById(idEquip);
					Posto posto = postoDAO.getPostoById(idPosto);
					
					if((equip != null) && (posto != null)){
						equipsEnviadosDAO.enviarEquips(idEquip, idPosto);
					}else{
						JOptionPane.showMessageDialog(null, "Equipamento ou posto inexistentes!");
					}
					
					break;
				case 2:	
					String equipamentos = "";
					ArrayList<EquipsEnviados> listaEquipsEnv = equipsEnviadosDAO.getListEquipsEnviados();
					if(listaEquipsEnv.size() == 0){
						JOptionPane.showMessageDialog(null, "Lista Vazia!");
					}else{
						for(EquipsEnviados equipsenv : listaEquipsEnv){
							equipamentos += equipsenv.toString();
						}
						JOptionPane.showMessageDialog(null, equipamentos);
					}
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
				String nome, endereco, cidade, estado;
				nome = JOptionPane.showInputDialog("Digite o nome do posto:");
				endereco = JOptionPane.showInputDialog("Digite o endereço do posto:");
				cidade = JOptionPane.showInputDialog("Digite o cidade do posto:");
				estado = JOptionPane.showInputDialog("Digite o estado do posto:");
				
				Posto posto = new Posto(nome, endereco, cidade, estado);
				if(validaPosto(posto)) postoDAO.addPosto(posto);
				break;
			case 2:
				int idPosto = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do Posto:"));
				postoDAO.deletePosto(idPosto);
				break;
			case 3:
				ArrayList<Posto> listaPosto = postoDAO.getListPosto();
				String postoDados = "";
				
				if(listaPosto.size() == 0){
					JOptionPane.showMessageDialog(null, "Lista Vazia!");
				}else{
					for(Posto postoIter: listaPosto){
						postoDados += postoIter.toString();
					}
					JOptionPane.showMessageDialog(null, postoDados);
				}
				break;
			case 4:
				int idBusca = Integer.parseInt(JOptionPane.showInputDialog("Digite o id a ser procurado:"));
				Posto postoBusca = postoDAO.getPostoById(idBusca);
				
				if(postoBusca != null) 
					JOptionPane.showMessageDialog(null, postoBusca.toString());
				break;
			case 5:
				int idUpd = Integer.parseInt(JOptionPane.showInputDialog("Digite o id a ser atualizado:"));
				Posto postoUpd = postoDAO.getPostoById(idUpd);
				if(postoUpd != null){
					String nomeNew = JOptionPane.showInputDialog("Digite o novo nome:");
					String endNew = JOptionPane.showInputDialog("Digite o novo endereço:");
					String cidadeNew = JOptionPane.showInputDialog("Digite a nova cidade:");
					String estadoNew = JOptionPane.showInputDialog("Digite o novo estado:");
					
					postoUpd.setNome(nomeNew);
					postoUpd.setEndereco(estadoNew);
					postoUpd.setCidade(cidadeNew);
					postoUpd.setEstado(estadoNew);
					
					postoDAO.updatePosto(idUpd, postoUpd);
				}
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
				String cpf, nome, endereco, cidade, estado, dataNascStr;
				Date dataNasc = null;
				cpf = JOptionPane.showInputDialog("Digite o cpf do Paciente:");
				nome = JOptionPane.showInputDialog("Digite o nome do Paciente:");
				endereco = JOptionPane.showInputDialog("Digite o endereço do Paciente:");
				cidade = JOptionPane.showInputDialog("Digite o cidade do Paciente:");
				estado = JOptionPane.showInputDialog("Digite o estado do Paciente:");
				dataNascStr = JOptionPane.showInputDialog("Digite a data de nascimento do Paciente:"
														+ "no formato dd/mm/AAAA");

		        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		        
				try {
					java.util.Date parsed = format.parse(dataNascStr);
					dataNasc = new Date(parsed.getTime());
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				Paciente paciente = new Paciente(cpf, nome, endereco, cidade, estado, dataNasc);
				if(validaPaciente(paciente)){
					pacienteDAO.addPaciente(paciente);
				}else{
					JOptionPane.showMessageDialog(null, "Paciente inválido, tente novamente");
				}
				break;
			case 2:
				String cpfPaciente = JOptionPane.showInputDialog("Digite o cpf do Paciente:");
				if(validaCPF(cpfPaciente)) pacienteDAO.deletePaciente(cpfPaciente);
				break;
			case 3:
				ArrayList<Paciente> listaPaciente = pacienteDAO.getListPaciente();
				String pacienteDados = "";
				
				if(listaPaciente.size() == 0){
					JOptionPane.showMessageDialog(null, "Lista Vazia!");
				}else{
					for(Paciente pacienteIter: listaPaciente){
						pacienteDados += pacienteIter.toString();
					}
					JOptionPane.showMessageDialog(null, pacienteDados);
				}
				break;
			case 4:
				String cpfBusca = JOptionPane.showInputDialog("Digite o cpf a ser procurado:");
				if(validaCPF(cpfBusca)){
					Paciente pacienteBusca = pacienteDAO.getPacienteById(cpfBusca);
					if(pacienteBusca != null)
						JOptionPane.showMessageDialog(null, pacienteBusca.toString());
				}else{
					JOptionPane.showMessageDialog(null, "Cpf inválido");
				}
				
				break;
			case 5:
				String cpfUpd = JOptionPane.showInputDialog("Digite o cpf a ser atualizado:");
				if(validaCPF(cpfUpd) != false){
					Paciente pacienteUpd = pacienteDAO.getPacienteById(cpfUpd);
					if(pacienteUpd != null){
						Date dataNascNew = null;
						
						String nomeNew = JOptionPane.showInputDialog("Digite o novo nome:");
						String endNew = JOptionPane.showInputDialog("Digite o novo endereço:");
						String cidadeNew = JOptionPane.showInputDialog("Digite o novo cidade:");
						String estadoNew = JOptionPane.showInputDialog("Digite a nova estado:");
						dataNascStr = JOptionPane.showInputDialog("Digite a nova data de nascimento:"
																  + "no formato dd/mm/AAAA");
						SimpleDateFormat formatNew = new SimpleDateFormat("dd/MM/yyyy");
						
						try {
						java.util.Date parsed = formatNew.parse(dataNascStr);
						dataNascNew = new Date(parsed.getTime());
						} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						}

						pacienteUpd.setNome(nomeNew);
						pacienteUpd.setEndereco(endNew);
						pacienteUpd.setCidade(cidadeNew);
						pacienteUpd.setEstado(estadoNew);
						pacienteUpd.setDataNasc(dataNascNew);
						
						pacienteDAO.updatePaciente(cpfUpd, pacienteUpd);
					}	
				}
				break;
			default:
				end = true;
				break;
			}
		}
	}
	
	public static boolean validaPaciente(Paciente paciente){
		if(paciente.getCpf() == null || paciente.getCpf().isEmpty() ||
			paciente.getCpf().length() != 11 || paciente.getCpf().matches("\\d+") == false){
			JOptionPane.showMessageDialog(null, "Cpf inválido!");
			return false;
		}
		if(paciente.getNome() == null || paciente.getNome().isEmpty()){
			JOptionPane.showMessageDialog(null, "Nome inválido!");
			return false;
		}
		if(paciente.getEndereco() == null || paciente.getEndereco().isEmpty()){
			JOptionPane.showMessageDialog(null, "Endereco inválido!");
			return false;
		}
		if(paciente.getCidade() == null || paciente.getCidade().isEmpty()){
			JOptionPane.showMessageDialog(null, "Cidade inválida");
			return false;
		}
		if(paciente.getEstado() == null || paciente.getEstado().isEmpty()){
			JOptionPane.showMessageDialog(null, "Estado inválido");
			return false;
		}
		if(paciente.getDataNasc() == null){
			JOptionPane.showMessageDialog(null, "Data inválida");
			return false;
		}
		return true;
	}
	
	public static boolean validaPosto(Posto posto){
	
		if(posto.getNome() == null || posto.getNome().isEmpty()){
			JOptionPane.showMessageDialog(null, "Nome inválido!");
			return false;
		}
		if(posto.getEndereco() == null || posto.getEndereco().isEmpty()){
			JOptionPane.showMessageDialog(null, "Endereco inválido!");
			return false;
		}
		if(posto.getCidade() == null || posto.getCidade().isEmpty()){
			JOptionPane.showMessageDialog(null, "Cidade inválida");
			return false;
		}
		if(posto.getEstado() == null || posto.getEstado().isEmpty()){
			JOptionPane.showMessageDialog(null, "Estado inválido");
			return false;
		}
		return true;
	}
	
	public static boolean validaEquipamento(Equipamentos equip){
		if(equip.getNome() == null || equip.getNome().isEmpty()){
			JOptionPane.showMessageDialog(null, "Nome inválido!");
			return false;
		}
		if(equip.getQuantidade() < 0){
			JOptionPane.showMessageDialog(null, "Quantidade inválida!");
			return false;
		}
		return true;
	}
	
	public static boolean validaCPF(String cpf){
		if(cpf == null || cpf.isEmpty() || cpf.length() != 11 || cpf.matches("\\d+") == false){
				JOptionPane.showMessageDialog(null, "Cpf inválido!");
				return false;
		}
		return true;
	}
	

}