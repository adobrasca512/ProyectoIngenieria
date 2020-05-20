package ProyectoIngenieria;

import java.io.File;
import java.io.FileWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

import javax.swing.text.StyledEditorKit.ForegroundAction;

public class Comprascliente {
	private Administradortabla tablacliente;
	private String seccion;
	private String articulo;
	private int posicion;
	private ArrayList<String> carrito;
	private ArrayList<Double> carritoprecio;
	private int desicion;
	private String matriz[][];
	private String rutas;
	private String motivo;
	private String productodevuelto;
	private Accesos_Clientes datos = new Accesos_Clientes("", "", "", "", "", 0, 0, "");
	private final String rutaquejas= "quejas-clientes.txt"; 
	Path rutarelativa1=Paths.get(rutaquejas);
    Path rutabsoluta1=rutarelativa1.toAbsolutePath();
   String rutafinal1=String.valueOf(rutabsoluta1);
	private String rutascuentas= "fichero-de-cuentasyusuarios.txt";
	Path rutarelativa2=Paths.get(rutascuentas);
    Path rutabsoluta2=rutarelativa2.toAbsolutePath();
   String rutafinal2=String.valueOf(rutabsoluta2);
	private String[][] matrizquejas ;
	public Comprascliente(Administradortabla tablacliente, String seccion, String articulo, int subdesicion,
			int desicion, String[][] matriz, String rutas) {
		super();
		this.matrizquejas=matrizquejas;
		this.posicion=posicion;
		this.rutas = rutas;
		this.tablacliente = tablacliente;
		this.seccion = seccion;
		this.articulo = articulo;
		this.desicion = desicion;
		this.matriz = matriz;
		
	
		this.tablacliente = new Administradortabla();
		// posicionesCompradas = new ArrayList<Integer>();
		carritoprecio = new ArrayList<Double>();
		carrito = new ArrayList<String>();
		

	}

	public String[][] getMatriz() {
		return matriz;
	}

	public ArrayList<String> getCarrito() {

		return carrito;
	}

	public void setCarrito(ArrayList<String> carrito) {

		this.carrito = carrito;

	}

	public void setMatriz(String[][] matriz) {
		this.matriz = matriz;
	}

	public int getDesicion() {
		return desicion;
	}

	public ArrayList<Double> getCarritoprecio() {
		return carritoprecio;
	}

	public void setCarritoprecio(ArrayList<Double> carritoprecio) {
		this.carritoprecio = carritoprecio;
	}

	public void setDesicion(int desicion) {
		this.desicion = desicion;
	}

	public void Menu_Clientes(int desicion, String[][] matriz, int posicion) {
		Scanner teclado = new Scanner(System.in);
		// Mientras que el usuario exista...
		System.out.println("\t\tBienvenido a la pagina de compras Juice Delicio S.A"
				+ "\n^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^" + "\n   \ud83d\udc64 1. Mi cuenta\n"
				+ "\n   \uD83D\uDC5C 2. Compras\n" + "\n   \ud83d\udcb8 3. Devoluciones\n"
				+ "\n   \ud83d\udcc3 4. Ayuda al Cliente\n"
				+ "\n^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		System.out.print(" \u270E Respuesta: ");

		while (desicion != 10 && teclado.hasNextInt()) {
			desicion = teclado.nextInt();
			// [sodas-2-10%]String posicion= matriz[i][j]

			// Change to switch
			int subdesicion = 0;

			switch (desicion) {
			case 1:

				getDatos(subdesicion, posicion);
				break;
			case 2:
				Comprar(subdesicion, matriz);
				break;
			case 3:
				mensaje(posicion);
				break;
			case 4:
				System.out.println("\nAyuda al cliente: \n\nInformacion de uso:"
						+ "\n*Mi cuenta: \nPodras verificar tus datos u Modificar cualquier dato que desees."
						+ "\n*Compras: \nTe permite realizar compras dentro de Juice Delicio S.A, tambien podras visualizar todo los productos disponibles o simplemente ver categorias"
						+ "especificas."
						+ "\n*Devoluciones: \nTe permite realizar una queja de algun producto que no te satisfaga, sera comunicado directamente con el Manager."
						+ "");
				break;
			default:
				System.out.println("Valor no válido! \ud83d\udeab");
				break;
			// }
			}
			System.out.println(
					"\t\tBienvenido a la pagina de compras Juice Delicio S.A (Presione cualquier letra para salir)."
							+ "\n^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^"
							+ "\n   \ud83d\udc64 1. Mi cuenta\n" + "\n   \uD83D\uDC5C 2. Compras\n"
							+ "\n   \ud83d\udcb8 3. Devoluciones\n"
							+ "\n   \ud83d\udcc3 4. Ayuda al Cliente\n"
							+ "\n^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
			System.out.print(" \u270E Respuesta: ");

		}
		System.out.println("Hasta luego!");
		
		if(this.carrito.size()>0) {
			Envio envio=new Envio(enviomensaje(posicion),datos.getCorreo(posicion));
			envio.enviarMail();
		}
		
	}

	public void getDatos(int subdesicion, int posicion) {

		Scanner teclado = new Scanner(System.in);
		System.out.println("\n 1.Ver datos\n" + "\n 2.Modificar Datos\n" );
		System.out.print(" \u270E Respuesta: ");
		if (teclado.hasNextInt() ) {
			subdesicion = teclado.nextInt();

			switch (subdesicion) {
			case 1:
				System.out.println("\n\n \u276F TUS DATOS: \n");

				datos.getImprimirdatos(posicion);
				break;
			case 2:
				System.out.println("\n\n \u276F MODIFICACIÓN DE DATOS: \n");
				datos.getModificardatos(posicion, tablacliente);
				break;
			

			}
		} else {
			System.out.println("Valor no válido! \ud83d\udeab");
		}

		System.out.println();

	}

	// Esta funcion me muesta las cosas por seccion
	public void Comprar(int subdesicion, String[][] matriz) {
		Scanner teclado = new Scanner(System.in);

		System.out.println(
				"\n 1. Visualisacion total de productos" + "\n 2. Visualisacion por categoria" + "\n 3. Comprar Articulo");
		System.out.print("\n \u270E Respuesta: ");
		if (teclado.hasNextInt()) {
			subdesicion = teclado.nextInt();
			switch (subdesicion) {
			case 1:
				getImpresiontotal();
				// tablacliente.getPintarMatriz(this.matriz);
				break;
			case 2:
				getPorcategoria(this.seccion, matriz);
				break;
			case 3:
				porArticulo(articulo, this.matriz);
				break;
			default:
				System.out.println("Seccion aun no disponible");
				break;
			}
		} else {
			System.out.println("Valor no válido! \ud83d\udeab");
		}
	}

	public String[][] getImpresiontotal() {
		System.out.println("------------------------------------");
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				if (j < 3) {
					System.out.print("\u274D " + this.matriz[0][j] + ": " + this.matriz[i][j] + "\n");

				}
				// aqui solo me mostrara los valores que se deben mostrar al usuario
				if (j > 5 && j < 8) {
					System.out.print("\u274D " + this.matriz[0][j] + ": " + this.matriz[i][j] + "\n");
				}
			}
			System.out.println("------------------------------------");
		}
		return matriz;

	}

