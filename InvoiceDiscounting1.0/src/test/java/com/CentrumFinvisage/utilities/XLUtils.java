package com.CentrumFinvisage.utilities;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class XLUtils {

	@Test
	public static void getRowCount()
	{
		XSSFWorkbook workbook;
		try {
			workbook = new XSSFWorkbook("C:\\Users\\karthik\\eclipse-workspace\\Centrum_Finvisage1.0\\src\\test\\java\\com\\CecntrumFinvisage\\testData\\TestData.xlsx");

			XSSFSheet sheet=workbook.getSheetAt(0);
			int lrn=sheet.getLastRowNum();
			System.out.println(lrn);

			for (int i = 1; i<lrn; i++)
			{
				for(int j=0; j<2; j++) {
					System.out.println(sheet.getRow(i).getCell(j).getStringCellValue());
					System.out.print(" ");
				}
				System.out.print(" ");
			}

		} catch (Exception e) {

			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}
