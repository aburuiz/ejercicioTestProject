package manejador;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import BHDLAutomatizacionControladorComunSelenium.manejador.ManejadorLog;
import BHDLAutomatizacionControladorComunSelenium.utileria.TextoCliente;

public class Manejador {
	
	private static Manejador instaciaManejador = null;

    public static Manejador getinstanciaManejador(){

        if(instaciaManejador==null){
            instaciaManejador = new Manejador();
        }
        return instaciaManejador;
    }
    
    public List<String[]> leerCSV(String ruta) {
    	
    	ArrayList<String[]> datos = null;
    	try {

        	CSVReader csvReader = new CSVReader(new FileReader(ruta));
        	return csvReader.readAll();
       
    	} catch(FileNotFoundException e) {
    		ManejadorLog.getInstanciaUnicaManejadorLog().reporteLogControl(TextoCliente.getInstanciaUnicaTextoCliente().mensajeExcepcion(e));
    		
    		return null;
    	} catch (IOException e) {
    		ManejadorLog.getInstanciaUnicaManejadorLog().reporteLogControl(TextoCliente.getInstanciaUnicaTextoCliente().mensajeExcepcion(e));
    		return null;
		} catch (CsvException e) {
			ManejadorLog.getInstanciaUnicaManejadorLog().reporteLogControl(TextoCliente.getInstanciaUnicaTextoCliente().mensajeExcepcion(e));
    		return null;
		}
    	
    	
    }
	
	
}
