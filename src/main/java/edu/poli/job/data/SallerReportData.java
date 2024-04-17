package edu.poli.job.data;

import java.util.List;

import edu.poli.job.core.CustomException;
import edu.poli.job.dto.SallerReportDto;

public class SallerReportData extends StoreData<SallerReportDto> {
	
	private List<SallerReportDto> salerrreport;
	
	public SallerReportData(List<SallerReportDto> salerrreport) {
		this.salerrreport = salerrreport;
	}

	@Override
	protected List<SallerReportDto> setListData() throws CustomException {
		return this.salerrreport;
	}

	@Override
	protected String setFileName() {
		return "reportSale.csv";
	}

}
