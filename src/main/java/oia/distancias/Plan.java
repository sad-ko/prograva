package oia.distancias;

import java.util.ArrayList;
import java.util.List;

import grafos.Grafo;
import grafos.ListaAdyacente;
import grafos.algoritmos.ShortestPath;
import grafos.Arista;

public class Plan {

	private Grafo grafo;
	private List<String> nombres;
	private int origen;
	private int destino;
	private List<String> ruta;
	private double distancia;

	public Plan(Arista[] aristas, List<String> nombres, int origen, int destino) {
		this.grafo = new ListaAdyacente(aristas, nombres.size());
		this.nombres = nombres;
		this.origen = origen;
		this.destino = destino;
	}

	public void planificar() {
		ShortestPath caminos = new ShortestPath();

		distancia = caminos.dijkstra(grafo, origen)[destino];

		if (distancia != Double.MAX_VALUE) {
			List<Integer> camino = caminos.caminoHasta(origen, destino);
			ruta = new ArrayList<>();
			for (Integer localidad : camino) {
				ruta.add(nombres.get(localidad));
			}
		}
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();

		if (distancia != Double.MAX_VALUE) {
			str.append("La ruta mas corta es de " + distancia + "km: ");

			str.append(ruta.get(0));
			for (int i = 1; i < ruta.size(); i++) {
				str.append(" - " + ruta.get(i));
			}
		} else {
			str.append("No se encontro camino desde " + nombres.get(origen) + " hasta " + nombres.get(destino));
		}

		return str.toString();
	}

}
