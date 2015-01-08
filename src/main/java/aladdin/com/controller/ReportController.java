package aladdin.com.controller;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import aladdin.com.dao.CartDAOImpl;
import aladdin.com.model.Cart;
import aladdin.com.model.Vendor;
import aladdin.com.reports.SalesReport;
import aladdin.com.reports.Templates;

@Controller
public class ReportController {

	@Autowired
	private CartDAOImpl cartDao;

	@RequestMapping(value = "/getReportPage", method = RequestMethod.GET)
	public String getReposrtForm() {

		return "report";
	}
	
	@RequestMapping(value = "/getReportVendorPage", method = RequestMethod.GET)
	public String getReposrtVendorForm() {

		return "reportVendor";
	}



	@RequestMapping(value = "/getReport", method = RequestMethod.GET)
	public ResponseEntity<byte[]> getPDF() throws IOException {

		cartDao.beginTransaction();
		List<Cart> carts = cartDao.getAll();
		cartDao.commitTransaction();

		SalesReport salesReport = new SalesReport(carts);
		salesReport.build();

		byte[] contents = loadFile(Templates.TEMP_STORAGE + "salesReport.pdf");

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.parseMediaType("application/pdf"));
		String filename = "salesReport.pdf";
		headers.setContentDispositionFormData(filename, filename);
		headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
		ResponseEntity<byte[]> response = new ResponseEntity<byte[]>(contents,
				headers, HttpStatus.OK);
		return response;
	}

	@RequestMapping(value = "/getReportByWeek", method = RequestMethod.GET)
	public ResponseEntity<byte[]> getPDFWeek() throws IOException {
		Date fromDate = new Date();

		Calendar cal = Calendar.getInstance();
		cal.setTime(fromDate);
		cal.add(Calendar.WEEK_OF_MONTH, 1);
		Date toDate = cal.getTime();

		cartDao.beginTransaction();
		List<Cart> carts = cartDao.findCartsByDates(fromDate, toDate);
		cartDao.commitTransaction();

		SalesReport salesReport = new SalesReport(carts);
		salesReport.build();

		byte[] contents = loadFile(Templates.TEMP_STORAGE + "salesReport.pdf");

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.parseMediaType("application/pdf"));
		String filename = "weeklySalesReport.pdf";
		headers.setContentDispositionFormData(filename, filename);
		headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
		ResponseEntity<byte[]> response = new ResponseEntity<byte[]>(contents,
				headers, HttpStatus.OK);
		return response;
	}
	
	@RequestMapping(value = "/getReportByMonth", method = RequestMethod.GET)
	public ResponseEntity<byte[]> getPDFMonth() throws IOException {
		Date fromDate = new Date();

		Calendar cal = Calendar.getInstance();
		cal.setTime(fromDate);
		cal.add(Calendar.MONTH, 1);
		Date toDate = cal.getTime();

		cartDao.beginTransaction();
		List<Cart> carts = cartDao.findCartsByDates(fromDate, toDate);
		cartDao.commitTransaction();

		SalesReport salesReport = new SalesReport(carts);
		salesReport.build();

		byte[] contents = loadFile(Templates.TEMP_STORAGE + "salesReport.pdf");

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.parseMediaType("application/pdf"));
		String filename = "monthlySalesReport.pdf";
		headers.setContentDispositionFormData(filename, filename);
		headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
		ResponseEntity<byte[]> response = new ResponseEntity<byte[]>(contents,
				headers, HttpStatus.OK);
		return response;
	}

	@RequestMapping(value = "/getReportByYear", method = RequestMethod.GET)
	public ResponseEntity<byte[]> getPDFYear() throws IOException {

		Calendar cal = Calendar.getInstance();
		cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.JANUARY), 01);
		Date fromDate = cal.getTime();
		cal.add(Calendar.YEAR, 1);
		Date toDate = cal.getTime();

		cartDao.beginTransaction();
		List<Cart> carts = cartDao.findCartsByDates(fromDate, toDate);
		cartDao.commitTransaction();

		SalesReport salesReport = new SalesReport(carts);
		salesReport.build();

		byte[] contents = loadFile(Templates.TEMP_STORAGE + "salesReport.pdf");

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.parseMediaType("application/pdf"));
		String filename = "yearlySalesReport.pdf";
		headers.setContentDispositionFormData(filename, filename);
		headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
		ResponseEntity<byte[]> response = new ResponseEntity<byte[]>(contents,
				headers, HttpStatus.OK);
		return response;
	}
	
	@RequestMapping(value = "/getReportByVendor", method = RequestMethod.GET)
	public ResponseEntity<byte[]> getPDFVendor(HttpServletRequest request)
			throws IOException {

		Vendor vendor = (Vendor) request.getSession().getAttribute(
				"userDetails");
		System.out.println("=============" + vendor.getBusinessName());

		cartDao.beginTransaction();
		List<Cart> carts = cartDao.findCartsByVendor(vendor);
		cartDao.commitTransaction();

		SalesReport salesReport = new SalesReport(carts);
		salesReport.build();

		byte[] contents = loadFile(Templates.TEMP_STORAGE + "salesReport.pdf");

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.parseMediaType("application/pdf"));
		String filename = vendor.getBusinessName() + "salesReport.pdf";
		headers.setContentDispositionFormData(filename, filename);
		headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
		ResponseEntity<byte[]> response = new ResponseEntity<byte[]>(contents,
				headers, HttpStatus.OK);
		return response;
	}

	@RequestMapping(value = "/getReportByVendorWeek", method = RequestMethod.GET)
	public ResponseEntity<byte[]> getPDFVendorWeek(HttpServletRequest request)
			throws IOException {

		Vendor vendor = (Vendor) request.getSession().getAttribute(
				"userDetails");
		Date fromDate = new Date();

		Calendar cal = Calendar.getInstance();
		cal.setTime(fromDate);
		cal.add(Calendar.WEEK_OF_MONTH, 1);
		Date toDate = cal.getTime();

		cartDao.beginTransaction();
		List<Cart> carts = cartDao.findCartsByVendorDates(vendor, fromDate,
				toDate);
		cartDao.commitTransaction();

		SalesReport salesReport = new SalesReport(carts);
		salesReport.build();

		byte[] contents = loadFile(Templates.TEMP_STORAGE + "salesReport.pdf");

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.parseMediaType("application/pdf"));
		String filename = vendor.getBusinessName() + "weeklySalesReport.pdf";
		headers.setContentDispositionFormData(filename, filename);
		headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
		ResponseEntity<byte[]> response = new ResponseEntity<byte[]>(contents,
				headers, HttpStatus.OK);
		return response;
	}
	
	@RequestMapping(value = "/getReportByVendorMonthly", method = RequestMethod.GET)
	public ResponseEntity<byte[]> getPDFVendorMonth(HttpServletRequest request)
			throws IOException {

		Vendor vendor = (Vendor) request.getSession().getAttribute(
				"userDetails");
		Date fromDate = new Date();

		Calendar cal = Calendar.getInstance();
		cal.setTime(fromDate);
		cal.add(Calendar.MONTH, 1);
		Date toDate = cal.getTime();

		cartDao.beginTransaction();
		List<Cart> carts = cartDao.findCartsByVendorDates(vendor, fromDate,
				toDate);
		cartDao.commitTransaction();

		SalesReport salesReport = new SalesReport(carts);
		salesReport.build();

		byte[] contents = loadFile(Templates.TEMP_STORAGE + "salesReport.pdf");

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.parseMediaType("application/pdf"));
		String filename = vendor.getBusinessName() + "monthlySalesReport.pdf";
		headers.setContentDispositionFormData(filename, filename);
		headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
		ResponseEntity<byte[]> response = new ResponseEntity<byte[]>(contents,
				headers, HttpStatus.OK);
		return response;
	}

	@RequestMapping(value = "/getReportByVendorYear", method = RequestMethod.GET)
	public ResponseEntity<byte[]> getPDFVendorYear(HttpServletRequest request)
			throws IOException {

		Vendor vendor = (Vendor) request.getSession().getAttribute(
				"userDetails");
		Calendar cal = Calendar.getInstance();
		cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.JANUARY), 01);
		Date fromDate = cal.getTime();
		cal.add(Calendar.YEAR, 1);
		Date toDate = cal.getTime();

		cartDao.beginTransaction();
		List<Cart> carts = cartDao.findCartsByDates(fromDate, toDate);
		cartDao.commitTransaction();

		SalesReport salesReport = new SalesReport(carts);
		salesReport.build();
		byte[] contents = loadFile(Templates.TEMP_STORAGE + "salesReport.pdf");

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.parseMediaType("application/pdf"));
		String filename = vendor.getBusinessName() + "yearlySalesReport.pdf";
		headers.setContentDispositionFormData(filename, filename);
		headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
		ResponseEntity<byte[]> response = new ResponseEntity<byte[]>(contents,
				headers, HttpStatus.OK);
		return response;
	}

	private static byte[] readFully(InputStream stream) throws IOException {
		byte[] buffer = new byte[8192];
		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		int bytesRead;
		while ((bytesRead = stream.read(buffer)) != -1) {
			baos.write(buffer, 0, bytesRead);
		}
		return baos.toByteArray();
	}

	private static byte[] loadFile(String sourcePath) throws IOException {
		InputStream inputStream = null;
		try {
			inputStream = new FileInputStream(sourcePath);
			return readFully(inputStream);
		} finally {
			if (inputStream != null) {
				inputStream.close();
			}
		}
	}

}
