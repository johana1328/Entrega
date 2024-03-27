package edu.poli.job.data;

import java.util.ArrayList;
import java.util.List;

import edu.poli.job.core.CustomException;
import edu.poli.job.core.JobUtil;
import edu.poli.job.dto.DocType;
import edu.poli.job.dto.SellerDto;

public class SellerData extends StoreData<SellerDto> {
	private String fileName = "sellers.txt";
	private static final String MAX_USER = "edu.poli.job.total.seller";
	private static final long PREFIX_NUMBER = 92154000;

	@Override
	protected List<SellerDto> setListData() throws CustomException {
		List<SellerDto> sellers = new ArrayList<>();
		int max = Integer.parseInt(JobUtil.getProperty(MAX_USER));
		for (int i = 0; i <= max; i++) {
			SellerDto seller = new SellerDto();
			seller.setIdType(DocType.randomType());
			seller.setIdNumber(Long.toString(PREFIX_NUMBER + i));
			seller.setName("Vendedor" + i);
			seller.setLastname("Apellido" + i);
			sellers.add(seller);
		}
		return sellers;
	}

	@Override
	protected String setFileName() {
		return fileName;
	}

}
