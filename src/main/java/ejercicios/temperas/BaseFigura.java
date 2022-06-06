package ejercicios.temperas;

public abstract class BaseFigura implements Figura {

	protected BaseFigura figuraContenida;

	public void insertarFigura(BaseFigura figura) {
		this.figuraContenida = figura;
	}

	public double area() {
		return (this.figuraContenida != null ? this.figuraContenida.area() : 0);
	}
}
