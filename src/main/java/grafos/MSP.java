package grafos;

import java.util.ArrayList;
import java.util.List;

import monticulos.ColaDePrioridad;
import monticulos.MinMonticulo;

/**
 * Minimum Spanning Tree (MSP), es un sub-grafo que busca conectar todos los
 * nodos del grafo de una forma tal que no contenga ciclos y tenga el menor
 * costo posible al recorrerlo.
 */
public class MSP {

	private MSP() {
	}

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

			for (int i = 0; i < grafo.size(); i++) {
				if (visitado.get(i).equals(Boolean.FALSE)) {
					Double costo = grafo.getArista(currentID, i);
					if (costo != null) { // Si existe una relacion.
						queue.insert(new Arista(currentID, i, costo));
					}
				}
			}
		}

		return resultado;
	}

}
