package oia.vecinos;

public class EjercicioOIA {

	Plan plan;

	public static void main(String[] args) {
		EjercicioOIA ejercicio = new EjercicioOIA();

		ejercicio.leer("src/main/java/oia/vecinos/in/00.in");
		ejercicio.resolver();
		ejercicio.escribir("src/main/java/oia/vecinos/out/00.out");
	}

	public void leer(String path) {
		plan = Lector.leer(path);
	}

	public void escribir(String path) {
		Escritor.escribir(path, plan);
	}

	public void resolver() {
		plan.planificar();
	}
}
