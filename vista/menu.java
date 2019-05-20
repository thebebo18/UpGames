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

public class menu {

	private JFrame frame;
	private JTextField tfBuscarNombreAdmin;
	private JTextField ftBuscarPrecioAdmin;
	private JTextField tfBuscarCodigoAdmin;
	private JTextField tfVentasTotal;
	private JTable table_3;
	private JTextField tfBuscarDespAdmin;
	private JTextField tfBuscarCantidadAdmin;
	private ControladorMenu ctrlmenuAdmin = new ControladorMenu();
	private JTextField tfNombreCliente;
	private JTextField tfRncCliente;
	private articulo articulo;
	private JTextField tfNumeroOrden;
	static ArrayList<ordenDeCompra> listaOrdenes = null;
	DefaultTableModel model ;

	public menu() throws ClassNotFoundException, SQLException {
		
		initialize();
	}
	public JFrame getFrame() {
		return frame;
	}

	private void initialize() throws ClassNotFoundException, SQLException {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 745, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
	
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 83, 719, 358);
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
		
		tfNombreCliente = new JTextField();
		tfNombreCliente.setBounds(502, 100, 202, 20);
		panel.add(tfNombreCliente);
		tfNombreCliente.setColumns(10);
		
		JLabel lblNombre = new JLabel("NOMBRE");
		lblNombre.setBounds(398, 103, 77, 14);
		panel.add(lblNombre);
		
		JLabel lblCedularnc = new JLabel("CEDULA/RNC");
		lblCedularnc.setBounds(398, 142, 94, 14);
		panel.add(lblCedularnc);
		
		tfRncCliente = new JTextField();
		tfRncCliente.setBounds(502, 139, 202, 20);
		panel.add(tfRncCliente);
		tfRncCliente.setColumns(10);
		
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
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("ORDEN", null, panel_2, null);
		panel_2.setLayout(null);

		JButton btnVentasVender = new JButton("VENDER");
		btnVentasVender.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ctrlmenuAdmin.crtlvender(tfNumeroOrden.getText());
			}
		});
		btnVentasVender.setBounds(135, 203, 129, 23);
		panel_2.add(btnVentasVender);

		JLabel lblTotal = new JLabel("TOTAL:");
		lblTotal.setBounds(481, 207, 46, 14);
		panel_2.add(lblTotal);

		tfVentasTotal = new JTextField();
		tfVentasTotal.setText(""+ctrlmenuAdmin.getTotal()+"");
		tfVentasTotal.setBounds(591, 204, 97, 20);
		panel_2.add(tfVentasTotal);
		tfVentasTotal.setColumns(10);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 11, 782, 165);
		panel_2.add(scrollPane_2);

		ImageIcon icon = new ImageIcon("icono.png");

		JLabel lblNewLabel_6 = new JLabel(icon);
		lblNewLabel_6.setBounds(10, 11, 76, 63);
		frame.getContentPane().add(lblNewLabel_6);
		
		tfBuscarDespAdmin = new JTextField();
		tfBuscarDespAdmin.setBounds(452, 27, 234, 20);
		panel.add(tfBuscarDespAdmin);
		tfBuscarDespAdmin.setColumns(10);

		tfBuscarCantidadAdmin = new JTextField();
		tfBuscarCantidadAdmin.setBounds(164, 165, 202, 20);
		panel.add(tfBuscarCantidadAdmin);
		tfBuscarCantidadAdmin.setColumns(10);
		
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

		scrollPane_2.setBounds(10, 11, 782, 165);
		scrollPane_2.setViewportView(table_3);
		panel_2.add(scrollPane_2);
		
		btnNewButton.setBounds(196, 205, 106, 23);
		panel.add(btnNewButton);
		
		JLabel lblCantidad = new JLabel("CANTIDAD");
		lblCantidad.setBounds(20, 168, 89, 14);
		panel.add(lblCantidad);
		
		JLabel lblInsertarDatosDel = new JLabel("INSERTAR DATOS DEL CLIENTE");
		lblInsertarDatosDel.setBounds(455, 75, 231, 14);
		panel.add(lblInsertarDatosDel);
		
		tfNumeroOrden = new JTextField();
		tfNumeroOrden.setBounds(502, 180, 86, 20);
		panel.add(tfNumeroOrden);
		tfNumeroOrden.setColumns(10);

		JLabel lblNumeroOrden = new JLabel("NUMERO ORDEN");
		lblNumeroOrden.setBounds(398, 183, 94, 14);
		panel.add(lblNumeroOrden);
		
	}
	
}

