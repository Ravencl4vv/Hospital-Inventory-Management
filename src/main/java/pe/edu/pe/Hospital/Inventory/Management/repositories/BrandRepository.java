package pe.edu.pe.Hospital.Inventory.Management.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.pe.Hospital.Inventory.Management.entities.Brand;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Integer> {
}
