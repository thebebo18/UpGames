package controlador;

import vista.*;
import modelo.*;

import java.sql.*;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class ControladorMenu {

    private String user = null;
    private singletonDB sindb = singletonDB.getInstance();
    private JTable tablaSesiones;
    private JTable ventas;
    private double total;
   

    public double getTotal(){
        return total;
    }

    public Connection desconetar(Connection connection) {
        return connection;
    }

    public ArrayList<usuario> getConn() {
        return sindb.mostrarSesiones();
    }

    public Connection ConetionMenu(String user, String pass) throws ClassNotFoundException, SQLException {

        return sindb.loginUsers(user, pass);
    }

    public ControladorMenu() {
    }


    public JTable ctrlSesiones() throws ClassNotFoundException, SQLException {

        String[] titulos = { "USUARIO", "DURACION" };
        String informacion[][] = obtenerMatriz();
        tablaSesiones = new JTable(informacion, titulos);

        return tablaSesiones;
    }

    private String[][] obtenerMatriz() throws ClassNotFoundException, SQLException {
        usuario usuario = new usuario();

        ArrayList<usuario> listaUsuario = getConn();

        String matrizInfo[][] = new String[listaUsuario.size()][2];

        for (int i = 0; i < listaUsuario.size(); i++) {
            matrizInfo[i][0] = listaUsuario.get(i).getNombreUsuario() + "";
            matrizInfo[i][1] = listaUsuario.get(i).getDuracion() + "";
        }

        return matrizInfo;
    }

    public void agregarArticulo(Double codigo, String nombre, String descripcion, int cantidad, double precio)
            throws SQLException {
        sindb.agregarArticulo(codigo, nombre, descripcion, cantidad, precio);
    }

    public void agregarCliente(String nombre, String cedula) {

    }

    public articulo mostrarArticulo(String codigo) {

        articulo articulo;
        articulo = sindb.mostrarArticulos(codigo);
        return articulo;
    }

    public void ctrlOrdenesCompras(String numeroorden,Double codigo, String nombre, String descripcion, int cantidad, double precio, String cliente, String rnc) throws HeadlessException, SQLException {

	    sindb.ordenDeCompra(numeroorden,codigo,nombre,descripcion,cantidad,precio,cliente,rnc);
    
    }

    public void crtlvender(String numeroOrden){
        sindb.vender(numeroOrden);
    }
}

