package formatFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CSVFileName {
	String nomorAplikasi;
	String cSVfile;

	public void parseData(String str, String inputFile) throws InterruptedException{	

		String pattern = "ddMMyyyy";
		Thread.sleep(505);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String fdate = simpleDateFormat.format(new Date());

		try {
			if (inputFile.contains("REAFILE")) {
				File file = new File(".//resultDataDummyFile//REAFILE.csv");
				if (file.renameTo(new File(".//resultDataDummyFile//REAFILE"+"_"+str+"_"+"24BL008"+"_"+fdate+".csv"))) 

					try {
						String csvFileAddress = ".//resultDataDummyFile//REAFILE_"+str+"_24BL008_"+fdate+".csv"; //csv file address
						String xlsxFileAddress = ".//fileValidation//REAFILE_"+str+"_24BL008_"+fdate+".xlsx"; //xlsx file address
						XSSFWorkbook workBook = new XSSFWorkbook();
						XSSFSheet sheet = workBook.createSheet("Realisasi");
						String currentLine=null;
						int RowNum=0;
						BufferedReader br = new BufferedReader(new FileReader(csvFileAddress));
						while ((currentLine = br.readLine()) != null) {
							String str1[] = currentLine.split("\\|");

							XSSFRow currentRow=sheet.createRow(RowNum);
							RowNum++;
							for(int i=0;i<str1.length;i++){
								currentRow.createCell(i).setCellValue(str1[i]);
							}
						}

						FileOutputStream fileOutputStream =  new FileOutputStream(xlsxFileAddress);
						workBook.write(fileOutputStream);		
						fileOutputStream.close();

						//System.out.println("Done");
					} catch (Exception ex) {
						System.out.println(ex.getMessage()+"Exception in try");
					}

				System.out.println("Success");


			}else if (inputFile.contains("APPFILE")) {
				File file = new File(".//resultDataDummyFile//APPFILE.csv");
				if (file.renameTo(new File(".//resultDataDummyFile//APPFILE"+"_"+str+"_"+"24BL008"+"_"+fdate+".csv"))) 

					try {

						String fileExcel = null;
						File folder = new File(".//fileValidation");
						File[] listOfFiles = folder.listFiles();

						for (int i = 0; i < listOfFiles.length; i++) {
							if (listOfFiles[i].isFile()) {

								if (listOfFiles[i].getName().contains("APPFILE")) {
									fileExcel = listOfFiles[i].getName();
									//System.out.println(fileExcel);
								}

							} else if (listOfFiles[i].isDirectory()) {
								System.out.println("Directory " + listOfFiles[i].getName());
							}
						}

						String csvFileAddress = ".//resultDataDummyFile//APPFILE_"+str+"_24BL008_"+fdate+".csv"; //csv file address
						String xlsxFileAddress = ".//fileValidation//APPFILE_"+str+"__24BL008_"+fdate+".xlsx"; //xlsx file address

						XSSFWorkbook workBook = new XSSFWorkbook();
						XSSFSheet sheet = workBook.createSheet("Approval");
						String currentLine=null;
						int RowNum=0;
						BufferedReader br = new BufferedReader(new FileReader(csvFileAddress));
						while ((currentLine = br.readLine()) != null) {
							String str1[] = currentLine.split("\\|");

							XSSFRow currentRow=sheet.createRow(RowNum);
							RowNum++;
							for(int i=0;i<str1.length;i++){
								currentRow.createCell(i).setCellValue(str1[i]);
							}
						}

						FileOutputStream fileOutputStream =  new FileOutputStream(xlsxFileAddress);
						workBook.write(fileOutputStream);		
						fileOutputStream.close();
						br.close();

						//System.out.println("Done");
					} catch (Exception ex) {
						System.out.println(ex.getMessage()+"Exception in try");
					}

				System.out.println("success");


			}else if (inputFile.contains("Pengurus")) {
				File file = new File(".//resultDataDummyFile//REAFILE.csv");
				if (file.renameTo(new File(".//resultDataDummyFile//REAFILE"+"_"+str+"_"+"24BL008"+"_"+fdate+".csv"))) 
					System.out.println("Succes");
				else
					System.out.println("");
			}

		} catch(Exception ex) {
			System.out.println("gagal");

		}
	}

}



