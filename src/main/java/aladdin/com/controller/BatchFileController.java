package aladdin.com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import aladdin.com.service.CSVFileReader;

@Controller
public class BatchFileController {

	@RequestMapping(value = "/readcsv", method = RequestMethod.POST)
	public void readCSV(@RequestParam("csvFileName") String csvFileName) {
		
		CSVFileReader csvReader = new CSVFileReader();
		csvReader.readCSVFile(csvFileName);
	
	}

	
}
