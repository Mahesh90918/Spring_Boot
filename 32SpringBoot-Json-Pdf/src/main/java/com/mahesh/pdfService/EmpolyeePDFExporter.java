package com.mahesh.pdfService;

import java.awt.Color;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lowagie.text.*;
import com.lowagie.text.pdf.*;
import com.mahesh.model.Employee;

public class EmpolyeePDFExporter {
	private List<Employee> listEmploye;

	public EmpolyeePDFExporter(List<Employee> listEmploye) {
		this.listEmploye = listEmploye;
	}

	private void writeTableHeader(PdfPTable table) {
		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(Color.BLUE);
		cell.setPadding(5);

		Font font = FontFactory.getFont(FontFactory.HELVETICA);
		font.setColor(Color.WHITE);

		cell.setPhrase(new Phrase("Empolyee Id", font));

		table.addCell(cell);

		cell.setPhrase(new Phrase("Empolyee Name", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Empolyee Salary", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Empolyee Email", font));
		table.addCell(cell);

	}

	private void writeTableData(PdfPTable table) {
		for (Employee emp : listEmploye) {
			table.addCell(String.valueOf(emp.getId()));
			table.addCell(emp.getName());
			table.addCell(String.valueOf(emp.getSalary()));
			table.addCell(emp.getEmail());
		}
	}

	public void export(HttpServletResponse response) throws DocumentException, IOException {
		Document document = new Document(PageSize.A4);
		PdfWriter.getInstance(document, response.getOutputStream());

		document.open();
		Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		font.setSize(18);
		font.setColor(Color.BLUE);

		Paragraph p = new Paragraph("LIST OF EMPOLYEES", font);
		p.setAlignment(Paragraph.ALIGN_CENTER);

		document.add(p);

		PdfPTable table = new PdfPTable(4);
		table.setWidthPercentage(100f);
		table.setWidths(new float[] { 1.5f, 3.5f, 3.0f, 3.0f });
		table.setSpacingBefore(10);

		writeTableHeader(table);
		writeTableData(table);

		document.add(table);

		document.close();

	}
}