package oia.metro;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Escritor {

	private Escritor() {}

	public static void escribir(String path, Plan resultado) {
		FileWriter file = null;
		PrintWriter printerWriter = null;

		try {
			file = new FileWriter(path);
			printerWriter = new PrintWriter(file);

			printerWriter.print(resultado);
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

			if (printerWriter != null) {
				printerWriter.close();
			}
		}
	}
}
