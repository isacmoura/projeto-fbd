package br.com.ufc.jdbc.pojo;

import java.sql.Date;

public class Paciente {
	private String cpf;
	private String nome;
	private Date dataNasc;
	private String endereco;
	private String cidade;
	private String estado;
	private Posto posto;
	
	public Paciente(String cpf,  String nome, Date dataNasc, String endereco,
			String cidade, String estado, Posto posto) {
		super();
		this.cpf = cpf;
		this.dataNasc = dataNasc;
		this.nome = nome;
		this.setEndereco(endereco);
		this.cidade = cidade;
		this.estado = estado;
		this.posto = posto;
	}


	public Paciente(String nome, Date dataNasc, String endereco, String cidade,
			String estado, Posto posto) {
		super();
		this.dataNasc = dataNasc;
		this.nome = nome;
		this.setEndereco(endereco);
		this.cidade = cidade;
		this.estado = estado;
		this.posto = posto;
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
	public Date getDataNasc() {
		return dataNasc;
	}
	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}
	public String getEndereco() {
		return endereco;
	}


	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	@Override
	public String toString() {
		return "Paciente [CPF=" + cpf + ", Nome=" + nome + ", Data de nascimento=" +
				dataNasc + ", Endereço= " + endereco + ", " + cidade + ", " + estado + "]";
	}


	
}
