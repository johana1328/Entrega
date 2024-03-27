package edu.poli.job;

import edu.poli.job.business.DataBusiness;
import edu.poli.job.core.CustomException;
import edu.poli.job.core.FileStorage;

public class GenerateInfoFiles {

	public static void main(String[] args) {
		try {
			FileStorage.buildRootDir();
			DataBusiness dataBusiness = new DataBusiness();
			dataBusiness.buildData();
		} catch (CustomException e) {
			System.out.println("Error: "+e.getMessage());
		}

	}

}
