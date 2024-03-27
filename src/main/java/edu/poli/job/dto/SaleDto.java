package edu.poli.job.dto;

import java.io.Serializable;

public class SaleDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String CSV_SEPARATOR = ";";

	private SellerDto seller;
	private ProductDto product;
	private Integer total;

	public SellerDto getSeller() {
		return seller;
	}

	public void setSeller(SellerDto seller) {
		this.seller = seller;
	}

	public ProductDto getProduct() {
		return product;
	}

	public void setProduct(ProductDto product) {
		this.product = product;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return new StringBuilder(seller.getIdType().name()).append(CSV_SEPARATOR).append(seller.getIdNumber())
				.append(CSV_SEPARATOR).append(product.getIdProduct()).append(CSV_SEPARATOR).append(total).toString();
	}

}
