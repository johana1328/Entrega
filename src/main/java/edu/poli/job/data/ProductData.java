package edu.poli.job.data;

import java.util.ArrayList;
import java.util.List;

import edu.poli.job.core.CustomException;
import edu.poli.job.core.JobUtil;
import edu.poli.job.dto.ProductDto;

public class ProductData extends StoreData<ProductDto> {

	private String fileName = "product.txt";
	private static final String MAX_PRODUCT = "edu.poli.job.total.product";
	private static final Integer MIN_VALUE = 2000;
	private static final Integer MAX_VALUE = 20000;

	@Override
	protected List<ProductDto> setListData() throws CustomException {
		List<ProductDto> products = new ArrayList<>();
		try {
			int max = Integer.parseInt(JobUtil.getProperty(MAX_PRODUCT));
			for (int i = 0; i <= max; i++) {
				ProductDto productDto = new ProductDto();
				productDto.setIdProduct("00" + i);
				productDto.setNameProduct("producto" + i);
				productDto.setPriceProduct(JobUtil.getRandomDouble(MIN_VALUE, MAX_VALUE));
				products.add(productDto);
			}
			return products;
		} catch (CustomException e) {
			throw e;
		} catch (Exception e) {
			throw new CustomException("Error an retornar lista buildFile() " + e.getMessage());
		}
	}

	@Override
	protected String setFileName() {
		return this.fileName.toString();
	}

}
