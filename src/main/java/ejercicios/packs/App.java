package ejercicios.packs;

import java.util.ArrayList;

public class App {
	public static void main(String[] args) {
		Carrito carro = new Carrito();
		Articulo item_1 = new Articulo("Jabon", 99.99);
		Articulo item_2 = new Articulo("Bananas", 150.25);
		ArrayList<Articulo> item_list = new ArrayList<Articulo>();
		
		item_list.add(item_1);
		item_list.add(item_2);
		
		PackDescuento pd = new PackDescuento(item_list, 50);
		PackFijo pf = new PackFijo(item_list, 100);
		PackRegalo pr = new PackRegalo(item_list);

		carro.agregarCarrito(item_1);
		carro.agregarCarrito(item_2);
		carro.agregarCarrito(pd);
		carro.agregarCarrito(pf);
		carro.agregarCarrito(pr);
		carro.calcularTotal();
		
		System.out.println(carro);
	}
}
