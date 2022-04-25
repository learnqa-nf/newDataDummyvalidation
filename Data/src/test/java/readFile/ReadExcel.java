package readFile;
import writeFile.ValidationResult;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.openxml4j.util.ZipSecureFile;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ReadExcel {
	// AppFile Case	
	String[] collectDataApp ;

	String pattern = "ddMMyyyy";
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
	String fdate = simpleDateFormat.format(new Date());

	public void caseReadExcelApp() throws InterruptedException, IOException {

		int idxNomorAplikasi = 0;
		int idxStatus =2;
		int iCollect = 1;
		try {
			ZipSecureFile.setMinInflateRatio(0);
			XSSFWorkbook workbook = new XSSFWorkbook(".//testData.xlsx");
			XSSFSheet sheet = workbook.getSheet("Approval");

			int rowCount = sheet.getPhysicalNumberOfRows();
			for (int i =1; i < rowCount; i++) {
				String cellData = sheet.getRow(i).getCell(0).getStringCellValue();

				// Call Class Read text file
				ReadTXT toTXT = new ReadTXT();
				toTXT.textFile(idxNomorAplikasi,idxStatus,cellData);
				this.collectDataApp = toTXT.value2;

				idxNomorAplikasi = idxNomorAplikasi+3;
				idxStatus = idxStatus+3; 

				//call class
				ValidationResult inDataExcel = new ValidationResult();
				inDataExcel.excelResultApp(iCollect,this.collectDataApp[0],this.collectDataApp[1]);

				iCollect = iCollect+1;


			}	

			workbook.close();
		}catch (Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}

	}

	// ReaFile Case	
	String[] collectDataRea ;
	public void caseReadExcelRea() throws InterruptedException, IOException {

		int idxNomorAplikasi = 0;
		int idxStatus =2;
		int iCollect = 1;
		try {
			ZipSecureFile.setMinInflateRatio(0);
			XSSFWorkbook workbook = new XSSFWorkbook(".//testData.xlsx");
			XSSFSheet sheet = workbook.getSheet("Realisasi");

			int rowCount = sheet.getPhysicalNumberOfRows();
			for (int i =1; i < rowCount; i++) {
				String cellData = sheet.getRow(i).getCell(0).getStringCellValue();

				// Call Class Read text file
				ReadTXT toTXT = new ReadTXT();
				toTXT.textFile(idxNomorAplikasi,idxStatus,cellData);
				this.collectDataRea = toTXT.value2;

				idxNomorAplikasi = idxNomorAplikasi+3;
				idxStatus = idxStatus+3; 

				//call class
				ValidationResult inDataExcel = new ValidationResult();
				inDataExcel.excelResultRea(iCollect,this.collectDataRea[0],this.collectDataRea[1]);

				iCollect = iCollect+1;
			}	
			workbook.close();
		}catch (Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
	}
}