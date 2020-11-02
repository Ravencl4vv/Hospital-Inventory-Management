package pe.edu.pe.Hospital.Inventory.Management.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.pe.Hospital.Inventory.Management.entities.Model;

import java.util.Optional;

@Repository
public interface ModelRepository extends JpaRepository<Model,Integer> {

    Optional<Model> findByModelName(String nameModel);
}
