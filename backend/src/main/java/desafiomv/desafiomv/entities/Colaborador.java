package desafiomv.desafiomv.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_colaborador")
public class Colaborador implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private String cpf;
	
	private String nome;
	
	private String opcao;
	

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

	public Colaborador() {
	}

	public Colaborador(String cpf, String nome, String opcao) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.opcao = opcao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((opcao == null) ? 0 : opcao.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Colaborador other = (Colaborador) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (opcao == null) {
			if (other.opcao != null)
				return false;
		} else if (!opcao.equals(other.opcao))
			return false;
		return true;
	}
	
	
	
	

}
