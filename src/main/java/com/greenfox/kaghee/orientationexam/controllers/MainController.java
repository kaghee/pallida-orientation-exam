package com.greenfox.kaghee.orientationexam.controllers;

import com.greenfox.kaghee.orientationexam.models.LicencePlate;
import com.greenfox.kaghee.orientationexam.repos.PlateRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    @Autowired
    PlateRepo plateRepo;

    @GetMapping({"", "/"})
    public String loadMain(Model model, @ModelAttribute LicencePlate plate) {
        model.addAttribute("platelist", plateRepo.findAll());
        return "main";
    }

    @GetMapping("/search")
    public String search(@RequestParam(name = "type", required = false) String type,
                         @RequestParam(value = "q") String plate, Model model) {
        if (type.equals("police")) {
            model.addAttribute("platelist", plateRepo.findAllPolice());
        } else if (type.equals("diplomat")) {
            model.addAttribute("platelist", plateRepo.findAllDiplomat());
        }
        return "redirect:/main";
    }

    @GetMapping("/search/{brand}")
    public String searchBrand(@PathVariable String brand, Model model, @ModelAttribute LicencePlate plate) {
        model.addAttribute("platelist", plateRepo.findAllByBrand(brand));
        return "redirect:/main";
    }
}
