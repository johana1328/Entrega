package edu.poli.job.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SallerReportDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private static final String CSV_SEPARATOR = ";";
	private String saler;
	private List<Double> saleValue;
	private Double totalsalesValue;

	public SallerReportDto() {
		this.saleValue = new ArrayList<>();
		totalsalesValue = 0.0;
	}

	public void addValue(double value) {
		this.saleValue.add(value);
		this.totalsalesValue += value;
	}

	public String getSaler() {
		return saler;
	}

	public void setSaler(String saler) {
		this.saler = saler;
	}

	public List<Double> getSaleValue() {
		return saleValue;
	}

	public void setSaleValue(List<Double> saleValue) {
		this.saleValue = saleValue;
	}

	public Double getTotalsalesValue() {
		return totalsalesValue;
	}

	public void setTotalsalesValue(Double totalsalesValue) {
		this.totalsalesValue = totalsalesValue;
	}

	@Override
	public String toString() {
		return new StringBuilder(this.saler).append(CSV_SEPARATOR).append(this.totalsalesValue).toString();
	}

}
