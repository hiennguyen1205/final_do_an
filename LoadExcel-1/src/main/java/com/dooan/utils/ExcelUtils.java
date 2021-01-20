package com.dooan.utils;

import java.awt.Point;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.dooan.model.ThietBi;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.ui.Model;

public class ExcelUtils {
	static int numColumn = 0;
	static String[] tenCot;
	// static String[] tieuDe;

	public static ByteArrayInputStream thietbiToExcel(List<ThietBi> listOfThietBi) throws IOException {
		String[] COLUMNs = { "STT", "Ten", "Model", "Serial", "HangSx", "NuocSX", "NamSX", "DonVi", "SoLuong",
				"DonGiaVND", "DonGiaUSD", "ThanhTien", "KhoaSuDung", "NgayBanGiao", "GiayTo", "Nguon", "GhiChu" };
		try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream();) {
			CreationHelper createHelper = workbook.getCreationHelper();

			Sheet sheet = workbook.createSheet("ThietBi");

			Font headerFont = workbook.createFont();
			headerFont.setBold(true);
			headerFont.setColor(IndexedColors.BLUE.getIndex());

			CellStyle headerCellStyle = workbook.createCellStyle();
			headerCellStyle.setFont(headerFont);

			// Row for Header
			Row headerRow = sheet.createRow(0);

			// Header
			for (int col = 0; col < COLUMNs.length; col++) {
				Cell cell = headerRow.createCell(col);
				cell.setCellValue(COLUMNs[col]);
				cell.setCellStyle(headerCellStyle);
			}

			// CellStyle for Age
			CellStyle ageCellStyle = workbook.createCellStyle();
			ageCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("#"));

			int rowIdx = 1;

//			for (Customer customer : customers) {
//				Row row = sheet.createRow(rowIdx++);
//	 
//				row.createCell(0).setCellValue(customer.getId());
//				row.createCell(1).setCellValue(customer.getName());
//				row.createCell(2).setCellValue(customer.getAddress());
//	 
//				Cell ageCell = row.createCell(3);
//				ageCell.setCellValue(customer.getAge());
//				ageCell.setCellStyle(ageCellStyle);
//			}

			for (ThietBi tb : listOfThietBi) {
				Row row = sheet.createRow(rowIdx++);

				row.createCell(0).setCellValue(tb.getStt());
				row.createCell(1).setCellValue(tb.getTen());
				row.createCell(2).setCellValue(tb.getModel());
				row.createCell(3).setCellValue(tb.getSerial());
				row.createCell(4).setCellValue(tb.getHangsx());
				row.createCell(5).setCellValue(tb.getNuocsx());
				row.createCell(6).setCellValue(tb.getNamsx());
				row.createCell(7).setCellValue(tb.getDonVi());
				row.createCell(8).setCellValue(tb.getSoLuong());
				row.createCell(9).setCellValue(tb.getDongiaVND());
				row.createCell(10).setCellValue(tb.getDongiaUSD());
				row.createCell(11).setCellValue(tb.getThanhTien());
				row.createCell(12).setCellValue(tb.getKhoa());
				row.createCell(13).setCellValue(tb.getNgayBanGiao());
				row.createCell(14).setCellValue(tb.getGiayTo());
				row.createCell(15).setCellValue(tb.getNguon());
				row.createCell(16).setCellValue(tb.getGhiChu());
			}

