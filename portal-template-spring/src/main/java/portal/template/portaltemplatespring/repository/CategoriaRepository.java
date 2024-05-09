package portal.template.portaltemplatespring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import portal.template.portaltemplatespring.models.entity.Categoria;

@Repository
public interface CategoriaRepository extends CrudRepository<Categoria,Integer> {}