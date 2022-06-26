package grafos;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import grafos.coloreo.Color;
import grafos.coloreo.Colorear;
import grafos.coloreo.TipoDeColores;
import grafos.coloreo.TipoDeOrden;

public class ColoreoTests {

	@Test
	public void testWelshPowell01() {
		Grafo grafo = new ListaAdyacenteNoDirigida(7);
		grafo.setArista(0, 1, 0);
		grafo.setArista(0, 6, 0);
		grafo.setArista(0, 3, 0);
		grafo.setArista(1, 6, 0);
		grafo.setArista(1, 5, 0);
		grafo.setArista(1, 4, 0);
		grafo.setArista(2, 6, 0);
		grafo.setArista(2, 5, 0);
		grafo.setArista(2, 4, 0);
		grafo.setArista(2, 3, 0);
		grafo.setArista(3, 6, 0);
		grafo.setArista(3, 4, 0);
		grafo.setArista(4, 5, 0);
		grafo.setArista(4, 6, 0);
		grafo.setArista(5, 6, 0);

		Map<String, List<Integer>> grafoColoreado = Colorear.colorear(grafo, TipoDeOrden.WELSH_POWELL,
				new Color(TipoDeColores.LETRAS));

		for (String color : grafoColoreado.keySet()) {
			System.out.println("[" + color + "]");
			System.out.println(grafoColoreado.get(color));
		}

		assertEquals(4, grafoColoreado.size());
	}

	@Test
	public void testMatula01() {
		Grafo grafo = new ListaAdyacenteNoDirigida(7);
		grafo.setArista(0, 1, 0);
		grafo.setArista(0, 6, 0);
		grafo.setArista(0, 3, 0);
		grafo.setArista(1, 6, 0);
		grafo.setArista(1, 5, 0);
		grafo.setArista(1, 4, 0);
		grafo.setArista(2, 6, 0);
		grafo.setArista(2, 5, 0);
		grafo.setArista(2, 4, 0);
		grafo.setArista(2, 3, 0);
		grafo.setArista(3, 6, 0);
		grafo.setArista(3, 4, 0);
		grafo.setArista(4, 5, 0);
		grafo.setArista(4, 6, 0);
		grafo.setArista(5, 6, 0);

		Map<String, List<Integer>> grafoColoreado = Colorear.colorear(grafo, TipoDeOrden.MATULA,
				new Color(TipoDeColores.LETRAS));

		for (String color : grafoColoreado.keySet()) {
			System.out.println("[" + color + "]");
			System.out.println(grafoColoreado.get(color));
		}

		assertEquals(4, grafoColoreado.size());
	}

}
