package metodosUtiles;

import org.testng.Reporter;

public class utiles {
	public static void reportes (String mensaje) {
		Reporter.log(mensaje);//Este es para reportar en chromo
		System.out.println(mensaje); //Este es para que escriba en consola
	}

}