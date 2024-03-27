package edu.poli.job.data;

import java.util.ArrayList;
import java.util.List;

import edu.poli.job.core.CustomException;
import edu.poli.job.core.FileStorage;

public abstract class StoreData<T> {

	protected abstract List<T> setListData() throws CustomException;

	protected abstract String setFileName();

	public List<T> buildFile() throws CustomException {
		try {
			List<String> linesFile = new ArrayList<>();
			List<T> listData = setListData();
			listData.forEach(data -> {
				linesFile.add(data.toString());
			});
			FileStorage.buildFile(setFileName(), linesFile);
			return listData;
		} catch (CustomException e) {
			throw e;
		} catch (Exception e) {
			throw new CustomException("Error buildFile() " + e.getMessage());
		}

	}

}
