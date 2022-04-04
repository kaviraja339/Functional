package com.saucedemo.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFFactory;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	
	public int getParameterIndex(String[] colArray, String colName) {
		for(int i=0;i<=colArray.length;i++) {
			if(colArray[i].equalsIgnoreCase(colName)) {
				return 1;
			}
		}
		return -1;	
	}
	
	public static HashMap<String, String[]> readdata() throws IOException{
		
		HashMap<String, String[]> map = new HashMap<String, String[]>();
		String key="";
		List<String> list = new ArrayList<String>();
		String key1="";
		ArrayList<String> list1 = new ArrayList<String>();
		FileInputStream report_file;
		XSSFWorkbook report_file_workbook;
		XSSFSheet spreadshhet;
		XSSFRow row0;
		XSSFCell cell;
		DataFormatter df = new DataFormatter();
		
		File file = new File(System.getProperty("user.dir")+"/src/test/resources/TestData/TestData.xlsx");
		report_file = new FileInputStream(file);
		
		report_file_workbook = new XSSFWorkbook(report_file);
		spreadshhet = report_file_workbook.getSheetAt(0);
		
		int startrow = spreadshhet.getFirstRowNum();
		int endrow = spreadshhet.getLastRowNum();
		int colcount = spreadshhet.getRow(0).getPhysicalNumberOfCells();
		for(int i=0;i<endrow;i++) {
			for(int j=0;j<colcount;j++) {
				if(j==0) {
					key =df.formatCellValue(report_file_workbook.getSheetAt(0).getRow(i).getCell(j));
				}else {
					list.add(df.formatCellValue(report_file_workbook.getSheetAt(0).getRow(i).getCell(j)).trim());
				}
			}
//			System.out.println(list);
			
			String[] strings = list.toArray(new String[list.size()]);
			map.put(key, strings);
			
			list= new ArrayList<String>();
		}
//		for(int i=0;i<endrow;i++) {
//			for(int j=0;j<colcount;j++) {
//				if(j==0) {
//					key1 = map.get(i)[j];
//				}else {
//					list1.add(map.get(i)[j]);
//				}
//			}
//			System.out.println(list1);
//			list1= new ArrayList<String>();
//		}
		
		return map;
		
	}

}
