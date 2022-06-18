package oia.metro;

import java.io.File;
import org.junit.Test;
import junitx.framework.FileAssert;

public class EnunciadoTest {

	EjercicioOIA ejercicio = new EjercicioOIA();

	@Test
	public void enunciado() {
		ejecutarCaso(0);
		ejecutarCaso(1);
		ejecutarCaso(2);
		ejecutarCaso(3);
		ejecutarCaso(4);
	}

	public void ejecutarCaso(int numCaso) {
		String caso = "0" + numCaso;

		String in = "src/main/java/oia/metro/in/" + caso + ".in";
		String expected = "src/main/java/oia/metro/expected/" + caso + ".out";
		String actual = "src/main/java/oia/metro/out/" + caso + ".out";

		ejercicio.leer(in);
		ejercicio.resolver();
		ejercicio.escribir(actual);

		FileAssert.assertEquals(new File(expected), new File(actual));
	}

}
