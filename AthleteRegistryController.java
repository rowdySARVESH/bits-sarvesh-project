package com.registry.controller;

import com.registry.model.LiftRecord;
import com.registry.service.PerformanceService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class AthleteRegistryController {

    private final PerformanceService performanceService;

    public AthleteRegistryController(PerformanceService performanceService) {
        this.performanceService = performanceService;
    }

    // READ OPERATION
    @GetMapping
    public String viewDashboard(Model model) {
        model.addAttribute("records", performanceService.getAllLiftRecords());
        return "list";
    }

    // CREATE OPERATION (Form Init)
    @GetMapping("/new")
    public String showLogForm(Model model) {
        model.addAttribute("liftRecord", new LiftRecord());
        model.addAttribute("athletes", performanceService.getAllAthletes());
        return "form";
    }

    // CREATE/UPDATE OPERATION (Execution)
    @PostMapping("/save")
    public String saveRecord(@Valid @ModelAttribute("liftRecord") LiftRecord record,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("athletes", performanceService.getAllAthletes());
            return "form";
        }
        performanceService.saveLiftRecord(record);
        return "redirect:/";
    }

    // UPDATE OPERATION (Form Init)
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("liftRecord", performanceService.getRecordById(id));
        model.addAttribute("athletes", performanceService.getAllAthletes());
        return "form";
    }
}
