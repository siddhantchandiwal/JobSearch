package com.neu.controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.neu.pojo.User;


public class MyPdfView {

	public void buildPdfDocument(List<User> users) {
		Document document = new Document();

		try {
			PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("D:\\EmpListing.pdf"));
			document.open();
			document.add(Chunk.NEWLINE);
			document.add(Chunk.NEWLINE);
			Chunk chunk = new Chunk("Employer listing as per your selection");
			Font font = new Font();
			chunk.setFont(font);

			Paragraph heading = new Paragraph(chunk);
			heading.setAlignment(Element.ALIGN_CENTER);

			document.add(heading);

			Paragraph p = new Paragraph();
			document.add(p);

			PdfPTable table = new PdfPTable(4); 

			table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_RIGHT);
			table.getDefaultCell().setVerticalAlignment(Element.ALIGN_TOP);

			PdfPCell cell1 = new PdfPCell(new Paragraph("Employer UserName"));
			PdfPCell cell2 = new PdfPCell(new Paragraph("First Name"));
			PdfPCell cell3 = new PdfPCell(new Paragraph("Type"));
			PdfPCell cell4 = new PdfPCell(new Paragraph("Email Id"));
		

			cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell4.setHorizontalAlignment(Element.ALIGN_CENTER);


			table.addCell(cell1);
			table.addCell(cell2);
			table.addCell(cell3);
			table.addCell(cell4);


			for (User user : users) {

				PdfPCell row1 = new PdfPCell(new Paragraph(user.getUserName()));
				PdfPCell row2 = new PdfPCell(new Paragraph(user.getFirstName()));
				PdfPCell row3 = new PdfPCell(new Paragraph(user.getUserType()));
				PdfPCell row4 = new PdfPCell(new Paragraph(user.getEmailId()));


				table.addCell(row1);
				table.addCell(row2);
				table.addCell(row3);
				table.addCell(row4);


			}

			document.add(table);

			document.close();
			writer.close();
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();

		}
	}



}	