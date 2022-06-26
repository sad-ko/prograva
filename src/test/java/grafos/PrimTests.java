package grafos;

import static org.junit.Assert.*;

import org.junit.Test;

import grafos.algoritmos.MSP;

public class PrimTests {

	@Test
	public void test01() {
		double[][] g = {
				{0,2,4,3},
				{2,0,5,2},
				{4,5,0,1},
				{3,2,1,0}
		};
		Grafo grafo = new MatrizAdyacente(g);
		Grafo result = MSP.prim(grafo, new Arista(3, 0));
		
		assertEquals(5, result.costo(), 0);
	}
	
	@Test
	public void test02() {
		double[][] g = {
				{0,7,0, 5, 0, 0,0},
				{7,0,8, 9, 7, 0,0},
				{0,8,0, 0, 5, 0,0},
				{5,9,0, 0,15, 6,0},
				{0,7,5,15, 0, 8,9},
				{0,0,0, 6, 8, 0,11},
				{0,0,0, 0, 9,11,0}
		};
		
		Grafo grafo = new MatrizAdyacente(g);
		Grafo result = MSP.prim(grafo, new Arista(3, 0));

		assertEquals(39, result.costo(), 0);
	}
	
	@Test
	public void test03() {
		double[][] g = {
				{0,1,5,0,0,0,0},
				{1,0,4,8,7,0,0},
				{5,4,0,6,0,2,0},
				{0,8,6,0,11,9,0},
				{0,7,0,11,0,3,10},
				{0,0,2,9,3,0,12},
				{0,0,0,0,10,12,0}
		};
		
		Grafo grafo = new MatrizAdyacente(g);
		Grafo result = MSP.prim(grafo, new Arista(3, 0));
		
		assertEquals(26, result.costo(), 0);
	}
	
	@Test
	public void test04() {
		double[][] g = {
				{0,4,4,0,0,0},
				{4,0,2,0,0,0},
				{4,2,0,3,2,4},
				{0,0,3,0,0,3},
				{0,0,2,0,0,3},
				{0,0,4,3,3,0}
		};
		
		Grafo grafo = new MatrizAdyacente(g);
		Grafo result = MSP.prim(grafo, new Arista(3, 0));

		assertEquals(14, result.costo(), 0);
	}
	
	@Test
	public void test05() {
		double[][] g = {
				{0,4,4,0,0,0},
				{4,0,2,0,0,0},
				{4,2,0,3,2,4},
				{0,0,3,0,0,3},
				{0,0,2,0,0,3},
				{0,0,4,3,3,0}
		};
		
		Grafo grafo = new MatrizAdyacente(g);
		Grafo result = MSP.prim(grafo, new Arista(3, 0));

		assertEquals(14, result.costo(), 0);
	}

}
