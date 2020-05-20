package ProyectoIngenieria;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PrincipalProyecto {

	public static void main(String[] args) {
		 
		
	    
		Viniciarsesion window1 = new Viniciarsesion();
	
	

		window1.setLocationRelativeTo(null);
		window1.setDefaultCloseOperation(window1.EXIT_ON_CLOSE);
		window1.setVisible(true);
		String ruta = "fichero-de-cuentasyusuarios.txt";
		Path rutarelativa1=Paths.get(ruta);
	    Path rutabsoluta1=rutarelativa1.toAbsolutePath();
	   String rutafinal1=String.valueOf(rutabsoluta1); 
	 //  System.out.println(rutafinal1);
		String ruta2= "fichero-de-cuentasyusuarios.txt";
		File fichero= new File(ruta2);
		Path rutarelativa2=Paths.get(ruta2);
		
	  //  Path rutabsoluta1=rutarelativa1.toAbsolutePath();
	   //String rutafinal1=String.valueOf(fichero); 
		System.out.println(fichero.getAbsolutePath());
	}

}
