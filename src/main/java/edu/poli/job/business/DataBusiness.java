package edu.poli.job.business;

import java.util.ArrayList;
import java.util.List;

import edu.poli.job.core.CustomException;
import edu.poli.job.core.JobUtil;
import edu.poli.job.data.ProductData;
import edu.poli.job.data.SalesData;
import edu.poli.job.data.SellerData;
import edu.poli.job.data.StoreData;
import edu.poli.job.dto.ProductDto;
import edu.poli.job.dto.SaleDto;
import edu.poli.job.dto.SellerDto;

public class DataBusiness {
	private StoreData<SellerDto> seller;
	private StoreData<ProductDto> product;
	private StoreData<SaleDto> sale;
 
	public DataBusiness() {
		this.seller = new SellerData();
		this.product = new ProductData();
	}

	public void buildData() throws CustomException {
		System.out.println("Inicio generacion de informacion del sistema");
		List<SellerDto> sellers = this.seller.buildFile();
		System.out.println("Generado archivo de vendedores ... OK");
		List<ProductDto> products = this.product.buildFile();
		System.out.println("Generado archivo de productos ... OK");
		for (SellerDto seller : sellers) {
			List<ProductDto> productsSold = getProductsSold(products);
			String fileName = new StringBuilder("V").append(seller.getIdNumber()).append(".txt").toString();
			sale = new SalesData(seller, productsSold, fileName);
			sale.buildFile();
		}
		System.out.println("Generados archivos de ventas ... OK");
		System.out.println("Ha finalizado la generación de archivos ... OK");
	}

	private List<ProductDto> getProductsSold(List<ProductDto> products) {
		List<ProductDto> productsResponse = new ArrayList<>();
		int maxSales = 5;
		if (maxSales > products.size()) {
			maxSales = products.size();
		}
		int[] poductList = JobUtil.getRandomList(maxSales, products.size() - 1);
		for (int i = 0; i < poductList.length; i++) {
			productsResponse.add(products.get(poductList[i]));
		}
		return productsResponse;
	}

}
