package desafiomv.desafiomv.dto;

import java.io.Serializable;

import desafiomv.desafiomv.entities.Colaborador;

public class ColaboradorDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String cpf;
	private String nome;
	private String opcao;
	
	public ColaboradorDTO() {
		
	}


	public ColaboradorDTO(String cpf, String nome, String opcao) {
		this.cpf = cpf;
		this.nome = nome;
		this.opcao = opcao;
	}
	
	public ColaboradorDTO(Colaborador entity) {
		cpf = entity.getCpf();
		nome = entity.getNome();
		opcao = entity.getOpcao();
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


	public String getOpcao() {
		return opcao;
	}


	public void setOpcao(String opcao) {
		this.opcao = opcao;
	}
	

}
