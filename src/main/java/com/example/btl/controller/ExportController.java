package com.example.btl.controller;

import com.example.btl.model.CustomerModel;
import com.example.btl.model.entities.Customer;
import com.example.btl.repository.CustomerRepository;
import com.itextpdf.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/pdf")
public class ExportController {
    @Autowired
    private CustomerModel customerModel;
    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping(value = "/export", produces =
            MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> employeeReport()
            throws IOException, DocumentException {
        List<Customer> employees = customerRepository.
                findAll();

        ByteArrayInputStream bis = customerModel.employeePDFReport(employees);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=employees.pdf");

        return ResponseEntity.ok().headers(headers).contentType
                        (MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }
}
