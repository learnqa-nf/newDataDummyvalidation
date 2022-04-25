package generateDefinitions;

import tCase.APPfile;
import tCase.REAfile;
import tCase.Pengurus;
import java.io.File;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;


public class createCSV {
	File inputFile = null, outputFile = null;
	String nomorAplikasi;

	@Given("Provide path file {string} existing and file name {string}")
	public void provide_path_file_existing_and_file_name(String excelFile, String CSVfile) throws InterruptedException {
		
		inputFile = new File(excelFile); //provide your file path existing
		outputFile = new File(CSVfile);
	}
	
	@Then("Generate data dummy from {string}")
	public void generate_data_dummy_from(String tCase) throws InterruptedException {
		if (tCase.contains("APPFILE")) {
			APPfile appFile = new APPfile();
			appFile.caseAPPFile(inputFile,outputFile);

		}else if (tCase.contains("REAFILE")) {
			REAfile reaFile = new REAfile();
			reaFile.caseReaFile(inputFile, outputFile);

		}else if (tCase.contains("PENGURUS")) {
			Pengurus pengurus = new Pengurus();
			pengurus.casePengurus(inputFile, outputFile);

		}
	}
}
