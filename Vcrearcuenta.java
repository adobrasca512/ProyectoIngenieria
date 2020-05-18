package ProyectoIngenieria;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.awt.event.ActionEvent;
import java.util.*;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Vcrearcuenta extends JFrame {

	private JPanel contentPane;
	private JTextField nombre;
	private JTextField apellido;
	private JTextField correo;
	private JTextField codigopostal;
	private JTextField telefono;
	private JTextField usuario;
	private JTextField contrasena;
	private String[][] matrizcontras = new String[30][2];
	private JTextField dni;
	private JTextField ciudad;
	private JTextField pais;
	private JButton btnEntrar = new JButton("Entrar");
	private String nombres;
	private String apellidos;
	private String correos;
	private String telefonos;
	private String cp;
	private String ciudades;
	private String paises;
	private String identificacion;

	public JTextField getCodigopostal() {
		return codigopostal;
	}

	public void setCodigopostal(JTextField codigopostal) {
		this.codigopostal = codigopostal;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCorreos() {
		return correos;
	}

	public void setCorreos(String correos) {
		this.correos = correos;
	}

	public String getTelefonos() {

		return telefonos;
	}

	public void setTelefonos(String telefonos) {
		this.telefonos = telefonos;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public String getCiudades() {
		return ciudades;
	}

	public void setCiudades(String ciudades) {
		this.ciudades = ciudades;
	}

	public String getPaises() {
		return paises;
	}

	public void setPaises(String paises) {
		this.paises = paises;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public Vcrearcuenta() {

		// esto me ajusta para que sea centrado
		setResizable(false);// no se maximise el diseño
		setTitle("Crear Cuenta");// permite poner nombre a la ventana
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 200, 572, 316);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNombre.setBounds(14, 60, 61, 22);
		contentPane.add(lblNombre);

		nombre = new JTextField();
		nombre.setBounds(86, 60, 151, 21);
		contentPane.add(nombre);
		nombre.setColumns(10);

		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setForeground(Color.WHITE);
		lblApellido.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblApellido.setBounds(267, 61, 61, 16);
		contentPane.add(lblApellido);

		apellido = new JTextField();
		apellido.setBounds(350, 55, 168, 26);
		contentPane.add(apellido);
		apellido.setColumns(10);

		JLabel lblCorreo = new JLabel("Correo:");
		lblCorreo.setForeground(Color.WHITE);
		lblCorreo.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblCorreo.setBounds(14, 101, 61, 16);
		contentPane.add(lblCorreo);

		correo = new JTextField();
		correo.setBounds(86, 97, 153, 26);
		contentPane.add(correo);
		correo.setColumns(10);

		JLabel lblCp = new JLabel("CP:");
		lblCp.setForeground(Color.WHITE);
		lblCp.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblCp.setBounds(16, 139, 61, 16);
		contentPane.add(lblCp);

		codigopostal = new JTextField();
		codigopostal.setBounds(86, 135, 153, 26);
		contentPane.add(codigopostal);
		codigopostal.setColumns(10);

		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setForeground(Color.WHITE);
		lblTelefono.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblTelefono.setBounds(266, 98, 61, 16);
		contentPane.add(lblTelefono);

		telefono = new JTextField();
		telefono.setBounds(350, 95, 168, 26);
		contentPane.add(telefono);
		telefono.setColumns(10);

		JLabel lblCrearCuenta = new JLabel("Crear Cuenta");
		lblCrearCuenta.setForeground(Color.WHITE);
		lblCrearCuenta.setFont(new Font("Superclarendon", Font.PLAIN, 22));
		lblCrearCuenta.setBounds(190, 17, 233, 26);
		contentPane.add(lblCrearCuenta);

		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setForeground(Color.WHITE);
		lblUsuario.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblUsuario.setBounds(16, 207, 61, 16);
		contentPane.add(lblUsuario);

		JLabel lblContrasea = new JLabel("Contraseña:");
		lblContrasea.setForeground(Color.WHITE);

		lblContrasea.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblContrasea.setBounds(269, 207, 84, 16);
		contentPane.add(lblContrasea);

		usuario = new JTextField();
		usuario.setBounds(86, 205, 153, 26);
		contentPane.add(usuario);
		usuario.setColumns(10);

		contrasena = new JTextField();
		contrasena.setBounds(348, 204, 168, 26);
		contentPane.add(contrasena);
		contrasena.setColumns(10);

		// CrearCuenta window1= new CrearCuenta();
		JButton btnEntrar = new JButton("Entrar");

		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Viniciarsesion window1 = new Viniciarsesion();
				Administradortabla prueba = new Administradortabla();
				String user = usuario.getText();
				String contra = contrasena.getText();
				
				nombres = nombre.getText();
				apellidos = apellido.getText();
				correos = correo.getText();
				telefonos = telefono.getText();
				cp = codigopostal.getText();
				identificacion = dni.getText();
				paises = pais.getText();
				ciudades = ciudad.getText();
				// Micuenta cuenta = new Micuenta();
				try {
					Accesos_Clientes clientesinfo = new Accesos_Clientes(nombres, apellidos, correos, ciudades, paises,
							Integer.parseInt(telefonos), Integer.parseInt(cp), identificacion);

					String ruta = "tableconvert_csv_0xo8do.csv";

					String matriz[][] = prueba.getlectura_csv(ruta);
				//	prueba.getPintarMatriz(matriz);
					// prueba.getPintarMatriz(clientesinfo.incluirClientes(matriz, nombres,
					// apellidos, correos, ciudades,
					// paises, Integer.parseInt(telefonos), Integer.parseInt(cp), identificacion));
					prueba.getescribirenFichero(ruta, clientesinfo.incluirClientes(matriz, nombres, apellidos, correos,
							ciudades, paises, Integer.parseInt(telefonos), Integer.parseInt(cp), identificacion));

					String rutas = "fichero-de-cuentasyusuarios.txt";
					String[][] matrizNueva = prueba.getlectura_csv(rutas);
                            
					// le di un tamaño al fichero
					// String[][] matriz = new String[30][2];
					// Realizo la escritura del fichero para que añada a los usuarios
					String matriz2[][] = new String[matrizNueva.length + 1][2];
int existe=0;
					for (int i = 0; i < matrizNueva.length; i++) {
						for (int j = 0; j < matrizNueva[0].length; j++) {
							// en la nueva va la anterior
							if(matrizNueva[i][j].equals(user)) {
								existe=-1;
								}
							else{
								matriz2[i][j] = matrizNueva[i][j];
							}
						}
					}
 if(existe ==-1) {
	 JOptionPane.showMessageDialog(null, "La cuenta introducida no esta disponible");
	 usuario.setText("");;
 }else {
	 
	 nombre.setText("");
	 apellido.setText("");
	 correo.setText("");
	 codigopostal.setText("");
	 dni.setText("");
	 ciudad.setText("");
	 pais.setText("");
	 telefono.setText("");
	JOptionPane.showMessageDialog(null, "Datos guardados con exito");
		matriz2[matriz2.length - 1][0] = usuario.getText();
		matriz2[matriz2.length - 1][1] = contrasena.getText();
		String rutacsv = "tableconvert_csv_0xo8do.csv";
		prueba.addFila(rutacsv);
		prueba.getescribirenFichero(rutas, matriz2);

		window1.setVisible(true);
		dispose();
 }
				
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "El codigo postal o el telefono que introdujo no es valido.");
					telefono.setText("");
                    codigopostal.setText("");
				}

			}
		});
		btnEntrar.setBounds(413, 259, 117, 29);
		contentPane.add(btnEntrar);

		JLabel lblDni = new JLabel("Dni:");
		lblDni.setForeground(Color.WHITE);
		lblDni.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblDni.setBounds(269, 139, 61, 16);
		contentPane.add(lblDni);

		dni = new JTextField();
		dni.setBounds(350, 134, 168, 26);
		contentPane.add(dni);
		dni.setColumns(10);

		JLabel lblCiudad = new JLabel("Ciudad:");
		lblCiudad.setForeground(Color.WHITE);
		lblCiudad.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblCiudad.setBounds(16, 170, 61, 16);
		contentPane.add(lblCiudad);

		ciudad = new JTextField();
		ciudad.setBounds(86, 166, 153, 26);
		contentPane.add(ciudad);
		ciudad.setColumns(10);

		JLabel lblPas = new JLabel("País:");
		lblPas.setForeground(Color.WHITE);
		lblPas.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblPas.setBounds(269, 171, 61, 16);
		contentPane.add(lblPas);

		pais = new JTextField();
		pais.setBounds(350, 166, 168, 26);
		contentPane.add(pais);
		pais.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Vcrearcuenta.class.getResource("/Imagen/Captura de Pantalla 2020-05-11 a la(s) 3.37.38 p. m..png")));
		lblNewLabel.setBounds(-63, -69, 763, 363);
		contentPane.add(lblNewLabel);

	}
}
