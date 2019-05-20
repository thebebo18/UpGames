package modelo;

public class usuario {
	private double idUsuario;
	private String nombreUsuario;
	private String codigoUsuario;
	private String duracion;
	
	public usuario() {}
	
	public double getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(double idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getCodigoUsuario() {
		return codigoUsuario;
	}
	public void setCodigoUsuario(String codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}

	public void setDuracion(String duracion){
		this.duracion=duracion;
	}

	public String getDuracion(){ return duracion;}
}
