package interfac;

import javax.swing.filechooser.FileFilter;
import java.io.File;

/**
 * Created by foxcar on 24/10/14.
 */
public class MP4Filtro extends FileFilter implements java.io.FileFilter {

	public boolean accept(File archivo) {
		if (archivo.getName().toLowerCase().endsWith(".mp4")) return true;
		return false;
	}

	public String getDescription() {
		return "MP4 archivos";
	}


}
