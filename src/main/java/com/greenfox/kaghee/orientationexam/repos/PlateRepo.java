package com.greenfox.kaghee.orientationexam.repos;

import com.greenfox.kaghee.orientationexam.models.LicencePlate;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PlateRepo extends CrudRepository<LicencePlate, Long> {
    @Query(value = "SELECT * FROM licence_plates" , nativeQuery = true)
    List<LicencePlate> findAll();

    @Query(value = "'SELECT * FROM licence_plates WHERE plate LIKE ''%' + platePart + '%'" , nativeQuery = true)
    List<LicencePlate> findAllByPlate(String platePart);

    @Query(value = "'SELECT * FROM licence_plates WHERE car_brand=' + brand" , nativeQuery = true)
    List<LicencePlate> findAllByCar_brand(String brand);

    @Query(value = "SELECT * FROM licence_plates WHERE plate LIKE 'RB%'" , nativeQuery = true)
    List<LicencePlate> findAllPolice();

    @Query(value = "SELECT * FROM licence_plates WHERE plate LIKE 'DP%'" , nativeQuery = true)
    List<LicencePlate> findAllDiplomat();
}
