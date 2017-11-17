package br.com.ufc.jdbc.pojo;

import java.sql.Date;

public class Paciente {
	private String cpf;
	private Posto posto;
	private String nome;
	private String cidade;
	private String estado;
	private String logradouro;
	private int numeroRua;
	private Date dataNasc;
	
	
	public Paciente(Posto posto, String nome, String cidade, String estado,
			String logradouro, int numeroRua, Date dataNasc) {
		super();
		this.posto = posto;
		this.nome = nome;
		this.cidade = cidade;
		this.estado = estado;
		this.logradouro = logradouro;
		this.numeroRua = numeroRua;
		this.dataNasc = dataNasc;
	}
	public Paciente(String cpf, Posto posto, String nome, String cidade,
			String estado, String logradouro, int numeroRua, Date dataNasc) {
		super();
		this.cpf = cpf;
		this.posto = posto;
		this.nome = nome;
		this.cidade = cidade;
		this.estado = estado;
		this.logradouro = logradouro;
		this.numeroRua = numeroRua;
		this.dataNasc = dataNasc;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Posto getPosto() {
		return posto;
	}
	public void setPosto(Posto posto) {
		this.posto = posto;
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
	public Date getDataNasc() {
		return dataNasc;
	}
	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}

	@Override
	public String toString() {
		return "Paciente [CPF=" + cpf + ", Nome=" + nome + ", Data de nascimento=" +
				dataNasc + ", Endereço= " + logradouro + ", " + numeroRua + 
				", " + cidade + ", " + estado + "]";
	}
	
}
