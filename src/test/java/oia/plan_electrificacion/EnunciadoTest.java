package oia.plan_electrificacion;

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
		ejecutarCaso(5);
	}

	public void ejecutarCaso(int numCaso) {
		String caso = "0" + numCaso;

		String in = "src/main/java/oia/plan_electrificacion/in/" + caso + ".in";
		String expected = "src/main/java/oia/plan_electrificacion/expected/" + caso + ".out";
		String actual = "src/main/java/oia/plan_electrificacion/out/" + caso + ".out";

		ejercicio.leer(in);
		ejercicio.resolver();
		ejercicio.escribir(actual);

		FileAssert.assertEquals(new File(expected), new File(actual));
	}

}
