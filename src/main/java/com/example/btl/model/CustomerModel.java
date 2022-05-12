package com.example.btl.model;

import com.example.btl.model.dto.CustomerService;
import com.example.btl.model.entities.Customer;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.context.annotation.Configuration;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.stream.Stream;

@Configuration
public class CustomerModel {

    public ByteArrayInputStream customerPDFReport(List<Customer> employees) throws DocumentException {
        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {
            PdfWriter.getInstance(document, out);
            document.open();

            Font font =  FontFactory.getFont(FontFactory.COURIER, 14,
                    BaseColor.BLACK);
            Paragraph para = new Paragraph("Customer List",  font);
            para.setAlignment(Element.ALIGN_CENTER);
            document.add(para);
            document.add(Chunk.NEWLINE);

            PdfPTable table = new PdfPTable(8);
            // Add PDF Table Header ->
            Stream.of("STT", "Name", "CCCD", "Address", "Phone","Email", "Register Date","Status").forEach(headerTitle ->
            {
                PdfPCell header = new PdfPCell();
                Font headFont =  FontFactory.
                        getFont(FontFactory.TIMES_ROMAN);
                header.setBackgroundColor(BaseColor.LIGHT_GRAY);
                header.setHorizontalAlignment(Element.ALIGN_CENTER);
                header.setBorderWidth(2);
                header.setPhrase(new Phrase(headerTitle, headFont));
                table.addCell(header);
            });

            for (Customer customer : employees) {
                PdfPCell idCell = new PdfPCell(new Phrase(customer.getId()+""));
                idCell.setPaddingLeft(4);
                idCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                idCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(idCell);

                PdfPCell firstNameCell = new PdfPCell(new Phrase
                        (customer.getName()));
                firstNameCell.setPaddingLeft(4);
                firstNameCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                firstNameCell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(firstNameCell);

                PdfPCell cccd = new PdfPCell(new Phrase
                        (String.valueOf(customer.getCccd())));
                cccd.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cccd.setHorizontalAlignment(Element.ALIGN_RIGHT);
                cccd.setPaddingRight(4);
                table.addCell(cccd);

                PdfPCell address = new PdfPCell(new Phrase
                        (customer.getAddress()));
                address.setPaddingLeft(4);
                address.setVerticalAlignment(Element.ALIGN_MIDDLE);
                address.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(address);

                PdfPCell sdt = new PdfPCell(new Phrase
                        (String.valueOf(customer.getPhoneNumber())));
                sdt.setVerticalAlignment(Element.ALIGN_MIDDLE);
                sdt.setHorizontalAlignment(Element.ALIGN_RIGHT);
                sdt.setPaddingRight(4);
                table.addCell(sdt);

                PdfPCell email = new PdfPCell(new Phrase
                        (String.valueOf(customer.getEmail())));
                email.setVerticalAlignment(Element.ALIGN_MIDDLE);
                email.setHorizontalAlignment(Element.ALIGN_RIGHT);
                email.setPaddingRight(4);
                table.addCell(email);

                PdfPCell created = new PdfPCell(new Phrase
                        (customer.getCreated()));
                created.setPaddingLeft(4);
                created.setVerticalAlignment(Element.ALIGN_MIDDLE);
                created.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(created);

                PdfPCell status = new PdfPCell(new Phrase
                        (String.valueOf(customer.getStatus())));
                status.setVerticalAlignment(Element.ALIGN_MIDDLE);
                status.setHorizontalAlignment(Element.ALIGN_RIGHT);
                status.setPaddingRight(4);
                table.addCell(status);
            }
            document.add(table);

            document.close();
        } catch (DocumentException e) {
            /*logger.error(e.toString());*/
        }

        return new ByteArrayInputStream(out.toByteArray());
    }

