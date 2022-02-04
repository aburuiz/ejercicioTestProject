package logicaNegocio;
import java.util.List;

import org.openqa.selenium.WebElement;

import BHDLAutomatizacionControladorComunSelenium.manejador.ManejadorAccion;
import BHDLAutomatizacionControladorComunSelenium.manejador.ManejadorConfiguracionEjecucionInicial;
import BHDLAutomatizacionControladorComunSelenium.manejador.ManejadorVerificacion;
import io.testproject.sdk.drivers.web.ChromeDriver;
import manejador.Manejador;

public class Accion {

	public static ChromeDriver obtenerWebDriver() {
		return ManejadorAccion.getinstanciaManejadorAccion().obtenerWebDriver("http://localhost:8585/", "zVYFhdW17RRqcvpxKaZp8rLj7I27OEOOOZNf2bEcOOk1");
	}
	
	public static WebElement creacionObjetoPorXpathLocal(String xpath, String atributo) {
		return ManejadorAccion.getinstanciaManejadorAccion().creacionObjetoPorXpathLocal(xpath, atributo);
	}
	
	public static boolean verificarElementoPantalla(String xpath, int tiempoEspera) {
		return ManejadorAccion.getinstanciaManejadorAccion().verificarElementoPantalla(xpath, tiempoEspera);
	}
	
	public static void escribirTexto(WebElement obj, String mensaje, String nombreObj, boolean esCredenciales) {
		ManejadorAccion.getinstanciaManejadorAccion().escribirTexto(obj, mensaje, nombreObj, esCredenciales);
	}
	
	public static void escribirTexto(WebElement obj, String mensaje, String nombreObj, boolean esCredenciales, boolean usarJavascript) {
		ManejadorAccion.getinstanciaManejadorAccion().escribirTexto(obj, mensaje, nombreObj, esCredenciales, usarJavascript);
	}
	
	public static void hacerClick(WebElement obj, String nombreObj) {
		ManejadorAccion.getinstanciaManejadorAccion().hacerClick(obj, nombreObj);
	}
	
	public static List<String[]> leerCSV(String ruta){
		return Manejador.getinstanciaManejador().leerCSV(ruta);
	}
	
	public static void verificarPantalla(String mensaje, boolean desicion, boolean postearPrintScreen , boolean generarDocumentacion){
		ManejadorVerificacion.getInstanciaUnicaManejadorVerificacion().verificarPantalla(mensaje, desicion, postearPrintScreen, generarDocumentacion);
	}
	
	public static void generarReporte(){
        ManejadorConfiguracionEjecucionInicial.procesoDespuesCasoPrueba();
    }
	
}
