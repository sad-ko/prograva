package ejercicios.temperas;

import java.util.ArrayList;
import java.util.List;

public class ContenedorDeFiguras implements Figura {

	private List<Figura> figuras = new ArrayList<>();

	public void add(Figura figura) {
		if (figura != this) {
			figuras.add(figura);
		}
	}

	@Override
	public double area() {
		double sum = 0;

		for (Figura figura : figuras) {
			sum += figura.area();
		}

		return sum;
	}

}
