package br.com.sipag.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.gson.annotations.JsonAdapter;

@Entity
@Table(name = "ADQUIRENTE")
public class AdquirenteEntity implements Serializable {

	private static final long serialVersionUID = 3888682567309693100L;

	@Id
	@Column(nullable = false, unique = true)
	private Long cnpj;

	@Column(nullable = false)
	@Size(min = 20, max = 100)
	private String nome;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ID_TELEFONE")
	private TelefoneEntity telefone;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ID_ENDERECO")
	private EnderecoEntity endereco;

	@OneToMany(mappedBy = "adquirente", cascade = CascadeType.ALL)
	private List<EmailEntity> email;

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
	public List<EmailEntity> getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(List<EmailEntity> email) {
		this.email = email;
	}

}
