package modoPasivo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

import com.sun.org.apache.xerces.internal.impl.io.UTF8Reader;

public class Read_text_from_file {
	
	private static ArrayList<String> arrWithLines;


	public static ArrayList<String> saveLines(File file){
		arrWithLines = new ArrayList<String>();
		
		String line;
		try {
			
			Scanner sc = new Scanner(file, "UTF8");
			
			while (sc.hasNext()){
				line=sc.nextLine();
				arrWithLines.add(line);			
			}
			
			sc.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return arrWithLines;
	}
	
}
