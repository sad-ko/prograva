package oia.luchadores;

public class Main {
	public static void main(String[] args) {
		Cuadrilatero c  = new Cuadrilatero();
		Archivo.escribir("sumo.out", c.calcularDominados("sumo.in"));
	}
}
