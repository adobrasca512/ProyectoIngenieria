package ProyectoIngenieria;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

public class Administradortabla {

	public int contarColumnas(String ruta) {
		File fichero = new File(ruta);
		int columnas = 0;

		try {
			Scanner leer = new Scanner(fichero);
			if (leer.hasNextLine()) {
				String linea = leer.nextLine();
				// "1;2;3;4
				columnas = linea.split(";").length;
			}
			leer.close();
		} catch (FileNotFoundException e) {
			System.out.println("Fichero '" + ruta + "' no encontrado!");
		}
		return columnas;
	}

	public static int contarLineas(String ruta) {
		File fichero = new File(ruta);
		int lineas = 0;

		try {
			Scanner leer = new Scanner(fichero);
			while (leer.hasNextLine()) {
				leer.nextLine();
				lineas++;
			}
			leer.close();
		} catch (FileNotFoundException e) {
			System.out.println("Fichero '" + ruta + "' no encontrado!");
		}
		return lineas;
	}

	// mejorar
	public String[][] getlectura_csv(String rutas) {
		int filas = contarLineas(rutas);
		int columnas = contarColumnas(rutas);
		// esto leera ambos csv en donde se heredara esta clase y tomara de parametros
		// los propios de las clases
		// El tamaño de fila de el csv almacenamiento es de 48 y columnas 9
		String[][] matriz = new String[filas][columnas];

		File file = new File(rutas);
		String data = "";
		try {
			Scanner reader = new Scanner(file);
			int i = 0;
			while (reader.hasNextLine()) {
				data = reader.nextLine();
				matriz[i] = data.split(";");
				i++;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();

		}
		return matriz;
	}

	public void getPintarMatriz(String[][] matriz) {
		System.out.println("---------------------------------------");
		for (int i = 1; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				System.out.print("\u274D " + matriz[0][j] + ": " + matriz[i][j] + "\n");
			}
			System.out.println("---------------------------------------");
		}
	}

	public static void getescribirenFichero(String ruta, String[][] Matriz) {
		try {
			FileWriter fichero = new FileWriter(ruta);
			// Escribimos linea a linea en el fichero
			for (int i = 0; i < Matriz.length; i++) {
				for (int j = 0; j < Matriz[0].length; j++) {
					fichero.write(Matriz[i][j] + ";");
				}
				fichero.write("\n");
			}
			fichero.close();
		} catch (Exception ex) {
			System.out.println("Mensaje de la excepción: " + ex.getMessage());
		}
	}

	public String[][] addFila(String ruta) {
		String[][] matriz = getlectura_csv(ruta);
		return addFila(matriz.length, ruta);
	}

	// Añadir la fila en la posición orden
	public String[][] addFila(int orden, String ruta) {

		// String rutas = "tableconvert_csv_0xo8do.csv";
		String[][] matriz = getlectura_csv(ruta);

		// 0: Primera fila
		// csv.length es la última

		// Reservamos espacio para una fila más
		String[][] nuevo_csv = new String[matriz.length + 1][matriz[0].length];

		int correccionFila = 0; // Corregir la fila de lectura

		for (int i = 0; i < nuevo_csv.length; i++) {
			if (i == orden) { // La nueva fila
				for (int j = 0; j < nuevo_csv[0].length; j++) {
					nuevo_csv[i][j] = "" + i;
				}
				correccionFila = -1;
			} else {
				nuevo_csv[i] = matriz[i + correccionFila];
			}
		}
		return nuevo_csv;

	}
}
