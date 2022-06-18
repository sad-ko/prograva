package oia.metro;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

import grafos.Arista;

public class Lector {

	private Lector() {}

	public static Plan leer(String path) {
		Plan plan = null;
		File file = new File(path);
		Scanner scanner = null;

		try {
			scanner = new Scanner(file);
			scanner.useLocale(Locale.ENGLISH);

			int islas = scanner.nextInt();
			int tuneles = scanner.nextInt();
			int puentes = scanner.nextInt();

			Arista[] aristas = new Arista[tuneles + puentes];

			for (int i = 0; i < tuneles; i++) {
				int d = scanner.nextInt() - 1;
				int h = scanner.nextInt() - 1;
				aristas[puentes + i] = new Arista(d, h, 0);
			}

			for (int i = 0; i < puentes; i++) {
				int d = scanner.nextInt() - 1;
				int h = scanner.nextInt() - 1;
				aristas[i] = new Arista(d, h, 1);
			}

			plan = new Plan(aristas, islas);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}

		return plan;
	}

}
