package edu.poli.job;

import edu.poli.job.business.SalesReport;
import edu.poli.job.core.CustomException;

public class GenerateInfoReport {

	public static void main(String[] args) {
	 try {
		SalesReport report = new SalesReport();
		report.buildreportSales();
	} catch (CustomException e) {
		e.printStackTrace();
	}

	}

}
