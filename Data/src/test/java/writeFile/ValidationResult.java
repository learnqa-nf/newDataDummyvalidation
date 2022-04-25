package writeFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ValidationResult {
	public void excelResultApp(int iCollect,String nomorAplikasi, String Status) throws IOException {

		//get file name
		String fileExcel = null ;
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
		String excelFilePath = ".//fileValidation//"+fileExcel;

		File file = new File(excelFilePath);
		FileInputStream os = new FileInputStream(excelFilePath);
		XSSFWorkbook wb = new XSSFWorkbook(os);
		XSSFSheet sheet = wb.getSheet("Approval");


		XSSFCellStyle style = wb.createCellStyle();
		style.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

		//insert new header column
		sheet.getRow(0).createCell(8).setCellValue("Nomor Aplikasi File Laporan");
		sheet.getRow(0).createCell(9).setCellValue("Status File Laporan");

		System.out.println(nomorAplikasi);
		System.out.println(Status);
		System.out.println(iCollect);

		//insert new column data to excel 
		
		sheet.getRow(iCollect).createCell(8).setCellValue(nomorAplikasi);
		sheet.getRow(iCollect).getCell(8).setCellStyle(style);
		
		sheet.getRow(iCollect).createCell(9).setCellValue(Status);
		sheet.getRow(iCollect).getCell(9).setCellStyle(style);

		//width autoSize
		sheet.autoSizeColumn(iCollect);
		FileOutputStream fout = new FileOutputStream(file);
		wb.write(fout);
		os.close();
		wb.close();

		System.out.println("Created");
	}

	public void excelResultRea(int iCollect,String nomorAplikasi, String Status) throws IOException {

		//get file name
		String fileExcel = null;



		File folder = new File(".//fileValidation");
		File[] listOfFiles = folder.listFiles();

		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {

				if (listOfFiles[i].getName().contains("REAFILE")) {
					fileExcel = listOfFiles[i].getName();
					//System.out.println(fileExcel);
				}

			} else if (listOfFiles[i].isDirectory()) {
				System.out.println("Directory " + listOfFiles[i].getName());
			}
		}


		String excelFilePath = ".//fileValidation//"+fileExcel.toString();

		File file = new File(excelFilePath);
		FileInputStream os = new FileInputStream(excelFilePath);
		XSSFWorkbook wb = new XSSFWorkbook(os);
		XSSFSheet sheet = wb.getSheet("Realisasi");
		
		XSSFCellStyle style = wb.createCellStyle();
		style.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		//insert new header column
		sheet.getRow(0).createCell(30).setCellValue("Nomor Aplikasi File Laporan");
		sheet.getRow(0).createCell(31).setCellValue("Status File Laporan");

		System.out.println(nomorAplikasi);
		System.out.println(Status);
		System.out.println(iCollect);

		//insert new column data to excel 
		sheet.getRow(iCollect).createCell(30).setCellValue(nomorAplikasi);
		sheet.getRow(iCollect).getCell(30).setCellStyle(style);
		
		sheet.getRow(iCollect).createCell(31).setCellValue(Status);
		sheet.getRow(iCollect).getCell(31).setCellStyle(style);

		//width autoSize
		sheet.autoSizeColumn(iCollect);
		FileOutputStream fout = new FileOutputStream(file);
		wb.write(fout);
		os.close();
		wb.close();

		System.out.println("Created");
	}

}
