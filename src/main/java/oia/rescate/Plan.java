package oia.rescate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import grafos.Grafo;
import grafos.ListaAdyacente;
import grafos.algoritmos.ShortestPath;
import grafos.Arista;

public class Plan {

	private Grafo grafo;
	private int[] dragones;
	private int princesa;
	private int principe;
	private boolean llego;
	private boolean noCamino;
	private boolean interceptado;
	private List<Integer> caminoFinal;

	public Plan(Arista[] senderos, int claros, int[] dragones, int princesa, int principe) {
		this.grafo = new ListaAdyacente(senderos, claros);
		this.dragones = dragones;
		this.princesa = princesa;
		this.principe = principe;
	}

	public void planificar() {
		ShortestPath[] dragonesPaths = new ShortestPath[dragones.length];
		double[][] dragonesDists = new double[dragones.length][grafo.size()];
		List<Integer> evitar = new ArrayList<>();

		for (int i = 0; i < dragones.length; i++) {
			dragonesPaths[i] = new ShortestPath();
			dragonesDists[i] = dragonesPaths[i].dijkstra(grafo, dragones[i]);
			evitar.add(dragones[i]);
			System.out.println(Arrays.toString(dragonesDists[i]));
		}

		do {
			ShortestPath princePath = new ShortestPath();
			double[] princeDist = princePath.dijkstra(grafo, principe, evitar);

			if (princeDist[princesa] == Double.MAX_VALUE) {
				noCamino = true;
				break;
			}

			List<Integer> camino = princePath.caminoHasta(principe, princesa);
			interceptado = false;

			for (int i = 1; i < camino.size(); i++) {
				if (interceptado(camino.get(i), princeDist[camino.get(i)], dragonesDists)) {
					evitar.add(camino.get(i));
					interceptado = true;
					break;
				}
			}

			if (!interceptado) {
				llego = true;
				caminoFinal = camino;
			}

		} while (!llego);
	}

	private boolean interceptado(int claro, double distancia, double[][] dragonesDists) {
		for (double[] ds : dragonesDists) {
			if (ds[claro] <= distancia) {
				return true;
			}
		}

		return false;
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();

		if (noCamino) {
			str.append((interceptado) ? "INTERCEPTADO" : "NO HAY CAMINO");
		} else {
			str.append(caminoFinal.get(0) + 1);
			for (int i = 1; i < caminoFinal.size(); i++) {
				str.append(" " + (caminoFinal.get(i) + 1));
			}
		}

		return str.toString();
	}

}