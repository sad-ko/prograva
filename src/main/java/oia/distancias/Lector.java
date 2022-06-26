package oia.distancias;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import grafos.Arista;

public class Lector {

	private Lector() {
	}

	public static Plan leer(String path) {
		Plan plan = null;
		File file = new File(path);
		Scanner scanner = null;

		try {
			scanner = new Scanner(file);
			scanner.useLocale(Locale.ENGLISH);

			int cantAristas = scanner.nextInt();
			String[] objetivos = scanner.nextLine().split(",");

			Arista[] aristas = new Arista[cantAristas];
			List<String> nombres = new ArrayList<>();

			for (int i = 0; i < cantAristas; i++) {
				String[] arista = scanner.nextLine().split(",");

				if (!nombres.contains(arista[0].trim())) {
					nombres.add(arista[0].trim());
				}

				if (!nombres.contains(arista[1].trim())) {
					nombres.add(arista[1].trim());
				}

				aristas[i] = new Arista(nombres.indexOf(arista[0].trim()), nombres.indexOf(arista[1].trim()),
						Double.parseDouble(arista[2]));
			}
			
			int origen = nombres.indexOf(objetivos[0].trim());
			int destino = nombres.indexOf(objetivos[1].trim());
			
			if (origen == -1 || destino == -1) {
				StringBuilder msg = new StringBuilder();
				msg.append("[ERROR] - Localidad de ");
				msg.append((origen == -1)? "origen: " + objetivos[0].trim() : "destino: " + objetivos[1].trim());
				msg.append(" no existente.");
				
				System.err.println(msg);
				System.exit(1);
			}


			plan = new Plan(aristas, nombres, origen, destino);

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
