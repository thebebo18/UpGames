package modelo;

public class ordenDeCompra{

    private String numeroorden = "";
    private Double codigo;
    private String nombre;
    private String descripcion;
    private int cantidad;
    private double precio;
    private String nombreCliente;
    private String cedulaCliente;

    /**
     * @return the iD_VENTA
     */
    public String getNumeroOrden() {
        return numeroorden;
    }

    /**
     * @param iD_VENTA the iD_VENTA to set
     */
    public void setNumeroOrden(String string) {
        string = string;
    }

    /**
     * @return the codigo
     */
    public Double getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(Double codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the cantidad
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * @return the precio
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * @return the nombreCliente
     */
    public String getNombreCliente() {
        return nombreCliente;
    }

    /**
     * @param nombreCliente the nombreCliente to set
     */
    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    /**
     * @return the cedulaCliente
     */
    public String getCedulaCliente() {
        return cedulaCliente;
    }

    /**
     * @param cedulaCliente the cedulaCliente to set
     */
    public void setCedulaCliente(String cedulaCliente) {
        this.cedulaCliente = cedulaCliente;
    }
    

}

