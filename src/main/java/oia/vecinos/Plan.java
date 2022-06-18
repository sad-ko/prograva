package oia.vecinos;

import grafos.Grafo;
import grafos.ListaAdyacente;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import grafos.Arista;

public class Plan {

	private Grafo grafo;
	private int rival_x;
	private int rival_y;
	private int aliados_x;
	private int aliados_y;
	private double[] amistades_x;
	private double[] amistades_y;

	public Plan(Arista[] lazos, int vecinos, int rival_x, int rival_y) {
		this.grafo = new ListaAdyacente(lazos, vecinos);
		this.rival_x = rival_x;
		this.rival_y = rival_y;
		this.aliados_x = 0;
		this.aliados_y = 0;
		this.amistades_x = new double[vecinos];
		this.amistades_y = new double[vecinos];
	}

	public void planificar() {
		amistades_x = BFS(rival_x, rival_y);
		amistades_y = BFS(rival_y, rival_x);
		System.out.println(Arrays.toString(amistades_x));
		System.out.println(Arrays.toString(amistades_y));

		for (int i = 0; i < amistades_x.length; i++) {
			if (i == rival_x || i == rival_y) {
				continue;
			}

			if (amistades_x[i] > amistades_y[i]) {
				aliados_x++;
			} else {
				aliados_y++;
			}
		}
	}

	private double[] BFS(int root, int rival) {
		boolean[] visitado = new boolean[grafo.size()];
		Queue<Integer> queue = new LinkedList<>();
		double[] amistades = new double[grafo.size()];

		for (int i = 0; i < amistades.length; i++) {
			amistades[i] = Double.MAX_VALUE;
		}

		visitado[root] = true;
		queue.add(root);

		while (!queue.isEmpty()) {
			int v = queue.poll();

			List<Integer> aristas = grafo.getAristasDe(v);
			for (Integer w : aristas) {
				if (w == rival) {
					continue;
				}

				double fuerza = grafo.getArista(v, w);
				if (!visitado[w]) {
					amistades[w] = (fuerza < amistades[v]) ? fuerza : amistades[v];
					visitado[w] = true;
					queue.add(w);
				} else {
					if (fuerza > amistades[w] && amistades[w] > amistades[v]) {
						amistades[v] = amistades[w];
					}
				}
			}
		}

		return amistades;
	}

	@Override
	public String toString() {
		return aliados_x + " " + aliados_y;
	}

}