package edu.poli.job.data;

import java.util.ArrayList;
import java.util.List;

import edu.poli.job.core.CustomException;
import edu.poli.job.core.JobUtil;
import edu.poli.job.dto.ProductDto;
import edu.poli.job.dto.SaleDto;
import edu.poli.job.dto.SellerDto;

public class SalesData extends StoreData<SaleDto> {

	private String fileName;
	private SellerDto seller;
	private List<ProductDto> productsSold;

	public SalesData(SellerDto seller, List<ProductDto> productsSold, String fileName) {
		this.fileName = fileName;
		this.seller = seller;
		this.productsSold = productsSold;
	}

	@Override
	protected List<SaleDto> setListData() throws CustomException {
		List<SaleDto> listSales = new ArrayList<>();
		for (ProductDto product : productsSold) {
			SaleDto sale = new SaleDto();
			sale.setSeller(seller);
			sale.setProduct(product);
			sale.setTotal(JobUtil.getRandomInt(1, 10));
			listSales.add(sale);
		}
		return listSales;
	}

	@Override
	protected String setFileName() {
		return this.fileName;
	}

}