	public String[][] getPorcategoria(String seccion, String[][] matrizseccion) {

		Scanner teclado = new Scanner(System.in);
		System.out.println("¿Que categoria deseas visualizar?");// Decir esto mas formal
		System.out.println(
				"[Agua-Bebidas Alcoholicas-Bebidas Isotonicas-Bebidas Gaseosas-Bebidas Energeticas]");
		System.out.print("\n \u270E Respuesta: ");
		seccion = teclado.nextLine();
         int correct=0;
         System.out.println("-------------------------------------------"); 		
		for (int i = 0; i < matrizseccion.length; i++) {
			for (int j = 0; j < matrizseccion[0].length; j++) {

				if (matrizseccion[i][0].equalsIgnoreCase(seccion)) {
                            correct=-1;
					if (j < 3) {
						System.out.print("\u274D " + this.matriz[0][j] + ": " + this.matriz[i][j] + "\n");

					}
					// aqui solo me mostrara los valores que se deben mostrar al usuario
					if (j > 5 && j < 8) {
						System.out.print("\u274D " + this.matriz[0][j] + ": " + this.matriz[i][j] + "\n");
					}
				}
				
			}
			// Hay que arreglar esto
			
			if (matrizseccion[i][0].equalsIgnoreCase(seccion)) {
				System.out.println("-------------------------------------------");
			}

		}
		if(correct!=-1) {
			System.out.println("Sección no encontrada.");
		}
		// Esto molesta? creo que sera util luego ya que tendria las cosas separadas por
		return matrizseccion;
	}

	public void porArticulo(String articulo, String[][] matriz) {
		Scanner teclado = new Scanner(System.in);
		System.out.println("¿Que articulo desea comprar?");
		System.out.print("\n \u270E Respuesta: ");
		this.articulo = teclado.nextLine();
		String producto = "";
		double porcentaje;
		double precio;
		double precios = 0;
		int posicionreducir = 0;
		String matrizcajas="";
		int encontrado=0;
		System.out.print("---------------------------------------\n");
		for (int i = 1; i < this.matriz.length; i++) {
			for (int j = 0; j < this.matriz[0].length; j++) {

				if (this.matriz[i][1].equalsIgnoreCase(this.articulo)) {
                     encontrado=-1;
					if (j < 2) {
						System.out.print("\u274D " + this.matriz[0][j] + ": " + this.matriz[i][j] + "\n");

						producto = this.matriz[i][1];

					}
					// aqui solo me mostrara los valores que se deben mostrar al usuario
					if (j > 5 && j < 8) {
						System.out.print("\u274D " + this.matriz[0][j] + ": " + this.matriz[i][j] + "\n");
						// Precio
						precio = Double.parseDouble(this.matriz[i][6]);

						// Porcentaje
						String cadena = this.matriz[i][7];
						// Aqui quito el simbolo de porcentaje
						String quitar = cadena.substring(0, 3);
						porcentaje = Double.parseDouble(quitar);

						precios = precio + (porcentaje / 100);
                        
					}

					// caja = 3
					posicionreducir = i;
				}
				

			}

		}
		if(encontrado!=-1) {
			System.out.println("EL producto no fue encontrado.");
			
			}
		else {
			int cajas=Integer.parseInt(this.matriz[posicionreducir][3]);
			
			
			 if(cajas<=0) {
				System.out.println("El producto esta agotado,disculpe las molestias.");
				
			}
			else {
				
				Compras(producto, precios);
				
				System.out.print("---------------------------------------\n");

				tablacliente.getescribirenFichero(rutas, getrestarCajas(posicionreducir));

			}
		}
		
		 
		
		
	}

