package ProyectoIngenieria;

import java.text.SimpleDateFormat;
import java.util.*;

public class Accesos_Productos {
	private Administradortabla tablaconfigurador;
	private String matriz[][];
	private final String ruta = "tableconvert_csv_8oqpav.csv";
	private String articulo;
	private String seccion;
	private String descripcion;
	private String cajas;
	private String unidades;
	private String precio_in;
	private String precio_out;
	private String fecha_in;
	private String fecha_out;
	private String iva;
   
    
	public Accesos_Productos(Administradortabla tablaconfigurador) {
		super();

		this.descripcion = descripcion;
		this.articulo = articulo;
		this.seccion = seccion;
		this.cajas = cajas;
		this.unidades = unidades;
		this.precio_in = precio_in;
		this.precio_out = precio_out;
		this.fecha_in = fecha_in;
		this.fecha_out = fecha_out;
		this.iva = iva;
		this.articulo = articulo;
		this.tablaconfigurador = tablaconfigurador;
		this.matriz = tablaconfigurador.getlectura_csv(ruta);
		

	}

	public String[][] getIncrementarPrecio() {

		int[][] matrizcajas = new int[this.matriz.length][this.matriz[0].length];
		double matrizPreciout = 0.00;
		String preciofinal = "";
		double ganancias = 0;
		for (int i = 1; i < matriz.length; i++) {

			matrizcajas[i][3] = Integer.parseInt(matriz[i][3]);
			// Si alguna caja es menor que 6
			if (matrizcajas[i][3] < 6 && matrizcajas[i][3] > 0) {
				// pasamos la matriz en la posicion de precios a doubles
				matrizPreciout = Double.parseDouble(matriz[i][6]);
				// Asigno cuanto hay que aumentarle de precio
				matrizPreciout = matrizPreciout + (0.10);
				// cambio ese precio modificado a string
				preciofinal = String.valueOf(String.format("%.2f", matrizPreciout));
				// le digo a la matriz que el valor devuelto va a ser el nuevo valor
				this.matriz[i][6] = preciofinal;
				// modificamos el fichero

			}

		}
		tablaconfigurador.getescribirenFichero(ruta, this.matriz);
		System.out.println("      \n\n Tabla Actualizada:\n");
		tablaconfigurador.getPintarMatriz(this.matriz);
		return matriz;
	}

	// Averiguar como reducirlo con una formula, es decir que no sean 50c
	public String[][] getBajarPrecio() {
		matriz = tablaconfigurador.getlectura_csv(ruta);
		int[][] matrizcajas = new int[this.matriz.length][this.matriz[0].length];
		double matrizPreciout = 0.00;
		double matrizPrecios=0.0;
		String preciofinal = "";
		int fueraalcance = 0;
		int posicion = 0;
		for (int i = 1; i < matriz.length; i++) {

			matrizcajas[i][3] = Integer.parseInt(matriz[i][3]);
			// digamos que el precio es 0.35
			// entonces si el que es menor de 0.35 posee 45 cajas debe reducirle menos
			// Si alguna caja es mayor que 40
			if (matrizcajas[i][3] > 20) {
				// pasamos la matriz en la posicion de precios a doubles
				// matrizPreciout = Double.parseDouble(matriz[i][6]);
				matrizPrecios = Double.parseDouble(matriz[i][6]);
				// Asigno cuanto hay que disminuirle de precio
				// Hay que reducirle un precio efectuado de una formula
				// modificamos el fichero
				if (matrizPrecios < 0.20) {
					fueraalcance = -1;
					System.out.println("El objeto " + matriz[i][1]
							+ " no se le puede reducir el precio debido a que ya esta a su nivel mas bajo.");

				} else if(matrizPrecios > 0.20){
					matrizPrecios = matrizPrecios - (0.10);
					// cambio ese precio modificado a string

					// Le agrego una funcion para que me baje la cantidad de decimales
					
					 preciofinal= String.valueOf(String.format("%.2f", matrizPrecios));
					// le digo a la matriz que el valor devuelto va a ser el nuevo valor
					 this.matriz[i][6]=preciofinal;
				}

			}

		}
		

		tablaconfigurador.getescribirenFichero(ruta, this.matriz);

		System.out.println("      \n\n Tabla Actualizada:\n");
		tablaconfigurador.getPintarMatriz(this.matriz);

		return matriz;
	}

