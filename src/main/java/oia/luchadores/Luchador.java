package oia.luchadores;

public class Luchador {
	private int peso;
	private int altura;
	
	public Luchador(int peso, int altura) {
		this.peso = peso;
		this.altura = altura;
	}
	
	public boolean domina(Luchador b) {
		return (this != b) && (this.peso >= b.peso && this.altura >= b.altura);
	}
}
