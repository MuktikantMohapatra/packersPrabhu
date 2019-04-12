package com.packers.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
import com.packers.bo.BookingBO;
import com.packers.bo.UserDetailsBO;
import com.packers.repo.UserDetailsRepository;

@Component
public class QutotationGenerator {

	private static final Logger LOGGER = LoggerFactory.getLogger(QutotationGenerator.class);
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

		cell = new PdfPCell(new Phrase("Qutotation"));
		cell.setColspan(2);
		table.addCell(cell);

		table.addCell("BOOKING ID");
		table.addCell(b_id);

		table.addCell("NAME");
		table.addCell(bo1.getName());

		table.addCell("EMAIL");
		table.addCell(bo1.getEmail());

		table.addCell("NAME");
		table.addCell(bo1.getNumber() + "");

		table.addCell("Service");
		table.addCell(b_id);

		table.addCell("SHIFTING FROM");
		table.addCell(bo.getShiftingFrom());

		table.addCell("SHIFTING TO");
		table.addCell(bo.getShiftingTo());

		table.addCell("BOOKING DATE");
		table.addCell(bo.getDate());

		return table;
	}
}
