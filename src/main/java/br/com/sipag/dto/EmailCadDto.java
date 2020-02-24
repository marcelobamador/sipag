package br.com.sipag.dto;

import java.io.Serializable;

public class EmailCadDto implements Serializable {

	private static final long serialVersionUID = 4979249018634164145L;

	private String email;

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

}
