package usc.ia.mundo.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Clase que realiza la ejecución de comandos Shell
 *
 * @author mkyong
 * @since November 14, 2012
 * <p/>
 * Clase bajada de internet http://www.mkyong.com/java/how-to-execute-shell-command-from-java/
 */
public class ExecuteShellComand {

	/**
	 * Prueba del comando realizando una consulata de ping a google.com
	 *
	 * @param args
	 */
	public static void main(String[] args) {

		ExecuteShellComand obj = new ExecuteShellComand();

		String domainName = "google.com";

		//in mac oxs
		String command = "ping -c 3 " + domainName;

		//in windows
		//String command = "ping -n 3 " + domainName;

		String output = obj.executeCommand(command);

		System.out.println(output);

	}

	/**
	 * @param command
	 * @return
	 */
	public String ejecutar(String command) {
		return executeCommand(command);
	}

	/**
	 * @param command
	 * @return
	 */
	private String executeCommand(String command) {

		StringBuffer output = new StringBuffer();

		Process p;
		try {
			p = Runtime.getRuntime().exec(command);
			p.waitFor();
			BufferedReader reader =
					new BufferedReader(new InputStreamReader(p.getInputStream()));

			String line = "";
			while ((line = reader.readLine()) != null) {
				output.append(line + "\n");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return output.toString();

	}
}