	// Lo hacemos por demanda?? que cuando sea poco solicitado sugerir modificarlo
	public String[][] getModificarProducto() {
		Scanner teclado = new Scanner(System.in);
		System.out.print("\n\u2750 ¿ Que producto desea cambiar? :");
		articulo = teclado.nextLine();
		int posicion = 0;
		boolean encontrado = false;
		boolean error=false;
		
		// RECORDAR QUE HAY QUE VALIDAR LA FECHA SI ESTA EN EL FORMATO QUE QUIERO
		for (int i = 0; i < matriz.length; i++) {

			// en la nueva va la anterior
			if (matriz[i][1].equalsIgnoreCase(articulo)) {

				// Me guardo la posicion para utilizarla luego
				posicion = i;
				encontrado = true;
			}

		}
		if (encontrado == true) {
			System.out.println("\n Producto Validado \u2714 \n");
			// saco la posicion y cambio sus valores
			// CUESTION: AÑADE EN LA SECCION DEL ARTICULO, SIN E
			
			System.out.print(" \u2750 Articulo: ");
			this.articulo = teclado.nextLine();
			this.matriz[posicion][1] = this.articulo;
			System.out.print(" \u2750 Descripcion: ");
			this.descripcion = teclado.nextLine();
			this.matriz[posicion][2] = this.descripcion;
			System.out.print(" \u2750 Cajas: ");
			int cajas = 0;
			if (teclado.hasNextInt()) {

				cajas = teclado.nextInt();
				this.cajas = String.valueOf(cajas);
				matriz[posicion][3] = this.cajas;

				System.out.print(" \u2750 Unidades: ");
				int unidades = 0;
				if (teclado.hasNextInt()) {
					unidades = teclado.nextInt();
					this.unidades = String.valueOf(unidades);
					matriz[posicion][4] = this.unidades;
					System.out.print(" \u2750 Precio_in: ");
					double precio_in = 0.0;
					if (teclado.hasNextDouble()) {
						precio_in = teclado.nextDouble();
						this.precio_in = String.valueOf(precio_in);
						this.precio_in = String.format("%.2f", precio_in);

						matriz[posicion][5] = this.precio_in;
						System.out.print(" \u2750 Precio_out: ");
						double precio_out = 0.0;
						if (teclado.hasNextDouble()) {
							precio_out = teclado.nextDouble();
							this.precio_out = String.valueOf(precio_out);
							this.precio_out = String.format("%.2f", precio_out);

							matriz[posicion][6] = this.precio_out;
							System.out.print(" \u2750 I.V.A: ");
							double ivas = 0.00;
							if (teclado.hasNextDouble()) {
								ivas = teclado.nextDouble();
								this.iva = String.valueOf(ivas);
								iva = String.format("%.2f", ivas);

								matriz[posicion][7] = this.iva + "%";
								System.out.print(" \u2750 Fecha_in: Formato(dd/mm/aa) \n");
								int dia = 0;
								int mes = 0;
								int anio = 0;
								System.out.print(" Dia: ");
								if (teclado.hasNextInt()) {
									dia = teclado.nextInt();
									System.out.print(" Mes: ");
									if (teclado.hasNextInt()) {
										mes = teclado.nextInt();
										System.out.print(" Año: ");
										if (teclado.hasNextInt()) {
											anio = teclado.nextInt();
											anio = anio - 1900;
											mes = mes - 1;
											Date fecha = new Date(anio, mes, dia);
											SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
											this.fecha_in = formatter.format(fecha);

											matriz[posicion][8] = this.fecha_in;
											System.out.print(" \u2750 Fecha_out: Formato(dd/mm/aa)\n");
											int dia1 = 0;
											int mes1 = 0;
											int anio1 = 0;

											System.out.print(" Dia: ");

											if (teclado.hasNextInt()) {
												dia1 = teclado.nextInt();
												System.out.print(" Mes: ");
												if (teclado.hasNextInt()) {
													mes1 = teclado.nextInt();
													System.out.print(" Año: ");
													if (teclado.hasNextInt()) {
														anio1 = teclado.nextInt();
														anio1 = anio1 - 1900;
														mes1 = mes1 - 1;
														SimpleDateFormat formatter1 = new SimpleDateFormat(
																"dd/MM/yyyy");
														this.fecha_out = formatter.format(fecha);

														matriz[posicion][9] = this.fecha_out;
														System.out.println("\nProducto Modificado.");
													} else {
														System.out.println("Formato no valido.");
														error=true;
													}
												} else {
													System.out.println("Formato no valido.");
													error=true;
												}
											} else {
												System.out.println("Formato no valido.");
												error=true;
											}

										} else {
											System.out.println("Formato no valido.");
											error=true;
										}
									}
								} else {
									System.out.println("Formato no valido.");
									error=true;
								}
							} else {
								System.out.println("Formato no valido.");
								error=true;
							}
						} else {
							System.out.println("Formato no valido.");
							error=true;
						}
					} else {
						System.out.println("Formato no valido.");
						error=true;
					}
				} else {
					System.out.println("Formato no valido.");
					error=true;
				}
			} else {
				System.out.println("Formato no valido.");
				error=true;
				
			}
			tablaconfigurador.getescribirenFichero(ruta, this.matriz);
			if(error==true){
				System.out.println("\nSe actualizo el formato hasta el ultimo digito valido. \n¿Desea ver la tabla actualizada? (si/no)");
			String desicion="";
			//Nota tuve que poner doble teclado ya que el propio java tenia un bug y no queria leerme uno
			desicion=teclado.nextLine();
			desicion=teclado.nextLine();
			if(desicion.equalsIgnoreCase("si")) {
				
				System.out.println("      \n\n Tabla Actualizada:\n");
				tablaconfigurador.getPintarMatriz(matriz);
			}
			
			}
			
		} else if (encontrado == false) {
			System.out.println("\nEl producto no se encuentra dentro del fichero \u2717\n");

		}

		// cuando se guarde le voy a añadir otra posicion nueva
		return matriz;
	}

