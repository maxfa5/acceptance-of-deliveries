package ru.acceptance.acceptance_of_deliveries.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import ru.acceptance.acceptance_of_deliveries.DTO.SupplierProductReport;
import ru.acceptance.acceptance_of_deliveries.service.DeliveryService;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class ReportController {


    
    @GetMapping("report/generate")
    public String generateReport(@RequestParam LocalDateTime startDate,
                                 @RequestParam LocalDateTime endDate,
                                 Model model) {
        try {
            List<SupplierProductReport> reportData = deliveryService.getSupplierProductReport(startDate, endDate);
            model.addAttribute("reportData", reportData);
            return "report-result";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("errorMessage", "Произошла ошибка при формировании отчета: " + e.getMessage());
            return "error-page";
        }
    }

    @Autowired
    private DeliveryService deliveryService;
    @GetMapping("api/report/generate")
    @ResponseBody
    public List<SupplierProductReport> getSupplierProductReport(
            @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDateTime startDate,
            @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDateTime endDate
    ) {
        return deliveryService.getSupplierProductReport(startDate, endDate);
    }

    @GetMapping("/reports")
    public String getAllSupplierProductReports(Model model) {
        List<SupplierProductReport> reportData =  deliveryService.getAllSupplierProductReports();
        model.addAttribute("reportData", reportData);
        return "report-result";
    }
}