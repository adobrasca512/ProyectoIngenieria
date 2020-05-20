package ProyectoIngenieria;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Manager {
	private Administradortabla tablaconfiguracion;

	private String matriz[][];
	private String matrizC[][];
	private int subdesicion;
	private int desicion;
	private final String ruta = "tableconvert_csv_8oqpav.csv";
	private final String rutaC = "tableconvert_csv_0xo8do.csv";
	private Accesos_Clientes clientesinfo;
	private String nombre;
	private String apellido;

	public Manager(int desicion, int subdesicion) {
		this.apellido = apellido;
		this.nombre = nombre;
		this.tablaconfiguracion = new Administradortabla();
		Path rutarelativa1=Paths.get(ruta);
        Path rutabsoluta1=rutarelativa1.toAbsolutePath();
       String rutafinal1=String.valueOf(rutabsoluta1);
       //Aqui la ruta 2
       Path rutarelativa2=Paths.get(rutaC);
       Path rutabsoluta2=rutarelativa2.toAbsolutePath();
      String rutafinal2=String.valueOf(rutabsoluta2);
		this.matriz = tablaconfiguracion.getlectura_csv(rutafinal1);
		this.matrizC = tablaconfiguracion.getlectura_csv(rutafinal2);
		this.clientesinfo = new Accesos_Clientes("", "", "", "", "", 0, 0, "");

	}

	public void getManagerMenu() {
Viniciarsesion ventana= new Viniciarsesion();
		Scanner teclado = new Scanner(System.in);
		Estadisticas estadisticas = new Estadisticas(this.tablaconfiguracion, this.matriz);
		Accesos_Productos accessproductos = new Accesos_Productos(tablaconfiguracion);

		System.out.println(
				"\t\tBienvenido a la plataforma de Gestionamiento de la empresa: Juice Delicio S.A (Presione 11 para Salir)\n\n"
						+ "1. Acceder a datos" + "\n\n2. Estadisticas (Capacidad de Almacenamiento)"
						+ "\n\n3. Accesos por Producto"

						+ "\n\n4. Accesos por Clientes");

		System.out.print("\n \u270E Respuesta: ");
		
		while (desicion != 11 && teclado.hasNextInt()) {
			desicion = teclado.nextInt();

			switch (desicion) {
			case 1:

				getAccederdatos(subdesicion);

				break;
			case 2:
				estadisticas.getCapacidadAlmacenamiento();
				break;
			case 3:

				getAccesosProductos(subdesicion, accessproductos);
				break;
			case 4:
				getAccesosclientes(subdesicion);
				break;

			default:

				System.out.println("El valor introducido no es valido");
				break;
			}

			System.out.println(
					"\t\tBienvenido a la plataforma de Gestionamiento de la empresa: Juice Delicio S.A (Presione 11 para Salir)\n\n"
							+ "1. Acceder a datos" + "\n\n2. Estadisticas (Capacidad de Almacenamiento)"
							+ "\n\n3. Accesos por Producto"

							+ "\n\n4. Accesos por Clientes");

			System.out.print("\n \u270E Respuesta: ");

		}

		System.out.println("\n¡Hasta luego!");

	}

	public void getAccesosclientes(int subdesicion) {
		Quejas_Clientes quejas = new Quejas_Clientes(tablaconfiguracion);
		Scanner teclado = new Scanner(System.in);
		System.out.println("\t1. Clientes Insatisfechos. " + "\n\n\t2. Comparaciones por clientes."
				+ "\n\n\t3. Busqueda de Clientes." + "\n\n\t4. Cantidad de Clientes en la Empresa.");
		System.out.print("\n \u270E Respuesta: ");
		if (teclado.hasNextInt()) {
			subdesicion=teclado.nextInt();
			switch (subdesicion) {
			case 1:
				quejas.getLeerquejas();
				break;
			case 2:
				getCompararClientes();
				break;
			case 3:
				clientesinfo.getAccederporNombre(matrizC, nombre, apellido);
				break;
			case 4:
				clientesinfo.getcantidadClientestotal(matrizC);
				break;
			}
		} else {
			System.out.println("Respuesta no valida. \ud83d\udeab");
		}
	}

	public void getAccederdatos(int subdesicion) {
		Scanner teclado = new Scanner(System.in);
		System.out.println("\t1. Visualizar Datos de Almacenamiento. " + "\n\n\t2. Visualizar Datos de Clientes.");
		System.out.print("\n \u270E Respuesta: ");
		if (teclado.hasNextInt()) {
			subdesicion = teclado.nextInt();
			switch (subdesicion) {
			case 1:
				System.out.println("\n\n ALMACEN:\n");
				tablaconfiguracion.getPintarMatriz(matriz);
				break;
			case 2:
				System.out.println("\n\n CLIENTES: ");
				tablaconfiguracion.getPintarMatriz(matrizC);
				break;
			}

		} else {
			System.out.println("Respuesta no valida. \ud83d\udeab");
		}

	}

	public void getCompararClientes() {
		Scanner teclado = new Scanner(System.in);
		System.out.println(
				"\t1. Mostrar Clientes Internacionales solamente." + "\n\n\t2. Mostrar Clientes Nacionales solamente.");
		System.out.print("\n \u270E Respuesta: ");
		if (teclado.hasNextInt()) {
			subdesicion = teclado.nextInt();
			switch (subdesicion) {
			case 1:
				clientesinfo.getCompararCInterncionales(matrizC);
				break;
			case 2:
				clientesinfo.getCompararClientes(matrizC);

				break;
			}
		} else {
			System.out.println("Respuesta no valida. \ud83d\udeab");
		}
	}

	public void getAccesosProductos(int subdesicion, Accesos_Productos accessproductos) {
		Scanner teclado = new Scanner(System.in);
		System.out.println("\n\n\t1. Incrementar productos" + "\n\n\t2. Incrementar Precios por alta demanda."
				+ "\n\n\t3. Reducir Precios por baja demanda." + "\n\n\t4. Modificacion de productos");
		System.out.print("\n \u270E Respuesta: ");
		
		if (teclado.hasNextInt()) {
			subdesicion = teclado.nextInt();
			switch (subdesicion) {
			case 1:
				accessproductos.getIncrementarMercancia();
				break;
			case 2:
				accessproductos.getIncrementarPrecio();
				break;
			case 3:
				accessproductos.getBajarPrecio();
				break;
			case 4:
				accessproductos.getModificarProducto();
				break;
			case 5:
				clientesinfo.getcantidadClientestotal(matrizC);
				break;
			}
		} else {
			System.out.println("Respuesta no valida. \ud83d\udeab");
			
		}
	}
}
