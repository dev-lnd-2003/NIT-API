package com.website.nit.service.impl;

import com.website.nit.model.Report;
import com.website.nit.repository.ReportRepository;
import com.website.nit.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    ReportRepository reportRepository;

    @Override
    public Report sendReport(Report report) {
        report.setConfirm(false);
        return reportRepository.save(report);
    }
}