    public ByteArrayInputStream customerInfoPDFReport(List<CustomerService> customerServices) throws DocumentException {
        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {
            PdfWriter.getInstance(document, out);
            document.open();

            Font font =  FontFactory.getFont(FontFactory.COURIER, 14,
                    BaseColor.BLACK);
            Paragraph para = new Paragraph("Customer List",  font);
            para.setAlignment(Element.ALIGN_CENTER);
            document.add(para);
            document.add(Chunk.NEWLINE);

            PdfPTable table = new PdfPTable(12);
            // Add PDF Table Header ->
            Stream.of("STT", "Name", "CCCD", "Address", "Phone","Email", "Register Date","Status",
                    "Number of water /m", "Volume using /m", "Price (x1000)", "Total (x1000)").forEach(headerTitle ->
            {
                PdfPCell header = new PdfPCell();
                Font headFont =  FontFactory.
                        getFont(FontFactory.TIMES_ROMAN);
                header.setBackgroundColor(BaseColor.LIGHT_GRAY);
                header.setHorizontalAlignment(Element.ALIGN_CENTER);
                header.setBorderWidth(2);
                header.setPhrase(new Phrase(headerTitle, headFont));
                table.addCell(header);
            });

            for (CustomerService customer : customerServices) {
                PdfPCell idCell = new PdfPCell(new Phrase(customer.getId()+""));
                idCell.setPaddingLeft(4);
                idCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                idCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(idCell);

                PdfPCell firstNameCell = new PdfPCell(new Phrase
                        (customer.getName()));
                firstNameCell.setPaddingLeft(4);
                firstNameCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                firstNameCell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(firstNameCell);

                PdfPCell cccd = new PdfPCell(new Phrase
                        (String.valueOf(customer.getCccd())));
                cccd.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cccd.setHorizontalAlignment(Element.ALIGN_RIGHT);
                cccd.setPaddingRight(6);
                table.addCell(cccd);

                PdfPCell address = new PdfPCell(new Phrase
                        (customer.getAddress()));
                address.setPaddingLeft(4);
                address.setVerticalAlignment(Element.ALIGN_MIDDLE);
                address.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(address);

                PdfPCell sdt = new PdfPCell(new Phrase
                        (String.valueOf(customer.getPhoneNumber())));
                sdt.setVerticalAlignment(Element.ALIGN_MIDDLE);
                sdt.setHorizontalAlignment(Element.ALIGN_RIGHT);
                sdt.setPaddingRight(6);
                table.addCell(sdt);

                PdfPCell email = new PdfPCell(new Phrase
                        (String.valueOf(customer.getEmail())));
                email.setVerticalAlignment(Element.ALIGN_MIDDLE);
                email.setHorizontalAlignment(Element.ALIGN_RIGHT);
                email.setPaddingRight(6);
                table.addCell(email);

                PdfPCell created = new PdfPCell(new Phrase
                        (customer.getCreated()));
                created.setPaddingLeft(6);
                created.setVerticalAlignment(Element.ALIGN_MIDDLE);
                created.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(created);

                PdfPCell status = new PdfPCell(new Phrase
                        (String.valueOf(customer.getStatus())));
                status.setVerticalAlignment(Element.ALIGN_MIDDLE);
                status.setHorizontalAlignment(Element.ALIGN_RIGHT);
                status.setPaddingRight(6);
                table.addCell(status);


                PdfPCell numWater = new PdfPCell(new Phrase
                        (String.valueOf(customer.getNumWater())));
                numWater.setVerticalAlignment(Element.ALIGN_MIDDLE);
                numWater.setHorizontalAlignment(Element.ALIGN_RIGHT);
                numWater.setPaddingRight(6);
                table.addCell(numWater);

                PdfPCell volume = new PdfPCell(new Phrase
                        (String.valueOf(customer.getVolume())));
                volume.setVerticalAlignment(Element.ALIGN_MIDDLE);
                volume.setHorizontalAlignment(Element.ALIGN_RIGHT);
                volume.setPaddingRight(4);
                table.addCell(volume);

                PdfPCell price = new PdfPCell(new Phrase
                        (customer.getPrice()+""));
                price.setPaddingLeft(4);
                price.setVerticalAlignment(Element.ALIGN_MIDDLE);
                price.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(price);

                PdfPCell total = new PdfPCell(new Phrase
                        (String.valueOf(customer.getVolume()* customer.getPrice())));
                total.setVerticalAlignment(Element.ALIGN_MIDDLE);
                total.setHorizontalAlignment(Element.ALIGN_RIGHT);
                total.setPaddingRight(4);
                table.addCell(total);
            }
            document.add(table);

            document.close();
        } catch (DocumentException e) {
            /*logger.error(e.toString());*/
        }

        return new ByteArrayInputStream(out.toByteArray());
    }
}
