package com.greenfox.kaghee.orientationexam.services;

import com.greenfox.kaghee.orientationexam.models.LicencePlate;
import com.greenfox.kaghee.orientationexam.repos.PlateRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PlateService {
    @Autowired
    PlateRepo plateRepo;

    public List<LicencePlate> list;

    public void listPolice() {
        for (LicencePlate lp: plateRepo.findAllPolice()) {
            list.add(lp);
        }
    }

    public void listDiplomat() {
        for (LicencePlate lp: plateRepo.findAllDiplomat()) {
            list.add(lp);
        }
    }

    public void listAllByPlate(String plate) {
        for (LicencePlate lp: plateRepo.findAllByPlate(plate)) {
            list.add(lp);
        }
    }
}
