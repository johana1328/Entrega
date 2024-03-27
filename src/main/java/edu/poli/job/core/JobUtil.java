package edu.poli.job.core;

import java.io.InputStream;
import java.util.Properties;
import java.util.Random;

public class JobUtil {
	private static final String FILE_CONFIG = "config.properties";

	public static String getProperty(String property) throws CustomException {
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		Properties props = new Properties();
		try (InputStream resourceStream = loader.getResourceAsStream(FILE_CONFIG)) {
			props.load(resourceStream);
		} catch (Exception e) {
			throw new CustomException("Error al leer el archivos de propiedades");
		}
		if (props.containsKey(property)) {
			return props.getProperty(property);
		}
		throw new CustomException("propiedad no encontrada");
	}

	public static Integer getRandomInt(int min, int max) {
		return getRandomDouble(min, max).intValue();
	}

	public static Double getRandomDouble(int min, int max) {
		Double rand = Math.floor(Math.random() * (max - min + min)) + min;
		return rand;
	}

	public static int[] getRandomList(int size, int maxrange) {
		int[] numeros = new int[size];
		Random rand = new Random();

		for (int i = 0; i < numeros.length; i++) {
			int nuevoNumero;
			boolean repetido;
			do {
				nuevoNumero = rand.nextInt(maxrange) + 1;
				repetido = false;
				for (int j = 0; j < i; j++) {
					if (numeros[j] == nuevoNumero) {
						repetido = true;
						break;
					}
				}
			} while (repetido);
			numeros[i] = nuevoNumero;
		}
		return numeros;
	}

}