			workbook.write(out);
			return new ByteArrayInputStream(out.toByteArray());
		}
	}

	static Model model;
	static String[] tieuDe = new String[19];

	static int sttRow = 0;
	static int sttCol = 0;

	public static String[] tenTieuDe(InputStream is) {
		try {
			Workbook workbook = new XSSFWorkbook(is);
			FileOutputStream outFile = new FileOutputStream("E:\\ky1_nam5\\do_an_tot_nghiep\\save\\data.xlsx");
			workbook.write(outFile);
			Sheet sheet = workbook.getSheetAt(0);
			Iterator<Row> rows = sheet.iterator();
			int rowNum = 0;
			int hang = 0;
			int noOfColumns = 0;
			while (sheet.getRow(hang) == null) {
				System.out.println(sheet.getRow(hang));
				hang++;
			}
			noOfColumns = sheet.getRow(hang).getLastCellNum();
			boolean sttDone = false;
			tieuDe = new String[noOfColumns];
			while (rows.hasNext()) {
				Row currentRow = rows.next();
				if (noOfColumns == 0) {
					noOfColumns = currentRow.getLastCellNum();
				}
				Iterator<Cell> cellsInRow = currentRow.iterator();
				if (!sttDone) {
					Cell cellStt = currentRow.getCell(0);
					cellStt.setCellType(Cell.CELL_TYPE_STRING);
					if (cellStt.getStringCellValue().equalsIgnoreCase("STT")) {
						System.out.println(0 + " " + rowNum);
						for (int j = 0; j < noOfColumns; j++) {
							Cell cellDataTieuDe = currentRow.getCell(j);
							cellDataTieuDe.setCellType(Cell.CELL_TYPE_STRING);
							tieuDe[j] = cellDataTieuDe.getStringCellValue().replaceAll("\\n","");
							System.out.println(tieuDe[j]);
						}
						sttRow = rowNum; // y
						sttCol = 0; // x
						sttDone = true;
					}
				}
				rowNum++;
			}
			workbook.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return tieuDe;
	}

	public static List<ThietBi> parseExcelFile(Map<String, String> map) {
		List<ThietBi> lstThietBi = new ArrayList<ThietBi>();
		try {
			FileInputStream inputStream = new FileInputStream(
					new File("E:\\ky1_nam5\\do_an_tot_nghiep\\save\\data.xlsx"));
			Workbook workbook = new XSSFWorkbook(inputStream);
			Sheet sheet = workbook.getSheetAt(0);
			Iterator<Row> rows = sheet.iterator();
			int noOfColumns = 0;
			int rowNum = 0;

			while (rows.hasNext()) {
				Row row = (Row) rows.next();
				rowNum++;
				if (rowNum == sttRow + 1) {
					break;
				}
			}

			while (rows.hasNext()) {

				Row currentRow = rows.next();
				if (noOfColumns == 0) {
					noOfColumns = currentRow.getLastCellNum();
				}

				Iterator<Cell> cellsInRow = currentRow.iterator();

//					System.out.println("chua vao");
				ThietBi thietbi = new ThietBi();
				for (int i = 0; i < noOfColumns; i++) {
					Cell cellStt = currentRow.getCell(i);
					String duLieu;
					String key = "";
					for (Map.Entry<String, String> entry : map.entrySet()) {
						System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
//						System.out.println("entry.getValue(): " + entry.getValue());
						if (entry.getValue().equals(tieuDe[i])) {
							key = entry.getKey();
							System.out.println("key: " + key);
							if (key.equals("ngaybangiao")) {
								DataFormatter df = new DataFormatter();
								duLieu = df.formatCellValue(cellStt);
								System.out.println("ngay: "+duLieu);
							} else {
			    				cellStt.setCellType(Cell.CELL_TYPE_STRING);
			    				duLieu = cellStt.getStringCellValue();
			    				
							}
							System.out.println("day la du lieu: " + duLieu);
							thietbi.setByKey(key, duLieu);
							break;
						} 
					}
//						if (tieuDe[i].equals("ngaybangiao")) {
//							DataFormatter df = new DataFormatter();
//							duLieu = df.formatCellValue(cellStt);
//							System.out.println("ngay: "+duLieu);
//						} else {
//		    				cellStt.setCellType(Cell.CELL_TYPE_STRING);
//		    				duLieu = cellStt.getStringCellValue();
//		    				
//						}

					


				}

				lstThietBi.add(thietbi);

				rowNum++;
			}
			workbook.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lstThietBi;
	}
}
