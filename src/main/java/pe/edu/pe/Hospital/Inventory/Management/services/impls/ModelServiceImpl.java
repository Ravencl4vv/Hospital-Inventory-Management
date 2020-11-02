package pe.edu.pe.Hospital.Inventory.Management.services.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.pe.Hospital.Inventory.Management.entities.Model;
import pe.edu.pe.Hospital.Inventory.Management.repositories.ModelRepository;
import pe.edu.pe.Hospital.Inventory.Management.services.ModelService;

import java.util.List;
import java.util.Optional;

@Service
public class ModelServiceImpl implements ModelService {
    @Autowired
    private ModelRepository modelRepository;

    @Override
    public Model save(Model entity) throws Exception {
        return modelRepository.save(entity);
    }

    @Override
    public List<Model> findAll() throws Exception {
        return modelRepository.findAll();
    }

    @Override
    public Optional<Model> findById(Integer integer) throws Exception {
        return modelRepository.findById(integer);
    }

    @Override
    public Model actualizar(Model Entity) throws Exception {
        return modelRepository.save(Entity);
    }

    @Override
    public void deleteById(Integer integer) throws Exception {
        modelRepository.deleteById(integer);
    }

    @Override
    public Optional<Model> findByModelName(String nameModel) throws Exception {
        return modelRepository.findByModelName(nameModel);
    }
}
