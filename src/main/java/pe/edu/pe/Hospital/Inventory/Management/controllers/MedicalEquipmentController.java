package pe.edu.pe.Hospital.Inventory.Management.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.pe.Hospital.Inventory.Management.entities.MedicalEquipment;
import pe.edu.pe.Hospital.Inventory.Management.services.MedicalEquipmentService;

import java.util.Optional;

@RestController
@RequestMapping("/medical-equipment")
public class MedicalEquipmentController {
    @Autowired
    private MedicalEquipmentService medicalEquipmentService;


    @GetMapping(path = "/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MedicalEquipment> fetchById(@PathVariable("id") Integer id){
        try{
            Optional<MedicalEquipment> optionalMedicalEquipment = medicalEquipmentService.findById(id);
            if(optionalMedicalEquipment.isPresent()){
            return new ResponseEntity<MedicalEquipment>(optionalMedicalEquipment.get(), HttpStatus.OK);
        }else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
