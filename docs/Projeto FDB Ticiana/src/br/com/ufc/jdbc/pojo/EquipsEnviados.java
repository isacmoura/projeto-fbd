package br.com.ufc.jdbc.pojo;

public class EquipsEnviados {
	private Equipamentos equipamento;
	private Posto posto;
	
	public EquipsEnviados(Equipamentos equipamento, Posto posto) {
		super();
		this.equipamento = equipamento;
		this.posto = posto;
	}
	public Equipamentos getEquipamento() {
		return equipamento;
	}
	public void setEquipamento(Equipamentos equipamento) {
		this.equipamento = equipamento;
	}
	public Posto getPosto() {
		return posto;
	}
	public void setPosto(Posto posto) {
		this.posto = posto;
	}
	
	@Override
	public String toString() {
		return "Equipamento: [" + equipamento + " foi enviado para " + posto + " na quantidade " + equipamento.getQuantidade() + "]\n";
	}
	
	
}