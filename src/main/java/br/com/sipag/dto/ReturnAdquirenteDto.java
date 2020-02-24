package br.com.sipag.dto;

import java.util.List;

import br.com.sipag.model.EnderecoEntity;
import br.com.sipag.model.TelefoneEntity;

public class ReturnAdquirenteDto extends ReturnDto {

	private static final long serialVersionUID = 5953888879925340266L;
	private Long cnpj;
	private String nome;
	private TelefoneEntity telefone;
	private EnderecoEntity endereco;
	private List<ReturnEmailDto> email;

	/**
	 * @return the cnpj
	 */
	public Long getCnpj() {
		return cnpj;
	}

	/**
	 * @param cnpj the cnpj to set
	 */
	public void setCnpj(Long cnpj) {
		this.cnpj = cnpj;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the telefone
	 */
	public TelefoneEntity getTelefone() {
		return telefone;
	}

	/**
	 * @param telefone the telefone to set
	 */
	public void setTelefone(TelefoneEntity telefone) {
		this.telefone = telefone;
	}

	/**
	 * @return the endereco
	 */
	public EnderecoEntity getEndereco() {
		return endereco;
	}

	/**
	 * @param endereco the endereco to set
	 */
	public void setEndereco(EnderecoEntity endereco) {
		this.endereco = endereco;
	}

	/**
	 * @return the email
	 */
	public List<ReturnEmailDto> getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(List<ReturnEmailDto> email) {
		this.email = email;
	}

}
