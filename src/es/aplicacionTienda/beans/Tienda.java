/**
 * 
 */
package es.aplicacionTienda.beans;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author LuisMiyObada
 *
 */
public class Tienda {
	
	private String nombreTienda;
	private ArrayList<Producto> productos = new ArrayList<>();
	private ArrayList<Cliente> clientes = new ArrayList<>();
	private Map<String,ArrayList<Compra>> compraCliente = new HashMap<String,ArrayList<Compra>>();

	
	
	public Tienda() {
		
	}

	public Tienda(String nombreTienda, ArrayList<Producto> productos, Map<String, ArrayList<Compra>> compraCliente) {
		super();
		this.nombreTienda = nombreTienda;
		this.productos = productos;
		this.compraCliente = compraCliente;
	}

	public String getNombreEmpresa() {
		return nombreTienda;
	}

	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreTienda = nombreEmpresa;
	}

	public ArrayList<Producto> getProductos() {
		return productos;
	}

	public void setProductos(ArrayList<Producto> productos) {
		this.productos = productos;
	}

	public Map<String, ArrayList<Compra>> getCompraCliente() {
		return compraCliente;
	}

	public void setCompraCliente(Map<String, ArrayList<Compra>> compraCliente) {
		this.compraCliente = compraCliente;
	}
	
	public void aumentarStock(int numero, String nombre) {
		
		int aumento = 0;
		
		for (Producto p : this.productos) {
			
			if(nombre.equals(p.getNombre())) {
				aumento = p.getStock() + numero;
				p.setStock(aumento);
			}
		}
		
	}
	
	public void bajarStock(int numero, String nombre) {
		int bajada = 0;
		
		for (Producto p : this.productos) {
			
			if(nombre.equals(p.getNombre())) {
				bajada = p.getStock() - numero;
				p.setStock(bajada);
			}
		}
	}
	
	public void crearProducto(String nombre,String descripcion, double precio, String categoria,int stock) {
		this.productos.add(new Producto(nombre,descripcion,precio,categoria,stock));
	}
	public void crearCliente(String nombre,String apellidos, String direccion, String telefono,String dni) {
		this.clientes.add(new Cliente());
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Tienda [nombreTienda=" + nombreTienda + ", productos=" + productos + ", clientes=" + clientes
				+ ", compraCliente=" + compraCliente + "]";
	}
}
