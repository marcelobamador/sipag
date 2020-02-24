package br.com.sipag.dto;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "vo")
@XmlAccessorType(XmlAccessType.FIELD)
public class CadAdquirenteInputDto implements Serializable {

	private static final long serialVersionUID = -7321270712606819491L;
	private String nome;
	private String cnpj;
	private Long cep;
	private String logradouro;
	private String bairro;
	private String cidade;
	private String uf;
	private String complemento;
	private Long telCelular;
	private Long telResidencial;
	private Long telComercial;
	private List<EmailCadDto> email;

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
	public String getCnpj() {
		return cnpj;
	}

	/**
	 * @param cnpj the cnpj to set
	 */
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	/**
	 * @return the cep
	 */
	public Long getCep() {
		return cep;
	}

	/**
	 * @param cep the cep to set
	 */
	public void setCep(Long cep) {
		this.cep = cep;
	}

	/**
	 * @return the logradouro
	 */
	public String getLogradouro() {
		return logradouro;
	}

	/**
	 * @param logradouro the logradouro to set
	 */
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	/**
	 * @return the bairro
	 */
	public String getBairro() {
		return bairro;
	}

	/**
	 * @param bairro the bairro to set
	 */
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	/**
	 * @return the cidade
	 */
	public String getCidade() {
		return cidade;
	}

	/**
	 * @param cidade the cidade to set
	 */
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	/**
	 * @return the uf
	 */
	public String getUf() {
		return uf;
	}

	/**
	 * @param uf the uf to set
	 */
	public void setUf(String uf) {
		this.uf = uf;
	}

	/**
	 * @return the complemento
	 */
	public String getComplemento() {
		return complemento;
	}

	/**
	 * @param complemento the complemento to set
	 */
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	/**
	 * @return the telCelular
	 */
	public Long getTelCelular() {
		return telCelular;
	}

	/**
	 * @param telCelular the telCelular to set
	 */
	public void setTelCelular(Long telCelular) {
		this.telCelular = telCelular;
	}

	/**
	 * @return the telResidencial
	 */
	public Long getTelResidencial() {
		return telResidencial;
	}

	/**
	 * @param telResidencial the telResidencial to set
	 */
	public void setTelResidencial(Long telResidencial) {
		this.telResidencial = telResidencial;
	}

	/**
	 * @return the telComercial
	 */
	public Long getTelComercial() {
		return telComercial;
	}

	/**
	 * @param telComercial the telComercial to set
	 */
	public void setTelComercial(Long telComercial) {
		this.telComercial = telComercial;
	}

	/**
	 * @return the email
	 */
	public List<EmailCadDto> getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(List<EmailCadDto> email) {
		this.email = email;
	}

}
