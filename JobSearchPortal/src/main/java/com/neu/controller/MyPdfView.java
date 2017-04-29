package com.neu.controller;

import java.awt.Color;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import com.neu.pojo.User;


public class MyPdfView extends AbstractPdfView{

    @Override
    protected void buildPdfDocument(Map<String, Object> users, Document document, PdfWriter pdfwriter, HttpServletRequest request, HttpServletResponse response) throws Exception {
        // TODO Auto-generated method stub
        Font  helvetica_18_blue = new Font(Font.HELVETICA, 18, Font.BOLDITALIC, Color.BLUE);
        Paragraph title = new Paragraph("List of Active Employers", helvetica_18_blue);
        
       // document.add(title);
        
        
       @SuppressWarnings("unchecked")
	List<User> userlist = (List<User>)users.get("users");
        
       
       
//        System.out.println("Order Id "+orderId);
       
        document.add(new Paragraph("List of Active Employers")); 
        document.add(new Paragraph("----------------------------------------------------------------------------------------------------------------------------------"));
        document.add(new Paragraph(""));
        document.add(new Paragraph(""));
        document.add(new Paragraph(""));
        document.add(Chunk.NEWLINE);
        
        
       PdfPTable table = new PdfPTable(4);
        table.setTotalWidth(500);
        table.setLockedWidth(true);
        table.setWidths(new float[]{1, 1, 1,1});
        PdfPCell cell;
        
       table.addCell(new Paragraph("Emp User Name",FontFactory.getFont(FontFactory.TIMES, 15,Font.BOLD)));
        table.addCell(new Paragraph("First Name",FontFactory.getFont(FontFactory.TIMES, 15,Font.BOLD)));
        table.addCell(new Paragraph("Role Type",FontFactory.getFont(FontFactory.TIMES, 15,Font.BOLD)));
        table.addCell(new Paragraph("Email Id",FontFactory.getFont(FontFactory.TIMES, 15,Font.BOLD)));
        
        for (User user : userlist)
        {
            table.addCell(String.valueOf(user.getUserName()));
			table.addCell(String.valueOf(user.getFirstName()));
			table.addCell(String.valueOf(user.getUserType()));
			table.addCell(String.valueOf(user.getEmailId()));
        }
        
       document.add(table);
        
//       document.add(Chunk.NEWLINE);
//       document.add(new Paragraph("Please Note : This List is of Registered Employers Only"));
//       document.add(Chunk.NEWLINE);
        
    }
    
    

}