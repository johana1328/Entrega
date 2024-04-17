package edu.poli.job.core;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.util.ArrayList;
import java.util.List;

public class FileStorage {

	private static final String DIR_PATH = "edu.poli.job.path.repository";
	private static final String PATH_SEPARATOR = FileSystems.getDefault().getSeparator();

	public static void buildRootDir() throws CustomException {
		String dirPath = JobUtil.getProperty(DIR_PATH);
		File dir = new File(dirPath);
		deleteDirectorio(dir);
		if (!dir.exists()) {
			if (dir.mkdirs()) {
				System.out.println("Directorio creado");
			} else {
				System.out.println("Error al crear directorio");
			}
		}
	}

	public static void buildFile(String fileName, List<String> data) throws CustomException {
		try {
			String fileWrite = JobUtil.getProperty(DIR_PATH).concat(PATH_SEPARATOR).concat(fileName);
			File file = new File(fileWrite);
			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
			data.forEach(line -> {
				try {
					bw.write(line + "\n");
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
			bw.close();
		} catch (IOException e) {
			throw new CustomException("Error al leer escribir el achivo " + e.getMessage());
		} catch (Exception e) {
			throw new CustomException("Error " + e.getMessage());
		}
	}

	private static void deleteDirectorio(File borrar) {
		if (borrar.isDirectory()) {
			try {
				for (File listFile : borrar.listFiles()) {
					if (listFile.isFile()) {
						listFile.delete();
						listFile.deleteOnExit();
					} else {
						if (listFile.isDirectory()) {
							deleteDirectorio(listFile);
							listFile.delete();
							listFile.deleteOnExit();
						}
					}
				}
			} catch (NullPointerException e) {
				System.out.println(e);
			}
		}
		borrar.delete();
		borrar.deleteOnExit();
	}

	public static List<String> getFilesByPrefix(String prefix) throws CustomException {
		List<String> listResponse = new ArrayList<>();
		try {
			String dirPath = JobUtil.getProperty(DIR_PATH);
			File carpeta = new File(dirPath);
			String[] listado = carpeta.list();
			for (String in : listado) {
				if (in.startsWith(prefix)) {
					listResponse.add(in);
				}
			}
		} catch (Exception e) {
			throw new CustomException("Error al listar ficheros");
		}
		return listResponse;
	}

	public static List<String> linesByFile(String fileName) throws CustomException {
		List<String> lineStrings = new ArrayList<>();
		try {
			String dirPath = JobUtil.getProperty(DIR_PATH);
			String file = dirPath.concat(PATH_SEPARATOR).concat(fileName);
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String linea;
			while ((linea = br.readLine()) != null) {
				lineStrings.add(linea);
			}
			br.close();
		} catch (Exception e) {
			throw new CustomException("Error al leer archivo " + e.getMessage());
		}
		return lineStrings;
	}
}
