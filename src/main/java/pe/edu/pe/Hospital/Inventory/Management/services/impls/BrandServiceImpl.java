package pe.edu.pe.Hospital.Inventory.Management.services.impls;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.pe.Hospital.Inventory.Management.entities.Brand;
import pe.edu.pe.Hospital.Inventory.Management.repositories.BrandRepository;
import pe.edu.pe.Hospital.Inventory.Management.services.BrandService;


import java.util.List;
import java.util.Optional;

@Service
public class BrandServiceImpl implements BrandService {


    @Autowired
    private BrandRepository brandRepository;


    @Override
    public Brand save(Brand entity) throws Exception {
        return brandRepository.save(entity);
    }

    @Override
    public List<Brand> findAll() throws Exception {
        return brandRepository.findAll();
    }

    @Override
    public Optional<Brand> findById(Integer integer) throws Exception {
        return brandRepository.findById(integer);
    }

    @Override
    public Brand actualizar(Brand Entity) throws Exception {
        return brandRepository.save(Entity);
    }

    @Override
    public void deleteById(Integer integer) throws Exception {
        brandRepository.deleteById(integer);
    }

    @Override
    public Optional<Brand> findByBrandName(String nameBrand) throws Exception {
        return brandRepository.findByBrandName(nameBrand);
    }
}
