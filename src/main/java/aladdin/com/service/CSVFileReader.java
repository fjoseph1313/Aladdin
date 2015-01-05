package aladdin.com.service;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;

import aladdin.com.dao.ProductCategoryDAOImpl;
import aladdin.com.model.ProductCategory;

public class CSVFileReader {

@Autowired
private ProductCategoryDAOImpl productCategoryDAO;
	
	private static final String[] FILE_HEADER_MAPPING = {
			"categoryDescription", "categoryName" };

	private static final String CATEGORY_DESCRIPTION = "categoryDescription";
	private static final String CATEGORY_NAME = "categoryName";

	public void readCSVFile(String fileName) {
		FileReader fileReader = null;

		CSVParser csvFileParser = null;

		CSVFormat csvFileFormat = CSVFormat.DEFAULT
				.withHeader(FILE_HEADER_MAPPING);

		try {

			// Create a new list of student to be filled by CSV file data
			List<ProductCategory> productCategories = new ArrayList();

			// initialize FileReader object
			fileReader = new FileReader(fileName);
			System.out.println("==========="+fileReader);

			// initialize CSVParser object
			csvFileParser = new CSVParser(fileReader, csvFileFormat);
			System.out.println("========"+csvFileParser.isClosed());
			// Get a list of CSV file records
			List<CSVRecord> csvRecords = csvFileParser.getRecords();
			System.out.println("========"+csvRecords.size());
			// Read the CSV file records starting from the second record to skip
			// the header
			for (int i = 1; i < csvRecords.size(); i++) {
				CSVRecord record = csvRecords.get(i);
				// Create a new student object and fill his data
				ProductCategory productCategory = new ProductCategory();
				productCategory.setCategoryName(record.get(CATEGORY_NAME));
				productCategory.setCategoryDescription(record.get(CATEGORY_DESCRIPTION));
				productCategories.add(productCategory);
			}
			System.out.println("========productCategories size"+productCategories.size());
			// Print the new student list
			ProductCategoryDAOImpl pcatDao = new ProductCategoryDAOImpl();
			for (ProductCategory pCat: productCategories) {
				pcatDao.beginTransaction();
				pcatDao.save(pCat);
				pcatDao.commitTransaction();
			}
		} catch (Exception e) {
			System.out.println("Error in CsvFileReader !!!");
			System.out.println(e.getMessage());
		} finally {
			try {
				fileReader.close();
				csvFileParser.close();
			} catch (IOException e) {
				System.out
						.println("Error while closing fileReader/csvFileParser !!!");
				e.printStackTrace();
			}
		}
	}
}
