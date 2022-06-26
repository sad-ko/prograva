package grafos;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import grafos.algoritmos.ShortestPath;

public class FloydWarshallTests {

	@Test
	public void test01() {
		Grafo grafo = new MatrizAdyacente(4);
		grafo.setArista(0, 2, -2);
		grafo.setArista(1, 0, 4);
		grafo.setArista(1, 2, 3);
		grafo.setArista(2, 3, 2);
		grafo.setArista(3, 1, -1);

		double[][] distancias = ShortestPath.floyd(grafo);

		for (double[] ds : distancias) {
			System.out.println(Arrays.toString(ds));
		}

		assertEquals(3, distancias[3][0], 0);
		assertEquals(-1, distancias[3][1], 0);
		assertEquals(1, distancias[3][2], 0);
		assertEquals(0, distancias[3][3], 0);
	}

	@Test
	public void test02() {
		Grafo grafo = new MatrizAdyacenteNoDirigida(4);
		grafo.setArista(0, 1, -2);
		grafo.setArista(0, 2, 4);
		grafo.setArista(2, 3, 2);

		boolean[][] caminos = ShortestPath.warshall(grafo);

		for (boolean[] ds : caminos) {
			System.out.println(Arrays.toString(ds));
		}

		assertEquals(true, caminos[3][1]);
	}

}
