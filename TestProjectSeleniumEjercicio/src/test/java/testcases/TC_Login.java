package testcases;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import keyword.GlobalVariable;
import keyword.XpathObjetos;
import logicaNegocio.Accion;

public class TC_Login {

	@Test
	public void ejecutarTCLogin() {
		tcLogin(false);
	}
	
	public static void tcLogin(boolean ejecucionFuncional) {
		
		try {
			
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/driver/chromedriver.exe");
			
			ChromeDriver driver = Accion.obtenerWebDriver();
						
			
			List<String[]> datos = new ArrayList<String[]>();
			
			if(!ejecucionFuncional) {
				datos = Accion.leerCSV(System.getProperty("user.dir") + "/utileria/datafiles/DF_Login.csv");
			} else {
				String[] d = new String[] {"","Admin","admin123"};
				datos.add(d);
			}
			
			for(String[] info : datos) {
				
				driver.get(GlobalVariable.urlEjecucion);
				
				String casoDePrueba = info[0];
				String usuario = info[1];
				String clave = info[2];
				
				if(Accion.verificarElementoPantalla(XpathObjetos.inputUsername.getDato(), GlobalVariable.timeOut)) {
					
					Accion.escribirTexto(XpathObjetos.inputUsername.getElemento("input Username"), usuario, "inputUsername", false);
					
					if(Accion.verificarElementoPantalla(XpathObjetos.inputPassword.getDato(), GlobalVariable.timeOut)) {
						
						Accion.escribirTexto(XpathObjetos.inputPassword.getElemento("input Password"), clave, "inputPassword", false);
						
						if(Accion.verificarElementoPantalla(XpathObjetos.btnLogin.getDato(), GlobalVariable.timeOut)) {
							
							Accion.hacerClick(XpathObjetos.btnLogin.getElemento("btn Login"), "btn Login");
							
							if(Accion.verificarElementoPantalla(XpathObjetos.welcomeProfile.getDato(), GlobalVariable.timeOut)) {
								if(casoDePrueba.equals("Login credenciales validas")) {
									Accion.verificarPantalla("Resultado caso de prueba " + casoDePrueba + " exitoso.", true, true, true);
								} else {
									Accion.verificarPantalla("Resultado caso de prueba " + casoDePrueba + " fallido.", false, true, true);
									
								}
							}
							
							
						}else {
							Accion.verificarPantalla("Boton Login no encontrado. Resultado caso de prueba " + casoDePrueba + " fallido.", false, true, true);
							
						}
						
					} else {
						Accion.verificarPantalla("Elemento Password no encontrado. Resultado caso de prueba " + casoDePrueba + " fallido.", false, true, true);
						
					}
					
				} else {
					Accion.verificarPantalla("Elemento Username no encontrado. Resultado caso de prueba " + casoDePrueba + " fallido.", false, true, true);
					
				}
				
				
			}
			
			

		}catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}finally{
			if(!ejecucionFuncional) {
				System.exit(1);
				
			}
		}
		
		
		
		
	}
	
}
