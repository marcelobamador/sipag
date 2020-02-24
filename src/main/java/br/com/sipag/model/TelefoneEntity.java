package br.com.sipag.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TELEFONE")
public class TelefoneEntity implements Serializable {

	private static final long serialVersionUID = -1852737451804713276L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "TELEFONE_CELULAR")
	private Long telCelular;

	@Column(name = "TELEFONE_RESIDENCIAL")
	private Long telResidencial;

	@Column(name = "TELEFONE_COMERCIAL")
	private Long telComercial;


	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
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

}
