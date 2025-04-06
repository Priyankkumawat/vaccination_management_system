package com.example.vaccineManagement.Controllers;


import com.example.vaccineManagement.Exceptions.VaccinationAddressNotFound;
import com.example.vaccineManagement.Models.VaccinationCenter;
import com.example.vaccineManagement.Services.VaccinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Hello this is priyank and i am adding this so that webhook could detact this change and update
//the vector data base, as u know vector data base is awesom

@RestController
@RequestMapping("/vaccinationCenter")
public class VaccinationController {

    // adding one more comment
    @Autowired
    public VaccinationService vaccinationService;

    @PostMapping("/add")
    public ResponseEntity<String> addCenter(@RequestBody VaccinationCenter vaccinationCenter){

        try {
            String result = vaccinationService.addVaccinationCenter(vaccinationCenter);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (VaccinationAddressNotFound e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }

    }

    // hello

}
