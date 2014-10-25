package interfac;

import usc.ia.mundo.DeteccionDeObjetos;

import javax.swing.*;
import java.io.IOException;

/**
 * Created by foxcar on 24/10/14.
 */
public class InterfaceDeteccionDeObjetos {

	//------------------------------------------------------------------------------------------
	// Atributos
	// ------------------------------------------------------------------------------------------

	/**
	 * Indica la ubicación inicial donde se encuentra el video de ejemplo
	 */
	private static final String basePath = "multimedia/video/";

	//------------------------------------------------------------------------------------------
	// Atributos de la interfaz
	//------------------------------------------------------------------------------------------
	/**
	 * Relación con la clase principal del mundo
	 */
	private DeteccionDeObjetos ddo;

	//------------------------------------------------------------------------------------------
	// Constructor
	//------------------------------------------------------------------------------------------

	public InterfaceDeteccionDeObjetos() {

		String r = llamarArchivo();

		if (r != null) {

			System.out.println("\nPath = " + r + "\n\n");

			ddo = new DeteccionDeObjetos(r);
		}


	}

	//------------------------------------------------------------------------------------------
	// Main
	//------------------------------------------------------------------------------------------

	/*
  * El punto de entrada de la solicitud, que se abre un archivo con un video que
  * se utilizará como referencia y se inicia la aplicación.
  */
	public static void main(String[] args) throws IOException {

		InterfaceDeteccionDeObjetos iddo = new InterfaceDeteccionDeObjetos();
		iddo.salir();

	}

	//------------------------------------------------------------------------------------------
	// Metodos
	//------------------------------------------------------------------------------------------

	/**
	 * Llama a el archivo a ser procesado
	 */
	private String llamarArchivo() {

		String rute = null;

		JFileChooser fc = new JFileChooser(basePath);

		//Filtro de extencion de archivos a buscar
		fc.setFileFilter(new MP4Filtro());

		int respuesta = fc.showOpenDialog(null);

		// se procesa el archivo de video seleccionado
		if (respuesta == JFileChooser.APPROVE_OPTION) {

			//File archivo = fc.getSelectedFile();
			//System.out.println("\nArchivo en la ruta = " + archivo.getPath());

			return fc.getSelectedFile().toString();


		} else {

			//Mensaje de advertencia ya que no se ha seleccionado algún archivo
			JOptionPane.showMessageDialog(null, "Debe seleccionar un video para ser procesado.", "Abortando...", JOptionPane.WARNING_MESSAGE);

		}

		return rute;
	}

	/**
	 * Fuerza a terminar la aplicación
	 */
	private void salir() {
		System.exit(0);
	}

}