	public  void Compras(String producto, double precios) {
		carrito.add(producto);
		carritoprecio.add(precios);
		String prod="";
		for (int i = 0; i < carrito.size() && i < carritoprecio.size(); i++) {
			System.out.println("Ha insertado el producto: " + carrito.get(i));
			System.out.println("Con un total de " + String.format("%.2f", carritoprecio.get(i)) + " €");
		}
		
	}

	public String[][] getrestarCajas(int posicionreducir) {
		// Si fila y columna están dentro de los limites de la matriz...
		if (posicionreducir < this.matriz.length) {

			// en la nueva va la anterior
			int cajas = Integer.parseInt(this.matriz[posicionreducir][3]);
			// cajas 3
			// cajas 3-1 --> cajas=2
			// numero= 2-->String
			// matriz[posicion][3]==numero
			// numero= 2-->String Valueof(
			// matriznueva[filas][columnas]=numero

			cajas = cajas - 1;
			String nuevototalcajas = "";
			// me imprime un valor menos (no se porque)
			nuevototalcajas = String.valueOf(cajas);

			this.matriz[posicionreducir][3] = nuevototalcajas;

		}

		return matriz;

	}

	public void mensaje(int posicion) {
		boolean encontrado = false;
	
		Scanner teclado = new Scanner(System.in);
		System.out.println("\tEspecifique: ");
		System.out.print("a. Nombre del articulo: ");
		this.productodevuelto = teclado.nextLine();
		for (int i = 0; i < carrito.size(); i++) {
			if (carrito.get(i).equalsIgnoreCase(productodevuelto)) {
				encontrado = true;
				// Hay que verificar si el producto que va a devolver existe

			} else {
				encontrado = false;
			}
		}
		if (encontrado == true) {
			System.out.println("\n  Producto Verificado \u2714\n");
			System.out.print("b. Motivo de la devolucion: ");
			this.motivo = teclado.nextLine();
			getGuardarqueja(productodevuelto, motivo,posicion);
			System.out.println("Queja enviada.");
		} else {
			System.out.println("Este producto no puede ser devuelto debido a que no ha realizado esta compra. \u2718\n");

		}

	}

	public void getGuardarqueja(String productodevuelto, String motivo,int posicion) {
		
		this.matrizquejas= tablacliente.getlectura_csv(rutafinal1);
		
		String[][] matrizusuario = tablacliente.getlectura_csv(rutafinal2);
        String usuario="";
        usuario=matrizusuario[posicion][0];
	
        matrizquejas=tablacliente.addFila(rutafinal1);
		this.matrizquejas[matrizquejas.length-1][0] = productodevuelto;
		this.matrizquejas[matrizquejas.length-1][1] = motivo;
		this.matrizquejas[matrizquejas.length-1][2] = usuario;
		tablacliente.getescribirenFichero(rutafinal1, this.matrizquejas);
	}
	public String enviomensaje(int posicion) {
		int subdesicion;
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		  
		Date date= new Date();
		String mensajetotal="";
		double total=0.0;
		String format="";
				for(int j=0;j<carritoprecio.size();j++) {
					format=String.format("%.2f", carritoprecio.get(j));
				}
		mensajetotal += "Juice Delicio S.A" + "\nDepartamento de facturación:\nDia: "+ dateFormat.format((date)) + "\n\n" 
		+datos.getImprimirdatosCorreo(posicion);
		mensajetotal+="Producto: "+this.carrito+" \nPrecio: "+this.carritoprecio;
		for(int i=0; i < carrito.size() && i<carritoprecio.size();i++) {
			//array[i]=mensajetotal;
			total=this.carritoprecio.get(i)+total;
			
		
		}
		if(carrito.size()>0) {
			System.out.println("Factura enviada.");
				
		}
		mensajetotal+="\n\nFactura Total: "+total;
		//System.out.println(Arrays.toString(array));
		return mensajetotal;
	}
public String toString() {
	
	
	return articulo;
	
}
}