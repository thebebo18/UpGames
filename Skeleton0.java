
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import controlador.*;
import vista.*;
import modelo.*;

public class Skeleton0 {

	private JFrame frame;
	private JTextField tFUsuario;
	private JTextField tFPassword;
	private JButton btnLogin;

	public JFrame getFrame() {
		return frame;
	}

	public JTextField gettFUsuario() {
		return tFUsuario;
	}

	public JTextField gettFPassword() {
		return tFPassword;
	}

	public JButton getbtnLogin() {
		return btnLogin;
	}

	public Skeleton0() {

		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Ingrese Usuario");
		lblNewLabel.setBounds(26, 151, 102, 14);
		frame.getContentPane().add(lblNewLabel);

		tFUsuario = new JTextField();
		tFUsuario.setBounds(166, 148, 136, 20);
		frame.getContentPane().add(tFUsuario);
		tFUsuario.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Ingrese Password");
		lblNewLabel_1.setBounds(26, 191, 130, 14);
		frame.getContentPane().add(lblNewLabel_1);

		tFPassword = new JTextField();
		tFPassword.setBounds(166, 188, 136, 20);
		frame.getContentPane().add(tFPassword);
		tFPassword.setColumns(10);

		ImageIcon icon = new ImageIcon("icono.png");

		JLabel label2 = new JLabel(icon);
		label2.setBounds(166, 33, 89, 74);
		frame.getContentPane().add(label2);

		JButton btnLogin = new JButton("INGRESAR");
		JButton btnLogin2 = btnLogin;
		btnLogin2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
			
				try {
					ControladorMenu menu = new ControladorMenu();
					menu.ConetionMenu(gettFUsuario().getText(), gettFPassword().getText());
					frame.setVisible(false);
				} catch (SQLException e1) {
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnLogin2.setBounds(166, 227, 108, 23);
		frame.getContentPane().add(btnLogin2);
	}
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Skeleton0 login = new Skeleton0();
		login.frame.setVisible(true);
	}
}