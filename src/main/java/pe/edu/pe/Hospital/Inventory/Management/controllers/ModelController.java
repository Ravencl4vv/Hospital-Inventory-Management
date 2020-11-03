package pe.edu.pe.Hospital.Inventory.Management.controllers;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pe.edu.pe.Hospital.Inventory.Management.entities.Model;
import pe.edu.pe.Hospital.Inventory.Management.repositories.ModelRepository;
import pe.edu.pe.Hospital.Inventory.Management.services.BrandService;
import pe.edu.pe.Hospital.Inventory.Management.services.ModelService;

import java.util.List;
import java.util.Optional;
@Slf4j
@RestController
@RequestMapping("")
public class ModelController {

    @Autowired
    private ModelService modelService;
    @Autowired
    private BrandService brandService;
    @Autowired
    private ModelRepository modelRepository;

    @GetMapping(path = "/models/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Model> fetchById(@PathVariable("id") Integer id){
        try{
            Optional<Model> optionalModel = modelService.findById(id);
            if(optionalModel.isPresent()){
                return new ResponseEntity<Model>(optionalModel.get(), HttpStatus.OK);
            }else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //BUSQUEDA POR MODEL NAME

    @GetMapping(path = "/models/nombre/{modelName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Model> fetchById(@PathVariable("modelName") String modelName){
        try{
            Optional<Model> optionalModel = modelService.findByModelName(modelName);
            //otra manera
            if (optionalModel.isPresent()){
                return ResponseEntity.ok(optionalModel.get());
            } else{
                return ResponseEntity.notFound().build();
            }
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    //TODAS LOS MODEL CREADOS
    @GetMapping("/models")
    public ResponseEntity<List<Model>> findAll() {
        try {
            List<Model> models = modelService.findAll();
            if (models.isEmpty()) {
                return  ResponseEntity.noContent().build();
            } else{
                return  ResponseEntity.ok(models);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    // CREAR UNA BRAND
    @PostMapping("/brands/{id}/models")
    public Object save(@PathVariable("id") Integer id, @RequestBody Model
            model, BindingResult result){
        log.info("Creating Invoice : {}", model);
        if (result.hasErrors()){
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE);
        }
        try {

            return brandService.findById(id).map(brand -> {model.setBrand(brand);
            return modelRepository.save(model);});
        } catch (Exception e) {
            return HttpStatus.NOT_ACCEPTABLE;
        }

    }

    // ACTUALIZAR UNA BRAND

    @PutMapping(value = "/models/{id}")
    public ResponseEntity<?> actualizar(@PathVariable("id") Integer id, @RequestBody Model model) {
        log.info("Updating Invoice with id {}", id);
        model.setId(id);
        try {
            Model currentModel = modelService.actualizar(model);

            if (currentModel == null) {
                log.error("Unable to update. Invoice with id {} not found.", id);
                return  ResponseEntity.notFound().build();
            }
            else {
                return  ResponseEntity.ok(currentModel);
            }
        } catch (Exception e) {

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }



    }


    //BORRAR UNA BRAND
    @DeleteMapping("/models/{id}")
    public ResponseEntity<Model> deleteById(@PathVariable(name = "id") Integer id) {

        try {
            return (ResponseEntity<Model>) modelService.deleteById(id);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }




}
