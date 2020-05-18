package ProyectoIngenieria;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class Viniciarsesion extends JFrame {

	private JPanel contentPane;
	public static JTextField txtUsuario;
	public static JPasswordField passwordField;
	private Accesos_Clientes datos;
	private Vcrearcuenta crearcuenta;
	private Comprascliente compras;

	public Viniciarsesion() {
		this.setLocation(400, 220);// esto me ajusta para que sea centrado
		setResizable(false);// no se maximise el diseño
		setTitle("Iniciar Sesión");// permite poner nombre a la ventana
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblMemberLogin = new JLabel("Member Login");
		lblMemberLogin.setFont(new Font("Superclarendon", Font.PLAIN, 22));
		lblMemberLogin.setBounds(121, 17, 194, 25);
		contentPane.add(lblMemberLogin);

		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(
				"/Users/adilemdobras/Documents/Captura de Pantalla 2020-04-11 a la(s) 3.57.22 p. m..png"));
		lblNewLabel_1.setBounds(-113, 24, 15, 156);
		contentPane.add(lblNewLabel_1);

		JLabel lblUsuario = new JLabel("Usuario: ");
		lblUsuario.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblUsuario.setBounds(49, 79, 61, 16);
		contentPane.add(lblUsuario);

		txtUsuario = new JTextField();
		txtUsuario.setBounds(140, 74, 130, 26);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		passwordField = new JPasswordField();
		lblPassword.setBounds(49, 131, 71, 16);
		contentPane.add(lblPassword);
		// int tel=Integer.parseInt(window2.telefonos);
		// int cp=Integer.parseInt(window2.cp);
		// DatosCliente datos= new DatosCliente(window2.nombres,
		// window2.apellidos,window2.correos, window2.identificacion,window2.ciudades,
		// tel, cp, window2.paises);
		// datos.getmostrarDatos();
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Administradortabla prueba = new Administradortabla();
				// ruta del nuevo fichero que almacenara la cuenta y contraseña de los usuarios
				String ruta = "fichero-de-cuentasyusuarios.txt";
				// le di un tamaño al fichero
				String[][] matriz = prueba.getlectura_csv(ruta);
				// Realizo la escritura del fichero para que añada a los usuarios
				File file = new File(ruta);
				String data = "";
				/*
				 * try { Scanner reader = new Scanner(file); int i = 0; while
				 * (reader.hasNextLine()) { data = reader.nextLine(); matriz[i] =
				 * data.split(";"); i++; } } catch (FileNotFoundException ee) {
				 * ee.printStackTrace();
				 * 
				 * }
				 */
				int i = 1;
				boolean encontrado = false;
				// Aqui verifico que cuando el usuario intente iniciar sesion exista su cuenta
				// dentro del fichero
				while (!encontrado && i < matriz.length) {
					if (txtUsuario.getText().equals(matriz[i][0])) {
						encontrado = true;
						if (passwordField.getText().equals(matriz[i][1])) {

							// Me llamo al administrador de la tabla
							Accesos_Clientes datos = new Accesos_Clientes("", "", "", "", "", 0, 0, "");
							String rutas = "tableconvert_csv_8oqpav.csv";
							Vcrearcuenta cuentanueva = new Vcrearcuenta();
							String matrizalmacen[][] = prueba.getlectura_csv(rutas);
							Comprascliente compras = new Comprascliente(prueba, "", "", 0, 0, matrizalmacen, rutas);
							JOptionPane.showMessageDialog(null, "Bienvenido al Sistema!");
							compras.Menu_Clientes(compras.getDesicion(), compras.getMatriz(), i);

						}
					}

					i++;
				}
				// me parece un poco tonto crear tres cuentas de manager
				if (!encontrado && txtUsuario.getText().equals("Manager1")) {
					if (passwordField.getText().equals("JKYJQ123")) {
						Manager manager = new Manager(0, 0);
						JOptionPane.showMessageDialog(null, "Bienvenido al Sistema (Manager).");
						manager.getManagerMenu();
					}
				}
				if (!encontrado) {

					JOptionPane.showMessageDialog(null, "Error, usuario o contraseña incorrectos. ");

				}

			}
		});
		btnEntrar.setBounds(288, 215, 117, 29);
		contentPane.add(btnEntrar);
		final Vcrearcuenta window2 = new Vcrearcuenta();
		JButton btnNewButton = new JButton("Crear cuenta");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				window2.setLocationRelativeTo(null);
				window2.setDefaultCloseOperation(window2.EXIT_ON_CLOSE);
				window2.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(52, 215, 117, 29);
		contentPane.add(btnNewButton);

		passwordField = new JPasswordField();
		passwordField.setBounds(140, 126, 130, 26);
		contentPane.add(passwordField);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(
				Viniciarsesion.class.getResource("/Imagen/Captura de Pantalla 2020-04-21 a la(s) 2.06.29 p. m..png")));
		lblNewLabel.setBounds(0, 0, 450, 278);
		contentPane.add(lblNewLabel);
	}
}
