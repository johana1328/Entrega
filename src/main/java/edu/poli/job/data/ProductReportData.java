package edu.poli.job.data;

import java.util.List;

import edu.poli.job.core.CustomException;
import edu.poli.job.dto.ProductReportDto;

public class ProductReportData extends StoreData<ProductReportDto>{
	
	private List<ProductReportDto> listProductReport;
	
	public ProductReportData(List<ProductReportDto> listProductReport) {
		this.listProductReport = listProductReport;
	}

	@Override
	protected List<ProductReportDto> setListData() throws CustomException {
		return listProductReport;
	}

	@Override
	protected String setFileName() {
		return "productreport.csv";
	}

}
