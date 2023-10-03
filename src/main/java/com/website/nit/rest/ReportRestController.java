package com.website.nit.rest;


import com.website.nit.model.Report;
import com.website.nit.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/report")

public class ReportRestController {

    @Autowired
    ReportService reportService;

    @PostMapping("/send-report")
    public ResponseEntity<Report> submitReport(@RequestBody Report report) {
        Report savedReport = reportService.sendReport(report);
        return new ResponseEntity<>(savedReport, HttpStatus.CREATED);
    }

}
