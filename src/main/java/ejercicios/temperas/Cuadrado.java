package ejercicios.temperas;

public class Cuadrado extends BaseFigura {

	private double ancho;
	private double largo;

	public Cuadrado(double ancho, double largo) {
		this.ancho = ancho;
		this.largo = largo;
	}

	@Override
	public double area() {
		return (ancho * largo) - super.area();
	}

}
