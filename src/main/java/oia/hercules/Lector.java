package oia.hercules;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Lector {

	private Lector() {}

	public static Estrategia leer(String path) {
		Estrategia estrategia = null;

		File file = new File(path);
		Scanner scanner = null;

		try {
			scanner = new Scanner(file);
			scanner.useLocale(Locale.ENGLISH);

			int n = scanner.nextInt();
			int h = scanner.nextInt();

			List<Espada> espadas = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				int c = scanner.nextInt();
				int d = scanner.nextInt();
				int r = scanner.nextInt();

				Espada espada = new Espada(i, c, d, r);
				espadas.add(espada);
			}

			estrategia = new Estrategia(h, espadas);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}

		return estrategia;
	}

}
