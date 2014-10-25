package usc.ia.mundo;

import usc.ia.mundo.util.ExecuteShellComand;

/**
 * Created by foxcar on 24/10/14.
 */
public class DeteccionDeObjetos {


	//------------------------------------------------------------------------------------------
	// Atributos
	// ------------------------------------------------------------------------------------------

	private String rDestino = "multimedia/imagen/";

	//------------------------------------------------------------------------------------------
	// Constructor
	//------------------------------------------------------------------------------------------

	/**
	 * @param ruta del archivo de video a ser procesado
	 */
	public DeteccionDeObjetos(String ruta) {

		System.out.println("\nInicio constructor DeteccionDeObjetos\n");

		System.out.println(generarSecuencia(ruta));

		System.out.println("\nFin constructor DeteccionDeObjetos\n");
	}

	//------------------------------------------------------------------------------------------
	// Main
	//------------------------------------------------------------------------------------------

	/**
	 * El punto de entrada de la solicitud, que se abre un archivo con un video que se utilizará como referencia y se
	 * inicia la aplicación.
	 *
	 * @param args
	 */
	public static void main(String[] args) {

		new DeteccionDeObjetos("multimedia/video/video_IA_1_SD_480P.mp4");
		System.exit(0);

	}

	//------------------------------------------------------------------------------------------
	// Metodos
	//------------------------------------------------------------------------------------------


	/**
	 * Se genera una secuencia de imagenes usando ffmpeg por linea de comando
	 *
	 * @param rArchivo ruta del archivo a procesar
	 * @return mensajes del Terminal
	 */
	private String generarSecuencia(String rArchivo) {

		ExecuteShellComand esc = new ExecuteShellComand();

		// Limpia la carpeta de destino
		//String clr  = "rm –Rf " + rDestino;

		String clr = "rm -rf /Users/foxcar/IdeaProjects/USC/DetecccionDeObjetos/multimedia/imagen/*";
		esc.ejecutar(clr);

		/*
		// Pregunta si se deben borrar los archivos de la papelera
		int borrando1 = JOptionPane.showConfirmDialog(null, "Vaciar Papelera?", "Borrando", JOptionPane.YES_NO_OPTION);

		// Si se vacea la papelera
		if (borrando1 == 0) {
			JOptionPane.showMessageDialog(null,"Vaciando papelera");
			System.out.println("Borrando la papelera...");
			esc.ejecutar("rm -rf ~/.Trash/*");
			System.out.println("Papelera borrada");
		}
		*/


		System.out.println("\nInicio de la conversión de video a imagenes...");

		// Comando para usar el terminal y generar la secuencia de imagenes a partir de un video usando ffmpeg
		//String comando = "ffmpeg -i " + rArchivo + " -f image2 " + rDestino + "img%05d.png";

		String comandof = "ffmpeg -i " + rArchivo + " -f image2 -vf fps=fps=5 " + rDestino + "img%05d.png";


		String resultado = esc.ejecutar(comandof);
		System.out.println("Fin de la conversión.\n");


		return resultado;
	}
}
