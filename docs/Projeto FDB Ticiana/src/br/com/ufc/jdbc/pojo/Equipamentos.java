package br.com.ufc.jdbc.pojo;

public class Equipamentos {
	private int id;
	private String nome;
	private int quantidade;
	
	public Equipamentos(String nome, int quantidade) {
		super();
		this.nome = nome;
		this.quantidade = quantidade;
	}
	
	public Equipamentos(int id, String nome, int quantidade) {
		super();
		this.id = id;
		this.nome = nome;
		this.quantidade = quantidade;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	@Override
	public String toString() {
		return "Equipamento [id= " + id + ", Nome=" + nome + ", Quantidade=" + quantidade + "]\n";
	}
	
}