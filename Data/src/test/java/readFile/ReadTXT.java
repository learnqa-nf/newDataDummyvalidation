package readFile;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import io.cucumber.messages.internal.com.google.protobuf.Value;

public class ReadTXT {
	// include throws to handle some file handling exceptions
	String status;
	String nomorAplikasi;

	String[] value2;
	public String[] textFile(int idxNomorAplikasi, int idxStatus,String vExcel)throws IOException {
		String str;
		String eachString1 = null;

		String[] stringarray = null;
		// arraylist to store strings
		List<String> listOfStrings
		= new ArrayList<String>();

		// load content of file based on specific delimiter
		Scanner sc = new Scanner(new FileReader(".//fileValidation//Laporan_Berhasil_App_L000001_24BL001_10112021.txt"))
				.useDelimiter(",");

		// checking end of file
		while (sc.hasNext()) {
			str = sc.next();

			// adding each string to arraylist
			listOfStrings.add(str);
		}

		// convert any arraylist to array
		String[] array = listOfStrings.toArray(new String[0]);

		// print each string in array
		for (String eachString : array) {
			eachString = eachString.replace("\n", "|");
			eachString1 = eachString;
			
			stringarray = eachString1.split("\\|");
			for(int i=0; i < stringarray.length; i++)  {  
				nomorAplikasi = stringarray[idxNomorAplikasi];
				if (stringarray[i].contains(vExcel)) {
					status = stringarray[idxStatus];
				}
				
				String[] value = new String[2];
				value[0] = nomorAplikasi;
				value[1] = status;
				value2 = value;
			}

		} 
	
//		System.out.println(value2);
		return value2;
		
		

	}
}

