package ejercicios.temperas;

public class App {
	public static void main(String[] args) {
		double pomoTempera = 100;

		Cuadrado cuad = new Cuadrado(12, 12);
		Triangulo tri = new Triangulo(30, 45);
		Circulo cir = new Circulo(4);

		ContenedorDeFiguras conRojo = new ContenedorDeFiguras();
		conRojo.add(cuad);
		conRojo.add(tri);
		conRojo.add(conRojo);

		cuad.insertarFigura(cir);

		System.out.println(conRojo.area() / pomoTempera);
		int temperasRojas = (int) Math.ceil(conRojo.area() / pomoTempera);
		System.out.println(temperasRojas);
	}
}
