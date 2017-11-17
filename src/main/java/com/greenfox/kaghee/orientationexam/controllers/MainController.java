package com.greenfox.kaghee.orientationexam.controllers;

import com.greenfox.kaghee.orientationexam.repos.PlateRepo;
import com.greenfox.kaghee.orientationexam.services.PlateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    public static final int NUM_OF_CARS = 202;

    @Autowired
    PlateRepo plateRepo;

    @Autowired
    PlateService plateService;

    @GetMapping({"", "/"})
    public String loadMain(Model model) {
        model.addAttribute("numOfCars", NUM_OF_CARS);
        model.addAttribute("allcars", plateRepo.findAll());
        model.addAttribute("platelist", plateRepo.findAll());
        return "main";
    }

    @GetMapping("/search")
    public String search(@RequestParam(name = "police", required = false) Integer isPolice,
                         @RequestParam(name = "diplomat", required = false) Integer isDiplomat,
                         @RequestParam(value = "q", required = false) String plate, Model model) {
        if (isPolice != null && isPolice == 1) {
            plateService.listPolice();
        } else if (isDiplomat != null && isDiplomat == 1) {
            plateService.listDiplomat();
        } else {
            plateService.listAllByPlate(plate);
        }
        model.addAttribute("platelist", plateService.list);
        return "redirect:/";
    }

    @GetMapping("/search/{brand}")
    public String searchBrand(@PathVariable String brand, Model model) {
        model.addAttribute("platelist", plateRepo.findAllByCar_brand(brand));
        return "redirect:/";
    }
}
