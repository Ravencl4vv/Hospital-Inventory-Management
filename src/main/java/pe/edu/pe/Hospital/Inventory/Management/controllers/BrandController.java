package pe.edu.pe.Hospital.Inventory.Management.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pe.edu.pe.Hospital.Inventory.Management.entities.Brand;
import pe.edu.pe.Hospital.Inventory.Management.services.BrandService;


import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/brands")
public class BrandController {
    @Autowired
    private BrandService brandService;


    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Brand> fetchById(@PathVariable("id") Integer id){
        try{
            Optional<Brand> optionalBrand = brandService.findById(id);
            if(optionalBrand.isPresent()){
                return new ResponseEntity<Brand>(optionalBrand.get(), HttpStatus.OK);
            }else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //BUSQUEDA POR BRAND NAME

    @GetMapping(path = "/name/{nameBrand}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Brand> fetchById(@PathVariable("nameBrand") String nameBrand){
        try{
            Optional<Brand> optionalBrand = brandService.findByBrandName(nameBrand);
            //otra manera
            if (optionalBrand.isPresent()){
                return ResponseEntity.ok(optionalBrand.get());
            } else{
                return ResponseEntity.notFound().build();
            }
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    //TODAS LAS BRAND CREADAS
    @GetMapping
    public ResponseEntity<List<Brand>> findAll() {
        try {
            List<Brand> brands = brandService.findAll();
            if (brands.isEmpty()) {
                return  ResponseEntity.noContent().build();
            } else{
                return  ResponseEntity.ok(brands);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    // CREAR UNA BRAND
    @PostMapping
    public ResponseEntity<Brand> save(@RequestBody Brand brand, BindingResult result) {
        log.info("Creating Invoice : {}", brand);
        if (result.hasErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        try {
            Brand brandDB = brandService.save (brand);
            return ResponseEntity.status(HttpStatus.CREATED).body(brandDB);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    // ACTUALIZAR UNA BRAND

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> actualizar(@PathVariable("id") Integer id, @RequestBody Brand brand) {
        log.info("Updating Invoice with id {}", id);

        brand.setId(id);
        try {
            Brand currentBrand = brandService.actualizar(brand);

            if (currentBrand == null) {
                log.error("Unable to update. Invoice with id {} not found.", id);
                return  ResponseEntity.notFound().build();
            }
            else {
                return  ResponseEntity.ok(currentBrand);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }



    }


    //BORRAR UNA BRAND
    @DeleteMapping("/{id}")
    public ResponseEntity<Brand> deleteById(@PathVariable(name = "id") Integer id) {

        try {
            return (ResponseEntity<Brand>) brandService.deleteById(id);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
