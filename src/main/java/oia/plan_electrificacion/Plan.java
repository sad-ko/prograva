package oia.plan_electrificacion;

import java.util.Comparator;

import grafos.Grafo;
import grafos.GrafoLista;
import grafos.MatrizAdyacente;
import grafos.algoritmos.MSP;
import grafos.Arista;

public class Plan {

	private int[] centrales;
	private Grafo grafo;
	private GrafoLista costo;

	public Plan(double[][] grafo, int[] centrales) {
		// Todos los caminos que cuesten 0 son convertidos a null.
		this.grafo = new MatrizAdyacente(grafo);
		this.centrales = centrales;
	}

	public void planificar() {
		// Todos los caminos entre centrales pasan a costar 0.
		for (int i = 0; i < centrales.length; i++) {
			for (int j = 0; j < centrales.length; j++) {
				if (i != j) {
					grafo.setArista(centrales[i], centrales[j], 0);
				}
			}
		}

		// Como el camino entre todas las centrales es 0, la central por la que se
		// comienza el recorrido es indiferente.
		costo = MSP.prim(grafo, new Arista(centrales[0], centrales[0], 0));

		// El valor de los nodos son tratados internamente desde el 0. Pero podemos
		// asignarle un nombre de referencia, para el uso de este caso seria:
		// valorDelNodo + 1.
		String[] nombres = new String[costo.size()];
		for (int i = 0; i < nombres.length; i++) {
			nombres[i] = String.valueOf(i + 1);
		}

		try {
			costo.setNombres(nombres);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Ordenamos el grafo resultante por nombre de la ciudad conectada.
		Comparator<Arista> byName = new Comparator<Arista>() {
			@Override
			public int compare(Arista a1, Arista a2) {
				return a1.getHastaNombre().compareTo(a2.getHastaNombre());
			}
		};

		costo.sort(byName);
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();

		str.append((int) this.costo.costo() + "\n");
		str.append(this.costo);

		return str.toString();
	}

}