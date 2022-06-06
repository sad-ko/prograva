package oia.mesadas;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Deposito {

	private List<Mesada> mesadas;

	public Deposito() {
		this.mesadas = new ArrayList<>();
	}

	public void cargarArchivo(final String filename) {
		Scanner scanner = null;

		try {
			File file = new File(filename);
			scanner = new Scanner(file);
			scanner.useLocale(Locale.ENGLISH);

			int n = scanner.nextInt();

			for (int i = 0; i < n; i++) {
				int ancho = scanner.nextInt();
				int largo = scanner.nextInt();

				Mesada mesada = new Mesada(ancho, largo);
				this.mesadas.add(mesada);
			}
		} catch (Exception e) {
			System.err.println("[ERROR] - No puede abrirse el archivo: " + filename);
			e.printStackTrace();
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}

	public int armarPilas() {
		int listaSize = this.mesadas.size();
		int cant = 0;

		this.mesadas.sort(Mesada::compareTo);

		// n*(n-1) = n²-n => O(n²)
		for (int i = 0; i < listaSize; i++) { // n
			Mesada mesada = this.mesadas.get(i);

			for (int j = i + 1; j < listaSize && !mesada.estaApilado(); j++) { // (n-1)
				Mesada otraMesada = this.mesadas.get(j);

				if (!otraMesada.estaApilado() && mesada.apilable(otraMesada)) {
					otraMesada.apilarlo();
					// Apuntamos al nuevo tope de la pila
					mesada = otraMesada.copy();
				}
			}

			// Las unicas mesas no apiladas son las bases de las pilas.
			if (!mesada.estaApilado()) {
				cant++;
			}
		}

		return cant;
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();

		str.append("-------\n");
		for (Mesada mesada : mesadas) {
			str.append(mesada + "\n");
		}
		str.append("-------");

		return str.toString();
	}

}
