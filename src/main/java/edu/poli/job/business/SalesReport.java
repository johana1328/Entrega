package edu.poli.job.business;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.poli.job.core.CustomException;
import edu.poli.job.core.FileStorage;
import edu.poli.job.data.ProductReportData;
import edu.poli.job.data.SallerReportData;
import edu.poli.job.dto.ProductDto;
import edu.poli.job.dto.ProductReportDto;
import edu.poli.job.dto.SallerReportDto;

public class SalesReport {

	private List<ProductDto> listProduct;
	private SallerReportData reportsales;
	private ProductReportData reportProduct;
	// TODO Auto-generated method stub
	
	public SalesReport() throws CustomException {
		getProducts();
	}

	public void buildreportSales() {
		try {
			List<String> filesSale = FileStorage.getFilesByPrefix("V");
			List<SallerReportDto> listSallerReport = new ArrayList<>();
			Map<String, Double> productos = new HashMap<>();
			for (String name : filesSale) {
				SallerReportDto report = new SallerReportDto();
				List<String> lines = FileStorage.linesByFile(name);
				for (String line : lines) {
					String[] data = line.split(";");
					ProductDto product = getProductById(data[2]);
					double salesUnit = Double.parseDouble(data[3]);
					report.setSaler(data[2]);
					report.addValue(salesUnit * product.getPriceProduct());
					if(productos.containsKey(product.getIdProduct())) {
						productos.put(product.getIdProduct(), productos.remove(product.getIdProduct())+salesUnit);
					}else {
						productos.put(product.getIdProduct(), salesUnit);
					}
				}
				listSallerReport.add(report);
			}
			
			listSallerReport.sort(new Comparator<SallerReportDto>() {

				@Override
				public int compare(SallerReportDto o1, SallerReportDto o2) {
					return o2.getTotalsalesValue().compareTo(o1.getTotalsalesValue());
				}
			});
			
			this.reportsales = new SallerReportData(listSallerReport);
			this.reportsales.buildFile();
			
			List<ProductReportDto> listProducReport = new ArrayList<>();
			productos.forEach((k,v) -> {
				ProductReportDto productReportDto = new ProductReportDto();
				ProductDto product = getProductById(k);
				productReportDto.setName(product.getNameProduct());
				productReportDto.setValue(product.getPriceProduct());
				productReportDto.setTotal(v);
				listProducReport.add(productReportDto);
			});
			
			listProducReport.sort(new Comparator<ProductReportDto>() {

				@Override
				public int compare(ProductReportDto o1, ProductReportDto o2) {
					return o2.getTotal().compareTo(o1.getTotal());
				}
			});
			reportProduct = new ProductReportData(listProducReport);
			reportProduct.buildFile();
			
		} catch (CustomException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private List<ProductDto> getProducts() throws CustomException {
		if (listProduct == null) {
			listProduct = new ArrayList<>();
		}
		try {
			List<String> lines = FileStorage.linesByFile("product.txt");
			for (String line : lines) {
				String[] data = line.split(";");
				ProductDto product = new ProductDto();
				product.setIdProduct(data[0]);
				product.setNameProduct(data[1]);
				product.setPriceProduct(Double.parseDouble(data[2]));
				listProduct.add(product);
			}
			return listProduct;
		} catch (CustomException e) {
			throw new CustomException("Error al mapear producto " + e.getMessage());
		}
	}

	private ProductDto getProductById(String id) {
		for (ProductDto produc : listProduct) {
			if (produc.getIdProduct().equals(id)) {
				return produc;
			}
		}
		return null;
	}

}
