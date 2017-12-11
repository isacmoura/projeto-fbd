package br.com.ufc.jdbc.pojo;

public class Posto {
	private int idPosto;
	private String nome;
	private String endereco;
	private String cidade;
	private String estado;
	
	
	public Posto(String nome, String endereco, String cidade, String estado) {
		super();
		this.nome = nome;
		this.cidade = cidade;
		this.estado = estado;
		this.endereco = endereco;
	}
	public Posto(int idPosto, String nome, String endereco, String cidade, String estado) {
		super();
		this.idPosto = idPosto;
		this.nome = nome;
		this.cidade = cidade;
		this.estado = estado;
		this.endereco = endereco;
	}
	public int getIdPosto() {
		return idPosto;
	}
	public void setIdPosto(int idPosto) {
		this.idPosto = idPosto;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	
	@Override
	public String toString() {
		return "Posto [id=" + idPosto + ", Nome=" + nome + ", Endereço= " + endereco +
				", " + cidade + ", " + estado + "]\n";
	}
	
}
