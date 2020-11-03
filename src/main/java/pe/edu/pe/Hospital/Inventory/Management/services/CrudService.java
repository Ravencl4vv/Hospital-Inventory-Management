package pe.edu.pe.Hospital.Inventory.Management.services;

import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface CrudService<T, ID> {

    T save(T entity) throws Exception;

    List<T> findAll() throws Exception;

    Optional<T> findById(ID id) throws Exception;

    T actualizar(T Entity) throws Exception;

    ResponseEntity<?> deleteById(ID id) throws Exception;
}
