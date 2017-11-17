package br.com.ufc.jdbc.pojo;

import java.sql.Date;

public class Paciente {
	private String cpf;
	private String nome;
	private Date dataNasc;
	private String endereco;
	private String cidade;
	private String estado;
	
	
	public Paciente(String nome, Date dataNasc, String endereco, String cidade,
			String estado) {
		super();
		this.nome = nome;
		this.dataNasc = dataNasc;
		this.endereco = endereco;
		this.cidade = cidade;
		this.estado = estado;
	}
	public Paciente(String cpf, String nome, Date dataNasc, String endereco,
			String cidade, String estado) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.dataNasc = dataNasc;
		this.endereco = endereco;
		this.cidade = cidade;
		this.estado = estado;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
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
