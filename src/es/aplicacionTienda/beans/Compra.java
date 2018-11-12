/**
 * 
 */
package es.aplicacionTienda.beans;

/**
 * @author LuisMiyObada
 *
 */
public class Compra {
	
	private Cliente cliente;
	
	private String fecha;
	
	private double total;

	
	public Compra() {
		
	}
	
	
	public Compra(Cliente cliente, String fecha, double total) {
		super();
		this.cliente = cliente;
		this.fecha = fecha;
		this.total = total;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public String getFecha() {
		return fecha;
	}


	public void setFecha(String fecha) {
		this.fecha = fecha;
	}


	public double getTotal() {
		return total;
	}


	public void setTotal(double total) {
		this.total = total;
	}
	
	
	public void compraTotal(int numero, Producto p) { 
		this.total += numero*p.getPrecio();
		System.out.println("Compra a�adida al carrito");
		
	}


	@Override
	public String toString() {
		return "Compra [Cliente=" + cliente.getDni() +", fecha=" + fecha + ", total=" + total + "]";
	}
	
	

}
