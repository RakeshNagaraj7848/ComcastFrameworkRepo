package com.practise3;

import java.io.IOException;
import java.util.List;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileutility.ExcelUtility;

public class ToReadMultripleDataFromExcelForAllDataTypes extends ExcelUtility {
	@Test
	public void printExcelData() throws IOException, InvalidFormatException {
		// Call the method to read data from the Excel sheet
		List<List<Object>> excelData = readingMultipleDataFromExcel("Sheet2","./testdata/testscriptdata.xlsx");

		// Iterate over the rows of data
		for (List<Object> row : excelData) {
			// Print each cell in the row with a tab space between them
			for (Object cellData : row) {
				System.out.print(cellData + "\t");
			}
			// Move to the next line after each row
			System.out.println();
		}
	}

}
