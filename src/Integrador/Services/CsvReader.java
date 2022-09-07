package Integrador.Services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class CsvReader {

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
