package grafos.coloreo;

public class Color {

	private int numero;
	private TipoDeColores tipo;

	public Color(TipoDeColores tipo) {
		this.tipo = tipo;
		this.numero = 0;
	}

	public void nuevoColor() {
		numero++;
	}

	public String pintar() {
		String pintura = "";

		switch (tipo) {
		case LETRAS:
			pintura = String.valueOf((char) ('A' + numero));
			break;

		case NUMEROS:

			break;

		case PALABRAS:

			break;

		default:
			break;
		}

		return pintura;
	}

}
