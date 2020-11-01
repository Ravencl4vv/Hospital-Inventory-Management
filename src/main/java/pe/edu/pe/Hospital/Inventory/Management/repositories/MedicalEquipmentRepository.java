package pe.edu.pe.Hospital.Inventory.Management.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.pe.Hospital.Inventory.Management.entities.MedicalEquipment;

@Repository

public interface MedicalEquipmentRepository extends JpaRepository<MedicalEquipment, Integer> {
}
