package keyword;

import org.openqa.selenium.WebElement;
import logicaNegocio.Accion;

public enum XpathObjetos {
	
	inputUsername("//*/input[@name='txtUsername']"),
	inputPassword("//*/input[@name='txtPassword']"),
	btnLogin("//*/input[@name='Submit']"),
	labelProfile("//*/a[@id='welcome']"),
	welcomeProfile("//*/a[@id='welcome']"),
	menuAdmin("//*/a[@id='menu_admin_viewAdminModule']"),
	menuUserManagement("//*/a[@id='menu_admin_UserManagement']"),
	opcionMenuUsers("//*/a[@id='menu_admin_viewSystemUsers']"),
	btnAdd("//*/input[@id='btnAdd']"),
	inputEmployeeName("//*/input[@id='systemUser_employeeName_empName']"),
	inputEmployeeUser("//*/input[@id='systemUser_userName']"),
	inputEmployeePass("//*/input[@id='systemUser_password']"),
	inputEmployeePassConfirm("//*/input[@id='systemUser_confirmPassword']"),
	btnSave("//*/input[@id='btnSave']");

	private String dato;
	private WebElement elemento;
	
	XpathObjetos(String inf) {
		this.dato = inf;
	}
	
	public String getDato() {
		return this.dato;
	}
	
	public WebElement getElemento(String nombre) {
		return Accion.creacionObjetoPorXpathLocal(this.dato, nombre);
	}
	
}
