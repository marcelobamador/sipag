package br.com.sipag.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "EMAIL")
public class EmailEntity implements Serializable {

	private static final long serialVersionUID = 7220691518097817235L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String email;

	@ManyToOne
	@JoinColumn(name = "ADQUIRENTE_ID")
	private AdquirenteEntity adquirente;

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
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the adquirente
	 */
	public AdquirenteEntity getAdquirente() {
		return adquirente;
	}

	/**
	 * @param adquirente the adquirente to set
	 */
	public void setAdquirente(AdquirenteEntity adquirente) {
		this.adquirente = adquirente;
	}

	@Override
	public String toString() {
		return "id=" + id + ", email=" + email + ", adquirente=" + adquirente + "";
	}
	

}
