package pe.edu.pe.Hospital.Inventory.Management.services.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.pe.Hospital.Inventory.Management.entities.MedicalEquipment;
import pe.edu.pe.Hospital.Inventory.Management.repositories.MedicalEquipmentRepository;
import pe.edu.pe.Hospital.Inventory.Management.services.MedicalEquipmentService;

import java.util.List;
import java.util.Optional;

@Service
public class MedicalEquipmentServiceImpl implements MedicalEquipmentService {

    @Autowired
    private MedicalEquipmentRepository medicalEquipmentRepository;


    @Override
    public MedicalEquipment save(MedicalEquipment entity) throws Exception {
        return medicalEquipmentRepository.save(entity);
    }

    @Override
    public List<MedicalEquipment> findAll() throws Exception {
        return medicalEquipmentRepository.findAll();
    }

    @Override
    public Optional<MedicalEquipment> findById(Integer integer) throws Exception {
        return medicalEquipmentRepository.findById(integer);
    }

    @Override
    public MedicalEquipment actualizar(MedicalEquipment Entity) throws Exception {
        return medicalEquipmentRepository.save(Entity);
    }

    @Override
    public void deleteById(Integer integer) throws Exception {
        medicalEquipmentRepository.deleteById(integer);
    }
}
