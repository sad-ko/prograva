package oia.luchadores;

public class Cuadrilatero {

	public int[] calcularDominados(String filename) {
		Luchador[] luchadores = Archivo.leer(filename);
		int[] resultados = new int[luchadores.length];

		for (int i = 0; i < luchadores.length; i++) {
			for (int j = 0; j < luchadores.length; j++) {
				resultados[i] += luchadores[i].domina(luchadores[j]) ? 1 : 0;
			}
		}

		return resultados;
	}
}
