package es.aplicacionTienda.Main;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import es.aplicacionTienda.beans.Cliente;
import es.aplicacionTienda.beans.Compra;
import es.aplicacionTienda.beans.Producto;
import es.aplicacionTienda.beans.Tienda;

public class Main {
	
	private static Map<String, ArrayList<Compra>> listaClientes = new HashMap<String, ArrayList<Compra>>();
	private static ArrayList<Producto> productos = new ArrayList<Producto>();
	private static ArrayList<Compra> listaCompras = new ArrayList<Compra>();
	
	public static void main(String[] args) {
		
		
		Tienda t = new Tienda();
		Cliente c1 = new Cliente("User1", "Surname", "Road", "6161616", "469745Y");

		Producto limpieza = new Producto("Neutrex", "Para el suelo", 3.25, "Limpieza", 200);
		productos.add(limpieza);
		Producto limpieza2 = new Producto("Sanex", "Para el cuerpo", 1.75, "Limpieza", 250);
		productos.add(limpieza2);
		Producto alimentacion = new Producto("Jamon", "En lonchas", 1, "Alimentacion", 300);
		productos.add(alimentacion);
		Producto alimentacion2 = new Producto("Queso", "Curado", 2.57, "Alimentacion", 300);
		productos.add(alimentacion2);
		Producto perfumeria = new Producto("Axe", "Desodorante", 1.10, "Perfumeria", 430);
		productos.add(perfumeria);
		t.setNombreEmpresa("Tienda de Barrio");
		t.setProductos(productos);
		

		Scanner sc = new Scanner(System.in);

		int op = 0;

		for (;;) {
			System.out.println("===============================================");
			System.out.println("|              TIENDA DE BARRIO               |");
			System.out.println("|                                             |");
			System.out.println("===============================================");
			System.out.println("ооооооооооооооооооооооооооооооооооооооооооооооо");
			System.out.println("|              Opciones de tienda             |");
			System.out.println("ооооооооооооооооооооооооооооооооооооооооооооооо");
			System.out.println("|             1.-Comprar (Con usuario)        |");
			System.out.println("|             2.-Administrar tienda           |");
			System.out.println("|             3.-Crear Cliente                |");
			System.out.println("|                  0.-Salir                   |");
			System.out.println("|                                             |");
			System.out.println("|               Elige Opciєn (0-3)            |");
			System.out.println("===============================================");
			op = sc.nextInt();
			switch (op) {
			case 1:
				menuComprar(c1, t, listaClientes);
				break;
			case 2:
				menuEmpresa(t);
				break;
			case 3:
				crearCliente(t);
				break;
			case 4:
				break;
			}
		}

	}

	private static void menuComprar(Cliente c1, Tienda t, Map<String, ArrayList<Compra>> listaClientes) {
		Scanner sc = new Scanner(System.in);
		Compra compra = new Compra();
		int op = 0;
		for (;;) {
			System.out.println("===============================================");
			System.out.println("|               1.Productos                    |");
			System.out.println("|               2.Pagar                        |");
			System.out.println("|               3.Salir                        |");
			System.out.println("===============================================");
			op = sc.nextInt();
			switch (op) {
			case 1:
				hacerCompra(c1, t, compra);
				break;
			case 2:
				pagarCompra(c1, t, compra, listaClientes);
				break;
			case 3:
				System.out.println("Gracias por su compra");
				main(null);
				break;
			}
		}

	}

	private static void crearCliente(Tienda t) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Nombre: ");
		String nombre = sc.nextLine();
		System.out.println("Apellido:");
		String apellido = sc.nextLine();
		System.out.println("Direcciєn: ");
		String direccion = sc.nextLine();
		System.out.println("Telefono: ");
		String telefono = sc.nextLine();
		System.out.println("DNI");
		String dni = sc.nextLine();

