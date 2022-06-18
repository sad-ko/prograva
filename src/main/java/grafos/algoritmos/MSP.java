package grafos.algoritmos;

import java.util.ArrayList;
import java.util.List;

import grafos.Arista;
import grafos.Grafo;
import grafos.GrafoLista;
import grafos.ListaAdyacente;
import grafos.UnionFind;
import monticulos.ColaDePrioridad;
import monticulos.MinMonticulo;

/**
 * Minimum Spanning Tree (MSP), es un sub-grafo que busca conectar todos los
 * nodos del grafo de una forma tal que no contenga ciclos y tenga el menor
 * costo posible al recorrerlo.
 */
public class MSP {

	private MSP() {}

	public static GrafoLista prim(Grafo grafo, Arista raiz) {
		GrafoLista resultado = new ListaAdyacente(grafo.size());

		List<Double> costos = new ArrayList<>(grafo.size());
		List<Boolean> visitado = new ArrayList<>(grafo.size());

		for (int i = 0; i < grafo.size(); i++) {
			costos.add(Double.MAX_VALUE);
			visitado.add(false);
		}

		// Guardamos los Nodos a revisar en una Cola de Prioridad para optimizar el
		// tiempo de busqueda para ir al siguiente nodo con el menor costo.
		ColaDePrioridad<Arista> queue = new MinMonticulo<>();
		queue.insert(raiz);

		while (!queue.isEmpty()) {
			Arista current = queue.remove();
			int currentID = current.getHasta();
			visitado.set(currentID, true);

			double minCosto = current.getCosto();

			if (minCosto < costos.get(currentID)) {
				costos.set(currentID, minCosto);
				resultado.setArista(current.getDesde(), currentID, minCosto);
			}

			List<Integer> aristas = grafo.getAristasDe(currentID);
			for (Integer arista : aristas) {
				if (visitado.get(arista).equals(Boolean.FALSE)) {
					Double costo = grafo.getArista(currentID, arista);
					queue.insert(new Arista(currentID, arista, costo));
				}
			}
		}

		return resultado;
	}

	public static GrafoLista kruskal(Grafo grafo) {
		GrafoLista resultado = new ListaAdyacente(grafo.size());
		ColaDePrioridad<Arista> queue = new MinMonticulo<>();
		UnionFind[] set = new UnionFind[grafo.size()];

		for (int i = 0; i < grafo.size(); i++) {
			set[i] = new UnionFind(i);

			List<Integer> aristas = grafo.getAristasDe(i);
			for (Integer arista : aristas) {
				Double costo = grafo.getArista(i, arista);
				queue.insert(new Arista(i, arista, costo));
			}
		}

		while (!queue.isEmpty()) {
			Arista current = queue.remove();
			int desde = current.getDesde();
			int hasta = current.getHasta();

			if (!set[desde].find().equals(set[hasta].find())) {
				resultado.setArista(desde, hasta, current.getCosto());
				set[desde].union(set[hasta]);
			}
		}

		return resultado;
	}

}
