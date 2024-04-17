package edu.poli.job.dto;

import java.io.Serializable;

public class ProductReportDto implements Serializable{

	private static final long serialVersionUID = 1L;
	private static final String CSV_SEPARATOR = ";";
	
	private String name;
	private Double value;
	private Double total;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getValue() {
		return value;
	}
	public void setValue(Double value) {
		this.value = value;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	@Override
	public String toString() {
		return new StringBuilder(name).append(CSV_SEPARATOR).append(value).append(CSV_SEPARATOR).append(total).toString();
	}
	
	

}
