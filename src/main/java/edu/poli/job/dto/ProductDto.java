package edu.poli.job.dto;

import java.io.Serializable;

public class ProductDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String CSV_SEPARATOR = ";";

	private String idProduct;
	private String nameProduct;
	private double priceProduct;

	public String getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(String idProduct) {
		this.idProduct = idProduct;
	}

	public String getNameProduct() {
		return nameProduct;
	}

	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}

	public double getPriceProduct() {
		return priceProduct;
	}

	public void setPriceProduct(double priceProduct) {
		this.priceProduct = priceProduct;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return new StringBuilder().append(idProduct).append(CSV_SEPARATOR).append(nameProduct).append(CSV_SEPARATOR)
				.append(priceProduct).toString();
	}

}
