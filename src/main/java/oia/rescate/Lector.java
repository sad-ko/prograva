package oia.rescate;

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

			int claros = scanner.nextInt();
			Arista[] senderos = new Arista[scanner.nextInt()];
			int[] dragones = new int[scanner.nextInt()];
			int princesa = scanner.nextInt() - 1;
			int principe = scanner.nextInt() - 1;

			for (int i = 0; i < dragones.length; i++) {
				dragones[i] = scanner.nextInt() - 1;
			}

			for (int i = 0; i < senderos.length; i++) {
				int d = scanner.nextInt() - 1;
				int h = scanner.nextInt() - 1;
				senderos[i] = new Arista(d, h, scanner.nextInt());
			}

			plan = new Plan(senderos, claros, dragones, princesa, principe);

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
