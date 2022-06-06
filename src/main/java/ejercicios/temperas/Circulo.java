package ejercicios.temperas;

public class Circulo extends BaseFigura {

	private double radio;

	public Circulo(double radio) {
		this.radio = radio;
	}

	@Override
	public double area() {
		return (Math.PI * Math.pow(radio, 2)) - super.area();
	}

}
