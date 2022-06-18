package grafos.algoritmos;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import grafos.Arista;
import grafos.Grafo;
import monticulos.ColaDePrioridad;
import monticulos.MinMonticulo;

public class ShortestPath {

	private int[] antecesores;

	public double[] dijkstra(final Grafo grafo, final int root) {
		return this.dijkstra(grafo, root, null);
	}

	public double[] dijkstra(final Grafo grafo, final int root, final List<Integer> blacklist) {
		ColaDePrioridad<Arista> queue = new MinMonticulo<>();
		double[] costos = new double[grafo.size()];
		boolean[] visitados = new boolean[grafo.size()];
		this.antecesores = new int[grafo.size()];

		for (int i = 0; i < grafo.size(); i++) {
			double costo = (i == root) ? 0 : Double.MAX_VALUE;
			costos[i] = costo;
			antecesores[i] = root;
			visitados[i] = false;
		}

		queue.insert(new Arista(root, 0));

		while (!queue.isEmpty()) {
			Arista current = queue.remove();
			int u = current.getHasta();
			visitados[u] = true;

			List<Integer> aristas = grafo.getAristasDe(u);

			for (Integer arista : aristas) {
				if (blacklist != null && blacklist.contains(arista)) {
					continue;
				}

				Double costo = grafo.getArista(u, arista);

				if (!visitados[arista]) {
					double nuevoCosto = costo + current.getCosto();
					if (nuevoCosto < costos[arista]) {
						queue.insert(new Arista(u, arista, nuevoCosto));
						antecesores[arista] = u;
						costos[arista] = nuevoCosto;
					}
				}
			}
		}

		return costos;
	}

	public List<Integer> caminoHasta(int desde, int hasta) {
		List<Integer> lista = new LinkedList<>();
		Deque<Integer> pila = new LinkedList<>();

		pila.add(hasta);
		while (this.antecesores[hasta] != desde) {
			pila.push(this.antecesores[hasta]);
			hasta = this.antecesores[hasta];
		}
		pila.push(desde);

		while (!pila.isEmpty()) {
			lista.add(pila.pop());
		}

		return lista;
	}

}
