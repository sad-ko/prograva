package oia.hercules;

public class EjercicioOIA {

	Estrategia estatregia;

	public static void main(String[] args) {
		EjercicioOIA ejercicio = new EjercicioOIA();

		ejercicio.leer("src/main/java/oia/hercules/in/00.in");
		ejercicio.resolver();
		ejercicio.escribir("src/main/java/oia/hercules/out/00.out");
	}

	/**
	 * Este método se encarga de leer la entrada de la consigna desde el archivo.
	 */
	public void leer(String path) {
		estatregia = Lector.leer(path);
	}

	/**
	 * Este método se encarga de escribir la salida de la consigna en el archivo.
	 */
	public void escribir(String path) {
		Escritor.escribir(path, estatregia);
	}

	/**
	 * Este método debe realizar la resolución del ejercicio. NO DEBE SITUARSE LA
	 * LOGICA AQUI, sino que se pueden utilizar clases adicionales, y los objetos
	 * creados en la etapa de lectura. Utilizar este mismo paquete para toda la
	 * resolución.
	 */
	public void resolver() {
		estatregia.hercules();
	}
}
