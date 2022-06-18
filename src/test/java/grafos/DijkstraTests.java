package grafos;

import static org.junit.Assert.*;

import org.junit.Test;

import grafos.algoritmos.ShortestPath;

public class DijkstraTests {

	@Test
	public void test01() {
		double[][] g = {
				{0,5,4,2},
				{5,0,4,1},
				{4,4,0,1},
				{2,1,1,0}
		};
		
		int root = 0;
		
		Grafo grafo = new MatrizAdyacente(g);
		ShortestPath d = new ShortestPath();
		double[] distancias = d.dijkstra(grafo, root);
		
		assertEquals(3, distancias[2], 0);
		assertEquals(2, distancias[3], 0);
	}
	
	@Test
	public void test02() {
		double[][] g = {
				{0,6,4,1,0,0,0},
				{6,0,0,2,3,0,0},
				{4,0,0,5,0,5,0},
				{1,2,5,0,6,8,2},
				{0,3,0,6,0,0,3},
				{0,0,5,8,0,0,9},
				{0,0,0,2,3,9,0}
		};
		
		int root = 0;
		
		Grafo grafo = new MatrizAdyacente(g);
		ShortestPath d = new ShortestPath();
		double[] distancias = d.dijkstra(grafo, root);

		assertEquals(3, distancias[6], 0);
		assertEquals(1, distancias[3], 0);
		assertEquals(3, distancias[1], 0);
	}
	
	@Test
	public void test03() {
		double[][] g = {
				{0,10,0,30,100},
				{10,0,50,0,0},
				{0,50,0,20,10},
				{30,0,20,0,60},
				{100,0,10,60,0}
		};
		
		int root = 0;
		
		Grafo grafo = new MatrizAdyacente(g);
		ShortestPath d = new ShortestPath();
		double[] distancias = d.dijkstra(grafo, root);

		assertEquals(10, distancias[1], 0);
		assertEquals(50, distancias[2], 0);
		assertEquals(30, distancias[3], 0);
		assertEquals(60, distancias[4], 0);
	}
	
	@Test
	public void test04() {
		double[][] g = {
				{0,1,0},
				{1,0,0},
				{0,0,0}
		};
		
		int root = 2;
		
		Grafo grafo = new MatrizAdyacente(g);
		ShortestPath d = new ShortestPath();
		double[] distancias = d.dijkstra(grafo, root);
		assertEquals(Double.MAX_VALUE, distancias[0], 0);
	}
	
	@Test
	public void test05() {
		Arista[] senderos = new Arista[10];
		senderos[0] = new Arista(0,1,3);
		senderos[1] = new Arista(0,2,2);
		senderos[2] = new Arista(1,2,4);
		senderos[3] = new Arista(1,5,1);
		senderos[4] = new Arista(2,5,2);
		senderos[5] = new Arista(2,3,2);
		senderos[6] = new Arista(2,7,1);
		senderos[7] = new Arista(3,4,2);
		senderos[8] = new Arista(5,8,3);
		senderos[9] = new Arista(5,7,5);
		
		int root = 7;
		
		Grafo grafo = new ListaAdyacente(senderos, 10);
		ShortestPath d = new ShortestPath();
		double[] distancias = d.dijkstra(grafo, root);

		assertEquals(3, distancias[0], 0);
	}
	
	@Test
	public void test06() {
		double[][] g = {
				{0,3,2,0,0,0,0,0,0},
				{3,0,4,0,0,1,0,0,0},
				{2,4,0,2,0,2,0,1,0},
				{0,0,2,0,2,0,0,0,0},
				{0,0,0,2,0,0,0,0,0},
				{0,1,2,0,0,0,0,5,3},
				{0,0,0,0,0,0,0,0,0},
				{0,0,1,0,0,5,0,0,0},
				{0,0,0,0,0,3,0,0,0}
		};
		
		int root = 7;
		
		Grafo grafo = new MatrizAdyacente(g);
		ShortestPath d = new ShortestPath();
		double[] distancias = d.dijkstra(grafo, root);

		assertEquals(3, distancias[0], 0);
	}

}