		t.crearCliente(nombre, apellido, direccion, telefono, dni);
	}

	private static void menuEmpresa(Tienda t) {
		Scanner sc = new Scanner(System.in);
		int op = 0;
		for (;;) {
			System.out.println("===============================================");
			System.out.println("|              TIENDA DE BARRIO               |");
			System.out.println("|                                             |");
			System.out.println("===============================================");
			System.out.println("ооооооооооооооооооооооооооооооооооооооооооооооо");
			System.out.println("|              Administraciєn                 |");
			System.out.println("ооооооооооооооооооооооооооооооооооооооооооооооо");
			System.out.println("|        1.-Aёadir un nuevo producto          |");
			System.out.println("|           2.-Incrementar Stock              |");
			System.out.println("|             3.-Reducir Stock                |");
			System.out.println("|          4.-Lista de productos              |");
			System.out.println("|      5.-Lista de compras de clientes        |");
			System.out.println("|                  0.-Salir                   |");
			System.out.println("|                                             |");
			System.out.println("|               Elige Opciєn (0-5)            |");
			System.out.println("===============================================");
			op = sc.nextInt();
			switch (op) {

			case 1:
				insertarProducto(t);
				break;
			case 2:
				aumentarStock(t);
				break;
			case 3:
				bajarStock(t);
				break;
			case 4:
				mostrarProductos(t);
				break;
			case 5:
				listaDeCompradores(t);
				break;
			case 0:
				main(null);
				break;
			}
		}

	}

	private static void listaDeCompradores(Tienda t) {
		int i=0;
		for (i=0;i<listaCompras.size();i++){
			System.out.println(listaCompras.get(i).toString());
			
		}
		
		

	}

	private static void insertarProducto(Tienda t) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Categoria: 1.Alimentacion 2.Limpieza 3.Perfumeria");
		System.out.println("Alimentacion");
		System.out.println("Limpieza ");
		System.out.println("Perfumeria");
		String categoria = sc.nextLine();
		System.out.println("Nombre del producto:");
		String nombre = sc.nextLine();
		System.out.println("Descripcion del producto:");
		String descripcion = sc.nextLine();
		System.out.println("Precio del producto:");
		double precio = sc.nextDouble();
		System.out.println("Stock del producto");
		int stock = sc.nextInt();

		t.crearProducto(nombre, descripcion, precio, categoria, stock);
	}

	private static void mostrarProductos(Tienda t) {
		for (Producto p : t.getProductos()) {
			System.out.println("-----------------------------------------------------------------------------");
			System.out.println("Categoria: " + p.getCategoria() + "\t" + p.getNombre() + ":" + p.getDescripcion()
					+ "\t |--Nos quedan: " + p.getStock());
			System.out.println("------------------------------------------------------------------------------");
		}
	}

	public static boolean isNumeric(String cadena) {

		boolean resultado;
		try {
			Integer.parseInt(cadena);
			resultado = true;
		} catch (NumberFormatException excepcion) {
			resultado = false;
		}

		return resultado;
	}

	private static void hacerCompra(Cliente c1, Tienda t, Compra compra) {
		Scanner sc = new Scanner(System.in);
		mostrarProductos(t);
		String fecha = "";
		Date dfecha = new Date();
		System.out.println(dfecha);
		String formato= "dd/MMM/yyyy";
		SimpleDateFormat sdf = new SimpleDateFormat(formato);
		fecha=sdf.format(dfecha);
		System.out.println(fecha);
		
		System.out.println("Indica el nombre del producto: ");
		System.out.println("===============================================");
		String nombre = sc.nextLine();
		System.out.println("Introduce cantidad del producto");
		System.out.println("===============================================");
		int stock = sc.nextInt();
		for (Producto p : t.getProductos()) {
			if (p.getNombre().equalsIgnoreCase(nombre)) {
				if (p.getStock() > stock) {
					compra.setCliente(c1);
					compra.setFecha(fecha);
					compra.compraTotal(stock, p);
					t.bajarStock(stock, nombre);
					System.out.println(" cliente que ha comprado ="+compra.getCliente().getDni());
				} else {
					System.out.println("No hay suficientes productos");
				}

			}
		}
		listaCompras.add(compra);
	}

	private static void pagarCompra(Cliente c1, Tienda t, Compra compra, Map<String, ArrayList<Compra>> listaClientes) {
		System.out.println("Total a pagar: " + compra.getTotal());
		ArrayList<Compra> lista = new ArrayList<>();
		lista.add(compra);

		listaClientes.put(c1.getDni(), lista);
		t.setCompraCliente(listaClientes);
		System.out.println("COMPRA======"+t.getCompraCliente().toString());
	}

	private static void bajarStock(Tienda t) {
		Scanner sc = new Scanner(System.in);
		System.out.println("-Nombre del producto:");
		String nombre = sc.nextLine();
		System.out.println("Cantidad a retirar:");
		int stock = sc.nextInt();
		for (Producto p : t.getProductos()) {
			if (p.getNombre().equalsIgnoreCase(nombre)) {
				t.bajarStock(stock, nombre);
				System.out.println("Ahora tienes: " + p.getStock() + "de " + p.getNombre());
			}
		}
	}

	private static void aumentarStock(Tienda t) {
		Scanner sc = new Scanner(System.in);
		System.out.println("-Nombre del producto:");
		String nombre = sc.nextLine();
		System.out.println("Cantidad a depositar:");
		int stock = sc.nextInt();
		for (Producto p : t.getProductos()) {
			if (p.getNombre().equalsIgnoreCase(nombre)) {
				t.aumentarStock(stock, nombre);
				System.out.println("Ahora tiene:" + p.getStock() + "de " + p.getNombre());
			}
		}
	}
}
