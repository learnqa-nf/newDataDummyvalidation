package tCase;

import formatFile.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Iterator;
import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import formatFile.CSVFileName;

public class REAfile {
	String nmrApp = null;
	File gblInputFile = null;
	public void caseReaFile(File inputFile, File outputFile) throws InterruptedException {
		StringBuffer data = new StringBuffer();
		gblInputFile = outputFile;
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
			Sheet sSheet = workbook.getSheet("Realisasi");
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
						if(sCell.getColumnIndex() == 29 && sCell.getRowIndex() == 0) {
							data.append(sCell.getStringCellValue());

							//Nomor_Aplikasi
						}else if (sCell.getColumnIndex() == 0 && sCell.getRowIndex() > 0) {
							String pattern = "ddHHmmss";
							Thread.sleep(501);
							SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
							String fdate = simpleDateFormat.format(new Date());	
							nmrApp = sCell.getStringCellValue();
							data.append(nmrApp + "NF"+fdate+"|");

							// Nama_Debitur	
						}else if (sCell.getColumnIndex() == 1 && sCell.getRowIndex() > 0) {						
							data.append(sCell.getStringCellValue() + " " + sCell.getRowIndex() + "|");

							// Jenis_Debitur
						}else if (sCell.getColumnIndex() == 2 && sCell.getRowIndex() > 0) {						
							data.append(sCell.getStringCellValue() + "|");

							// Alamat
						}else if (sCell.getColumnIndex() == 3 && sCell.getRowIndex() > 0) {						
							data.append(sCell.getStringCellValue() +  " " + sCell.getRowIndex() + "|");

							// Alamat_Kelurahan
						}else if (sCell.getColumnIndex() == 4 && sCell.getRowIndex() > 0) {						
							data.append(sCell.getStringCellValue() +  " " + sCell.getRowIndex() + "|");

							// Alamat_Kecamatan
						}else if (sCell.getColumnIndex() == 5 && sCell.getRowIndex() > 0) {						
							data.append(sCell.getStringCellValue() +  " " + sCell.getRowIndex() + "|");

							// Alamat_Kode_Pos
						}else if (sCell.getColumnIndex() == 6 && sCell.getRowIndex() > 0) {	
							
							String pattern = "dmmss";
							Thread.sleep(501);
							SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
							String fdate = simpleDateFormat.format(new Date());
							
							data.append(fdate+"|");

							// Alamat_KODE_DATI_II
						}else if (sCell.getColumnIndex() == 7 && sCell.getRowIndex() > 0) {						
							data.append(sCell.getStringCellValue() + "|");

							// No_Telepon
						}else if (sCell.getColumnIndex() == 8 && sCell.getRowIndex() > 0) {		
							String pattern = "ddhhmmss";
							Thread.sleep(501);
							SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
							String fdate = simpleDateFormat.format(new Date());
							data.append(sCell.getStringCellValue().replace("autogenerate", "08134"+fdate) + "|");

							// No_Akte
						}else if (sCell.getColumnIndex() == 9 && sCell.getRowIndex() > 0) {						
							data.append(sCell.getStringCellValue() + "|");

							// Tanggal_Berdiri
						}else if (sCell.getColumnIndex() == 10 && sCell.getRowIndex() > 0) {						
							data.append(sCell.getStringCellValue() + "|");

							// No_Akte_Terakhir
						}else if (sCell.getColumnIndex() == 11 && sCell.getRowIndex() > 0) {						
							data.append(sCell.getStringCellValue() + "|");

							// Tanggal_Akte_Terakhir
						}else if (sCell.getColumnIndex() == 12 && sCell.getRowIndex() > 0) {						
							data.append(sCell.getStringCellValue() + "|");

							// Bidang_Usaha
						}else if (sCell.getColumnIndex() == 13 && sCell.getRowIndex() > 0) {						
							data.append(sCell.getStringCellValue() + "|");

							// Nomor_NPWP
						}else if (sCell.getColumnIndex() == 14 && sCell.getRowIndex() > 0) {						
							String pattern = "ddMMyyyyHHmmss";
							Thread.sleep(505);
							SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
							String fdate = simpleDateFormat.format(new Date());								
							data.append(sCell.getStringCellValue().replace("autogenerate","2"+fdate+"|"));

							// Jangka_Waktu
						}else if (sCell.getColumnIndex() == 15 && sCell.getRowIndex() > 0) {						
							data.append(sCell.getStringCellValue() + "|");

							// Jenis_Kredit
						}else if (sCell.getColumnIndex() == 16 && sCell.getRowIndex() > 0) {						
							data.append(sCell.getStringCellValue() + "|");

							// Plafon
						}else if (sCell.getColumnIndex() == 17 && sCell.getRowIndex() > 0) {						
							Long s = Long.parseLong(sCell.getStringCellValue());
							String fs = String.format("%013d"+"00", s);
							data.append(fs);

							// Interest_Rate
						}else if (sCell.getColumnIndex() == 18 && sCell.getRowIndex() > 0) {						
							Long s = Long.parseLong(sCell.getStringCellValue());
							String fs = String.format("%05d", s);
							data.append(fs + "|");

							// Nomor_PK
						}else if (sCell.getColumnIndex() == 19 && sCell.getRowIndex() > 0) {						
							String pattern = "HHmmss";
							Thread.sleep(505);
							SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
							String s = simpleDateFormat.format(new Date());	
							String fs = String.format("%020d",Integer.parseInt(s));							
							data.append(sCell.getStringCellValue().replace("autogenerate", fs + "|"));
							
							// Tanggal_Akad
						}else if (sCell.getColumnIndex() == 20 && sCell.getRowIndex() > 0) {	
							DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMddyyyy");
							LocalDate localDate = LocalDate.now().minusDays(1);
							String fdate = dtf.format(localDate);
							data.append(sCell.getStringCellValue().replace("autogenerate", fdate + "|"));

							// Tanggal_Angsuran_1
						}else if (sCell.getColumnIndex() == 21 && sCell.getRowIndex() > 0) {
							String pattern = "MMddyyyy";
							Thread.sleep(505);
							SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
							String fdate = simpleDateFormat.format(new Date());	
							data.append(fdate + "|");

							// Jenis_Penggunaan
						}else if (sCell.getColumnIndex() == 22 && sCell.getRowIndex() > 0) {						
							data.append(sCell.getStringCellValue() + "|");

							// Sektor_Ekonomi
						}else if (sCell.getColumnIndex() == 23 && sCell.getRowIndex() > 0) {						
							data.append(sCell.getStringCellValue() + "|");

							// Omzet
						}else if (sCell.getColumnIndex() == 24 && sCell.getRowIndex() > 0) {						
							data.append(sCell.getStringCellValue() + "|");	

							// Go_Public
						}else if (sCell.getColumnIndex() == 25 && sCell.getRowIndex() > 0) {						
							data.append(sCell.getStringCellValue() + "|");

							// Sandi_Golongan_Debitur
						}else if (sCell.getColumnIndex() == 26 && sCell.getRowIndex() > 0) {						
							data.append(sCell.getStringCellValue() + "|");

							// Penghasilan_Kotor_Per_Tahun
						}else if (sCell.getColumnIndex() == 27 && sCell.getRowIndex() > 0) {						
							data.append(sCell.getStringCellValue() + "|");

							// Bentuk_Badan_Usaha
						}else if (sCell.getColumnIndex() == 28 && sCell.getRowIndex() > 0) {						
							data.append(sCell.getStringCellValue() + "|");

							//Tempat_berdiri_badan_usaha
						}else if (sCell.getColumnIndex() == 29 && sCell.getRowIndex() > 0 ) {
							data.append(sCell.getStringCellValue());

						}else {
							data.append(sCell.getStringCellValue() + "|");

						}
						break;
					case BLANK:							
						data.append("|");
						break;
					default:
						data.append(sCell + "|");
					}
				}
				data.append('\n'); //appending new line after each row
			}

			fos.write(data.toString().getBytes());
			fos.close();

		} catch (Exception ioe) {
			ioe.printStackTrace();
		}
		System.out.println(nmrApp);
		CSVFileName renameFile = new CSVFileName();
		renameFile.parseData(nmrApp, gblInputFile.toString());
	}
}
