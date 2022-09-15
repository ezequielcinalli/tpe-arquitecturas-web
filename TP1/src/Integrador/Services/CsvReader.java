package Integrador.Services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

/**
* Lector de archivos .csv
*/
public class CsvReader {

	/**
	* Obtiene todas las lineas de un archivo .csv y separa el contenido cortando por las "comas"
	* @param relativeUri Uri relativa desde la carpeta raiz del proyecto
	* @return Lista de renglones, donde cada renglon es un arreglo de strings (uno por cada columna del .csv)
	*/
	public static ArrayList<String[]> ReadLinesFromFilePath(String relativeUri){
		String absoluteUri = new File("").getAbsolutePath();
        String line = "";
        ArrayList<String[]> lines = new ArrayList<String[]>();
        try (BufferedReader br = new BufferedReader(new FileReader(absoluteUri + "\\" + relativeUri))) {
            boolean isFirstLine = true;
            String[] lineParams;
            while ((line = br.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }
                lineParams = line.split(",");
                lines.add(lineParams);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lines;
	}
	
}
