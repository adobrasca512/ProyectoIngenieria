package ProyectoIngenieria;

import java.io.FileWriter;
import java.util.*;

public class Accesos_Clientes {
	private String matriz[][];
	private String matrizUsuarios[][];
	private String nombre;
	private String apellido;
	private String correo;
	private String pais;
	private String ciudad;
	private int telefono;
	private int cp;
	private String dni;
	private String nusuario;
	private String contrasena;
	private Administradortabla usuario;
	private int cantidadInter;
	private int cantidadnacional;
	private final String rutas = "tableconvert_csv_0xo8do.csv";
	private final String rutausuario = "fichero-de-cuentasyusuarios.txt";

	public Accesos_Clientes(String nombre, String apellido, String correo, String pais, String ciudad, int telefono,
			int cp, String dni) {
		super();
		this.cantidadInter = cantidadInter;
		this.cantidadnacional = cantidadnacional;
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.pais = pais;
		this.ciudad = ciudad;
		this.telefono = telefono;
		this.cp = cp;
		this.dni = dni;
		this.usuario = new Administradortabla();
		this.matrizUsuarios = usuario.getlectura_csv(rutausuario);
	}

	public void getImprimirdatos(int posicion) {
		// String rutas = "tableconvert_csv_0xo8do.csv";
		String[][] matriz = usuario.getlectura_csv(rutas);

		for (int j = 0; j < matriz[0].length; j++) {
			System.out.println(matriz[0][j] + ": " + matriz[posicion][j]);
		}

	}

	public String getImprimirdatosCorreo(int posicion) {
		// String rutas = "tableconvert_csv_0xo8do.csv";
		String[][] matriz = usuario.getlectura_csv(rutas);
		String mensaje;

		mensaje = "Cliente: " + matriz[posicion][0] + " " + matriz[posicion][1] + "\nDireccion: " + matriz[posicion][3]
				+ ", " + matriz[posicion][5] + "\n";

		return mensaje;
	}

	public String getNusuario() {
		return nusuario;
	}

