package productservice.repositories;

import org.springframework.data.repository.CrudRepository;

import productservice.entities.ProductEntity;

public interface ProductRepository extends CrudRepository<ProductEntity, Long> {
}
