package oia.vecinos;

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

			int vecinos = scanner.nextInt();
			Arista[] lazos = new Arista[scanner.nextInt()];
			int rival_x = scanner.nextInt() - 1;
			int rival_y = scanner.nextInt() - 1;

			for (int i = 0; i < lazos.length; i++) {
				int d = scanner.nextInt() - 1;
				int h = scanner.nextInt() - 1;
				lazos[i] = new Arista(d, h, scanner.nextInt());
			}

			plan = new Plan(lazos, vecinos, rival_x, rival_y);

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
