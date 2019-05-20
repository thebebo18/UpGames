package modelo;

public class articulo {
	
	private double codigo;
	private String nombre;
	private String descripcion;
	private int cantidad;
	private float precio;
	
	public articulo() {
		
	}
	public double getCodigo() {
		return codigo;
	}
	public void setCodigo(double codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
}
