package com.packers.util;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import com.packers.bo.BookingBO;
import com.packers.bo.UserDetailsBO;
import com.packers.repo.UserDetailsRepository;

@Component
public class PDFGenerator {

	private static final Logger LOGGER = LoggerFactory.getLogger(PDFGenerator.class);
	@Autowired
	UserDetailsRepository userRepository;

	public void generatePDF(BookingBO bo, String filePath) {
		LOGGER.info("Inside generateItinerary()");
		Document document = new Document();
		try {
			PdfWriter.getInstance(document, new FileOutputStream(filePath));
			document.open();
			document.add(generateTable(bo));
			document.close();
		} catch (FileNotFoundException | DocumentException e) {
			LOGGER.error("Error insde generateItinerary() :" + e);
		}
	}

	private PdfPTable generateTable(BookingBO bo) {

		Optional<UserDetailsBO> optBO = userRepository.findById(bo.getCustId());
		UserDetailsBO bo1 = optBO.get();

		String b_id = bo.getBookingId() + "";

		PdfPTable table = new PdfPTable(2);
		PdfPCell cell;

		cell = new PdfPCell(new Phrase("BOOKING DETAILS"));
		cell.setColspan(2);
		table.addCell(cell);

		table.addCell("EMAIL");
		table.addCell(bo1.getEmail());

		table.addCell("NAME");
		table.addCell(bo1.getName());

		table.addCell("BOOKING ID");
		table.addCell(b_id);

		table.addCell("SHIFTING FROM");
		table.addCell(bo.getShiftingFrom());

		table.addCell("SHIFTING TO");
		table.addCell(bo.getShiftingTo());

		table.addCell("BOOKING DATE");
		table.addCell(bo.getDate());

		return table;
	}

	public static void generatePDFFromHTML(String filename, String destination) throws Exception {
		/*
		 * filename == full path of html file destination == where to store the
		 * generated file
		 */
		Document document = new Document();
		PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(destination));
		FileInputStream fs = new FileInputStream(filename);
		StringBuilder builder = new StringBuilder();
		int i = 0;

		try {
			while ((i = fs.read()) != -1) {
				builder.append((char) i);
			}
			fs.close();
			// System.out.println(builder.toString());
			document.open();
			InputStream is = new ByteArrayInputStream(builder.toString().getBytes());
			XMLWorkerHelper.getInstance().parseXHtml(writer, document, is);
			document.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
