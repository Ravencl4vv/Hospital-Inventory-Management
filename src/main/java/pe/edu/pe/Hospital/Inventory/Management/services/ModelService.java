package pe.edu.pe.Hospital.Inventory.Management.services;


import pe.edu.pe.Hospital.Inventory.Management.entities.Model;

import java.util.Optional;

public interface ModelService extends CrudService<Model, Integer>{

    Optional<Model> findByModelName(String name_model) throws Exception;
}
