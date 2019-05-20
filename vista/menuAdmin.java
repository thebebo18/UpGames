package vista;

import controlador.*;
import modelo.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.HeadlessException;

public class menuAdmin {

	private JFrame frame;
	private JTextField tfBuscarNombreAdmin;
	private JTextField ftBuscarPrecioAdmin;
	private JTextField tfBuscarCodigoAdmin;
	private JTextField tfAgregarNombre;
	private JTextField tfAgregarCantidad;
	private JTextField tfAgregarPrecio;
	private String user;
	private JTextField tfVentasTotal;
	private JTable table_1;
	private JTable table_3;
	private JTextField tfDescripcion;
	private JTextField tfBuscarDespAdmin;
	private JTextField tfBuscarCantidadAdmin;
	private ControladorMenu ctrlmenuAdmin = new ControladorMenu();
	private JTextField tfAgregarCodigo;
	private JTextField tfNombreCliente;
	private JTextField tfRncCliente;
	private articulo articulo = new articulo();
	static ArrayList<ordenDeCompra> listaOrdenes = null;
	DefaultTableModel model ;

	public menuAdmin() throws ClassNotFoundException, SQLException {

		initialize(user);
	}

	public JFrame getFrame() {
		return frame;
	}

	private void initialize(String user) throws ClassNotFoundException, SQLException {

		frame = new JFrame();
		frame.setBounds(100, 100, 833, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 83, 807, 358);
		frame.getContentPane().add(tabbedPane);

		JPanel panel = new JPanel();
		tabbedPane.addTab("BUSCAR", null, panel, null);
		panel.setLayout(null);

		tfBuscarCodigoAdmin = new JTextField();
		tfBuscarCodigoAdmin.setBounds(164, 27, 202, 20);
		panel.add(tfBuscarCodigoAdmin);
		tfBuscarCodigoAdmin.setColumns(10);

		tfBuscarNombreAdmin = new JTextField();
		tfBuscarNombreAdmin.setBounds(164, 72, 202, 20);
		panel.add(tfBuscarNombreAdmin);
		tfBuscarNombreAdmin.setColumns(10);
		ftBuscarPrecioAdmin = new JTextField();
		ftBuscarPrecioAdmin.setBounds(164, 121, 202, 20);

		panel.add(ftBuscarPrecioAdmin);
		ftBuscarPrecioAdmin.setColumns(10);

		JLabel lblIngresarCodigo = new JLabel("INGRESAR CODIGO");
		lblIngresarCodigo.setBounds(20, 30, 115, 14);
		panel.add(lblIngresarCodigo);

		JLabel lblNewLabel = new JLabel("NOMBRE");
		lblNewLabel.setBounds(20, 75, 89, 14);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_2 = new JLabel("PRECIO");
		lblNewLabel_2.setBounds(20, 124, 46, 14);
		panel.add(lblNewLabel_2);

		JLabel lblDescripcion = new JLabel("DESCRIPCION");
		lblDescripcion.setBounds(455, 11, 106, 14);

		panel.add(lblDescripcion);

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("AGREGAR", null, panel_1, null);
		panel_1.setLayout(null);

		tfAgregarNombre = new JTextField();
		tfAgregarNombre.setBounds(154, 92, 209, 20);
		panel_1.add(tfAgregarNombre);
		tfAgregarNombre.setColumns(10);

		tfAgregarCantidad = new JTextField();
		tfAgregarCantidad.setBounds(154, 130, 209, 20);
		panel_1.add(tfAgregarCantidad);
		tfAgregarCantidad.setColumns(10);

		tfAgregarPrecio = new JTextField();
		tfAgregarPrecio.setBounds(154, 173, 209, 20);
		panel_1.add(tfAgregarPrecio);
		tfAgregarPrecio.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("NOMBRE");
		lblNewLabel_1.setBounds(30, 95, 80, 14);
		panel_1.add(lblNewLabel_1);

		JLabel lblNewLabel_3 = new JLabel("CANTIDAD");
		lblNewLabel_3.setBounds(30, 133, 80, 14);
		panel_1.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("PRECIO");
		lblNewLabel_4.setBounds(30, 176, 46, 14);
		panel_1.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("DESCRIPCION");
		lblNewLabel_5.setBounds(438, 36, 112, 14);
		panel_1.add(lblNewLabel_5);

		JButton btnAgregarAgregar = new JButton("AGREGAR");
		btnAgregarAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String text = tfAgregarCantidad.getText();
				int cantidad = Integer.parseInt(text);

				String text2 = tfAgregarPrecio.getText();
				double precio = Double.parseDouble(text2);
				try {
					ctrlmenuAdmin.agregarArticulo(Double.parseDouble(tfAgregarCodigo.getText()),
							tfAgregarNombre.getText(), tfDescripcion.getText(), cantidad, precio);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnAgregarAgregar.setBounds(615, 225, 89, 23);
		panel_1.add(btnAgregarAgregar);

		tfDescripcion = new JTextField();
		tfDescripcion.setBounds(434, 65, 224, 20);
		panel_1.add(tfDescripcion);
		tfDescripcion.setColumns(10);

		JTextField tfNumeroOrden = new JTextField();
		tfNumeroOrden.setBounds(526, 178, 99, 20);
		panel.add(tfNumeroOrden);
		tfNumeroOrden.setColumns(10);

		tfAgregarCodigo = new JTextField();
		tfAgregarCodigo.setBounds(155, 50, 208, 20);
		panel_1.add(tfAgregarCodigo);
		tfAgregarCodigo.setColumns(10);

		JLabel lblCodigo = new JLabel("CODIGO");
		lblCodigo.setBounds(30, 53, 46, 14);
		panel_1.add(lblCodigo);

		JButton btnNewButton_3 = new JButton("BUSCAR");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (tfBuscarCodigoAdmin.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "ERROR Campo vacio");

				} else {

					articulo = ctrlmenuAdmin.mostrarArticulo(tfBuscarCodigoAdmin.getText());
					tfBuscarNombreAdmin.setText(articulo.getNombre());
					tfBuscarDespAdmin.setText(articulo.getDescripcion());
					ftBuscarPrecioAdmin.setText(String.valueOf(articulo.getPrecio()));
					tfBuscarCantidadAdmin.setText(String.valueOf(articulo.getCantidad()));

				}
			}
		});
		btnNewButton_3.setBounds(20, 205, 89, 23);
		panel.add(btnNewButton_3);

		tfBuscarDespAdmin = new JTextField();
		tfBuscarDespAdmin.setBounds(452, 27, 234, 20);
		panel.add(tfBuscarDespAdmin);
		tfBuscarDespAdmin.setColumns(10);

		tfBuscarCantidadAdmin = new JTextField();
		tfBuscarCantidadAdmin.setBounds(164, 165, 202, 20);
		panel.add(tfBuscarCantidadAdmin);
		tfBuscarCantidadAdmin.setColumns(10);

		JLabel lblCantidad = new JLabel("CANTIDAD");
		lblCantidad.setBounds(20, 168, 89, 14);
		panel.add(lblCantidad);

		JLabel lblNumeroOrden = new JLabel("NUMERO ORDEN");
		lblNumeroOrden.setBounds(410, 181, 106, 14);
		panel.add(lblNumeroOrden);

		JLabel lblIngresarDatosDel = new JLabel("INGRESAR DATOS DEL CLIENTE");
		lblIngresarDatosDel.setBounds(455, 58, 231, 14);
		panel.add(lblIngresarDatosDel);

		tfNombreCliente = new JTextField();
		tfNombreCliente.setBounds(529, 100, 231, 20);
		panel.add(tfNombreCliente);
		tfNombreCliente.setColumns(10);

		JLabel lblNombre = new JLabel("NOMBRE");
		lblNombre.setBounds(440, 100, 77, 14);
		panel.add(lblNombre);

		JLabel lblCedularnc = new JLabel("CEDULA/RNC");
		lblCedularnc.setBounds(425, 146, 94, 14);
		panel.add(lblCedularnc);

		tfRncCliente = new JTextField();
		tfRncCliente.setBounds(529, 143, 231, 20);
		panel.add(tfRncCliente);
		tfRncCliente.setColumns(10);

		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("ORDEN", null, panel_2, null);
		panel_2.setLayout(null);

		JButton btnVentasVender = new JButton("VENDER");
		btnVentasVender.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrlmenuAdmin.crtlvender(tfNumeroOrden.getText());
			}
		});
		btnVentasVender.setBounds(153, 203, 127, 23);
		panel_2.add(btnVentasVender);

		JLabel lblTotal = new JLabel("TOTAL:");
		lblTotal.setBounds(481, 207, 46, 14);
		panel_2.add(lblTotal);

		tfVentasTotal = new JTextField();
		tfVentasTotal.setText("" + ctrlmenuAdmin.getTotal() + "");
		tfVentasTotal.setBounds(591, 204, 97, 20);
		panel_2.add(tfVentasTotal);
		tfVentasTotal.setColumns(10);

		// ORDENES DE VENTAS

		JButton btnNewButton = new JButton("SELECIONAR");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					ctrlmenuAdmin.ctrlOrdenesCompras(tfNumeroOrden.getText(),
							Double.parseDouble(tfBuscarCodigoAdmin.getText()), tfBuscarNombreAdmin.getText(),
							tfBuscarDespAdmin.getText(), Integer.parseInt(tfBuscarCantidadAdmin.getText()),
							Double.parseDouble(ftBuscarPrecioAdmin.getText()), tfNombreCliente.getText(),
							tfRncCliente.getText());

							model.addRow(new Object[]{tfBuscarCodigoAdmin.getText(),tfBuscarNombreAdmin.getText(),tfBuscarDespAdmin.getText(),Integer.parseInt(tfBuscarCantidadAdmin.getText()),Double.parseDouble(ftBuscarPrecioAdmin.getText())});

							int totalRow = table_3.getRowCount();
							totalRow -= 1;
							double total = 0, sumatoria = 0, sumatoria1 = 0, cantidad = 0, cantidad1 = 0;
					
							for (int i = 0; i <= (totalRow); i++) {
								sumatoria = Double.parseDouble(String.valueOf(table_3.getValueAt(i, 4)));
								cantidad = Double.parseDouble(String.valueOf(table_3.getValueAt(i, 3)));
								cantidad1 += cantidad;
								sumatoria1 += sumatoria;
								total += cantidad1 * sumatoria1;
							}
					
							tfVentasTotal.setText(String.valueOf(total));
					
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnNewButton.setBounds(196, 205, 106, 23);
		panel.add(btnNewButton);

		model = new DefaultTableModel();
		table_3 = new JTable(model);
		model.addColumn("CODIGO");
		model.addColumn("NOMBRE");
		model.addColumn("DESCRIPCION");
		model.addColumn("CANTIDAD");
		model.addColumn("PRECIO");

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 11, 782, 165);
		scrollPane_2.setViewportView(table_3);
		panel_2.add(scrollPane_2);
		
		ImageIcon icon = new ImageIcon("icono.png");

		JLabel lblNewLabel_6 = new JLabel(icon);
		lblNewLabel_6.setBounds(10, 11, 76, 63);
		frame.getContentPane().add(lblNewLabel_6);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("SESIONES", null, panel_3, null);
		panel_3.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(135, 11, 452, 155);
		panel_3.add(scrollPane);

		table_1 = new JTable();
		table_1 = ctrlmenuAdmin.ctrlSesiones();
		scrollPane.setViewportView(table_1);
		
		JButton btnAceptar = new JButton("ACEPTAR");
		btnAceptar.setBounds(498, 271, 89, 23);
		panel_3.add(btnAceptar);
		
	}
	
}