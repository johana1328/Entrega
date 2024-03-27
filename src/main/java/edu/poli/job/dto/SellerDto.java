package edu.poli.job.dto;

import java.io.Serializable;

public class SellerDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String CSV_SEPARATOR = ";";
	private DocType idType;
	private String idNumber;
	private String name;
	private String lastname;

	public DocType getIdType() {
		return idType;
	}

	public void setIdType(DocType idType) {
		this.idType = idType;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@Override
	public String toString() {
		return new StringBuilder(idType.name()).append(CSV_SEPARATOR).append(idNumber).append(CSV_SEPARATOR)
				.append(name).append(CSV_SEPARATOR).append(lastname).toString();
	}

}
