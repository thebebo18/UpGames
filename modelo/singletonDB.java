package modelo;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import vista.*;

public class singletonDB {

	private static final String JDBC_MYSQL_LOCALHOST_3306_DB = "jdbc:mysql://localhost:3306/DB";
	private static singletonDB login;
	static Connection conn = null;
	private String user;
	private String password;

	private singletonDB() {
	}

	public static singletonDB getInstance() {
		if (login == null) {
			login = new singletonDB();
		}
		return login;
	}

	public Connection loginUsers(String usuario, String pass) throws SQLException, ClassNotFoundException {
		this.user = usuario;
		this.password = pass;

		Statement st;
		ResultSet rs;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			conn = DriverManager.getConnection(JDBC_MYSQL_LOCALHOST_3306_DB, "root", "JoseMoreno01");
			st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs = st.executeQuery("SELECT nombreUsuario, codigoUsuario from  DB.Usuarios WHERE nombreUsuario='" + usuario
					+ "' AND codigoUsuario='" + pass + "'");

			int count = 0;

			while (rs.next()) {
				count += 1;
			}
			if (count == 1) {
				conn.close();
				conn = DriverManager.getConnection(JDBC_MYSQL_LOCALHOST_3306_DB, usuario, pass);
				JOptionPane.showMessageDialog(null, "Conectando a la Base de Datos!!!!");

				if (usuario.equals("admin")) {
					menuAdmin menuadmin = new menuAdmin();
					menuadmin.getFrame().setVisible(true);
				} else {
					menu menu = new menu();
					menu.getFrame().setVisible(true);
				}
			} else {

			}

		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e);

		}
		return conn;
	}

	public void desconectarDB() throws SQLException {
		
		try {
			conn = DriverManager.getConnection(JDBC_MYSQL_LOCALHOST_3306_DB, user, password);
			conn.close();
		} catch (SQLException se) {
			if (!se.getSQLState().equals("08006")) {
				throw se;
			}
		}
	}

	public ArrayList<usuario> mostrarSesiones() {

		ArrayList<usuario> listaUsuarios = new ArrayList<usuario>();
		usuario user;
		Statement st;
		ResultSet rs;

		try {
			st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs = st.executeQuery("SELECT registroAccesoNombre, duracionConeccion from DB.RegistroAcceso");

			while (rs.next()) {
				user = new usuario();
				user.setNombreUsuario(rs.getString("registroAccesoNombre"));
				user.setDuracion(rs.getString("duracionConeccion"));
				listaUsuarios.add(user);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaUsuarios;
	}

	public void registrarSesiones(String user, String pass) {
	}

	public articulo mostrarArticulos(String codigo) {

		articulo articulo = null;
		Statement st;
		ResultSet rs;

		try {
			st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs = st.executeQuery("SELECT * from DB.articulos where codigo ='" + codigo + "'");

			while (rs.next()) {
				articulo = new articulo();
				articulo.setCodigo(rs.getDouble("codigo"));
				articulo.setNombre(rs.getString("nombre"));
				articulo.setCantidad(rs.getInt("cantidad"));
				articulo.setDescripcion(rs.getString("descripcion"));
				articulo.setPrecio(rs.getFloat("precio"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return articulo;
	}

	public ArrayList<venta> mostrarVentas() {
		ArrayList<venta> listaVentas = new ArrayList<venta>();

		venta ventas;
		Statement st;
		ResultSet rs;

		try {
			st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs = st.executeQuery("SELECT * from DB.ventas");

			while (rs.next()) {
				ventas = new venta();
				ventas.setCodigo(rs.getDouble("codigo"));
				ventas.setNombre(rs.getString("nombre"));
				ventas.setCantidad(rs.getInt("cantidad"));
				ventas.setDescripcion(rs.getString("descripcion"));
				ventas.setPrecio(rs.getFloat("precio"));
				ventas.setNombreCliente(rs.getString("cliente"));
				ventas.setCedulaCliente(rs.getString("cedula"));
				ventas.setNombreUsuario(rs.getString("nombreusuario"));
				ventas.setFecha(rs.getString("fecha"));

				listaVentas.add(ventas);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaVentas;
	}

	public void agregarArticulo(Double codigo, String nombre, String descripcion, int cantidad,
			double precio) throws SQLException {
		String query = null;
		Statement st = conn.createStatement();
		query = "INSERT INTO Articulos (codigo, nombre, descripcion, cantidad, precio) VALUES(" + "'" + codigo + "', "
				+ "'" + nombre + "', " + "'" + descripcion + "', " + cantidad + ", " + precio + ");";

		if (st.executeUpdate(query) > 0) {
			JOptionPane.showMessageDialog(null, "ARTICULO INGRESADO.");
		} else {
			JOptionPane.showMessageDialog(null, "Error!, AL INGRESAR ARTICULO.");
		}

	}

	public void ordenDeCompra(String numeroorden, Double codigo, String nombre, String descripcion, int cantidad, double precio, String cliente, String rnc) throws HeadlessException, SQLException {
		String query=null;
			Statement st = conn.createStatement();

			query = "INSERT INTO DB.ordenesdecompras (numeroorden,codigo,nombre,descripcion,cantidad,precio,nombreCliente,cedulaCliente) VALUES("+ "'" +numeroorden+ "', " + "'" +codigo+ "', "+"'" +nombre+ "', "+"'" + descripcion+"',"+"'" +cantidad+ "'," +"'"+ precio+ "',"+"'"+cliente+"',"+" '"+rnc+"')";
	
			if (st.executeUpdate(query) > 0) {
				
			} else {
				JOptionPane.showMessageDialog(null, "Error!, AL INGRESAR ORDEN.");	
			}

		}

	public ArrayList<ordenDeCompra> mostrarOrdenes(String numeroOrden){
		ArrayList<ordenDeCompra> listaOrdenes = new ArrayList<ordenDeCompra>();

		ordenDeCompra orden;
		Statement st;
		ResultSet rs;

		try {
			st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs = st.executeQuery("SELECT * from DB.ordenesdecompras WHERE estado = 'hay' AND numeroorden ="+"'"+numeroOrden+"'" );

			while (rs.next()) {
				orden = new ordenDeCompra();
				orden.setNumeroOrden(rs.getString("numeroorden"));
				orden.setCodigo(rs.getDouble("codigo"));
				orden.setNombre(rs.getString("nombre"));
				orden.setCantidad(rs.getInt("cantidad"));
				orden.setDescripcion(rs.getString("descripcion"));
				orden.setPrecio(rs.getFloat("precio"));
				orden.setNombreCliente(rs.getString("cliente"));
				orden.setCedulaCliente(rs.getString("cedula"));
			
				listaOrdenes.add(orden);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaOrdenes;

	}

	public void vender(String numeroOrden){
		Statement st;
		ResultSet rs;

		try {
			st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs = st.executeQuery("UPDATE DB.ordenesdecompras SET estado = vendido WHERE numeroorden ="+"'"+numeroOrden+"'" );

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
}

