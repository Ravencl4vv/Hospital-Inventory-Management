package pe.edu.pe.Hospital.Inventory.Management.services;

import pe.edu.pe.Hospital.Inventory.Management.entities.Brand;


import java.util.Optional;

public interface BrandService extends CrudService<Brand, Integer>{
    Optional<Brand> findByBrandName(String nameBrand) throws Exception;

}
