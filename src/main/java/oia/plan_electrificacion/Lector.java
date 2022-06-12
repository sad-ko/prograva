package oia.plan_electrificacion;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

public class Lector {

	private Lector() {}

	public static Plan leer(String path) {
		Plan plan = null;
		File file = new File(path);
		Scanner scanner = null;

		try {
			scanner = new Scanner(file);
			scanner.useLocale(Locale.ENGLISH);

			int grafoSize = scanner.nextInt();
			int centralesSize = scanner.nextInt();

			double[][] grafo = new double[grafoSize][grafoSize];
			int[] centrales = new int[centralesSize];

			for (int i = 0; i < centralesSize; i++) {
				centrales[i] = scanner.nextInt() - 1;
			}

			for (int i = 0; i < grafoSize; i++) {
				for (int j = 0; j < grafoSize; j++) {
					grafo[i][j] = scanner.nextInt();
				}
			}

			plan = new Plan(grafo, centrales);

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
