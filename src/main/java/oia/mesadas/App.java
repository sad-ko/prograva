package oia.mesadas;

import java.io.File;
import java.util.Locale;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		String[] pruebas = { "Ejemplo Original", "Apilar todas en una pila", "No se pueden apilar", "4", "5" };

		for (int i = 1; i <= pruebas.length; i++) {
			Deposito dp = new Deposito();
			String arch = String.format("mesadas_%d", i);

			dp.cargarArchivo("src/main/java/oia/mesadas/in/" + arch + ".in");
			int rc = dp.armarPilas();
			boolean result = App.comprobarResultado(rc, "src/main/java/oia/mesadas/out/" + arch + ".out");

			System.out.println(pruebas[i - 1]);
			System.out.println(result + ", resultado = " + rc);
			System.out.println(dp);
		}

		System.out.println("\n[Programa finalizado]");
	}

	public static boolean comprobarResultado(final int resultado, final String esperado) {
		Scanner scanner = null;
		boolean res = false;

		try {
			File file = new File(esperado);
			scanner = new Scanner(file);
			scanner.useLocale(Locale.ENGLISH);

			int esp = scanner.nextInt();
			res = (esp == resultado);

		} catch (Exception e) {

			System.err.println("[ERROR] - No puede abrirse el archivo: " + esperado);
			e.printStackTrace();

		} finally {

			if (scanner != null) {
				scanner.close();
			}
		}

		return res;
	}

}
