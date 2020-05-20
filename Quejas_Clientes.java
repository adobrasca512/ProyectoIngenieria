package ProyectoIngenieria;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Quejas_Clientes {
	private Administradortabla tablaconfigurador;
	private String matriz[][];
	private final String ruta = "quejas-clientes.txt";
	private Comprascliente compras;

	public Quejas_Clientes(Administradortabla tablaconfigurador) {
		super();
		this.tablaconfigurador = tablaconfigurador;
		Path rutarelativa1=Paths.get(ruta);
        Path rutabsoluta1=rutarelativa1.toAbsolutePath();
       String rutafinal1=String.valueOf(rutabsoluta1);
		this.matriz = tablaconfigurador.getlectura_csv(rutafinal1);
	}

	public void getLeerquejas() {
		System.out.println("\nQuejas de Clientes \n");

		System.out.println("---------------------------------------\n");
		tablaconfigurador.getPintarMatriz(this.matriz);
	}
}