	public String[][] getIncrementarMercancia() {
		int incCajas[][] = new int[this.matriz.length][this.matriz[0].length];
		double incPrecio[][] = new double[this.matriz.length][this.matriz[0].length];
		int sumaCajas = 0;
		int maxcapacidad = 0;
		int sumaActualizada = 0;
		int total = 0;
		// La inicializo en 1 porque no puede leer la primera linea que contiene letras
		for (int i = 1; i < matriz.length; i++) {
			// Esto lo que hace es pasar las filas cajas a un int
			incCajas[i][3] = Integer.parseInt(matriz[i][3]);
			sumaCajas = incCajas[i][3] + sumaCajas;

			// Comprobamos que la mercancia se menor que la capacidad maxima
			if (sumaCajas < 3000) {
				maxcapacidad = 0;

				// Aqui le aumentamos 10 cajas
				incCajas[i][3] = incCajas[i][3] + 10;
				sumaActualizada = incCajas[i][3] + sumaActualizada;
				if (sumaActualizada > 3000) {
					total = (3000 - sumaActualizada) / 47;
					incCajas[i][3] = incCajas[i][3] - total;
				}

				// Aqui pasamos la fila de precios a dobles
				incPrecio[i][5] = Double.parseDouble(matriz[i][5]);
				// Aqui le sumamos el mismo precio al precio de entrada, ya que supongamos que
				// vale lo mismo
				incPrecio[i][5] = incPrecio[i][5] + incPrecio[i][5];
				// pasamos las filas a String
				matriz[i][3] = String.valueOf(incCajas[i][3]);
				// pasamos las filas a String
				matriz[i][5] = String.valueOf(incPrecio[i][5]);
				// Llamo a un metodo que me calcula el dia
				Date fecha = new Date();
				// Esta clase har que se imprima en el formato dd/mm/yy
				SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
				// pasamos la fecha a string
				String fechaactual = formatter.format(fecha);
				// Colocamos la nueva fecha en la posicion que quiero
				matriz[i][8] = fechaactual;
			} else {
				maxcapacidad = -1;
			}

		}
		if (maxcapacidad == -1) {
			System.out
					.println("¡ALERTA! El almacen esta en su capacidad máxima, NO SE PUEDE INCREMENTAR LA MERCANCIA.");
		} else {
			System.out
					.println("Se tuvo que hacer una reduccion de: " + total + " por la capacidad de almacenamiento.\n");

			tablaconfigurador.getescribirenFichero(ruta, this.matriz);

			System.out.println("-.-.-.-.-.-.-.-.-.- Almacen Actualizado -.-.-.-.-.-.-.-.-.-");
			tablaconfigurador.getPintarMatriz(this.matriz);
		}

		return matriz;
	}
}
