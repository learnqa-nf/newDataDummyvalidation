package generateDefinitions;

import java.io.IOException;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import readFile.ReadExcel;
import readFile.*;
import readFile.ReadTXT;

public class Validation {
	@Given("Provide file Excel compare {string}")
	public void provide_file_excel_compare(String tCase) throws IOException, InterruptedException {
		
		//for (int i=0;i <= 100;i++){

			if(tCase.contains("APPFILE")) {
				
				ReadExcel readExcelApp = new ReadExcel();
				readExcelApp.caseReadExcelApp();
				
			}else if (tCase.contains("REAFILE")) {
				ReadExcel readExcelRea = new ReadExcel();
				readExcelRea.caseReadExcelRea();
			}
			
			//System.out.println(i);
//		}
	}
}
