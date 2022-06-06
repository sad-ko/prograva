package oia.luchadores;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.Scanner;

public class Archivo {

	private Archivo() {}

	public static Luchador[] leer(String filename) {
		Luchador[] lista = null;
		Scanner scanner = null;

		try {
			File file = new File(filename);
			scanner = new Scanner(file);
			scanner.useLocale(Locale.ENGLISH);

			int l = scanner.nextInt();
			lista = new Luchador[l];

			for (int i = 0; i < l; i++) {
				int peso = scanner.nextInt();
				int altura = scanner.nextInt();
				Luchador luchador = new Luchador(peso, altura);
				lista[i] = luchador;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}

		return lista;
	}

	public static void escribir(String filename, int[] datos) {
		FileWriter file = null;
		PrintWriter printerWriter = null;

		try {
			file = new FileWriter(filename);
			printerWriter = new PrintWriter(file);

			for (int i = 0; i < datos.length; i++) {
				printerWriter.println(datos[i]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (file != null) {
				try {
					file.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
