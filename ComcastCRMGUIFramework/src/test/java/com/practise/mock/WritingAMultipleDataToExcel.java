package com.practise.mock;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileutility.ExcelUtility;

public class WritingAMultipleDataToExcel {

	@Test
	public void writeDataToExcel() throws EncryptedDocumentException, IOException {
		ExcelUtility eLib = new ExcelUtility();
		// Prepare data to write to Excel
        List<List<Object>> data = new ArrayList<>();

        // Add rows with mixed types of data, explicitly casting to List<Object>
        data.add(new ArrayList<>(Arrays.<Object>asList("Name", "Age", "Salary", "Active"))); // Explicit cast to List<Object>
        data.add(new ArrayList<>(Arrays.<Object>asList("John", 25, 50000.75, true)));
        data.add(new ArrayList<>(Arrays.<Object>asList("Alice", 30, 60000.50, false)));
        data.add(new ArrayList<>(Arrays.<Object>asList(28, "Bob", false, 45000.0 )));
	        
		eLib.writeMultipleDataToExcel("./testdata/testscriptdata.xlsx", "writingtoexcel", data);
	}

}
