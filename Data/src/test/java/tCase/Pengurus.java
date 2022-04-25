package tCase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Pengurus {

	public void casePengurus(File inputFile, File outputFile) {
		StringBuffer data = new StringBuffer();

		try {
			System.out.println("Generating dummy Data...");
			FileOutputStream fos = new FileOutputStream(outputFile);
			// Get the workbook object for XLSX file
			FileInputStream fis = new FileInputStream(inputFile);
			Workbook workbook = null;
			String ext = FilenameUtils.getExtension(inputFile.toString());

			if (ext.equalsIgnoreCase("xlsx")) {
				workbook = new XSSFWorkbook(fis);
			} else if (ext.equalsIgnoreCase("xls")) {
				workbook = new HSSFWorkbook(fis);
			}
			
			Row sRow;
			Cell sCell;
			Sheet sSheet = workbook.getSheet("Pengurus");
			Iterator<Row> rowIterator = sSheet.iterator();
			while (rowIterator.hasNext()) {
				sRow = rowIterator.next();
				// For each row, iterate through each columns
				Iterator<Cell> cellIterator = sRow.cellIterator();
				while (cellIterator.hasNext()) {
					sCell = cellIterator.next();
					switch (sCell.getCellType()) {

					case STRING:
						// Last header without "|"
						if(sCell.getColumnIndex() == 8 && sCell.getRowIndex() == 0) {
							data.append(sCell.getStringCellValue());

							// generate Nomor_Aplikasi
						}else if (sCell.getColumnIndex() == 1 && sCell.getRowIndex() > 0) {
							String pattern = "ddHHmmss";
							Thread.sleep(505);
							SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
							String fdate = simpleDateFormat.format(new Date());								
							data.append(sCell.getStringCellValue().replace("null", "NF"+fdate+" | "));

							// null replace to "|"
						}else if (sCell.getColumnIndex() == 2 && sCell.getRowIndex() > 0) {
							data.append(sCell.getStringCellValue().replace("null", " | "));

							// generate NPWP
						}else if (sCell.getColumnIndex() == 3 && sCell.getRowIndex() > 0) {
							String pattern = "ddMMyyyyHHmmss";
							Thread.sleep(505);
							SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
							String fdate = simpleDateFormat.format(new Date());								
							data.append(sCell.getStringCellValue().replace("null","2"+fdate+" | "));

							//generate Interest_Rate
						}else if (sCell.getColumnIndex() == 7 && sCell.getRowIndex() > 0) {
							Long s = Long.parseLong(sCell.getStringCellValue());
							String fs = String.format("%05d", s);
							data.append(fs + " | ");

							// generate Plafon_Kredit
						}else if (sCell.getColumnIndex() == 8 && sCell.getRowIndex() > 0 ) {
							Long s = Long.parseLong(sCell.getStringCellValue());
							String fs = String.format("%013d"+"00", s);
							data.append(fs);

						}else {
							data.append(sCell.getStringCellValue() + " | ");

						}					
						break;
					case BLANK:							
						data.append("");
						break;
					default:
						data.append(sCell + " | ");
					}
				}
				data.append('\n'); //appending new line after each row
			}
			fos.write(data.toString().getBytes());
			fos.close();

		} catch (Exception ioe) {
			ioe.printStackTrace();
		}
	}
}
