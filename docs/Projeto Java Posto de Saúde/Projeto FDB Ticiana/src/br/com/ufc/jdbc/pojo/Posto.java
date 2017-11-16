package br.com.ufc.jdbc.pojo;

public class Posto {
	private int idPosto;
	private String nome;
	private String cidade;
	private String estado;
	private String logradouro;
	private int numeroRua;
	
	public Posto(String nome, String cidade, String estado, String logradouro,
			int numeroRua) {
		super();
		this.nome = nome;
		this.cidade = cidade;
		this.estado = estado;
		this.logradouro = logradouro;
		this.numeroRua = numeroRua;
	}
	public Posto(int idPosto, String nome, String cidade, String estado,
			String logradouro, int numeroRua) {
		super();
		this.idPosto = idPosto;
		this.nome = nome;
		this.cidade = cidade;
		this.estado = estado;
		this.logradouro = logradouro;
		this.numeroRua = numeroRua;
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
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public int getNumeroRua() {
		return numeroRua;
	}
	public void setNumeroRua(int numeroRua) {
		this.numeroRua = numeroRua;
	}
	
	@Override
	public String toString() {
		return "Posto [id=" + idPosto + ", Nome=" + nome + ", Endereço= " + logradouro
				+ ", " + numeroRua + ", " + cidade + ", " + estado + "]";
	}
	
}