	public void setNusuario(String nusuario) {
		this.nusuario = nusuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public void getmostrarDatos() {

		System.out.println(" INFORMACION DEL CLIENTE\n");
		System.out.println("\u27A3 Nombre: " + this.nombre);
		System.out.println("\u27A3 Apellido: " + this.apellido);
		System.out.println("\u27A3 Dni: " + this.dni);
		System.out.println("\u27A3 Correo: " + this.correo);
		System.out.println("\u27A3 telefono: " + this.telefono);
		System.out.println("\u27A3 Ciudad: " + this.ciudad);
		System.out.println("\u27A3 País: " + this.pais);
		System.out.println("\u27A3 C.P: " + this.cp);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCorreo() {
		return correo;
	}
	public String getCorreo(int posicion) {
		String[][] matriz = usuario.getlectura_csv(rutas);
	 String correo=matriz[posicion][7];
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public int getCp() {
		return cp;
	}

	public void setCp(int cp) {
		this.cp = cp;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String[][] incluirClientes(String matriz[][], String nombre, String apellido, String correo, String pais,
			String ciudad, int telefono, int cp, String dni) {

		String matrizNueva[][] = new String[matriz.length + 1][8];

		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				// en la nueva va la anterior
				matrizNueva[i][j] = matriz[i][j];
			}
		}

		matrizNueva[matrizNueva.length - 1][0] = this.nombre;
		matrizNueva[matrizNueva.length - 1][1] = this.apellido;

		matrizNueva[matrizNueva.length - 1][2] = this.dni;

		matrizNueva[matrizNueva.length - 1][3] = this.ciudad;
		String codigopostal = String.valueOf(this.cp);
		matrizNueva[matrizNueva.length - 1][4] = codigopostal;
		matrizNueva[matrizNueva.length - 1][5] = this.pais;
		String tel = String.valueOf(this.telefono);
		matrizNueva[matrizNueva.length - 1][6] = tel;
		matrizNueva[matrizNueva.length - 1][7] = this.correo;
		// cuando se guarde le voy a añadir otra posicion nueva
		usuario.addFila(rutas);
		return matrizNueva;
	}

	public String[][] getModificardatos(int posicion, Administradortabla usuario) {

		Scanner teclado = new Scanner(System.in);
		String desicion = "";
		String rutas = "tableconvert_csv_0xo8do.csv";
		String matriz[][] = usuario.getlectura_csv(rutas);
		// Si fila y columna están dentro de los límites de la matriz...
		System.out.println(
				"¿Cual dato desea modificar? [Nombre, Apellido, Correo, Ciudad, País, Codigo Postal, Telefono, NIF] ");
		desicion = teclado.nextLine();
		if (posicion < matriz.length) {

			if (desicion.equalsIgnoreCase("Nombre")) {
				System.out.print("Nombre: ");
				this.nombre = teclado.nextLine();
				matriz[posicion][0] = this.nombre;
				System.out.println("Dato Modificado.");
			}

			else if (desicion.equalsIgnoreCase("apellido")) {
				System.out.print("Apellido: ");
				this.apellido = teclado.nextLine();
				matriz[posicion][1] = this.apellido;
				System.out.println("Dato Modificado.");
			} else if (desicion.equalsIgnoreCase("dni")) {
				System.out.print("Dni: ");
				this.dni = teclado.nextLine();
				matriz[posicion][2] = this.dni;
				System.out.println("Dato Modificado.");
			} else if (desicion.equalsIgnoreCase("ciudad")) {
				System.out.print("Ciudad: ");
				this.ciudad = teclado.nextLine();
				matriz[posicion][3] = this.ciudad;
				System.out.println("Dato Modificado.");
			} else if (desicion.equalsIgnoreCase("codigo postal")) {
				System.out.print("Codigo postal: ");
				int cod=0;
				if(teclado.hasNextInt()) {
					cod = teclado.nextInt();	
					String codigopostal = String.valueOf(this.cp);
					
					matriz[posicion][4] = codigopostal;
					System.out.println("Dato Modificado.");
				}
				else {
					System.out.println("Lo siento solo se permiten dígitos numericos.");
				}
				
			} else if (desicion.equalsIgnoreCase("pais") || desicion.equalsIgnoreCase("país") ) {
				System.out.print("País: ");
				this.pais = teclado.nextLine();
				matriz[posicion][5] = this.pais;
				System.out.println("Dato Modificado.");
			} else if (desicion.equalsIgnoreCase("telefono")) {
				System.out.print("Telefono: ");
				int telef=0;
				if(teclado.hasNextInt()) {
					telef = teclado.nextInt();	
					String tel = String.valueOf(this.telefono);
					matriz[posicion][6] = tel;
					System.out.println("Dato Modificado.");
				}
				else {
					System.out.println("Lo siento solo se permiten dígitos numericos.");
				}
			} else if (desicion.equalsIgnoreCase("correo")) {
				System.out.print("Correo: ");
				this.correo = teclado.nextLine();
				matriz[posicion][7] = correo;
			System.out.println("Dato Modificado.");
			} else {
				System.out.println("Lo siento, lo introducido no se encuentra como caracteristica en datos. \u2718");
			}
			usuario.getescribirenFichero(rutas, matriz);
		}

		return matriz;
	}

	public boolean getcorreccionFila() {
		Scanner teclado = new Scanner(System.in);
		String eleccion = "";
		boolean eliminar = false;
		System.out.print(" ¿Desea eliminar su cuenta?: ");
		eleccion = teclado.nextLine();
		if (eleccion.equalsIgnoreCase("si")) {
			eliminar = true;
		} else {
			eliminar = false;
		}

		return eliminar;
	}

	public void getcantidadClientestotal(String[][] matriz) {
		for (int i = 1; i < matriz.length; i++) {

			if (matriz[i][5].equalsIgnoreCase("España")) {
				cantidadnacional = cantidadnacional + 1;

			}

			if (!(matriz[i][5].equalsIgnoreCase("España"))) {

				cantidadInter = cantidadInter + 1;
			}

		}
		System.out.println("\n      REGISTRO DE CLIENTES EN SU TOTALIDAD:" + "\n*Cantidad de clientes total: "
				+ (matriz.length - 1));
		System.out.println("*Cantidad de clientes extranjeros: " + cantidadInter);
		System.out.println("*Cantidad de clientes nacionales: " + cantidadnacional);
	}

	public int getCompararClientes(String[][] matriz) {
		System.out.println("\n           CLIENTES NACIONALES: \n\n");

		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				if (matriz[i][5].equalsIgnoreCase("España")) {
					cantidadnacional = cantidadnacional + 1;
					System.out.print("\u274D " + matriz[0][j] + ": " + matriz[i][j] + "\n");
				}

			}
			if ((matriz[i][5].equalsIgnoreCase("España"))) {
				System.out.println("-----------------------------------");

			}
		}
		return cantidadnacional;
	}

	public void getAccederporNombre(String[][] matriz, String nombre, String apellido) {
		Scanner teclado = new Scanner(System.in);
		System.out.println(" Introduzca el Nombre: ");
		nombre = teclado.nextLine();
		System.out.println(" Introduzca el Apellido: ");
		apellido = teclado.nextLine();
		int encontrado = 0;
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				if (matriz[i][0].equalsIgnoreCase(nombre) && matriz[i][1].equalsIgnoreCase(apellido)) {
					encontrado = -1;
					System.out.print("\u274D " + matriz[0][j] + ": " + matriz[i][j] + "\n");
				}

			}
			if (matriz[i][0].equalsIgnoreCase(nombre) && matriz[i][1].equalsIgnoreCase(apellido)) {
				System.out.println("-----------------------------------");

			}

		}

		if (encontrado != -1) {
			System.out.println("Nombre y Apellidos no encontrados.");
		}

	}

	public void getCompararCInterncionales(String[][] matriz) {
		System.out.println("           CLIENTES INTERNACIONALES: \n\n");

		for (int i = 1; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				if (!(matriz[i][5].equalsIgnoreCase("España"))) {

					System.out.print("\u274D " + matriz[0][j] + ": " + matriz[i][j] + "\n");
				}

			}
			if (!(matriz[i][5].equalsIgnoreCase("España"))) {
				System.out.println("-----------------------------------");

			}
		}

	}

}
