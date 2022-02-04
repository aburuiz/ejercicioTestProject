package testcases;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import keyword.GlobalVariable;
import keyword.XpathObjetos;
import logicaNegocio.Accion;
import testcases.TC_Login;

public class TC_CrearUsuario {

	@Test
	public void ejecutarTCLogin() {
		tcCrearUsuario(false);
	}
	
	public static void tcCrearUsuario(boolean ejecucionFuncional) {
		
		TC_Login.tcLogin(true);
		
		try {
			ChromeDriver driver = Accion.obtenerWebDriver();
			//DETENCION POR FALLO DE CREDENCIALES
			Thread.sleep(8000);
			List<String[]> datos = new ArrayList<String[]>();
			datos = Accion.leerCSV(System.getProperty("user.dir") + "/utileria/datafiles/DF_CrearUsuario.csv");
			
			
			for(String[] dato : datos) {
				String casoDePrueba = dato[0];
				String nombreEmp = dato[1];
				String usuarioEmp = dato[2];
				String claveEmp = dato[3];
				System.out.println(nombreEmp);
				System.out.println(usuarioEmp);
				System.out.println(claveEmp);
				
				if(Accion.verificarElementoPantalla(XpathObjetos.menuAdmin.getDato(), GlobalVariable.timeOut)) {
					
					Accion.hacerClick(XpathObjetos.menuAdmin.getElemento("menu Admin"), "menu Admin");
					
					if(Accion.verificarElementoPantalla(XpathObjetos.btnAdd.getDato(), GlobalVariable.timeOut)) {
						
						Accion.hacerClick(XpathObjetos.btnAdd.getElemento("btn Add"), "btn Add");
						
						if(Accion.verificarElementoPantalla(XpathObjetos.inputEmployeeName.getDato(), GlobalVariable.timeOut)) {
							
							Accion.escribirTexto(XpathObjetos.inputEmployeeName.getElemento("input EmployeeName"), nombreEmp, "input EmployeeName", false);
						
							if(Accion.verificarElementoPantalla(XpathObjetos.inputEmployeeUser.getDato(), GlobalVariable.timeOut)) {
								
								Accion.escribirTexto(XpathObjetos.inputEmployeeUser.getElemento("input EmployeeUser"), usuarioEmp, "input EmployeeUser", false);
							
								if(Accion.verificarElementoPantalla(XpathObjetos.inputEmployeePass.getDato(), GlobalVariable.timeOut)) {
									
									Accion.escribirTexto(XpathObjetos.inputEmployeePass.getElemento("input EmployeePass"), claveEmp, "input EmployeePass", false);
								
									if(Accion.verificarElementoPantalla(XpathObjetos.inputEmployeePassConfirm.getDato(), GlobalVariable.timeOut)) {
										
										Accion.escribirTexto(XpathObjetos.inputEmployeePassConfirm.getElemento("input EmployeePassConfirm"), claveEmp, "input EmployeePassConfirm", false);
									
										if(Accion.verificarElementoPantalla(XpathObjetos.btnSave.getDato(), GlobalVariable.timeOut)) {
											
											Accion.hacerClick(XpathObjetos.btnSave.getElemento("btn Save"), "btn Save");
											
										}
									
									}
								
								}
							}
						}
					} else {
						Accion.verificarPantalla("Elemento Add no encontrado. Resultado caso de prueba " + casoDePrueba + " fallido.", false, true, true);
						
					}
				}else {
					Accion.verificarPantalla("Elemento Admin no encontrado. Resultado caso de prueba " + casoDePrueba + " fallido.", false, true, true);
					
				}
			}
			
			
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.exit(1);
		} finally {
			if(!ejecucionFuncional) {
				
				//System.exit(1);
				
			}
		}
		
		
		
	}
	
}
